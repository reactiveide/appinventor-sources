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
import android.widget.TextView;
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
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic Label",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.hybro.io/label.png")


@SimpleObject
public class DynamicLabel extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private ViewGroup vg;
    private boolean isRepl = false;
	
	
	  //custom fot pack
	  //Backing for custom font typeface
	  // Font path
	  protected String fontPath = "";
	  private String fontTypefaceCustom;
	  //private boolean isRepl = false;
  
    public DynamicLabel(ComponentContainer container) {
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

   
  @SimpleFunction(description="Add A Label")
  public void AddLabel(int id , String text , int layout){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layout));
    TextView myText = new TextView(activity);
    myText.setTag(id);
    myText.setId(id);
    myText.setText(text);
    vg.addView(myText);
	
	  myText.setOnClickListener(new View.OnClickListener() {
	  @Override
	  public void onClick(View v) {
		  int txtID = v.getId();//getId of Clicked Button
		  ButtonClicked(txtID);
		  }
		  });
			myText.setOnLongClickListener(new View.OnLongClickListener() {
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
  public void SetText(int id , String text){
   TextView myText = (TextView)vg.findViewWithTag(id);
   myText.setText(text);
  }
   
@SimpleFunction
  public void SetFont(int id , String font){
    TextView myText = (TextView)vg.findViewWithTag(id);
    if (!this.isRepl) {
                myText.setTypeface(Typeface.createFromAsset(this.context.getAssets(), font));
            } 
                else {
                myText.setTypeface(Typeface.createFromFile("/mnt/sdcard/AppInventor/assets/" + font));
            }
  }


   @SimpleFunction
  public void SetSize(int id , int width , int height){
   TextView myText = (TextView)vg.findViewWithTag(id);
   LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    myText.setLayoutParams(lp);
  }
   
   @SimpleFunction
  public void SetLabelColor(int id , Object color){
   TextView myText = (TextView)vg.findViewWithTag(id);
   myText.setTextColor(getColorInt(color));
  }

@SimpleFunction
  public void SetLabelSize(int id , int size){
   TextView myText = (TextView)vg.findViewWithTag(id);
   myText.setTextSize(TypedValue.COMPLEX_UNIT_PT, size);
  }

@SimpleFunction
  public void DeleteLabel(int id){
   TextView myText = (TextView)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myText.getParent();
   dlbt.removeView(myText);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   TextView myText = (TextView)vg.findViewWithTag(id);
   if(visible){
   myText.setVisibility(View.VISIBLE);
   }
   else {
  myText.setVisibility(View.GONE);
   }
 }

   @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	TextView WV = (TextView)vg.findViewWithTag(viewID);
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
 /*@SimpleFunction(description = "Specifies the path of the fonts of the %type%.  " +
      "This will override the settings in FontTypeface.")
  public void CustomFontTypeface(int id,String typefaces) {
	
	
	TextView myText = (TextView)vg.findViewWithTag(id);
	fontPath = (typefaces == null) ? "" : typefaces;
	//fontTypefaceCustom = typefaces;
	if (typefaces.length() > 0) {
			
			if(isRepl){			
				//Notifier noti = null;
				//noti.ShowAlert("Custom fonts not supported in app testing.");
				myText.setTypeface(Typeface.createFromFile("/sdcard/AppInventor/assets/"+typefaces),0);
			}
			else{
				myText.setTypeface(Typeface.createFromAsset(context.getAssets(), typefaces),0);
			}
		
	}
	
  }*/
  
  }
