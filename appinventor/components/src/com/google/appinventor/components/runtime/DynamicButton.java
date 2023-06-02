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
import android.widget.Button;
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
import android.graphics.Typeface;
import android.view.Gravity;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic Button",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.reactiveide.com/button.png")

@SimpleObject
public class DynamicButton extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private ViewGroup vg;
	
	//custom fot pack
    //Backing for custom font typeface
    // Font path
    protected String fontPath = "";
    private String fontTypefaceCustom;
    private boolean isRepl = false;
  
    public DynamicButton(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context(); //Added
        activity = (Activity) context; //Added
		
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

   
  @SimpleFunction(description="Add A Button")
  public void AddButton(int id , String text , int width , int height , int layout){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layout));
    Button myButton = new Button(activity);
    myButton.setTag(id);
    myButton.setId(id);
    myButton.setText(text);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width , height);
    myButton.setLayoutParams(params);
    vg.addView(myButton);
    
    myButton.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
  int btnID = v.getId();//getId of Clicked Button
  ButtonClicked(btnID);
  }
  });
    myButton.setOnLongClickListener(new View.OnLongClickListener() {
@Override
public boolean onLongClick(View v) {
  int btnID = v.getId();
  ButtonLongClicked(btnID);
  return true;
}
});
   }


  
@SimpleEvent
public void ButtonClicked(int btnID) {
EventDispatcher.dispatchEvent(this, "ButtonClicked", btnID);
}
  @SimpleEvent
  public void ButtonLongClicked(int btnID) {
    EventDispatcher.dispatchEvent(this, "ButtonLongClicked", btnID);
  }
@SimpleFunction
  public void SetButtonText(int id , String text){
   Button myButton = (Button)vg.findViewWithTag(id);
   myButton.setText(text);
  }
   
   @SimpleFunction
  public void SetButtonSize(int id , int width , int height){
   Button myButton = (Button)vg.findViewWithTag(id);
    myButton.setLayoutParams(new LinearLayout.LayoutParams(width , height));
  }

@SimpleFunction
  public void SetButtonColor(int id , Object color){
   Button myButton = (Button)vg.findViewWithTag(id);
   myButton.getBackground().setColorFilter((getColorInt(color)), PorterDuff.Mode.SRC_ATOP);
  }
   
   @SimpleFunction
  public void SetTextColor(int id , Object color){
   Button myButton = (Button)vg.findViewWithTag(id);
   myButton.setTextColor(getColorInt(color));
  }

  @SimpleFunction
  public void SetButtonEnabled(int id , boolean enabled){
   Button myButton = (Button)vg.findViewWithTag(id);
   myButton.setEnabled(enabled); 
  }


@SimpleFunction
  public void SetTextSize(int id , int size){
   Button myButton = (Button)vg.findViewWithTag(id);
   myButton.setTextSize(TypedValue.COMPLEX_UNIT_PT, size);
  }

@SimpleFunction
  public void DeleteButton(int id){
   Button myButton = (Button)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myButton.getParent();
   dlbt.removeView(myButton);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   Button myButton = (Button)vg.findViewWithTag(id);
   if(visible){
   myButton.setVisibility(View.VISIBLE);
   }
   else {
  myButton.setVisibility(View.GONE);
   }
 }

   @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	Button WV = (Button)vg.findViewWithTag(viewID);
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
 
  @SimpleFunction(description = "Specifies the path of the fonts of the %type%.  " +
      "This will override the settings in FontTypeface.")
  public void CustomFontTypeface(int id,String typefaces) {
	
	
	Button myButton = (Button)vg.findViewWithTag(id);
	fontPath = (typefaces == null) ? "" : typefaces;
	//fontTypefaceCustom = typefaces;
	if (typefaces.length() > 0) {
			
			if(isRepl){			
				//Notifier noti = null;
				//noti.ShowAlert("Custom fonts not supported in app testing.");
				myButton.setTypeface(Typeface.createFromFile("/sdcard/AppInventor/assets/"+typefaces),0);
			}
			else{
				myButton.setTypeface(Typeface.createFromAsset(context.getAssets(), typefaces),0);
			}
		
	}
	
  }
 
  
  }
