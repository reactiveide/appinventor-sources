package com.google.appinventor.components.runtime;

// This Component is created and owned by hybro or its developer (member of hybro)

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.*;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.Uri;
import android.content.pm.PackageManager;
import android.content.*;
import android.util.*;
import android.app.Activity;
import android.app.ActivityManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.BatteryManager;
import android.widget.Toast;
import android.telephony.TelephonyManager;
import android.telephony.CellLocation;     
import android.telephony.PhoneStateListener;
//import android.support.v7.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TimeZone;
import java.util.Locale;




@SimpleObject
@DesignerComponent(version = 1,
    description = "DeviceInfo Component allows you to get some infomation or status from client's device, such as Android Version, IMEI. Wifi, Battery Level, etc. This component is created by (kwankiu.github.io), one of the member in Hybro (hybro.io), thank you for using it, hope it make use to boost your project/app to a success !",
    category = ComponentCategory.BASIC,
    nonVisible = true,
    iconName = "https://cdn.reactiveide.com/deviceinfoblack.png")

@UsesPermissions(permissionNames = "android.permission.READ_EXTERNAL_STORAGE,android.permission.READ_PHONE_STATE,android.permission.ACCESS_NETWORK_STATE,android.permission.ACCESS_WIFI_STATE,android.permission.INTERNET,android.permission.CHANGE_WIFI_STATE,android.permission.ACCESS_COARSE_LOCATION")

public class DeviceInfo extends AndroidNonvisibleComponent implements Component {
    private static final String LOG_TAG = "DeviceInfo";
    private final Context context;
  
    public DeviceInfo(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
    }

    @SimpleFunction(description = "Go to Home page of your device without quiting app.")
    public void GoHome() {
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        home.addCategory(Intent.CATEGORY_HOME);
        context.startActivity(home);
    }

    @SimpleFunction(description = "Get device Country Code.")
    public String DeviceCountry() {
        return this.context.getResources().getConfiguration().locale.getCountry();
    }

    @SimpleFunction(description = "Get device Language Code.")
    public String DeviceLanguage() {
        return this.context.getResources().getConfiguration().locale.getLanguage();
    }

    @SimpleFunction(description = "Get System default language")
    public String SysLang() {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        return language;
    }
    @SimpleFunction(description = "Return if system default language is chinese")
    public boolean SysLangIsZh() {
        return (SysLang().endsWith("zh"));
    }
    @SimpleFunction(description = "Return if system default language is english")
    public boolean SysLangIsEn() {
        return (SysLang().endsWith("en"));
    }

    @SimpleFunction(description = "Get Device Time Zone.")
    public String DeviceTimeZone() {
        return TimeZone.getDefault().getID();
    }

