package com.n222102520.uts222102520;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner _spinner1;
    private WebView _webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initSpinner1();

        _webView1 = (WebView) findViewById(R.id.webView1);

        WebViewClient webViewClient = new WebViewClient();
        _webView1.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        _webView1.setWebChromeClient(webChromeClient);

        WebSettings webSettings = _webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        WebAppInterface webAppInterface = new WebAppInterface( this, MainActivity.this);
        _webView1.addJavascriptInterface(webAppInterface, "Android");

        String url  = "https://web.whatsapp.com/";
        _webView1.loadUrl(url);
    }

    private void initSpinner1(){
    _spinner1= findViewById(R.id.spinner1);
    List<String> jenisList = new ArrayList<>();
    jenisList.add("Jenis Kelamin");
    jenisList.add("Laki laki");
    jenisList.add("Perempuan");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,jenisList);
        _spinner1.setAdapter(arrayAdapter);
    }

}