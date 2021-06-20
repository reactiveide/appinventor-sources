/* package com.google.appinventor.components.runtime;

    /*
    
    
      _   _           _    ___________ _____ 
     | | | |         | |  |_   _|  _  \  ___|
     | |_| |_   _  __| |_ __| | | | | | |__  
     |  _  | | | |/ _` | '__| | | | | |  __| 
     | | | | |_| | (_| | | _| |_| |/ /| |___ 
     \_| |_/\__, |\__,_|_| \___/|___/ \____/  @ ReactiveIDE 2021
             __/ |                           
            |___/                            


    */
/*
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.UsesLibraries;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.Context;
import android.widget.LinearLayout;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import java.lang.reflect.Constructor;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.trackselection.*;

 @DesignerComponent(
    version = 1,
    description = "Exo player",
    category = ComponentCategory.MEDIA,
    iconName = "https://cdn.reactiveide.com/exoplayer.png",
    nonVisible = true)

@UsesLibraries(libraries = "exoplayer-core.jar, exoplayer-core.aar, exoplayer-ui.jar, exoplayer-ui.aar")
@SimpleObject
public final class ExoPlayer extends AndroidNonvisibleComponent {
    
    private Context context;
    private Activity activity;
    private ViewGroup vg;
    private LinearLayout myla;
    private StyledPlayerView exoPlayerView;
    private SimpleExoPlayer exoPlayer;
    private DefaultTrackSelector trackSelector;
    private String mainurl = "";

    public ExoPlayer(ComponentContainer container) {
        super(container.$form());
        context = container.$context();
        activity = (Activity) context;
        exoPlayerView = new StyledPlayerView(activity);
    }

    /* to be fixed
    @SimpleFunction
    public void CreateExoPlayer(HVArrangement layout , String videoURL){

    vg = (ViewGroup)layout.getView();
    myla = (LinearLayout)vg.getChildAt(0);
    mainurl = videoURL;
     try {
         BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
         trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
         trackSelector.setParameters(trackSelector.buildUponParameters().setMaxVideoSize(1920 ,1080).build());
         exoPlayer = ExoPlayerFactory.newSimpleInstance(activity, trackSelector);
         Uri videoURI = Uri.parse(videoURL);
         DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
         ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
         MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);
         exoPlayerView.setPlayer(exoPlayer);
         exoPlayer.addListener(new ExoListener());
         exoPlayer.prepare(mediaSource);
         exoPlayer.setPlayWhenReady(true);
         myla.addView(exoPlayerView);

     }catch (Exception e){
         ErrorOccuredWhileCreating(e.toString());
     }
    }

    @SimpleFunction
    public void SetFullScreen(boolean fullscreen){
    	if(fullscreen){
    	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) exoPlayerView.getLayoutParams();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = LinearLayout.LayoutParams.MATCH_PARENT;
        exoPlayerView.setLayoutParams(params);
    	} else {
    	activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) exoPlayerView.getLayoutParams();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = 600;
        exoPlayerView.setLayoutParams(params);
    	}
    }

    @SimpleFunction
    public void SetVideoMaxResolution(int height , int width){
    try {
         trackSelector.setParameters(trackSelector.buildUponParameters().setMaxVideoSize(height ,width).build());
         exoPlayer = ExoPlayerFactory.newSimpleInstance(activity, trackSelector);
         Uri videoURI = Uri.parse(mainurl);
         DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
         ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
         MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);
         exoPlayerView.setPlayer(exoPlayer);
         exoPlayer.addListener(exoListener);
         exoPlayer.prepare(mediaSource);
         exoPlayer.setPlayWhenReady(true);
         myla.addView(exoPlayerView);

     }catch (Exception e){
         ErrorOccuredWhileCreating(e.toString());
    }
}

    @SimpleEvent
    public void ErrorOccuredWhileCreating(String error){
        EventDispatcher.dispatchEvent(this, "ErrorOccuredWhileCreating", error);
    }
    @SimpleEvent
    public void IsPlayingChanged(boolean playing){
        EventDispatcher.dispatchEvent(this, "IsPlayingChanged", playing);
    }
    @SimpleEvent
    public void PlayerError(String error){
        EventDispatcher.dispatchEvent(this, "PlayerError", error);
    }
    @SimpleEvent
    public void LoadingChanged(boolean loading){
        EventDispatcher.dispatchEvent(this, "LoadingChanged", loading);
    }
    @SimpleEvent
    public void VideoBuffering(){
        EventDispatcher.dispatchEvent(this, "VideoBuffering");
    }
    @SimpleEvent
    public void IdleState(){
        EventDispatcher.dispatchEvent(this, "IdleState");
    }
    @SimpleEvent
    public void VideoReadyToPlay(){
        EventDispatcher.dispatchEvent(this, "VideoReadyToPlay");
    }
    @SimpleEvent
    public void VideoEnded(){
        EventDispatcher.dispatchEvent(this, "VideoEnded");
    }

    private class ExoListener implements Player.EventListener {
    public void onIsPlayingChanged(boolean isPlaying){
     IsPlayingChanged(isPlaying);
     }
    public void onPlayerError(ExoPlaybackException error){
     PlayerError(error.toString());
     }
    public void onLoadingChanged(boolean isLoading){
     LoadingChanged(isLoading);
     }
    public void onPlayerStateChanged(int playbackState) {
    switch (playbackState) {
        case Player.STATE_BUFFERING:
            VideoBuffering();
            break;
        case Player.STATE_IDLE:
            IdleState();
            break;
        case Player.STATE_READY:
            VideoReadyToPlay();
            break;
        case Player.STATE_ENDED:
            VideoEnded();
            break;
        }
      }
    } 

  }

*/