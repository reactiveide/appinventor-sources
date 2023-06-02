package com.google.appinventor.components.runtime;

// Copyright © 2023 ReactiveIDE
// HydrIDE, Hybro and Hybro Studio are previous name assoiated with any MIT App Inventor based software of ReactiveIDE
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0
// Hybro's Dynamic Web View created by Hei at Hybro in 2020 and Hei, All rights reserved.

import android.content.Context;
import android.util.Log;
import android.view.*;
import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.util.TypedValue;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.view.Gravity;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.*;
import java.lang.String;
import gnu.math.IntNum;


@DesignerComponent(version = 1, 
                  description = "Dynamic Component - Web Viewer, a dynamic component for creating WebViewer.",
                  category = ComponentCategory.EXPERIMENTAL,
                  nonVisible = true,
                  iconName = "https://cdn.reactiveide.com/web.png")

@SimpleObject
public class DynamicWebView extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; 
    private Activity activity; 
    private ViewGroup vg;
	private String urls;
	
	//webview number
	private int webno = 0;
	
	//custom font pack
    //Backing for custom font typeface
    // Font path
    protected String fontPath = "";
    private String fontTypefaceCustom;
    private boolean isRepl = false;
    

    public DynamicWebView(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context();
        activity = (Activity) context;
		
		if (this.container.$form() instanceof ReplForm) {
            this.isRepl = true;
		}
		
    }
  
public static int getColorInt(Object colorType){
    int colorIntValue = 0;
    IntNum number = null;
    if (colorType instanceof String){
      colorIntValue = Color.parseColor((String) colorType);
    } else { 
      number = (IntNum) colorType;
      colorIntValue = number.intValue();
    }
      return colorIntValue;
    }

   
  @SimpleFunction(description="Add A WebView")
  public void AddWebView(int webViewID , int width , int height , int parentLayoutID){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(parentLayoutID));
    WebView WV = new WebView(activity);
    WV.setTag(webViewID);
    WV.setId(webViewID);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width , height);
    WV.setLayoutParams(params);
	WV.getSettings().setBuiltInZoomControls(true);
	WV.getSettings().setDisplayZoomControls(false);
	WV.setWebViewClient(new WebViewClient());
	vg.addView(WV);
	
	final int ids = webViewID;
	

    
    
   }


    @SimpleFunction(description="Set the view's visibility")
	public void setVisible(int webViewID , boolean isVisible) {
		WebView WV = (WebView)vg.findViewWithTag(webViewID);
		if(isVisible){
			WV.setVisibility(View.VISIBLE);
		}
		else{
			WV.setVisibility(View.GONE);
		}
	}
	@SimpleFunction(description="Get the view's visibility")
	public boolean isVisible(int webViewID) {
		WebView WV = (WebView)vg.findViewWithTag(webViewID);
		if(WV.getVisibility()==View.VISIBLE){
			return true;
		}
		else{
			return false;
		}
	}
	@SimpleFunction(description="Call the Dynamic WebView to go back")
	public void goBack(int webViewID) {
		WebView WV = (WebView)vg.findViewWithTag(webViewID);
		WV.goBack();
	}
	@SimpleFunction(description="Get if the Dynamic WebView can go back")
	public boolean canGoBack(int webViewID) {
		WebView WV = (WebView)vg.findViewWithTag(webViewID);
		return WV.canGoBack();
	}
	 @SimpleFunction(description="Call the Dynamic WebView to go forward")
	  public void goForward(int webViewID) {
		WebView WV = (WebView)vg.findViewWithTag(webViewID);
		WV.goForward();
	  }
	  @SimpleFunction(description="Get if the Dynamic WebView can go forward")
	public boolean canGoForward(int webViewID) {
		WebView WV = (WebView)vg.findViewWithTag(webViewID);
		return WV.canGoForward();
	}
	@SimpleFunction(description="Call the Dynamic WebView to go to a specific URL")
	  public void setURL(int webViewID , String url){
		  WebView WV = (WebView)vg.findViewWithTag(webViewID);
		  
          WV.loadUrl(url);
		  //Code to enable redirect \/
		  /*final int ids = webViewID;
		  WV.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url){
				WebView WV = (WebView)vg.findViewWithTag(ids);
        // do your handling codes here, which url is the requested url
        // probably you need to open that url rather than redirect:
		
        return false; // then it is not handled by default action
	}
	});*/
	   
	}
	@SimpleFunction(description="Get the Dynamic WebView's current URL")
	  public String getWebViewURL(int webViewID){
	   WebView WV = (WebView)vg.findViewWithTag(webViewID);
	   return WV.getUrl();
	}
	/*@SimpleFunction(description="Call the Dynamic WebView to go to a specific URL")
	  public void fingerZooom(int webViewID){
	   WebView WV = (WebView)vg.findViewWithTag(webViewID);
	   
	}*/
	@SimpleFunction(description="Delete the selected view")
	  public void DeleteView(int webViewID){
	   WebView WV = (WebView)vg.findViewWithTag(webViewID);
	   ViewGroup dlbt = (ViewGroup)WV.getParent();
	   dlbt.removeView(WV);
	  }
   
   
   
   
   


 // Hei
 // Hybro
 // Protected	  
  
  }
