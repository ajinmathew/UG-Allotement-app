package com.mgc.allotmentug;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AdminHome extends AppCompatActivity {
WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_home );
        webView=findViewById( R.id.webView );
        webView.setWebViewClient( new WebViewClient() );
        webView.loadUrl( "https://console.firebase.google.com/u/0/project/allotmentug/database/allotmentug/data" );
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled( true );
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
