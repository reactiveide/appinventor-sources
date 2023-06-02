package com.google.appinventor.components.runtime;

// Copyright © 2023 ReactiveIDE
// HydrIDE, Hybro and Hybro Studio are previous name assoiated with any MIT App Inventor based software of ReactiveIDE
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0



    

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;

@SimpleObject
@DesignerComponent(category = ComponentCategory.UTILS, description = "Update Your App", iconName = "https://cdn.reactiveide.com/updateicon.png", nonVisible = true, version = 1)
@UsesLibraries(libraries = "playcore.jar")
public final class InAppUpdate extends AndroidNonvisibleComponent implements ActivityResultListener { 
    private Context context;
    private Activity activity;
    private AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(context);
    private Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
    private InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() {
        public void onStateUpdate(InstallState state) {
            if (state.installStatus() == 11) {
                UpdateDownloaded();
            }
        }
    };
    private int MY_REQUEST_CODE = 0;

    public InAppUpdate(ComponentContainer container) {
        super(container.$form());
        context = container.$context();
        activity = container.$context();
        }

    @SimpleFunction
    public void StartUpdater(final int updateType){
    if (MY_REQUEST_CODE == 0) {
        MY_REQUEST_CODE = form.registerForActivityResult(this);
     }
    appUpdateManager.registerListener(installStateUpdatedListener);
    appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
    public void onSuccess(AppUpdateInfo appUpdateInfo) {
    if (appUpdateInfo.updateAvailability() == 1 && appUpdateInfo.isUpdateTypeAllowed(updateType)) {
        UpdateAvailable();
        try {
             appUpdateManager.startUpdateFlowForResult(appUpdateInfo, updateType , activity, MY_REQUEST_CODE);
        } catch (Exception e) {
          UpdateFailed();
         }
    } else {
        UpdateNotAvailable();
    }
}
      });

    }

    public void resultReturned(int requestCode, int resultCode, Intent data) {
    if (requestCode == MY_REQUEST_CODE) {
    if (resultCode != -1) {
     if(resultCode == 0){
     	UpdateCancelled();
     }
     if(resultCode == 1){
     	UpdateFailed();
     }
    }
    }
    }
     
     @SimpleFunction
     public void CompleteUpdate(){
         appUpdateManager.completeUpdate();
     }

     @SimpleEvent
     public void UpdateFailed(){
     	EventDispatcher.dispatchEvent(this ,"UpdateFailed");
     }

     @SimpleEvent
     public void UpdateAvailable(){
        EventDispatcher.dispatchEvent(this ,"UpdateAvailable");
     }


     @SimpleEvent
     public void UpdateNotAvailable(){
     	EventDispatcher.dispatchEvent(this ,"UpdateNotAvailable");
     }

     @SimpleEvent
     public void UpdateCancelled(){
     	EventDispatcher.dispatchEvent(this ,"UpdateCancelled");
     }

     @SimpleEvent
     public void UpdateDownloaded(){
     	EventDispatcher.dispatchEvent(this ,"UpdateDownloaded");
     }

     @SimpleProperty 
     public int IMMEDIATE(){
     	return 0;
     }

     @SimpleProperty 
     public int FLEXIBLE(){
     	return 1;
     }

}
