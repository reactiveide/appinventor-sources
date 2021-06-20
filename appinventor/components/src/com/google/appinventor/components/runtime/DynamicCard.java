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
import androidx.cardview.widget.CardView;
import android.widget.RelativeLayout;
import com.google.appinventor.components.runtime.DynamicArrangement;

@DesignerComponent(version = 1,  description = "Creates Dynamic Card",
        category = ComponentCategory.EXPERIMENTAL,
        nonVisible = true,
        iconName = "https://cdn.reactiveide.com/button.png")

@UsesLibraries(libraries = "cardview.jar , cardview.aar")
@SimpleObject
public class DynamicCard extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context; //Added
    private Activity activity; //Added
    private static ViewGroup vg;

    public DynamicCard(ComponentContainer container) {
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

   
  @SimpleFunction(description="Add A CardView")
  public void AddCard(int id, int width , int height , int layoutId){
    vg = (ViewGroup)(DynamicArrangement.getArrangement(layoutId));
    CardView myButton = new CardView(activity);
    myButton.setTag(id);
    myButton.setId(id);
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    lp.setMargins(0, 0, 0, 0);
    myButton.setLayoutParams(lp);
    vg.addView(myButton);
    

   }
@SimpleFunction
public void SetCardClickable(boolean clickable , int id){
CardView myButton = (CardView)vg.findViewWithTag(id);
 myButton.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
  int cardID = v.getId();//getId of Clicked Button
  CardClicked(cardID);
  }
  });

}
  
@SimpleEvent
public void CardClicked(int cardID) {
EventDispatcher.dispatchEvent(this, "CardClicked", cardID);
}

   @SimpleFunction
  public void SetCardSize(int id , int width , int height){
   CardView myButton = (CardView)vg.findViewWithTag(id);
   LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width , height);
    myButton.setLayoutParams(lp);
  }

@SimpleFunction
  public void SetBackroundColor(int id , Object color){
   CardView myButton = (CardView)vg.findViewWithTag(id);
   myButton.setCardBackgroundColor(getColorInt(color));
  }


@SimpleFunction
  public void DeleteCard(int id){
   CardView myButton = (CardView)vg.findViewWithTag(id);
   ViewGroup dlbt = (ViewGroup)myButton.getParent();
   dlbt.removeView(myButton);
  }

  @SimpleFunction
  public void SetVisible(int id , boolean visible){
   CardView myButton = (CardView)vg.findViewWithTag(id);
   if(visible==true){
   myButton.setVisibility(View.VISIBLE);
   }
   else {
  myButton.setVisibility(View.GONE);
   }
 }

   @SimpleFunction(description="Get the view's visibility")
  public boolean isVisible(int viewID) {
     CardView WV = (CardView)vg.findViewWithTag(viewID);
    if(WV.getVisibility()==View.VISIBLE){
      return true;
    }
    else{
      return false;
    }
  }

     @SimpleFunction
     public void SetRadius(int id , int radius){
        CardView myButton = (CardView)vg.findViewWithTag(id);
        myButton.setRadius(radius);
     }

     @SimpleFunction
     public void SetElevation(int id, int elevation){
        CardView myButton = (CardView)vg.findViewWithTag(id);
        myButton.setMaxCardElevation(elevation);
     }


}
