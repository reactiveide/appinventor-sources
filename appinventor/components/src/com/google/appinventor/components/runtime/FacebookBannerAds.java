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
import android.view.*;
import android.util.Log;
import android.widget.LinearLayout;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.facebook.ads.*;

@UsesLibraries(libraries="audience-network-sdk.jar, audience-network-sdk.aar")
@SimpleObject
@DesignerComponent(category = ComponentCategory.MONITIZATION, description = "Facebook Banner Ads", version = 1, iconName = "https://cdn.reactiveide.com/facebook.png")
public final class FacebookBannerAds extends AndroidViewComponent implements Component {
    private final String TAG = "";
    private final Activity activity;
    private ComponentContainer container;
    private Context context;
    private String placementId = "1";
    private String testAdName = "IMG_16_9_APP_INSTALL#";
    private AdView adView;

    public FacebookBannerAds(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = container.$context();
        activity = container.$context();
        AudienceNetworkAds.initialize(context);

        adView = new AdView(context, placementId, AdSize.BANNER_HEIGHT_50);
        adView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        
    }

    public View getView() {
        return this.adView;
    }

    @SimpleFunction
    public void LoadAd(){
        AdListener adListener = new AdListener() {
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
              ErrorOccured(adError.getErrorMessage());
            }
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
              AdLoaded();
            }
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
              AdClicked();
            }
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
              LoggingImpression();
            }
        };

        adView.loadAd();
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

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description="Facebook Ads Placement ID")
    public void PlacementId(String placementID) {
        placementId = placementID;
        adView = new AdView(context, placementId, AdSize.BANNER_HEIGHT_50);
    }

    @DesignerProperty(defaultValue = "BANNER_HEIGHT_50", editorType = "string")
    @SimpleProperty(description="Facebook Banner Ads Size")
    public void BannerSize(String bannerSize) {
        if (bannerSize == "BANNER_HEIGHT_50") {
          adView = new AdView(context, placementId, AdSize.BANNER_HEIGHT_50);
        } else if (bannerSize == "BANNER_90") {
          adView = new AdView(context, placementId, AdSize.BANNER_HEIGHT_90);
        } else if (bannerSize == "RECTANGLE_HEIGHT_250") {
          adView = new AdView(context, placementId, AdSize.RECTANGLE_HEIGHT_250);
        } else {
          adView = new AdView(context, placementId, AdSize.BANNER_HEIGHT_50);
        }
      }  
        
        
    }
