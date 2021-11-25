package com.mab.befix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView web;

    String url = "https://befix.in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web = findViewById(R.id.web);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);


        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLightTouchEnabled(true);
        web.getSettings().setGeolocationEnabled(true);
        web.setSoundEffectsEnabled(true);
        web.setWebViewClient(new WebViewClient());


        web.loadUrl(url);

        web.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (web.canGoBack()) {
                        web.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}