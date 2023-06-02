package com.google.appinventor.components.runtime;

// Copyright © 2023 ReactiveIDE
// HydrIDE, Hybro and Hybro Studio are previous name assoiated with any MIT App Inventor based software of ReactiveIDE
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0



    

import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;
import android.app.Activity;
import android.content.Context;
import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.downloader.Status;

@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.ACCESS_NETWORK_STATE,android.permission.WRITE_EXTERNAL_STORAGE,android.permission.READ_EXTERNAL_STORAGE")
@DesignerComponent(version = 1,  description = "Download Files With This",
        category = ComponentCategory.UTILS,
        nonVisible = true,
        iconName = "https://cdn.reactiveide.com/downloadicon.png")
@UsesLibraries(libraries="prdownloader.jar")
@SimpleObject
public class CustomDownload extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private String downloadinglink = "";
    private String filename = "file";
    private String path = "/storage/emulated/0/Download";
    private int downloadID = 1;
  
    public CustomDownload(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context(); //Added
        activity = (Activity) context; //Added
        PRDownloader.initialize(context);
    }

    @SimpleFunction
    public void DownloadFile(){ 
  	downloadID = PRDownloader.download(downloadinglink,path,filename)
        .build()
        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
            public void onStartOrResume() {
            DownloadStartOrResume();
            }
        })
        .setOnPauseListener(new OnPauseListener() {
            public void onPause() {
            DownloadPaused();
            }
        })
        .setOnCancelListener(new OnCancelListener() {
            public void onCancel() {
            DownloadCancled();
            }
        })
        .setOnProgressListener(new OnProgressListener() {
            public void onProgress(Progress progress) {
            long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
            ProgressChanged(progressPercent , progress.currentBytes , progress.totalBytes);
            }
        })
        .start(new OnDownloadListener() {
            public void onDownloadComplete() {
            DownloadComplete();
            }

            public void onError(Error error) {
            ErrorOccured(error.toString());
            }


        });

    }

    @SimpleFunction
    public void CancelDownload(){
       PRDownloader.cancel(downloadID);
    }

    @SimpleFunction
    public void PauseDownload(){
       PRDownloader.pause(downloadID);
    }

    @SimpleFunction
    public void ResumeDownload(){
       PRDownloader.resume(downloadID);
    }  

    @SimpleEvent
    public void DownloadStartOrResume(){
      EventDispatcher.dispatchEvent(this ,"DownloadStartOrResume");
    }

    @SimpleEvent
    public void DownloadPaused(){
      EventDispatcher.dispatchEvent(this ,"DownloadPaused");
    }

    @SimpleEvent
    public void DownloadCancled(){
      EventDispatcher.dispatchEvent(this ,"DownloadCancled");
    }

    @SimpleEvent
    public void ProgressChanged(long progressPercent , long progressBytes , long totalBytes){
      EventDispatcher.dispatchEvent(this ,"ProgressChanged" , progressPercent , progressBytes , totalBytes);
    }

    @SimpleEvent
    public void DownloadComplete(){
      EventDispatcher.dispatchEvent(this ,"DownloadComplete");
    }

    @SimpleEvent
    public void ErrorOccured(String error){
      EventDispatcher.dispatchEvent(this ,"ErrorOccured" ,error);
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description="Set Downloading File Link")
    public void DownloadingLink(String link) {
        downloadinglink = link;
    }

    @DesignerProperty(defaultValue = "file", editorType = "string")
    @SimpleProperty(description="Set Download File Name(Also Include File Extension)")
    public void DownloadName(String fileName) {
        filename = fileName;
    }

    @DesignerProperty(defaultValue = "/storage/emulated/0/Download", editorType = "string")
    @SimpleProperty(description="Set Path To Store Downloaded File")
    public void DownloadPath(String filePath) {
        path = filePath;
    }


  }
