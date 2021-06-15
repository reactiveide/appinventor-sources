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
import com.google.appinventor.components.annotations.UsesLibraries;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.google.appinventor.components.runtime.util.YailList;
import java.lang.String;
import android.util.TypedValue;
import gnu.math.IntNum;
import android.graphics.Color;

@DesignerComponent(version = 1,  description = "Creates Dynamic Arrangement",
        category = ComponentCategory.DYNAMIC,
        nonVisible = true,
        iconName = "https://cdn.hybro.io/table.png")
@SimpleObject
public class DynamicArrangement extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    public static ViewGroup vg;
 
    public DynamicArrangement(ComponentContainer container) {
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

   
  @SimpleFunction(description="Add A Arrangement")
  public void AddArrangement(int id, int width , int height , AndroidViewComponent layout , boolean horizontal , int alignment , int parentArrangementId){
    if(parentArrangementId!=0){
    vg = (ViewGroup)vg.findViewWithTag(parentArrangementId);
    } else {
    vg = (ViewGroup)layout.getView();
    }
    LinearLayout myButton = new LinearLayout(activity);
    myButton.setTag(id);
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    if (!horizontal) {
            myButton.setOrientation(1);
        } else {
            myButton.setOrientation(0);
        }
    if (alignment != 0) {
            myButton.setGravity(alignment);
        }
    myButton.setLayoutParams(lp);
    vg.addView(myButton);
    
   }
@SimpleFunction
public void SetArrangementClickable(boolean clickable , int id){
LinearLayout myButton = (LinearLayout)vg.findViewWithTag(id);

 myButton.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
  int iD = v.getId();//getId of Clicked Button
  ArrangementClicked(iD);
  }
  });

}
  
@SimpleEvent
public void ArrangementClicked(int iD) {
EventDispatcher.dispatchEvent(this, "ArrangementClicked", iD);
}

   @SimpleFunction
  public void SetSize(int id , int width , int height){
   LinearLayout myButton = (LinearLayout)vg.findViewWithTag(id);
   LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    myButton.setLayoutParams(lp);
  }

@SimpleFunction
  public void SetBackroundColor(int id , Object color){
   LinearLayout myButton = (LinearLayout)vg.findViewWithTag(id);
   myButton.setBackgroundColor(getColorInt(color));
  }


@SimpleFunction
  public void DeleteArrangement(int id){
   LinearLayout myButton = (LinearLayout)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myButton.getParent();
   dlbt.removeView(myButton);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   LinearLayout myButton = (LinearLayout)vg.findViewWithTag(id);
   if(visible==true){
   myButton.setVisibility(View.VISIBLE);
   }
   else {
  myButton.setVisibility(View.GONE);
   }
 }

      @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
  	LinearLayout WV = (LinearLayout)vg.findViewWithTag(viewID);
    //insert findview w/ tag code
    if(WV.getVisibility()==View.VISIBLE){
      return true;
    }
    else{
      return false;
    }
}

 @SimpleFunction(description = "Set the corner radius of %type%.")
  public void setCornerRadius(int id,int TopLeft, int TopRight, int BottomLeft, int BottomRight, Object color){
    double a = TopLeft;
    double b = TopLeft;
    double c = TopRight;
    double d = TopRight;
    double e = BottomLeft;
    double f = BottomLeft;
    double g = BottomRight;
    double h = BottomRight;

    LinearLayout myButton = (LinearLayout)vg.findViewWithTag(id);
    android.graphics.drawable.GradientDrawable q = new android.graphics.drawable.GradientDrawable(); 
    q.setColor(getColorInt(color)); 
    q.setCornerRadii(new float[] { (float)a, (float)b, (float)c,(float)d,(float)e, (float)f, (float)g, (float)h }); 
    myButton.setBackground(q);
  }

    @SimpleFunction(description = "Set padding.")
  public void setPadding(int id,int Top, int Bottom, int Left, int Right){
    LinearLayout myButton = (LinearLayout)vg.findViewWithTag(id);
   myButton.setPadding(Left,Top,Right,Bottom);
  }

  
  public static LinearLayout getArrangement(int layout){
   LinearLayout myButton = (LinearLayout)vg.findViewWithTag(layout);
   return myButton;
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
