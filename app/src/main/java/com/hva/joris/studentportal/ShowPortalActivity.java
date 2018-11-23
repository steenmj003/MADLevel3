package com.hva.joris.studentportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowPortalActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_portal);

        webView = (WebView) findViewById(R.id.webView);
        Intent intent = getIntent();
        PortalObject portalObject = intent.getParcelableExtra("PORTALOBJECT");

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(portalObject.getUrl());
    }
}
