package com.ywj.webviewdemoandroidtojs201713;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.util.Random;

/**
 * webview
 */
public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private Button btn_android;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏

        setContentView(R.layout.activity_main);

        initView();

        initData();

        initListener();

        requestData();
    }

    public void initView() {
        btn_android = (Button) findViewById(R.id.btn_android);
        webView = (WebView) findViewById(R.id.webView);

        initWebViewSettings();
    }

    private void initWebViewSettings() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);

        webView.addJavascriptInterface(new JavaScriptObject(this), "demo");
        //这里的“demo”要与<input type="button" value="jsToAndroid1''" onclick="window.demo.jsToAndroid1()"/>中demo对照
        webSettings.setJavaScriptEnabled(true); 
    }

    public void initData() {
        //设置webview的事件，根据需求自己实现
        //setWebChromeClient和setWebViewClient实现很多功能
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url1) {
                super.onPageFinished(view, url1);
            }
            //....
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Log.d("WebViewActivity","alert:"+message);
                return super.onJsAlert(view, url, message, result);
            }
            //....
        });
    }

    public void initListener() {
        btn_android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webView.loadUrl("javascript:show(10)");
                int i = new Random().nextInt(100);
                webView.loadUrl("javascript:androidToJs("+i+")");
            }
        });
    }

    public void requestData() {
        webView.loadUrl("file:///android_asset/a.html");
    }
}