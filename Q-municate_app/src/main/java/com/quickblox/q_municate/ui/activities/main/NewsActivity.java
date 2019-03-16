package com.quickblox.q_municate.ui.activities.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.quickblox.q_municate.R;

public class NewsActivity extends AppCompatActivity {

    private WebView webView;
    private Button news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);





            webView = (WebView) findViewById(R.id.webview3);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://cinnamon-reindeer-xnnn.squarespace.com/news");



            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

        }
        public void mtinews() {
            Intent intent = new Intent(this, NewsActivity.class);
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

