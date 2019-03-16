package com.quickblox.q_municate.ui.activities.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quickblox.q_municate.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class University extends AppCompatActivity {
    private WebView webView;
    private Button university;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://mtiuniversity.talentlms.com/");




        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    public void mtiuniversity() {
        Intent intent = new Intent(this, University.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}

