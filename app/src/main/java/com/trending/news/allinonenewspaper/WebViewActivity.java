package com.trending.news.allinonenewspaper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private String url;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = findViewById(R.id.webview);
        progressDialog = new ProgressDialog(this,R.style.myprogressdialogstyle);
        progressDialog.setMessage("অপেক্ষা করুন ...");
        progressDialog.show();

        if (getIntent().getStringExtra("url")!=null) {
            progressDialog.show();
            url = getIntent().getStringExtra("url");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient(){

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    super.onPageFinished(view, url);
                }
            });

            webView.loadUrl(url);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


}
