package com.google.appinventor.components.runtime;

import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.ActivityResultListener;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.ErrorMessages;

@DesignerComponent(version = 1,
    description = "Extension to pick a Google Account. " +
        "Version 1 as of 2016-12-05 for App Inventor version nb153 and Companion version 2.39.",
    category = ComponentCategory.SOCIAL,
    nonVisible = true,
    iconName = "https://puravidaapps.com/images/taifun16.png")
@SimpleObject
@UsesLibraries(libraries = "play-services-auth-9.6.1.jar, play-services-auth-base-9.6.1.jar")

public class GoogleSignIn extends AndroidNonvisibleComponent implements Component, ActivityResultListener {

  public static final int VERSION = 1;
  private ComponentContainer container;
  private Context context;
  private static final String LOG_TAG = "GoogleSignIn";
  private int requestCode = 0;
  private final int RESULT_OK = -1;


  public GoogleSignIn(ComponentContainer container) {
    super(container.$form());
    this.container = container;
    context = (Context) container.$context();
    Log.d(LOG_TAG, "TaifunAM Created" );
  }


  // https://stackoverflow.com/a/19444640/1545993
  @SimpleFunction(description = "Provide an account picker to pick a Google account.")
  public void Pick() {
    Log.d(LOG_TAG, "Pick");
    if (android.os.Build.VERSION.SDK_INT < 14) {
      form.dispatchErrorOccurredEvent(this, "Pick",
          ErrorMessages.ERROR_FUNCTIONALITY_NOT_SUPPORTED_CONTACT_EMAIL);
    } else {
      if (requestCode == 0) {
        // First time, we need to register this as an ActivityResultListener with the Form.
        // The Form's onActivityResult method will be called when the activity returns. If we
        // register with the Form and then use the requestCode when we start an activity, the Form
        // will call our resultReturned method.
        requestCode = form.registerForActivityResult(this);
        Log.d(LOG_TAG, "Pick, requestCode: " + requestCode);
      }

      try {
        // https://stackoverflow.com/a/26665427/1545993
        // AccountManager.newChooseAccountIntent >= API 14
        Intent intent = AccountManager.newChooseAccountIntent(null, null,
            new String[] { GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE }, false, null, null, null, null);
        container.$context().startActivityForResult(intent, requestCode);
      } catch (ActivityNotFoundException e) {
        form.dispatchErrorOccurredEvent(this, "Pick",
            ErrorMessages.ERROR_ACTIVITY_STARTER_NO_CORRESPONDING_ACTIVITY);
      }
    }
  }


  @SimpleEvent(description = "Event raised after account has been picked.")
  public void Picked(String accountName) {
    Log.i(LOG_TAG, "Picked: " + accountName);
    EventDispatcher.dispatchEvent(this, "Picked", accountName);
  }


  @Override
  public void resultReturned(int requestCode, int resultCode, Intent data) {
    Log.i(LOG_TAG, "resultReturned: " + resultCode);
    if (resultCode == RESULT_OK) {
      String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
      Picked(accountName);
    }
  }
}