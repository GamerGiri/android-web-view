package com.inovationware.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    LinearProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressIndicator = findViewById(R.id.progressIndicator);
        progressIndicator.setVisibility(View.VISIBLE);

        webView = findViewById(R.id.webView);
        webView.setVisibility(View.INVISIBLE);

        //clear caches, just in case, purely optional...
        try{
            webView.clearCache(false);
        }
        catch (Exception e){

        }
        //Enable Javascipt
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //force links to open in the WebView, instead of in a browser...
        CustomWebViewClient webViewClient = new CustomWebViewClient(progressIndicator, webView, getApplicationContext());
        webView.setWebViewClient(webViewClient);


        webView.loadUrl(getString(R.string.url));

    }
}