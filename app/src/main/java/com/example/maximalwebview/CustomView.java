package com.example.maximalwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class CustomView extends AppCompatActivity {
    WebView customWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        customWebView =findViewById(R.id.customWebView);
        //webView
        Intent intent = getIntent();
        String str = intent.getStringExtra("url");
        customWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings=customWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if(str.contains("https")||str.contains("http")){
            customWebView.loadUrl(str);
        }else{
            customWebView.loadUrl("https://"+str);
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (customWebView.canGoBack()) {
                        customWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}