package com.google.appinventor.components.runtime;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.IOException;

@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "A FloatingButton component is a non-visual component that can be shown as floating button on the screen. By default, the button will be at bottom-right of screen. NOTE: For this to work, the Screen Scrollable should be set to true.", iconName = "images/floatingButton.png", nonVisible = true, version = 1)
public class FloatingButton extends AndroidNonvisibleComponent implements Component {
    private static final String LOG_TAG = "FloatingButton";
    static final AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
    static final OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
    private Drawable backgroundImageDrawable;
    /* access modifiers changed from: private */
    public int bgcolor = -1;
    /* access modifiers changed from: private */
    public ComponentContainer container;
    /* access modifiers changed from: private */
    public Context context;
    private boolean enabled = true;
    /* access modifiers changed from: private */
    public Builder fabButton;
    private String imagePath = "";
    /* access modifiers changed from: private */
    public int marginBottom = 16;
    /* access modifiers changed from: private */
    public int marginLeft = 0;
    /* access modifiers changed from: private */
    public int marginRight = 16;
    /* access modifiers changed from: private */
    public int marginTop = 0;
    /* access modifiers changed from: private */
    public LayoutParams params;
    private int position = 0;
    /* access modifiers changed from: private */
    public ViewGroup rootViewGroup;
    /* access modifiers changed from: private */
    public int size = 32;
    /* access modifiers changed from: private */
    public FloatingActionButton view;
    private Boolean visible = Boolean.valueOf(true);

    public class Builder {
        int color = -1;
        Drawable drawable;
        int gravity = 85;

        public Builder(Context context) {
            FloatingButton.this.params = new LayoutParams(FloatingButton.this.size, FloatingButton.this.size);
            FloatingButton.this.params.gravity = this.gravity;
        }

        public Builder withGravity(int gravity2) {
            this.gravity = gravity2;
            return this;
        }

        public Builder withMargins(int left, int top, int right, int bottom) {
            FloatingButton.this.params.setMargins(FloatingButton.this.container.$form().convertDpToDensity(left), FloatingButton.this.container.$form().convertDpToDensity(top), FloatingButton.this.container.$form().convertDpToDensity(right), FloatingButton.this.container.$form().convertDpToDensity(bottom));
            return this;
        }

        public Builder withDrawable(Drawable drawable2) {
            this.drawable = drawable2;
            return this;
        }

        public Builder withButtonColor(int color2) {
            this.color = color2;
            return this;
        }

        public Builder withButtonSize(int size) {
            FloatingButton.this.params = new LayoutParams(size, size);
            return this;
        }

        public void setImageSize(int size) {
            if (FloatingButton.this.params != null) {
                FloatingButton.this.params.height = FloatingButton.this.container.$form().convertDpToDensity(size);
                FloatingButton.this.params.width = FloatingButton.this.container.$form().convertDpToDensity(size);
            }
        }

        public void setGravity(int gravity2) {
            if (FloatingButton.this.params != null) {
                FloatingButton.this.params.gravity = gravity2;
                FloatingButton.this.view.invalidate();
            }
        }

        @SimpleFunction(description = "Use this block when screen orientation changes")
        public void RecreateFab() {
            FloatingButton.this.view = null;
            FloatingButton.this.fabButton = new Builder(FloatingButton.this.context).withDrawable(FloatingButton.this.container.$context().getResources().getDrawable(17301547)).withButtonColor(-1).withGravity(85).withButtonSize(FloatingButton.this.container.$form().convertDpToDensity(FloatingButton.this.size)).withMargins(FloatingButton.this.marginLeft, FloatingButton.this.marginTop, FloatingButton.this.marginRight, FloatingButton.this.marginBottom);
            FloatingButton.this.fabButton.create();
            FloatingButton.this.Enabled(true);
        }

        public FloatingActionButton create() {
            Log.e(FloatingButton.LOG_TAG, "in create view is: " + (FloatingButton.this.view == null ? "null" : "not null"));
            if (FloatingButton.this.view == null) {
                Log.e(FloatingButton.LOG_TAG, "in create. creating view");
                FloatingButton.this.view = new FloatingActionButton(FloatingButton.this.context);
                FloatingButton.this.view.setFloatingActionButtonColor(FloatingButton.this.bgcolor);
                FloatingButton.this.view.setFloatingActionButtonDrawable(this.drawable);
                FloatingButton.this.params.gravity = this.gravity;
                FloatingButton.this.rootViewGroup = (ViewGroup) FloatingButton.this.container.$form().findViewById(16908290);
                FloatingButton.this.rootViewGroup.addView(FloatingButton.this.view, FloatingButton.this.params);
            }
            return FloatingButton.this.view;
        }

