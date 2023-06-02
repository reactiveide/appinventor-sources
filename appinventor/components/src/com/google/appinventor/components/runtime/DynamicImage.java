package com.google.appinventor.components.runtime;

// Copyright © 2023 ReactiveIDE
// HydrIDE, Hybro and Hybro Studio are previous name assoiated with any MIT App Inventor based software of ReactiveIDE
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0
//orginal created by Rubik, updated by Hybro devlopers, all right reserved to Hybro, thanks to orginal creator rubik

import android.graphics.Typeface;
import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.google.appinventor.components.runtime.util.YailList;
import java.lang.String;
import android.util.TypedValue;
import gnu.math.IntNum;
import android.graphics.Color;
import java.io.InputStream;
import java.net.URL;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic Image",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.reactiveide.com/image.png")


@SimpleObject
public class DynamicImage extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private ViewGroup vg;
    private boolean isRepl = false;
  
    public DynamicImage(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context(); //Added
        activity = (Activity) context; //Added
        if (this.container.$form() instanceof ReplForm) {
            this.isRepl = true;
        }
        
    }
   
  @SimpleFunction(description="Add A Image")
  public void AddImage(int id, int width , int height , String image , int layoutId){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layoutId));
    ImageView img = new ImageView(activity);
    img.setId(id);
    img.setTag(id);
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    img.setLayoutParams(lp);
    img.setAdjustViewBounds(true);
    if(image.contains("http://") || image.contains("https://")){
      try {
        InputStream is = (InputStream) new URL(image).getContent();
        Drawable d = Drawable.createFromStream(is, "src name");
        img.setImageDrawable(d);
    } catch (Exception e) {
    }
    }else{
        if (!this.isRepl) {
            try {
                img.setImageDrawable(Drawable.createFromStream(activity.getAssets().open(image), null));
                } catch (Exception e) {
                }
            } else {
                img.setImageDrawable(Drawable.createFromPath("/mnt/sdcard/AppInventor/assets/" + image));
            }
    }
    vg.addView(img); 
	
	
	 img.setOnClickListener(new View.OnClickListener() {
	  @Override
	  public void onClick(View v) {
	  int btnID = v.getId();//getId of Clicked Button
	  ButtonClicked(btnID);
	  }
	  });
		img.setOnLongClickListener(new View.OnLongClickListener() {
	@Override
	public boolean onLongClick(View v) {
	  int btnID = v.getId();
	  ButtonLongClicked(btnID);
	  return true;
	}
	});
   }

     @SimpleEvent(description = "User tapped and released the component.")
  public void ButtonClicked(int btnID) {
    EventDispatcher.dispatchEvent(this, "Click", btnID);
  }

   @SimpleEvent(description = "User held the component down.")
  public boolean  ButtonLongClicked(int btnID) {
    return EventDispatcher.dispatchEvent(this, "LongClick", btnID);
  }


@SimpleFunction
  public void SetImage(int id , String image){
   ImageView img = (ImageView)vg.findViewWithTag(id);
   if (!this.isRepl) {
            try {
                img.setImageDrawable(Drawable.createFromStream(activity.getAssets().open(image), null));
                } catch (Exception e) {
                }
            } else {
                img.setImageDrawable(Drawable.createFromPath("/mnt/sdcard/AppInventor/assets/" + image));
            }
  }
   
   @SimpleFunction
  public void SetSize(int id , int width , int height){
   ImageView img = (ImageView)vg.findViewWithTag(id);
   LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    img.setLayoutParams(lp);
  }
   
@SimpleFunction
  public void DeleteImage(int id){
   ImageView img = (ImageView)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)img.getParent();
   dlbt.removeView(img);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   ImageView img = (ImageView)vg.findViewWithTag(id);
   if(visible==true){
   img.setVisibility(View.VISIBLE);
   }
   else {
  img.setVisibility(View.GONE);
   }
 }

  @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	ImageView WV = (ImageView)vg.findViewWithTag(viewID);
    //insert findview w/ tag code
    if(WV.getVisibility()==View.VISIBLE){
      return true;
    }
    else{
      return false;
    }
  }

  @SimpleFunction
 public int PercentSizeWidth(int percent){
 	int finalpercent = (vg.getWidth()*percent) / 100;
 	return finalpercent;
 }

 @SimpleFunction
 public int PercentSizeHeight(int percent){
 	int finalpercent = (vg.getHeight()*percent) / 100;
 	return finalpercent;
 }
  }
