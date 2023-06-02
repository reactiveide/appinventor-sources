package com.google.appinventor.components.runtime;


// Copyright © 2023 ReactiveIDE
// HydrIDE, Hybro and Hybro Studio are previous name assoiated with any MIT App Inventor based software of ReactiveIDE
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0



    

import android.app.Activity; 
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.net.Uri;
import android.util.Log;
import android.util.*;
import java.util.*;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.annotations.UsesLibraries;


@DesignerComponent(version = 4, description = "A component that can edit images.", category = ComponentCategory.EXPERIMENTAL, nonVisible = true, iconName = "https://cdn.reactiveide.com/image.png")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.READ_EXTERNAL_STORAGE, android.permission.WRITE_EXTERNAL_STORAGE")
public final class ImageUtil extends AndroidNonvisibleComponent {
	public Context context;
	public Activity activity;
	private boolean isRepl = false;

	public ImageUtil(ComponentContainer container) {
		super(container.$form());
		context = container.$context();
		if (form instanceof com.google.appinventor.components.runtime.ReplForm){
			isRepl = true; 
		}
    }
	
	@SimpleFunction(description = "")
	public void resizeImageRetainRadio(String imageInputPath,String imageOutputPath,int size) throws IOException{
		FileUtil.resizeBitmapFileRetainRatio("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2a.jpg", 50); 
	}
/*
 private void _imagetest () { 
  FileUtil.resizeBitmapFileRetainRatio("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2a.jpg", 50); 
  FileUtil.resizeBitmapFileToSquare("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2b.jpg", 50); 
  FileUtil.resizeBitmapFileToCircle("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2c.jpg"); 
  FileUtil.resizeBitmapFileWithRoundedBorder("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2d.jpg", 5); 
  FileUtil.cropBitmapFileFromCenter("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2e.jpg", 200, 200); 
  SketchwareUtil.showMessage(getApplicationContext(), "Done"); 
 } 
  
  
 private void _image2 () { 
  if (1 == 0) { 
   FileUtil.rotateBitmapFile("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2f.jpg", 200); 
   FileUtil.scaleBitmapFile("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2g.jpg", 50, 50); 
   FileUtil.skewBitmapFile("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2i.jpg", 100, 150); 
  } 
  FileUtil.setBitmapFileColorFilter("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2j.jpg", 0xFF00BCD4); 
  FileUtil.setBitmapFileBrightness("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2k.jpg", 50); 
  FileUtil.setBitmapFileContrast("/storage/emulated/0/WhatsArt/2.jpg", "/storage/emulated/0/WhatsArt/2l.jpg", 20); 
  SketchwareUtil.showMessage(getApplicationContext(), "Done"); 
  delay = new TimerTask() {
   @Override
   public void run() {
    runOnUiThread(new Runnable() {
     @Override
     public void run() {
      
     }
    });
   }
  };
  _timer.schedule(delay, (int)(1000)); 
 } 
  
  */
 
  
} 