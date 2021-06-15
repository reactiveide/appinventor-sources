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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import com.google.appinventor.components.runtime.util.YailList;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import java.lang.String;
import android.util.TypedValue;
import gnu.math.IntNum;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.Gravity;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic CheckBox",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.hybro.io/checkbox.png")

@SimpleObject
public class DynamicCheckBox extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private ViewGroup vg;
  
    public DynamicCheckBox(ComponentContainer container) {
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

   
  @SimpleFunction(description="Add A CheckBox")
  public void AddCheckBox(int id , String text , int width , int height , int layout){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layout));
    CheckBox myCheckBox = new CheckBox(activity);
    myCheckBox.setTag(id);
    myCheckBox.setId(id);
    myCheckBox.setText(text);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width , height);
    myCheckBox.setLayoutParams(params);
    vg.addView(myCheckBox);
    final int id2 = id;
    myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    CheckedChanged(id2 ,isChecked);
    }
});

   }

  @SimpleEvent
  public void CheckedChanged(int id ,boolean isChecked){
    EventDispatcher.dispatchEvent(this ,"CheckedChanged" ,id ,isChecked);
  }  
   @SimpleFunction
  public void SetCheckBoxSize(int id , int width , int height){
   CheckBox myCheckBox = (CheckBox)vg.findViewWithTag(id);
    myCheckBox.setLayoutParams(new LinearLayout.LayoutParams(width , height));
  }

  @SimpleFunction
  public void SetCheckBoxColor(int id , Object color){
   CheckBox myCheckBox = (CheckBox)vg.findViewWithTag(id);
   myCheckBox.getBackground().setColorFilter((getColorInt(color)), PorterDuff.Mode.SRC_ATOP);
  }

  @SimpleFunction
  public void SetTextColor(int id , Object color){
   CheckBox myCheckBox = (CheckBox)vg.findViewWithTag(id);
   myCheckBox.setTextColor(getColorInt(color));
  }
   
  @SimpleFunction
  public void SetCheckBoxEnabled(int id , boolean enabled){
   CheckBox myCheckBox = (CheckBox)vg.findViewWithTag(id);
   myCheckBox.setEnabled(enabled); 
  }

@SimpleFunction
  public void DeleteCheckBox(int id){
   CheckBox myCheckBox = (CheckBox)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myCheckBox.getParent();
   dlbt.removeView(myCheckBox);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   CheckBox myCheckBox = (CheckBox)vg.findViewWithTag(id);
   if(visible==true){
   myCheckBox.setVisibility(View.VISIBLE);
   }
   else {
  myCheckBox.setVisibility(View.GONE);
   }
 }

     @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	CheckBox WV = (CheckBox)vg.findViewWithTag(viewID);
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
