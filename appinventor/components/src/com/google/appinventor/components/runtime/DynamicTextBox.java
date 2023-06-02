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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.graphics.Typeface;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.google.appinventor.components.runtime.util.YailList;
import java.lang.String;
import android.util.TypedValue;
import gnu.math.IntNum;
import android.graphics.Color;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic Label",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.reactiveide.com/textbox.png")


@SimpleObject
public class DynamicTextBox extends AndroidNonvisibleComponent {
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
  
    public DynamicTextBox(ComponentContainer container) {
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

   
  @SimpleFunction(description="Add A EditText")
  public void AddEditText(int id , String text , int width , int height , int layoutId){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layoutId));
    EditText myEditText = new EditText(activity);
    myEditText.setTag(id);
    myEditText.setText(text);
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    myEditText.setLayoutParams(lp);
    vg.addView(myEditText); 
   }


@SimpleFunction
  public void SetEditTextText(int id , String text){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   myEditText.setText(text);
  }

  @SimpleFunction
  public void SetEditTextHint(int id , String text){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   myEditText.setHint(text);
  }
   
   @SimpleFunction
  public void SetEditTextSize(int id , int width , int height){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    myEditText.setLayoutParams(lp);
  }

@SimpleFunction
  public void SetBackgroundColor(int id , Object color){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   myEditText.setBackgroundColor(getColorInt(color));
  }
   
   @SimpleFunction
  public void SetTextColor(int id , Object color){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   myEditText.setTextColor(getColorInt(color));
  }

  @SimpleFunction
  public void SetEditTextEnabled(int id , boolean enabled){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   myEditText.setEnabled(enabled); 
  }


@SimpleFunction
  public void SetTextSize(int id , int size){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   myEditText.setTextSize(TypedValue.COMPLEX_UNIT_PT, size);
  }

@SimpleFunction
  public void DeleteEditText(int id){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myEditText.getParent();
   dlbt.removeView(myEditText);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   EditText myEditText = (EditText)vg.findViewWithTag(id);
   if(visible){
   myEditText.setVisibility(View.VISIBLE);
   }
   else {
  myEditText.setVisibility(View.GONE);
   }
 }

  @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	EditText WV = (EditText)vg.findViewWithTag(viewID);
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
	
	
	EditText myEditText = (EditText)vg.findViewWithTag(id);
	fontPath = (typefaces == null) ? "" : typefaces;
	//fontTypefaceCustom = typefaces;
	if (typefaces.length() > 0) {
			
			if(isRepl){			
				//Notifier noti = null;
				//noti.ShowAlert("Custom fonts not supported in app testing.");
				myEditText.setTypeface(Typeface.createFromFile("/sdcard/AppInventor/assets/"+typefaces),0);
			}
			else{
				myEditText.setTypeface(Typeface.createFromAsset(context.getAssets(), typefaces),0);
			}
		
	}
	
  }
  
  }
