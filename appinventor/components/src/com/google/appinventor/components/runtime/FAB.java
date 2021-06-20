// FAB component originally developed by Rubik
// Fixed null_pointer_exception Error by Samuel
// Icon ttf changed to FontAwesome
// This component is designed and developed for ReactiveIDE
// Copyright @ ReactiveIDE 2021
// All rights reserved

package com.gooogle.appinventor.components.runtime;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.io.File;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.ReplForm;

@UsesAssets(fileNames = "fontawesome-webfont.ttf")
@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "Floating Action Button (FAB) is a button that float on the right button corner, it uses Font Aweome 4.6.2 as icon library. Cheatsheet : https://fontawesome.com/v4.7/cheatsheet/ ", iconName = "https://cdn.reactiveide.com/fab.png", nonVisible = true, version = 1)

public class FAB extends AndroidNonvisibleComponent implements Component {
    public static final int VERSION = 1;
    private Activity Acty;
    private TextView buttonBack;
    public TextView buttonToast;
    private int bcolor = -48077;
    private int fontColor = -16;
    private ComponentContainer container;
    private Context context;
    private int ejex = 25;
    private int ejey = 25;
    private int elevation = 12;

    private EditText f0et;
    private Typeface font;
    private String iconCode = "&#xf067;";
    private Interpolator interpolador;
    private LinearLayout layout;
    private LayoutParams layoutParam;

    private LinearLayout f1ll;
    private LinearLayout ll2;
    private LinearLayout ll2B;
    private RelativeLayout relative;
    private int sizeFAB = 200;
    private int sizeIcon = 25;
    private int sizeText = 14;
    private boolean upcolor = false;

    private TextView f2tv;
    private View view;
    private boolean isCompanion = false;

