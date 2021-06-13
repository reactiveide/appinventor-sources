package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.os.Environment;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.*;

import java.io.File;
import java.io.FileOutputStream;


@DesignerComponent(version = 1,
    description = "Extension to take a screenshot.",
    category = ComponentCategory.BASIC,
    nonVisible = true,
    iconName = "images/screenshot.png")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.WRITE_EXTERNAL_STORAGE")

public class Screenshot extends AndroidNonvisibleComponent implements Component {

  public static final int VERSION = 1;
  private ComponentContainer container;
  private Context context;
  private final Activity activity;
  private String fileName;
  private static final String LOG_TAG = "Screenshot";


  public Screenshot(ComponentContainer container) {
    super(container.$form());
    this.container = container;
    context = (Context) container.$context();
    activity = (Activity) container.$context();
    fileName = "screenshot.jpg";
    Log.d(LOG_TAG, "Screenshot Created" );
  }



  /**
   * Return fileName
   */
  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "filename of the screenshot to be taken")
  public String FileName() {
    return fileName;
  }


  /**
   * Set fileName
   */
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
      defaultValue = "screenshot.jpg")
  @SimpleProperty
  public void FileName(String fileName) {
    this.fileName = fileName;
  }


  /**
   * Take a screenshot
   */
  @SimpleFunction(description = "Take a screenshot.")
  public void TakeScreenshot() {
    // "http://stackoverflow.com/a/5651242/1545993
    try {
      // image naming and path  to include sd card  appending name you choose for file
      String mPath = Environment.getExternalStorageDirectory().toString() + File.separator + fileName;

      // create bitmap screen capture
      View v1 = activity.getWindow().getDecorView().getRootView();
      v1.setDrawingCacheEnabled(true);
      Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
      v1.setDrawingCacheEnabled(false);

      File imageFile = new java.io.File(mPath);

      FileOutputStream outputStream = new FileOutputStream(imageFile);
      int quality = 100;
      bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
      outputStream.flush();
      outputStream.close();

      Log.d(LOG_TAG, "screenshot taken: " + imageFile.toString());
      AfterScreenshot(imageFile.toString());
    } catch (Throwable e) {
      // Several error may come out with file handling or OOM
      Log.e(LOG_TAG, e.getMessage(), e);
      e.printStackTrace();
    }
  }

  /**
   * The AfterScreenshot event
   */
  @SimpleEvent(description = "Return image.")
  public void AfterScreenshot(String image){
    EventDispatcher.dispatchEvent(this, "AfterScreenshot", image);
  }

}