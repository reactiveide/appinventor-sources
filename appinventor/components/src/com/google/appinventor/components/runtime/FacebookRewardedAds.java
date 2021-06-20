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



    

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.facebook.ads.*;

@UsesLibraries(libraries="audience-network-sdk.jar, audience-network-sdk.aar")
@SimpleObject
@DesignerComponent(category = ComponentCategory.MONITIZATION, description = "Show Fb Rewarded ads", nonVisible = true, version = 1,iconName = "https://cdn.reactiveide.com/facebook.png")
public final class FacebookRewardedAds extends AndroidNonvisibleComponent implements Component {
    private final Activity activity;
    private ComponentContainer container;
    private Context context;
    private String placementId = "1";
    private RewardedVideoAd rewardedVideoAd;

    public FacebookRewardedAds(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = container.$context();
        activity = container.$context();
        AudienceNetworkAds.initialize(context);
        
    }

    @SimpleFunction
    public void LoadAd(){
        RewardedVideoAdListener rewardedVideoAdListener = new RewardedVideoAdListener() {
            public void onError(Ad ad, AdError adError) {
                ErrorOccured(adError.getErrorMessage());
            }

            public void onAdLoaded(Ad ad) {
                AdLoaded();
            }

            public void onAdClicked(Ad ad) {
                AdClicked();
            }

            public void onLoggingImpression(Ad ad) {
                LoggingImpression();
            }

            public void onRewardedVideoCompleted() {
                RewardedVideoCompleted();
            }

             public void onRewardedVideoClosed() {
                RewardedVideoClosed();
             }
        };

        rewardedVideoAd.loadAd();
    }

    @SimpleFunction
    public void ShowAd(){
        rewardedVideoAd.show();
    }

    @SimpleEvent
    public void RewardedVideoCompleted(){
        EventDispatcher.dispatchEvent(this ,"RewardedVideoCompleted");
    }

    @SimpleEvent
    public void RewardedVideoClosed(){
        EventDispatcher.dispatchEvent(this ,"RewardedVideoClosed");
    }

    @SimpleEvent
    public void AdLoaded(){
        EventDispatcher.dispatchEvent(this ,"AdLoaded");
    }

    @SimpleEvent
    public void AdClicked(){
        EventDispatcher.dispatchEvent(this ,"AdClicked");
    }

    @SimpleEvent
    public void LoggingImpression(){
        EventDispatcher.dispatchEvent(this ,"LoggingImpression");
    }

    @SimpleEvent
    public void ErrorOccured(String error){
        EventDispatcher.dispatchEvent(this ,"ErrorOccured" ,error);
    }

    @SimpleFunction
    public boolean IsAdLoaded(){
    return rewardedVideoAd.isAdLoaded();
    }

    @SimpleFunction
    public boolean IsAdInvalidated(){
    return rewardedVideoAd.isAdInvalidated();
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description="Set Your Facebook ads placementId")
    public void PlacementId(String placementID) {
        placementId = placementID;
        rewardedVideoAd = new RewardedVideoAd(context, placementId);
    }

    }