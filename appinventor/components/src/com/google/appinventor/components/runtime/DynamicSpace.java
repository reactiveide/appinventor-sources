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
import android.widget.Space;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic Space",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.reactiveide.com/spacer.png")


@SimpleObject
public class DynamicSpace extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private ViewGroup vg;
 
    public DynamicSpace(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context(); //Added
        activity = (Activity) context; //Added
    }
  

  @SimpleFunction(description="Add A Space")
  public void AddSpace(int id, int width , int height , int layoutId){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layoutId));
    Space myButton = new Space(activity);
    myButton.setTag(id);
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    myButton.setLayoutParams(lp);
    vg.addView(myButton);
}
   @SimpleFunction
  public void SetSize(int id , int width , int height){
   Space myButton = (Space)vg.findViewWithTag(id);
   LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    myButton.setLayoutParams(lp);
  }


@SimpleFunction
  public void DeleteSpace(int id){
   Space myButton = (Space)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myButton.getParent();
   dlbt.removeView(myButton);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   Space myButton = (Space)vg.findViewWithTag(id);
   if(visible==true){
   myButton.setVisibility(View.VISIBLE);
   }
   else {
  myButton.setVisibility(View.GONE);
   }
 }

   @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
     Space WV = (Space)vg.findViewWithTag(viewID);
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
