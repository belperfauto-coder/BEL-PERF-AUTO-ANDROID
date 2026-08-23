package fr.belperfauto.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.content.*;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintManager;

public class MainActivity extends Activity {
    private WebView webView;
    private ValueCallback<Uri[]> fileCallback;
    private static final int FILE_CHOOSER = 1001;

    @SuppressLint({"SetJavaScriptEnabled","JavascriptInterface"})
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setDatabaseEnabled(true);
        s.setBuiltInZoomControls(false);
        webView.addJavascriptInterface(new AndroidBridge(), "Android");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override public boolean onShowFileChooser(WebView view, ValueCallback<Uri[]> callback, FileChooserParams params) {
                fileCallback = callback;
                try { startActivityForResult(params.createIntent(), FILE_CHOOSER); }
                catch (Exception e) { fileCallback = null; return false; }
                return true;
            }
        });
        webView.loadUrl("file:///android_asset/index.html");
    }

    public class AndroidBridge {
        @JavascriptInterface public void openExternal(String url) {
            runOnUiThread(() -> {
                try { startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url))); } catch (Exception ignored) {}
            });
        }
        @JavascriptInterface public void printPage() {
            runOnUiThread(() -> {
                PrintManager pm = (PrintManager)getSystemService(PRINT_SERVICE);
                pm.print("BEL-PERF-AUTO", webView.createPrintDocumentAdapter("BEL-PERF-AUTO"), new PrintAttributes.Builder().build());
            });
        }
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_CHOOSER && fileCallback != null) {
            fileCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, data));
            fileCallback = null;
        }
    }

    @Override public void onBackPressed() {
        if (webView.canGoBack()) webView.goBack(); else super.onBackPressed();
    }
}