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



    

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import android.app.Activity;
import java.time.Duration;
import android.net.Uri;
import android.os.Bundle;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.pm.PackageManager;
import java.io.IOException;

import com.google.appinventor.components.common.*;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = 1, description = "", category = ComponentCategory.MONITIZATION, nonVisible = true, iconName = "https://res.cloudinary.com/dfozqceqg/image/upload/v1581413362/logo.png")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE")

public class AndroidPay extends AndroidNonvisibleComponent {
    private String TAG = "AndroidPay";
    private ComponentContainer container;
    private Activity activity;
    private Context context;
    private String upiId = "";
    private String dialogTitle;
    final int UPI_PAYMENT = 0;

    public AndroidPay(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        this.context = (Context)container.$context();
        this.activity = (Activity)this.context;
    }

    public static boolean isConnectionAvailable(Context context) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "returns the UPI ID", userVisible = true)
    public String UpiId() {
        return upiId;
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    @SimpleProperty
    public void UpiId(String id) {
        this.upiId = id;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the title of UPI Select Dialog", userVisible = false)
    public String UPIDialogTitle() {
        return dialogTitle;
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    @SimpleProperty
    public void UPIDialogTitle(String title) {
        this.dialogTitle = title;
    }

    void payUsingUpi(String name, String note, String amount, String currency) {
        Uri uri = Uri.parse("upi://pay").buildUpon().appendQueryParameter("pa", upiId).appendQueryParameter("pn", name)
                .appendQueryParameter("tn", note).appendQueryParameter("am", amount)
                .appendQueryParameter("cu", currency).build();

        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        Intent chooser = Intent.createChooser(upiPayIntent, dialogTitle);

        if (null != chooser.resolveActivity(context.getPackageManager())) {
            form.startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            AppNotFound();
        }
    }

    @SimpleFunction(description = "Make the payment using UPI")
    public void MakePayment(String name, String note, String amount, String currency) {
        payUsingUpi(name, note, amount, currency);
    }

    @SimpleEvent(description = "When any UPI app not found in the user's phone")
    public void AppNotFound() {
        EventDispatcher.dispatchEvent(this, "AppNotFound");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        case UPI_PAYMENT:
            if ((Activity.RESULT_OK == resultCode) || (resultCode == 11)) {
                if (data != null) {
                    String trxt = data.getStringExtra("response");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add(trxt);
                    upiPaymentDataOperation(dataList);
                } else {
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
            } else {
                ArrayList<String> dataList = new ArrayList<>();
                dataList.add("nothing");
                upiPaymentDataOperation(dataList);
            }
            break;
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(this.context)) {
            String str = data.get(0);
            String paymentCancel = "";
            if (str == null)
                str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if (equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    } else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase())
                            || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                } else {
                    paymentCancel = "Payment cancelled by user.";
                }
            }
            if (status.equals("success")) {
                PaymentSuccessful(approvalRefNo);
            } else if ("Payment cancelled by user.".equals(paymentCancel)) {
                CancelledByUser();
            } else {
                PaymentFailed(approvalRefNo);
            }
        } else {
            InternetError();
        }
    }

    @SimpleEvent(description = "When Internet Error detect in users phone")
    public void InternetError() {
        EventDispatcher.dispatchEvent(this, "InternetError");
    }

    @SimpleEvent(description = "When Payment cancelled by the user")
    public void CancelledByUser() {
        EventDispatcher.dispatchEvent(this, "CancelledByUser");
    }

    @SimpleEvent(description = "When Payment successful")
    public void PaymentSuccessful(String refId) {
        EventDispatcher.dispatchEvent(this, "PaymentSuccessful", refId);
    }

    @SimpleEvent(description = "When Payment failed")
    public void PaymentFailed(String refId) {
        EventDispatcher.dispatchEvent(this, "PaymentFailed", refId);
    }

}