package com.inovationware.webviewapp;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class CustomWebViewClient extends WebViewClient {

    LinearProgressIndicator linearProgressIndicator;
    WebView view;
    Context context;

    public CustomWebViewClient(LinearProgressIndicator linearProgressIndicator, WebView view, Context context) {
        this.linearProgressIndicator = linearProgressIndicator;
        this.view = view;
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        return super.shouldOverrideUrlLoading(view, request);
        if (context.getString(R.string.url).equals(Uri.parse(url).getHost())){
            return false;
        }
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (linearProgressIndicator.getVisibility() != View.INVISIBLE){
            linearProgressIndicator.setVisibility(View.INVISIBLE);
            view.setVisibility(View.VISIBLE);
        }
    }
}
