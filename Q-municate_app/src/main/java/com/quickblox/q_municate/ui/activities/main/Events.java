package com.quickblox.q_municate.ui.activities.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.quickblox.q_municate.R;

public class Events extends AppCompatActivity {

    private WebView webView;
    private Button scrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);





            webView = (WebView) findViewById(R.id.webview4);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://cinnamon-reindeer-xnnn.squarespace.com/new-events-2");



            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

        }
        public void mtievents() {
            Intent intent = new Intent(this, Events.class);
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

