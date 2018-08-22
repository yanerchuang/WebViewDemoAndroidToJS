package com.ywj.webviewdemoandroidtojs201713;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;


public class JavaScriptObject {
    Context mContxt;

    //sdk17+版本以上,需要在方法前加上@JavascriptInterface注解，否则无效
    public JavaScriptObject(Context mContxt) {
        this.mContxt = mContxt;
    }
    @JavascriptInterface
    public void jsToAndroid1() {
        Toast.makeText(mContxt, "jsToAndroid1", Toast.LENGTH_LONG).show();
        Log.d("WebViewActivity","jsToAndroid1");
    }

    @JavascriptInterface
    public void jsToAndroid2(String name) {
        Toast.makeText(mContxt, "jsToAndroid2:" + name, Toast.LENGTH_SHORT).show();
        Log.d("WebViewActivity","jsToAndroid2");
    }
} 