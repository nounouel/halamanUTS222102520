package com.n222102520.uts222102520;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;


public class WebAppInterface {
    private Activity _activity ;
    private Context _context;
    public  WebAppInterface( Context context,  Activity activity)
    {
        _context = context;
        _activity = activity;
    }

    @JavascriptInterface
    public void showWhatsApp(String mobileNumber, String message)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "https://wa.me/"+ mobileNumber.replace("+","")+"?text" +Uri.encode(message)
        ));

        _context.startActivity(intent);
    }
}
