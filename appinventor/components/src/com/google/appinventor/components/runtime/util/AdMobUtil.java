package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.util.Log;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class AdMobUtil {
    private static String LOG_TAG = "AdMobUtil";

    static String getAndroidId(Context context) {
        Log.d(LOG_TAG, "Getting Android ID...");
        String androidId = Secure.getString(context.getContentResolver(), "android_id");
        Log.d(LOG_TAG, "Android ID: " + androidId);
        return androidId;
    }

    static String getMD5(String string) throws NoSuchAlgorithmException {
        String hash = null;
        Log.d(LOG_TAG, "Getting MD5(" + string + ")...");
        if (string != null && string.length() > 0) {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(string.getBytes(), 0, string.length());
            hash = String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, localMessageDigest.digest())});
        }
        Log.d(LOG_TAG, "MD5(" + string + "): " + hash);
        return hash;
    }

    static String getDeviceId(String androidId) {
        String deviceId;
        Log.d(LOG_TAG, "Getting device ID(" + androidId + ")...");
        try {
            deviceId = getMD5(androidId);
        } catch (NoSuchAlgorithmException e) {
            deviceId = androidId.substring(0, 32);
        }
        Log.d(LOG_TAG, "Android ID(" + androidId + ") => " + deviceId);
        return deviceId;
    }

    public static String guessSelfDeviceId(Context context) {
        String testDeviceId = null;
        Log.d(LOG_TAG, "Guessing self device id...");
        try {
            testDeviceId = getDeviceId(getAndroidId(context));
            Log.i(LOG_TAG, "Guessed self device id: " + testDeviceId);
            return testDeviceId;
        } catch (Exception error) {
            Log.e(LOG_TAG, "Could not guess self device id: " + error);
            return testDeviceId;
        }
    }
}
