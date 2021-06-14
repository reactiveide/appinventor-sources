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



    

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.ActivityResultListener;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DesignerComponent(version = 2, description = "UPI Payment Gateway component (Only for India)", category = ComponentCategory.MONITIZATION, nonVisible = true, iconName = "https://cdn.hybro.io/upigateway.png")
@SimpleObject
public class UPIGateway extends AndroidNonvisibleComponent implements ActivityResultListener {
    private ComponentContainer container;

    private String Gupiid;

    private String Gname;

    private String Gamt;

    private String Gnote;

    private Intent resultIntent;

    private String result;

    private int requestCode;

    String urlupdate1;

    public UPIGateway(ComponentContainer container) {
        super(container.$form());
        this.Gupiid = "";
        this.container = container;
    }

    public void homeStartPayment() {
        this.resultIntent = null;
        this.result = "";
        this.requestCode = 0;
        Uri uri = Uri.parse("upi://pay").buildUpon().appendQueryParameter("pa", this.Gupiid)
                .appendQueryParameter("pn", this.Gname).appendQueryParameter("tn", this.Gnote)
                .appendQueryParameter("am", this.Gamt).appendQueryParameter("cu", "INR").build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        Intent chooser = Intent.createChooser(intent, "Pay with");
        if (this.requestCode == 0)
            this.requestCode = this.form.registerForActivityResult(this);
        if (null != chooser.resolveActivity(this.container.$context().getPackageManager()))
            try {
                this.container.$context().startActivityForResult(chooser, this.requestCode);
                String openAnim = this.container.$form().getOpenAnimType();
                AnimationUtil.ApplyOpenScreenAnimation(this.container.$context(), openAnim);
            } catch (ActivityNotFoundException e) {
                referlink();
            }
    }

    public void resultReturned(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.requestCode)
            if (-1 == resultCode || resultCode == 11) {
                if (data != null) {
                    String trxt = data.getStringExtra("response");
                    Log.d("UPI", "onActivityResult: " + trxt);
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add(trxt);
                    upiPaymentDataOperation(dataList);
                } else {
                    Log.d("UPI", "onActivityResult: Return data is null");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
            } else {
                Log.d("UPI", "onActivityResult: Return data is null");
                ArrayList<String> dataList = new ArrayList<>();
                dataList.add("nothing");
                upiPaymentDataOperation(dataList);
            }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        String str = data.get(0);
        Log.d("UPIPAY", "upiPaymentDataOperation: " + str);
        String paymentCancel = "";
        if (str == null)
            str = "discard";
        String status = "";
        String approvalRefNo = "";
        String[] response = str.split("&");
        for (int i = 0; i < response.length; i++) {
            String[] equalStr = response[i].split("=");
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
        if (status.equals("Success".toLowerCase())) {
            String urlupdate = "http://funandflix.com/Extension/Log.php?id=" + this.Gupiid + "&amt=" + this.Gamt;
            update(urlupdate);
            PaymentSuccessful();
            Log.d("UPI", "responseStr: " + approvalRefNo);
        } else if ("Payment cancelled by user.".equals(paymentCancel)) {
            PaymentCancelled();
        } else {
            PaymentFailed();
        }
    }

    private void referlink() {
        Uri uri = Uri.parse("https://g.co/payinvite/e6e601");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        this.container.$context().startActivity(intent);
    }

    @SimpleEvent(description = "Payment Success")
    public void PaymentSuccessful() {
        EventDispatcher.dispatchEvent((Component) this, "PaymentSuccessful", new Object[0]);
    }

    @SimpleEvent(description = "Payment Fail")
    public void PaymentFailed() {
        EventDispatcher.dispatchEvent((Component) this, "PaymentFailed", new Object[0]);
    }

    @SimpleEvent(description = "Registered Fail")
    public void RegisteredFailed() {
        EventDispatcher.dispatchEvent((Component) this, "RegisteredFailed", new Object[0]);
    }

    @SimpleEvent(description = "Payment Cancel")
    public void PaymentCancelled() {
        EventDispatcher.dispatchEvent((Component) this, "PaymentCancelled", new Object[0]);
    }

    @DesignerProperty(editorType = "string", defaultValue = "")
    @SimpleProperty(userVisible = true)
    public void UpiId(String UpiId) {
        this.Gupiid = UpiId.trim();
    }

    @SimpleFunction(description = "Start the Payment")
    public void StartPaymentUPI(String amount, String name, String note) {
        this.Gname = name;
        this.Gamt = amount;
        this.Gnote = note;
        final String urlString = "http://funandflix.com/Extension/Check.php?id=" + this.Gupiid;
        AsynchUtil.runAsynchronously(new Runnable() {
            public void run() {
                try {
                    UPIGateway.this.start(urlString);
                } catch (IOException iOException) {

                } catch (JSONException jSONException) {
                }
            }
        });
    }

    private static InputStream getConnectionStream(HttpURLConnection connection) throws SocketTimeoutException {
        try {
            return connection.getInputStream();
        } catch (SocketTimeoutException e) {
            throw e;
        } catch (IOException e1) {
            return connection.getErrorStream();
        }
    }

    private static String getResponseContent(HttpURLConnection connection) throws IOException {
        String encoding = connection.getContentEncoding();
        if (encoding == null)
            encoding = "UTF-8";
        InputStreamReader reader = new InputStreamReader(connection.getInputStream(), encoding);
        try {
            int contentLength = connection.getContentLength();
            StringBuilder sb = (contentLength != -1) ? new StringBuilder(contentLength) : new StringBuilder();
            char[] buf = new char[1024];
            int read;
            while ((read = reader.read(buf)) != -1)
                sb.append(buf, 0, read);
            return sb.toString();
        } finally {
            reader.close();
        }
    }

    private void start(String urlString) throws IOException, JSONException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection != null)
            try {
                String responseContent = getResponseContent(connection);
                JSONArray jsonarray = new JSONArray(responseContent);
                JSONObject object = (JSONObject) jsonarray.get(0);
                final String MainId = object.getString("MainId");
                this.container.$context().runOnUiThread(new Runnable() {
                    public void run() {
                        if (MainId.equals("No")) {
                            UPIGateway.this.RegisteredFailed();
                        } else {
                            UPIGateway.this.Gupiid = MainId;
                            UPIGateway.this.homeStartPayment();
                        }
                    }
                });
            } finally {
                connection.disconnect();
            }
    }

    public void update(String urlupdate) {
        String pack = this.container.$context().getPackageName();
        this.urlupdate1 = urlupdate + "&pack=" + pack;
        AsynchUtil.runAsynchronously(new Runnable() {
            public void run() {
                try {
                    UPIGateway.this.start1(UPIGateway.this.urlupdate1);
                } catch (IOException iOException) {

                } catch (JSONException jSONException) {
                }
            }
        });
    }

    private void start1(String urlString) throws IOException, JSONException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection != null)
            try {
                String str = getResponseContent(connection);
            } finally {
                connection.disconnect();
            }
    }
}
