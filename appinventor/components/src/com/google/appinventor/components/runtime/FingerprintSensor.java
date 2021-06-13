package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.CancellationSignal;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.util.Log;

import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;

import java.io.IOException;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


@DesignerComponent(androidMinSdk = 23, 
    category = ComponentCategory.SENSORS, 
    description = "", iconName = "", 
    nonVisible = true, version = 1)
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.USE_BIOMETRIC, android.permission.USE_FINGERPRINT")
/* renamed from: com.appybuilder.kennicholsandroid.FingerprintSensor.FingerprintSensor */
public class FingerprintSensor extends AndroidNonvisibleComponent {
    private static final String KEY_NAME = "FingerprintSensor";
    private String TAG = "FingerprintSensorExtension";

    public CancellationSignal cancellationSignal;
    private Cipher cipher;
    private ComponentContainer container;

    public Context context;
    private CryptoObject cryptoObject;
    private FingerprintManager fingerprintManager;
    private KeyGenerator keyGenerator;
    private KeyStore keyStore;
    private KeyguardManager keyguardManager;

    public class FingerprintHandler extends AuthenticationCallback {
        public FingerprintHandler(Context context) {
        }

        public void startAuth(FingerprintManager manager, CryptoObject cryptoObject) {
            FingerprintSensor.this.cancellationSignal = new CancellationSignal();
            if (FingerprintSensor.this.context.checkCallingOrSelfPermission("android.permission.USE_FINGERPRINT") == 0) {
                manager.authenticate(cryptoObject, FingerprintSensor.this.cancellationSignal, 0, this, null);
            }
        }

        public void onAuthenticationError(int errMsgId, CharSequence errString) {
            FingerprintSensor.this.AuthenticationError(errString.toString());
        }

        public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
            FingerprintSensor.this.AuthenticationHelp(helpString.toString());
        }

        public void onAuthenticationFailed() {
            FingerprintSensor.this.AuthenticationFailed();
        }

        public void onAuthenticationSucceeded(AuthenticationResult result) {
            FingerprintSensor.this.AuthenticationSucceeded();
        }
    }

    public FingerprintSensor(ComponentContainer container2) {
        super(container2.$form());
        this.container = container2;
        this.context = container2.$context();
        this.keyguardManager = (KeyguardManager) this.context.getSystemService("keyguard");
        this.fingerprintManager = (FingerprintManager) this.context.getSystemService("fingerprint");
    }

    @SimpleFunction(description = "Checks if device has a Fingerprint Sensor.")
    public boolean HasFingerprintSensor() {
        if (!this.fingerprintManager.isHardwareDetected()) {
            return false;
        }
        return true;
    }

    @SimpleFunction(description = "Checks if device has Enrolled Fingerprints.")
    public boolean HasEnrolledFingerprints() {
        if (!this.fingerprintManager.hasEnrolledFingerprints()) {
            return false;
        }
        return true;
    }

    @SimpleFunction(description = "Checks if the Keyguard(Lock Screen) is Secure. This is required to be able to use Fingerprint Authentication")
    public boolean IsKeyguardSecure() {
        if (!this.keyguardManager.isKeyguardSecure()) {
            return false;
        }
        return true;
    }

    @SimpleFunction(description = "Checks if the user has granted the app permission to use the Fingerprint Sensor.")
    public boolean HasFingerprintPermission() {
        return this.context.checkCallingOrSelfPermission("android.permission.USE_FINGERPRINT") == 0;
    }

    /* access modifiers changed from: protected */
    public void generateKey() {
        try {
            this.keyStore = KeyStore.getInstance("AndroidKeyStore");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            try {
                this.keyStore.load(null);
                this.keyGenerator.init(new Builder(KEY_NAME, 3).setBlockModes(new String[]{"CBC"}).setUserAuthenticationRequired(true).setEncryptionPaddings(new String[]{"PKCS7Padding"}).build());
                this.keyGenerator.generateKey();
            } catch (IOException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | CertificateException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException e3) {
            throw new RuntimeException("Failed to get KeyGenerator instance", e3);
        }
    }

    public boolean cipherInit() {
        try {
            this.cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                this.keyStore.load(null);
                this.cipher.init(1, (SecretKey) this.keyStore.getKey(KEY_NAME, null));
                return true;
            } catch (KeyPermanentlyInvalidatedException e) {
                return false;
            } catch (IOException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e2) {
                throw new RuntimeException("Failed to init Cipher", e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException("Failed to get Cipher", e3);
        }
    }

    @SimpleFunction(description = "Starts Fingerprint Authentication")
    public void Authenticate() {
        generateKey();
        if (cipherInit()) {
            this.cryptoObject = new CryptoObject(this.cipher);
            new FingerprintHandler(this.context).startAuth(this.fingerprintManager, this.cryptoObject);
        }
    }

    @SimpleFunction(description = "Cancels Fingerprint Authentication")
    public void CancelAuthentication() {
        if (this.cancellationSignal != null) {
            this.cancellationSignal.cancel();
            this.cancellationSignal = null;
        }
    }

    @SimpleEvent(description = "Called when an unrecoverable error has been encountered and the operation is complete.")
    public void AuthenticationError(String msg) {
        Log.d(this.TAG, "AuthenticationError");
        EventDispatcher.dispatchEvent(this, "AuthenticationError", new Object[]{msg});
    }

    @SimpleEvent(description = "Called when a recoverable error has been encountered during authentication.")
    public void AuthenticationHelp(String msg) {
        Log.d(this.TAG, "AuthenticationHelp");
        EventDispatcher.dispatchEvent(this, "AuthenticationHelp", new Object[]{msg});
    }

    @SimpleEvent(description = "Called when a fingerprint is valid but not recognized.")
    public void AuthenticationFailed() {
        Log.d(this.TAG, "AuthenticationFailed");
        EventDispatcher.dispatchEvent(this, "AuthenticationFailed", new Object[0]);
    }

    @SimpleEvent(description = "Called when a fingerprint is recognized.")
    public void AuthenticationSucceeded() {
        Log.d(this.TAG, "AuthenticationSucceeded");
        EventDispatcher.dispatchEvent(this, "AuthenticationSucceeded", new Object[0]);
    }
}
