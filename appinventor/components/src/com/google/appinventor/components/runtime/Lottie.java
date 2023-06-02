package com.google.appinventor.components.runtime;

// Copyright © 2023 ReactiveIDE
// HydrIDE, Hybro and Hybro Studio are previous name assoiated with any MIT App Inventor based software of ReactiveIDE
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0
//Hybro's component created by rubik and updated by hybro, All rights reserved.


import android.animation.Animator;
import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import android.view.View.OnClickListener;
import java.io.InputStream;
import java.io.IOException;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;

@SimpleObject
@DesignerComponent(category = ComponentCategory.ANIMATION, description = "Lottie Component", iconName = "images/lottie.png", nonVisible = false, version = 1)
@UsesLibraries(libraries = "lottie.jar , lottie.aar")
public class Lottie extends AndroidViewComponent implements Component {
    private Context context;
    private LottieAnimationView lottie;
    private boolean looP;
    private float animationSpeed;
    
    public Lottie(ComponentContainer container) {
        super(container);
        lottie = new LottieAnimationView(container.$context());
        container.$add(this);
        lottie.addAnimatorListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
                AnimationCanceled();
            }

            public void onAnimationEnd(Animator animator) {
                AnimationEnded();
            }

            public void onAnimationRepeat(Animator animator) {
                AnimationRepeated();
            }

            public void onAnimationStart(Animator animator) {
                AnimationStarted();
            }
        });
        lottie.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Click();
            }
        });
    }

    public View getView() {
        return lottie;
    }

    @SimpleFunction
    public int GetCurrentFrame() {
        return lottie.getFrame();
    }

    @SimpleFunction
    public void CancelAnimation() {
        lottie.cancelAnimation();
    }

    @SimpleFunction
    public boolean IsAnimating() {
        return lottie.isAnimating();
    }

    @SimpleFunction
    public void PauseAnimation() {
        lottie.pauseAnimation();
    }

    @SimpleFunction
    public void ResumeAnimation() {
        lottie.resumeAnimation();
    }

    @SimpleFunction
    public void SetAnimationFrame(int animeFrame) {
        lottie.setFrame(animeFrame);
    }

    @SimpleFunction
    public void StartAnimation() {
        lottie.loop(looP);
        lottie.setSpeed(animationSpeed);
        lottie.playAnimation();
    }


    @SimpleEvent
    public void AnimationCanceled() {
        EventDispatcher.dispatchEvent(this, "AnimationCanceled", new Object[0]);
    }

    @SimpleEvent
    public void AnimationEnded() {
        EventDispatcher.dispatchEvent(this, "AnimationEnded", new Object[0]);
    }

    @SimpleEvent
    public void AnimationRepeated() {
        EventDispatcher.dispatchEvent(this, "AnimationRepeated", new Object[0]);
    }

    @SimpleEvent
    public void AnimationStarted() {
        EventDispatcher.dispatchEvent(this, "AnimationStarted", new Object[0]);
    }

    @SimpleEvent
    public final void Click() {
        EventDispatcher.dispatchEvent(this, "Click", new Object[0]);
    }

    @DesignerProperty(defaultValue = "1.0", editorType = "float")
    @SimpleProperty(description = "Set the speed of the animation.")
    public final void AnimationSpeed(float animespeed) {
        animationSpeed = animespeed;
    }

    @DesignerProperty(defaultValue = "120", editorType = "integer")
    @SimpleProperty(description = "Set the Ending Frame")
    public final void EndFrame(int endFrame) {
        lottie.setMaxFrame(endFrame);
    }

    @DesignerProperty(defaultValue = "false", editorType = "boolean")
    @SimpleProperty(description = "Set Animation Loop")
    public final void Loop(boolean loop) {
        looP = loop;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description = "Set The Json File URL")
    public final void Source(String file) {
        if (file.startsWith("http://") || file.startsWith("https://")) {
            lottie.setAnimationFromUrl(file);
        } else {
            try {
            InputStream input = context.getAssets().open(file);
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();
            String json = new String(buffer, "UTF-8");
                lottie.setAnimationFromJson(json);
        } catch (IOException e) {
        }
    }
    }

    @DesignerProperty(defaultValue = "1", editorType = "integer")
    @SimpleProperty(description = "Set the Starting Frame")
    public final void StartFrame(int startFrame) {
        lottie.setMinFrame(startFrame);
    }
}

