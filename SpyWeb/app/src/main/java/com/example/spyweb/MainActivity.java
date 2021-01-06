package com.example.spyweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText link;
    WebView browser;
    Button btn_visit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    link=findViewById(R.id.editTextLink);
    browser=findViewById(R.id.webview);
    btn_visit=findViewById(R.id.btn_view);

browser.setWebViewClient(new myWebViewClient() );

btn_visit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String url=link.getText().toString();
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl(url);
    }
});
    }

    private class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
          view.loadUrl(url);
            return true;
        }
    }
    }
