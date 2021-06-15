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



     //orginal created by Rubik, updated by Hybro devlopers, all right reserved to Hybro, thanks to orginal creator rubik

import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.google.appinventor.components.runtime.util.YailList;
import java.lang.String;
import android.util.TypedValue;
import gnu.math.IntNum;
import android.graphics.Color;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(category = ComponentCategory.DYNAMIC,
 description = "Create Dynamic Admob Banner With This!",
 iconName = "https://cdn.hybro.io/admob.png",
 nonVisible = true,
  version = 1)
@UsesLibraries(libraries = "google-play-services.jar")
@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.ACCESS_NETWORK_STATE")
@SimpleObject
public class DynamicAdmobBanner extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private ViewGroup vg;
  
    public DynamicAdmobBanner(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context(); //Added
        activity = (Activity) context; //Added
    }
     
  @SimpleFunction(description="Add A Admob Banner")
  public void AddBanner(int id ,int layoutId){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layoutId));
    AdView adView = new AdView(activity);
    adView.setTag(id);
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2 , -2);
    adView.setLayoutParams(lp);
    vg.addView(adView);
  }

  @SimpleFunction
  public void LoadAd(int id){
   final int fid = id;
   AdView adView = (AdView)vg.findViewWithTag(id);
   AdRequest adRequest = new AdRequest.Builder().build();
    adView.loadAd(adRequest);
    adView.setAdListener(new AdListener() {

    public void onAdLoaded() {
       AdLoaded(fid);
    }

    public void onAdFailedToLoad(int errorCode) {
       AdFailedToLoad(fid , errorCode);
    }

    public void onAdLeftApplication() {
      AdLeftApplication(fid);
    }

    public void onAdClosed() {
       AdClosed(fid);
    }

    public void onAdOpened() {
       AdClosed(fid);
    }

    public void onAdClicked() {
        AdClicked(fid);
    }
});

  }

   @SimpleEvent
    public void AdFailedToLoad(int errorCode , int fid) {
        EventDispatcher.dispatchEvent(this, "AdFailedToLoad", errorCode , fid);
    }

    @SimpleEvent
    public void AdClosed(int fid) {
        EventDispatcher.dispatchEvent(this, "AdClosed", fid);
    }

    @SimpleEvent
    public void AdLeftApplication(int fid) {
        EventDispatcher.dispatchEvent(this, "AdLeftApplication", fid);
    }

    @SimpleEvent
    public void AdLoaded(int fid) {
        EventDispatcher.dispatchEvent(this, "AdLoaded", fid);
    }

    @SimpleEvent
    public void AdClicked(int fid) {
        EventDispatcher.dispatchEvent(this, "AdClicked", fid);
    }

    @SimpleEvent
    public void AdOpenend(int fid) {
        EventDispatcher.dispatchEvent(this, "AdOpenend", fid);
    }

   @SimpleFunction
  public void SetBannerSize(int id , int width , int height){
   AdView adView = (AdView)vg.findViewWithTag(id);
   AdSize adSize = new AdSize(width ,height);
   adView.setAdSize(adSize);
  }

 @SimpleFunction
  public void SetAdUnitID(int id , String adunit){
   AdView adView = (AdView)vg.findViewWithTag(id);
   adView.setAdUnitId(adunit);
  }

@SimpleFunction
  public void DeleteBanner(int id){
   AdView adView = (AdView)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)adView.getParent();
   dlbt.removeView(adView);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   AdView adView = (AdView)vg.findViewWithTag(id);
   if(visible==true){
   adView.setVisibility(View.VISIBLE);
   }
   else {
  adView.setVisibility(View.GONE);
   }
 }

     @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	AdView WV = (AdView)vg.findViewWithTag(viewID);
    //insert findview w/ tag code
    if(WV.getVisibility()==View.VISIBLE){
      return true;
    }
    else{
      return false;
    }
}
  
  }