    public FAB(ComponentContainer container2) {
        super(container2.$form());
        this.container = container2;
        this.context = container2.$context();
        this.Acty = (Activity) this.context;
        if (this.container.$form() instanceof ReplForm) {
            this.isCompanion = true;
        }
        this.ll2B = new LinearLayout(this.context);
        this.ll2 = new LinearLayout(this.context);
        this.buttonToast = new TextView(this.context);
        this.relative = new RelativeLayout(this.Acty);

    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Background color of FAB")
    public int ButtonColor() {
        return this.bcolor;
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR, defaultValue = ComponentConstants.DEFAULT_PRIMARY_COLOR)
    @SimpleProperty
    public void ButtonColor(int argb) {
        if (upcolor) {
        this.bcolor = AppInventorCompatActivity.getPrimaryColor();
        } else {
        this.bcolor = argb;
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Icon Color of FAB")
    public int IconColor() {
        return this.fontColor;
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR, defaultValue = Component.DEFAULT_VALUE_COLOR_WHITE)
    @SimpleProperty
    public void IconColor(int argb) {
        this.fontColor = argb;
    }

    @DesignerProperty(defaultValue = "25", editorType = "non_negative_float")
    @SimpleProperty
    public void IconSize(int iconSize) {
        this.sizeIcon = iconSize;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Icon Size of FAB")
    public int IconSize() {
        return this.sizeIcon;
    }

    @DesignerProperty(defaultValue = "200", editorType = "non_negative_float")
    @SimpleProperty
    public void ButtonSize(int fabSize) {
        this.sizeFAB = fabSize;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Button Size of FAB")
    public int ButtonSize() {
        return this.sizeFAB;
    }

    @DesignerProperty(defaultValue = "25", editorType = "non_negative_float")
    @SimpleProperty
    public void MarginRight(int marginRight) {
        this.ejex = marginRight;
    }

    @DesignerProperty(defaultValue = "25", editorType = "non_negative_float")
    @SimpleProperty
    public void MarginBottom(int marginBottom) {
        this.ejey = marginBottom;
    }

    @DesignerProperty(defaultValue = "12", editorType = "non_negative_float")
    @SimpleProperty
    public void Elevation(int elevation) {
        this.elevation = elevation;
    }

    @DesignerProperty(defaultValue = "&#xf067;", editorType = "string")
    @SimpleProperty(description = "Insert the text of icon")
    public void IconCode(String textoficon) {
        this.iconCode = textoficon;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Icon Code of FAB")
    public String IconCode() {
        return this.iconCode;
    }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, defaultValue = "True")
  @SimpleProperty(description = "Set FAB visible or not")
  public void Visible(boolean visible) {
    if (visible) {
    ButtonVisible();
    } else {
    ButtonInvisible();
    }
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, defaultValue = "False")
  @SimpleProperty(description = "Use App PrimaryColor as FAB Color")
  public void UsePrimaryColor(boolean usepcolor) {
    this.upcolor = usepcolor;
  }

    @SimpleFunction(description = "")
    public void CreateButton() {
        String str = "";
        if (this.isCompanion) {
        	this.font = Typeface.createFromFile("/mnt/sdcard/AppInventor/assets/" + "fontawesome-webfont.ttf");
            } else  {
             this.font = Typeface.createFromAsset(this.context.getAssets() ,"fontawesome-webfont.ttf");
          }
        LayoutParams llpb3 = new LayoutParams(-1, -1);
        llpb3.setMargins(0, 0, this.ejex, this.ejey);
        LayoutParams llpb = new LayoutParams(this.sizeFAB, this.sizeFAB);
        llpb.setMargins(0, 0, this.ejex, this.ejey);
        this.ll2B.setOrientation(0);
        this.ll2B.setLayoutParams(llpb3);
        this.ll2B.setGravity(85);
        this.ll2.setOrientation(0);
        this.ll2.setLayoutParams(llpb);
        this.ll2.setGravity(85);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(1);
        drawable.setCornerRadius(0.0f);
        drawable.setStroke(1, this.bcolor);
        drawable.setColor(this.bcolor);
        this.ll2.setBackgroundDrawable(drawable);
        this.ll2.setScaleX(0.0f);
        this.ll2.setScaleY(0.0f);
        int i = (int) (((float) 12) * this.context.getResources().getDisplayMetrics().density);
        LayoutParams llpb2 = new LayoutParams(this.sizeFAB, this.sizeFAB);
        llpb2.setMargins(0, 0, 0, 0);
        this.buttonToast.setTypeface(this.font);
        this.buttonToast.setTextSize((float) this.sizeIcon);
        this.buttonToast.setText(HtmlEntities.decodeHtmlText(this.iconCode));
        this.buttonToast.setTextColor(this.fontColor);
        this.buttonToast.setLayoutParams(llpb2);
        this.buttonToast.setGravity(17);
        this.ll2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ButtonClicked();
            }
        });
        this.ll2.addView(this.buttonToast);
        this.ll2B.addView(this.ll2);
        this.relative.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.relative.setGravity(85);
        this.relative.setBackgroundColor(0);
        this.relative.addView(this.ll2B, llpb3);
        RelativeLayout.LayoutParams layoutParam2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParam2.addRule(12);
        this.Acty.addContentView(this.relative, layoutParam2);
        this.interpolador = AnimationUtils.loadInterpolator(this.context, 17563661);
        
        //Set button to visible
        ButtonVisible();
    }

    public void ButtonInvisible() {
        int duration = 100;
        int startDelay = 0;
        this.ll2.animate().scaleY(0.0f).scaleX(0.0f).setInterpolator(this.interpolador).setDuration((long) duration).setStartDelay((long) startDelay).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
    }

    public void ButtonVisible() {
        int duration = 200;
        int startDelay = 0;
        this.ll2.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(this.interpolador).setDuration((long) duration).setStartDelay((long) startDelay).setListener(new AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    @SimpleEvent
    public void ButtonClicked() {
        EventDispatcher.dispatchEvent(this, "ButtonClicked", new Object[0]);
    }

    @SimpleFunction(description = "Use this block when you have to change icon from existing to new one.")
    public void ChangeIcon(final String newIconCode, final int duration) {
        this.buttonToast.animate().alpha(0.0f).setDuration((long) duration).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                buttonToast.setText(HtmlEntities.decodeHtmlText(newIconCode));
                buttonToast.animate().alpha(1.0f).setDuration((long) duration).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
            }
        });
    }
}