        private int convertToPixels(int dp, float scale) {
            return (int) ((((float) dp) * scale) + 0.5f);
        }
    }

    class FloatingActionButton extends View {
        Context context;
        Bitmap mBitmap;
        Paint mButtonPaint;
        Paint mDrawablePaint;
        boolean mHidden = false;

        public FloatingActionButton(Context context2) {
            super(context2);
            this.context = context2;
            init(-1);
            setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    FloatingButton.this.Click();
                }
            });
            setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == 1) {
                        view.setAlpha(1.0f);
                        FloatingButton.this.TouchUp();
                    } else if (event.getAction() == 0) {
                        view.setAlpha(0.6f);
                        FloatingButton.this.TouchDown();
                    }
                    return false;
                }
            });
        }

        public void setFloatingActionButtonColor(int buttonColor) {
            init(buttonColor);
        }

        public void setFloatingActionButtonDrawable(Drawable FloatingActionButtonDrawable) {
            this.mBitmap = ((BitmapDrawable) FloatingActionButtonDrawable).getBitmap();
            invalidate();
        }

        public void init(int buttonColor) {
            setWillNotDraw(false);
            setLayerType(1, null);
            this.mButtonPaint = new Paint(1);
            this.mButtonPaint.setColor(buttonColor);
            this.mButtonPaint.setStyle(Style.FILL);
            this.mDrawablePaint = new Paint(1);
            invalidate();
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            setClickable(true);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (((double) getWidth()) / 2.6d), this.mButtonPaint);
            canvas.drawBitmap(this.mBitmap, (float) ((getWidth() - this.mBitmap.getWidth()) / 2), (float) ((getHeight() - this.mBitmap.getHeight()) / 2), this.mDrawablePaint);
        }

        public void hideFloatingActionButton() {
            if (!this.mHidden) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 0.0f});
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, 0.0f});
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(new Animator[]{scaleX, scaleY});
                animSetXY.setInterpolator(FloatingButton.accelerateInterpolator);
                animSetXY.setDuration(100);
                animSetXY.start();
                this.mHidden = true;
                FloatingButton.this.view.setVisibility(8);
                invalidate();
            }
        }

        public void showFloatingActionButton() {
            if (this.mHidden) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.0f, 1.0f});
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.0f, 1.0f});
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(new Animator[]{scaleX, scaleY});
                animSetXY.setInterpolator(FloatingButton.overshootInterpolator);
                animSetXY.setDuration(200);
                animSetXY.start();
                this.mHidden = false;
                invalidate();
                FloatingButton.this.view.setVisibility(0);
            }
        }

        public boolean isHidden() {
            return this.mHidden;
        }
    }

    public FloatingButton(ComponentContainer container2) {
        super(container2.$form());
        this.container = container2;
        this.context = container2.$context();
        Log.e(LOG_TAG, "FloatingButton constructor");
        this.fabButton = new Builder(this.context).withDrawable(container2.$context().getResources().getDrawable(17301547)).withButtonColor(this.bgcolor).withGravity(85).withButtonSize(container2.$form().convertDpToDensity(this.size)).withMargins(this.marginLeft, this.marginTop, this.marginRight, this.marginBottom);
        this.fabButton.create();
        Enabled(true);
    }

    @SimpleFunction(description = "Recreates this component. Call this block when screen orientation is changed")
    public void ReCreateFAB() {
        this.rootViewGroup.removeView(this.view);
        this.view = null;
        if (this.backgroundImageDrawable != null) {
            this.backgroundImageDrawable = this.backgroundImageDrawable;
        } else {
            this.backgroundImageDrawable = this.container.$context().getResources().getDrawable(17301547);
        }
        this.fabButton = new Builder(this.context).withDrawable(this.backgroundImageDrawable).withButtonColor(this.bgcolor).withGravity(85).withButtonSize(this.container.$form().convertDpToDensity(this.size)).withMargins(this.marginLeft, this.marginTop, this.marginRight, this.marginBottom);
        this.fabButton.create();
        Enabled(this.enabled);
        Visible(this.visible);
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "If set, user can tap check box to cause action.")
    public boolean Enabled() {
        return this.enabled;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void Enabled(boolean enabled2) {
        this.enabled = enabled2;
        this.view.setEnabled(enabled2);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Image to display on button.")
    public String Image() {
        return this.imagePath;
    }

    @DesignerProperty(defaultValue = "", editorType = "asset")
    @SimpleProperty(description = "Specifies the path of the button's image.  If there is both an Image and a BackgroundColor, only the Image will be visible.")
    public void Image(String path) {
        if (!path.equals(this.imagePath)) {
            if (path == null) {
                path = "";
            }
            this.imagePath = path;
            if (this.imagePath.length() > 0) {
                try {
                    this.backgroundImageDrawable = MediaUtil.getBitmapDrawable(this.container.$form(), this.imagePath);
                    this.view.setFloatingActionButtonDrawable(this.backgroundImageDrawable);
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Unable to load " + this.imagePath);
                }
            }
        }
    }

    @DesignerProperty(defaultValue = "48", editorType = "non_negative_integer")
    @SimpleProperty(description = "Specifies the button size. Default is 56 x 56. This would be ideal if your image size is 48 x 48. Always add 8 for button size.")
    public void ButtonSize(int size2) {
        this.size = size2;
        this.fabButton.setImageSize(size2);
        this.view.invalidate();
    }

    public void ButtonPosition(int position2) {
        this.position = position2;
        if (position2 == 0) {
            this.fabButton = this.fabButton.withGravity(85);
        } else if (position2 == 1) {
            this.fabButton.setGravity(53);
        } else if (position2 == 2) {
            this.fabButton.setGravity(83);
        } else if (position2 == 3) {
            this.fabButton.setGravity(51);
        } else if (position2 == 4) {
            this.fabButton.setGravity(49);
        } else if (position2 == 5) {
            this.fabButton.setGravity(81);
        }
    }

    @SimpleEvent(description = "Indicates that the button was pressed down.")
    public void TouchDown() {
        EventDispatcher.dispatchEvent(this, "TouchDown", new Object[0]);
    }

    @SimpleEvent(description = "Indicates that the button has been released.")
    public void TouchUp() {
        EventDispatcher.dispatchEvent(this, "TouchUp", new Object[0]);
    }

    public void MarginLeft(int marginLeft2) {
        this.marginLeft = marginLeft2;
        this.fabButton = this.fabButton.withMargins(marginLeft2, this.marginTop, this.marginRight, this.marginBottom);
    }

    public void MarginTop(int marginTop2) {
        this.marginTop = marginTop2;
        this.fabButton = this.fabButton.withMargins(this.marginLeft, marginTop2, this.marginRight, this.marginBottom);
    }

    @DesignerProperty(defaultValue = "16", editorType = "non_negative_integer")
    @SimpleProperty(description = "Sets up right margin")
    public void MarginRight(int marginRight2) {
        this.marginRight = marginRight2;
        this.fabButton = this.fabButton.withMargins(this.marginLeft, this.marginTop, marginRight2, this.marginBottom);
    }

    @DesignerProperty(defaultValue = "16", editorType = "non_negative_integer")
    @SimpleProperty(description = "Sets up bottom margins")
    public void MarginBottom(int marginBottom2) {
        this.marginBottom = marginBottom2;
        this.fabButton = this.fabButton.withMargins(this.marginLeft, this.marginTop, this.marginRight, marginBottom2);
    }

    public void MarginsFromCsvRB(String csvLTRB) {
        Log.e(LOG_TAG, "MarginsFromCsvLTRB");
        String csvLTRB2 = csvLTRB.trim();
        if (csvLTRB2.isEmpty()) {
            csvLTRB2 = "16,16";
        }
        String[] margins = csvLTRB2.replaceAll(" ", "").split(",");
        if (margins.length != 2) {
            this.form.dispatchErrorOccurredEvent(this, "MarginsFromCsvRB", 3000, new Object[0]);
        }
        try {
            this.fabButton.withMargins(0, 0, Integer.valueOf(margins[0]).intValue(), Integer.valueOf(margins[1]).intValue());
        } catch (NumberFormatException e) {
            this.form.dispatchErrorOccurredEvent(this, "MarginsFromCsvLTRB", 3000, new Object[0]);
        }
        this.view.invalidate();
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public boolean Visible() {
        return this.visible.booleanValue();
    }

    @DesignerProperty(defaultValue = "True", editorType = "visibility")
    @SimpleProperty(description = "Specifies whether the component should be visible on the screen. Value is true if the component is showing and false if hidden.")
    public void Visible(Boolean visibility) {
        this.visible = visibility;
        if (this.visible.booleanValue()) {
            this.view.showFloatingActionButton();
        } else {
            this.view.hideFloatingActionButton();
        }
    }

    @SimpleEvent(description = "User tapped and released the button.")
    public void Click() {
        EventDispatcher.dispatchEvent(this, "Click", new Object[0]);
    }

    @DesignerProperty(defaultValue = "&H00FFFFFF", editorType = "color")
    @SimpleProperty
    public void BackgroundColor(int argb) {
        if (this.view != null) {
            this.view.setFloatingActionButtonColor(argb);
            this.bgcolor = argb;
        }
    }
}
