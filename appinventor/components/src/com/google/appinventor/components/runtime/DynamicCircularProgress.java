package com.google.appinventor.components.runtime;

// Copyright © 2023 ReactiveIDE
// HydrIDE, Hybro and Hybro Studio are previous name assoiated with any MIT App Inventor based software of ReactiveIDE
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0
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
import android.widget.ProgressBar;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.google.appinventor.components.runtime.util.YailList;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import java.lang.String;
import android.util.TypedValue;
import gnu.math.IntNum;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.Gravity;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic CircularProgress",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.reactiveide.com/CustomProgress.png")

@SimpleObject
public class DynamicCircularProgress extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private ViewGroup vg;
  
    public DynamicCircularProgress(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context(); //Added
        activity = (Activity) context; //Added
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

   
  @SimpleFunction(description="Add A CircularProgress")
  public void AddCircularProgress(int id , int width , int height , int layout , boolean indeterminate){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layout));
    ProgressBar myCircularProgress = new ProgressBar(activity);
    myCircularProgress.setTag(id);
    myCircularProgress.setId(id);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width , height);
    myCircularProgress.setLayoutParams(params);
    myCircularProgress.setIndeterminate(indeterminate);
    vg.addView(myCircularProgress);
    
    myCircularProgress.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
  int btnID = v.getId();//getId of Clicked CircularProgress
  CircularProgressClicked(btnID);
  }
  });
    myCircularProgress.setOnLongClickListener(new View.OnLongClickListener() {
@Override
public boolean onLongClick(View v) {
  int btnID = v.getId();
  CircularProgressLongClicked(btnID);
  return true;
}
});
   }


  
@SimpleEvent
public void CircularProgressClicked(int btnID) {
EventDispatcher.dispatchEvent(this, "CircularProgressClicked", btnID);
}
  @SimpleEvent
  public void CircularProgressLongClicked(int btnID) {
    EventDispatcher.dispatchEvent(this, "CircularProgressLongClicked", btnID);
  }   
   @SimpleFunction
  public void SetCircularProgressSize(int id , int width , int height){
   ProgressBar myCircularProgress = (ProgressBar)vg.findViewWithTag(id);
    myCircularProgress.setLayoutParams(new LinearLayout.LayoutParams(width , height));
  }

@SimpleFunction
  public void SetProgressBackgroundBarColor(int id , Object color){
   ProgressBar myCircularProgress = (ProgressBar)vg.findViewWithTag(id);
   myCircularProgress.setBackgroundColor(getColorInt(color));
  }
  
@SimpleFunction
  public void DeleteCircularProgress(int id){
   ProgressBar myCircularProgress = (ProgressBar)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myCircularProgress.getParent();
   dlbt.removeView(myCircularProgress);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   ProgressBar myCircularProgress = (ProgressBar)vg.findViewWithTag(id);
   if(visible==true){
   myCircularProgress.setVisibility(View.VISIBLE);
   }
   else {
  myCircularProgress.setVisibility(View.GONE);
   }
 }

    @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	ProgressBar WV = (ProgressBar)vg.findViewWithTag(viewID);
    //insert findview w/ tag code
    if(WV.getVisibility()==View.VISIBLE){
      return true;
    }
    else{
      return false;
    }
}

  }
