    package com.google.appinventor.components.runtime;

    /*
    
    
      _   _           _    ___________ _____ 
     | | | |         | |  |_   _|  _  \  ___|
     | |_| |_   _  __| |_ __| | | | | | |__  
     |  _  | | | |/ _` | '__| | | | | |  __| 
     | | | | |_| | (_| | | _| |_| |/ /| |___ 
     \_| |_/\__, |\__,_|_| \___/|___/ \____/  @ Hybro 2020
             __/ |                           
            |___/                            


    */



    

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Process;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DesignerComponent(version = 1, description = "Easily work with packages with this component", category = ComponentCategory.UTILS, nonVisible = true, iconName = "https://cdn.reactiveide.com/button.png")
@SimpleObject
public final class PackageUtils extends AndroidNonvisibleComponent {
  public static Context context;
  
  public static Bitmap b;
  
  public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
  
  public PackageUtils(ComponentContainer container) {
    super(container.$form());
    context = container.$context();
  }
  
@SimpleFunction(description="Return the UID associated with the given package name")
public static int GetPackageUID(String pkg){
        try {
            return context.getPackageManager().getPackageUid(pkg,0);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

@SimpleFunction(description="Return a list of all of the POSIX secondary group IDs that have been assigned to the given package")
public static List GetPackageGIDS(String pkg){
        try {
            int [] gids = context.getPackageManager().getPackageGids(pkg,0);
          return Arrays.asList(gids);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
        
@SimpleFunction(description="Returns a list of permissions requested by a package")
public static List<String> AppPermissionsList(String packageName) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
            return Arrays.asList(info.requestedPermissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
@SimpleFunction(description="Tries to add a new dynamic permission to the system")
public static void AddPermission(String permissionName){
        try {
  context.getPackageManager().addPermission(context.getPackageManager().getPermissionInfo(permissionName,PackageManager.GET_META_DATA));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
@SimpleFunction(description="Removes a permission that was previously added with 'AddPermission'")
public static void RemovePermission(String permissionName){
        try {
            context.getPackageManager().removePermission(permissionName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
@SimpleFunction(description="Query if this app is currently suspended")
public  static boolean IsAppSuspended(){
        return context.getPackageManager().isPackageSuspended();
    }
@SimpleFunction(description="Gets whether the given package is an instant app")
public static boolean InstantApp(String pkg){
        return context.getPackageManager().isInstantApp(pkg);
}
@SimpleFunction(description="Gets whether this application is an instant app")
public static boolean IsInstantApp(){
        return context.getPackageManager().isInstantApp();
}

@SimpleFunction(description="Retrieve the package name of the application that installed a package."
+"This identifies which market the package came from")
public static String InstallerPackageName(String pkg){
        return context.getPackageManager().getInstallerPackageName(pkg);
}
  @SimpleFunction(description = "Checks that specific permission is granted or not to current running app")
  public static boolean CheckSelfPermission(String permission) {
    try {
      int res = context.checkPermission(permission, Process.myPid(), Process.myUid());
      return (res == 0);
    } catch (Exception e) {
      return false;
    } 
  }
  
  @SimpleFunction(description = "Returns true if app is system app")
  public static boolean IsSystemApp(String packageName) {
    try {
      PackageManager pm = context.getPackageManager();
      ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageName, 128);
      return ((applicationInfo.flags & 0x1) != 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      return false;
    } 
  }
  
  @SimpleFunction(description = "Returns true if app is installed")
  public static boolean IsAppInstalled(String packageName) {
    try {
      context.getPackageManager().getApplicationInfo(packageName, 0);
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      return false;
    } 
  }
  
  @SimpleFunction(description = "Returns a list of all packages installed on system")
  public static List<String> InstalledApps(boolean includeSystemApps) {
        PackageManager pm = context.getPackageManager();
        List<String> IP = new ArrayList<>();
        List<ApplicationInfo> pk = pm.getInstalledApplications(0);
        for (ApplicationInfo p : pk) {
            if (includeSystemApps) {
                IP.add(p.packageName);
            } else {
                if (!IsSystemApp(p.packageName)) {
                    IP.add(p.packageName);
                }
            }
        }
        return IP;
    }
  
  @SimpleFunction(description = "Returns version name of given package")
  public static String AppVersionName(String packageName) {
    try {
      PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
      return pi.versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      return "Not Found";
    } 
  }
  
  @SimpleFunction(description = "Returns version code of given package")
  public static int AppVersionCode(String packageName) {
    try {
      PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
      return pi.versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      return 0;
    } 
  }
  
  @SimpleFunction(description = "Returns first install time of app/package")
  public static String FirstInstallTime(String packageName) {
    try {
      PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
      Date d = new Date(pi.firstInstallTime);
      return sdf.format(d);
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      return "";
    } 
  }
  
  @SimpleFunction(description = "Returns last update time of app/package")
  public static String LastUpdateTime(String packageName) {
    try {
      PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
      Date d = new Date(pi.lastUpdateTime);
      return sdf.format(d);
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      return "";
    } 
  }
  
  @SimpleFunction(description = "Returns path to icon of given package/app")
  public static String Icon(String packageName) {
    try {
      FileOutputStream fileOutputStream = null;
      File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
      String ID = AppName(packageName);
      File file = new File(path, ID + ".png");
      fileOutputStream = new FileOutputStream(file);
      Drawable icon = context.getPackageManager().getApplicationIcon(packageName);
      BitmapDrawable bitmapDrawable = (BitmapDrawable)icon;
      Bitmap img = bitmapDrawable.getBitmap();
      img.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
      fileOutputStream.flush();
      fileOutputStream.close();
      return String.valueOf(file);
    } catch (Exception e) {
      return String.valueOf(e);
    } 
  }
  
  @SimpleProperty(description = "Returns package name of current app")
  public static String PackageName() {
    try {
      return context.getPackageName();
    } catch (Exception e) {
      return "";
    } 
  }
  
  @SimpleProperty(description = "Returns name of current app")
  public static String ApplicationName() {
    return AppName(PackageName());
  }
  
  @SimpleProperty(description = "Returns version name of current app")
  public static String VersionName() {
    return AppVersionName(PackageName());
  }
  
  @SimpleProperty(description = "Returns version code of current app")
  public static int VersionCode() {
    return AppVersionCode(PackageName());
  }
  
  @SimpleFunction(description = "Returns target sdk of given package")
  public static int TargetSDK(String packageName) {
    try {
      return (context.getPackageManager().getApplicationInfo(packageName, 0)).targetSdkVersion;
    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
      return 0;
    } 
  }
  
  @SimpleFunction(description = "Returns app name from package")
  public static String AppName(String packageName) {
    try {
      PackageManager packageManager = context.getPackageManager();
      return (String)packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128));
    } catch (Exception e) {
      return String.valueOf(e);
    } 
  }
  
  @SimpleFunction(description = "Checks whether given package has specific permission")
  public static boolean HasPermission(String permissionName, String packageName) {
    try {
      PackageManager p = context.getPackageManager();
      int res = p.checkPermission(permissionName, packageName);
      return (res == 0);
    } catch (Exception e) {
      return false;
    } 
  }
  
  @SimpleFunction(description = "Checks whether system is booted in safe mode or not")
  public static boolean IsSafeMode() {
    PackageManager p = context.getPackageManager();
    return p.isSafeMode();
  }
  
  @SimpleFunction(description = "Returns list of available features of system")
  public static List<String> SystemAvailableFeatures() {
    PackageManager p = context.getPackageManager();
    List<String> features = new ArrayList<>();
    FeatureInfo[] list = p.getSystemAvailableFeatures();
    for (FeatureInfo f : list)
      features.add(f.name); 
    return features;
  }
  
  @SimpleFunction(description = "Checks whether system has particular feature")
  public static boolean HasSystemFeature(String feature) {
    PackageManager p = context.getPackageManager();
    return p.hasSystemFeature(feature);
  }
}