    @SimpleFunction(description = "Get Device Phone Number (Line 1 Number)")
    public String GetPhoneNumber() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }

    @SimpleFunction(description = "Get device ID / IMEI")
    public String GetDeviceID() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    @SimpleFunction(description = "Get device Carrier Name")
    public String GetCarrierName() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimOperatorName();
    }

    @SimpleFunction(description = "Returns the software version number for the device, for example, the IMEI/SV for GSM phones.")
    public String GetDeviceSoftwareVersion() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceSoftwareVersion();
    }

    @SimpleFunction(description = "Returns the ISO country code equivalent for the SIM provider's country code.")
    public String getSimCountryIso() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimCountryIso();
    }

    @SimpleFunction(description = "Returns the MCC+MNC (mobile country code + mobile network code) of the provider of the SIM.")
    public String getSimOperator() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimOperator();
    }

    @SimpleFunction(description = "Returns the Service Provider Name (SPN).")
    public String getSimOperatorName() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimOperatorName();
    }

    @SimpleFunction(description = "Returns the serial number of the SIM")
    public String getSimSerialNumber() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimSerialNumber();
    }

    @SimpleFunction(description = "Get device Android Version.")
    public String AndroidVersion() {
        return "Android " + VERSION.RELEASE;
    }

    @SimpleFunction(description = "Get device SDK Version.")
    public int SDK_Version() {
        return VERSION.SDK_INT;
    }

    @SimpleFunction(description = "Get Board Info.")
    public String Board() {
        return Build.BOARD;
    }

    @SimpleFunction(description = "Get system Bootloader Version.")
    public String Bootloader_Version() {
        return Build.BOOTLOADER;
    }

    @SimpleFunction(description = "Get device Brand.")
    public String Brand() {
        return Build.BRAND;
    }

    @SimpleFunction(description = "Get device Name.")
    public String DeviceName() {
        return Build.DEVICE;
    }

    @SimpleFunction(description = "Get device Software Build Number.")
    public String BuildNumber() {
        return Build.DISPLAY;
    }

    @SimpleFunction(description = "A string that uniquely identifies this build.")
    public String Fingerprint() {
        return Build.FINGERPRINT;
    }

    @SimpleFunction(description = "Get device Hardware Name.")
    public String Hardware() {
        return Build.HARDWARE;
    }

    @SimpleFunction(description = "Get device Build ID.")
    public String Id() {
        return Build.ID;
    }

    @SimpleFunction(description = "Get device manufacturer.")
    public String Manufacturer() {
        return Build.MANUFACTURER;
    }

    @SimpleFunction(description = "Get device Model Name.")
    public String ModelName() {
        return Build.MODEL;
    }

    @SimpleFunction(description = "Get device Product Name.")
    public String Product() {
        return Build.PRODUCT;
    }

    @SimpleFunction(description = "Get device build type.")
    public String Type() {
        return Build.TYPE;
    }
  
     @SimpleFunction(description = "Check if your device is in Night / Dark Mode")
    public boolean isDarkMode() {
        int darkMode = AppCompatDelegate.getDefaultNightMode();
        if (darkMode == 2) {
            return true;
        }
        else {
            return false;
        }
    }

    @SimpleFunction(description = "Total free RAM size in Gigabytes")
    public long MemoryFree() {
        android.app.ActivityManager.MemoryInfo mi = new android.app.ActivityManager.MemoryInfo();
        ((ActivityManager) this.context.getSystemService("activity")).getMemoryInfo(mi);
        return mi.availMem / 1048576;
    }

    @SimpleFunction(description = "Total RAM size in Gigabytes")
    public long MemoryTotal() {
        android.app.ActivityManager.MemoryInfo mi = new android.app.ActivityManager.MemoryInfo();
        ((ActivityManager) this.context.getSystemService("activity")).getMemoryInfo(mi);
        return mi.totalMem / 1048576;
    }

    @SimpleFunction(description = "Returns size of used-memory in Gigabytes")
    public long MemoryUsed() {
        return MemoryTotal() - MemoryFree();
    }

    @SimpleFunction(description = "Returns size of available internal storage in Gigabytes")
    public long InternalStorageAvailable() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        return (((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize())) / 1048576;
    }

    @SimpleFunction(description = "Returns total size of internal storage in Gigabytes")
    public long InternalStorageTotal() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        return (((long) stat.getBlockCount()) * ((long) stat.getBlockSize())) / 1048576;
    }

    @SimpleFunction(description = "Returns size of used-internal-storage in Gigabytes")
    public long InternalStorageUsed() {
        return InternalStorageTotal() - InternalStorageAvailable();
    }

    @SimpleFunction(description = "Returns available size of external storage in Gigabytes")
    public long ExternalStorageAvailable() {
        if (!externalStorageAvailable()) {
            return 0;
        }
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize())) / 1048576;
    }

    @SimpleFunction(description = "Returns total external storage size in Gigabytes")
    public long ExternalStorageTotal() {
        if (!externalStorageAvailable()) {
            return 0;
        }
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) stat.getBlockCount()) * ((long) stat.getBlockSize())) / 1048576;
    }

    @SimpleFunction(description = "Returns size of used-external-storage in Gigabytes")
    public long ExternalStorageUsed() {
        return ExternalStorageTotal() - ExternalStorageAvailable();
    }

    public boolean externalStorageAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }
  
        @SimpleFunction(description = "Launch App")
    public void LaunchApp(String packageName) {
      Intent LaunchApp = context.getPackageManager().getLaunchIntentForPackage(packageName);
      context.startActivity(LaunchApp);
         }
  
        @SimpleFunction(description = "Show An Alert")
    public void ShowAlert(String message) {
         Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
         }
  
        @SimpleFunction(description = "Get Wifi SSID")
    public String GetWifiSSID() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getSSID();
    }
  
        @SimpleFunction(description = "Get Wifi BSSID")
    public String GetWifiBSSID() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getBSSID();
    }
  
  @SimpleFunction(description = "Get Wifi MAC address")
    public String GetMacAddress() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getMacAddress();
    }
  

  @SimpleFunction(description = "Get Wifi IP address")
    public String GetIPAddress() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        int ip = wifiManager.getConnectionInfo().getIpAddress();
        String IPs = intToIp(ip);
        return IPs;
    }
  
    public static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }
  
  @SimpleFunction(description = "Get Wifi LinkSpeed")
    public int GetWifiLinkSpeed() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getLinkSpeed();
    }
  
  @SimpleFunction(description = "Get Wifi Frequency")
    public int GetWifiFrequency() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getFrequency();
    }

   @SimpleFunction(description = "Check if Wifi is enabled")
    public boolean isWifiEnabled() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();
    }

  @SimpleFunction(description = "Check if 5Ghz Band Wifi is supported")
    public boolean is5GHz_Wifi_Supported() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.is5GHzBandSupported();
    }

  @SimpleFunction(description = "Check if Device To ApRtt Supported")
    public boolean isDeviceToApRttSupported() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isDeviceToApRttSupported();
    }
  
  @SimpleFunction(description = "Check if Enhanced Power Reporting Supported")
    public boolean isEnhancedPowerReportingSupported() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isEnhancedPowerReportingSupported();
    }
  
  @SimpleFunction(description = "Check if Wifi P2P Supported ")
    public boolean isWifi_P2P_Supported() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isP2pSupported();
    }
  
   @SimpleFunction(description = "Check if Preferred Network Offload Supported")
    public boolean isPreferredNetworkOffloadSupported() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isPreferredNetworkOffloadSupported();
    }
  
   @SimpleFunction(description = "Check if Wifi Scanning is always available.")
    public boolean isWifiScanAlwaysAvailable() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isScanAlwaysAvailable();
    }

  @SimpleFunction(description = "Check if Wifi Tdls Supported.")
    public boolean isWifiTdlsSupported() {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isTdlsSupported();
    }

    @SimpleFunction(description = "Check if your Device is charging.")
    public boolean isDeviceCharging() {
        BatteryManager bm = (BatteryManager)context.getSystemService(Context.BATTERY_SERVICE);
        return bm.isCharging();
    }
  
  @SimpleFunction(description = "Detect if your device contains notch (This is coming soon, all devices on Android API 28 or newer will return true currently)")
    public boolean containNotch() {
      if (VERSION.SDK_INT < 27) {
        // Notch Detection is not supported !
        return false;
    } else {
        // Do a display cutout check (coming soon)
        return true;
      }
   }
  
  @SimpleFunction(description = "Detect if your device is an emulator")
  public boolean isEmulator() {
    if (Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT)) {
    return true;
    } else {
    return false;
    }
}
      @SimpleFunction(description = "About this Extension")
    public void AboutThisExtension() {
         Toast.makeText(context, "DeviceInfo is a component that get info from your device, developed by Samuel (kwankiu.github.io)",Toast.LENGTH_SHORT).show();
         }
}
