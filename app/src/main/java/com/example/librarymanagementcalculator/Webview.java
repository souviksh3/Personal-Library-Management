package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class Webview extends AppCompatActivity {
    ProgressBar progressbar;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        progressbar = findViewById(R.id.progressbar);
        progressbar.setMax(100);
        webview = findViewById(R.id.webview);
        //webview.setWebChromeClient(new mychromde ());
        webview.setWebViewClient(new HelpClient());
        webview.setWebChromeClient(new WebChromeClient()

        {

            public void onProgressChanged(WebView view, int progress) {

                progressbar.setProgress(progress);

                setTitle("Loading.....");

                if (progress == 100) {

                    progressbar.setProgress(0);

                }

                super.onProgressChanged(view, progress);
            }
        });

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setUseWideViewPort(true);
        webSettings.getBlockNetworkLoads();
        webSettings.getAllowContentAccess();
        webSettings.setAllowFileAccess(true);
        webSettings.setLoadsImagesAutomatically(true);
        webview.loadUrl("https://www.google.co.in/ ");


    }

    private class HelpClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

//    private class mychromde extends WebChromeClient
//    {
//        private View mCustomView;
//
//        private WebChromeClient.CustomViewCallback mCustomViewCallback;
//
//        protected FrameLayout mFullscreenContainer;
//
//        private int mOriginalOrientation;
//
//        private int mOriginalSystemUiVisibility;
//
//
//
//        mychromde() {}
//
//
//
//        public Bitmap getDefaultVideoPoster()
//
//        {
//
//            if (mCustomView == null) {
//
//                return null;
//
//            }
//
//            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
//
//        }
//
//
//
//        public void onHideCustomView()
//
//        {
//
//            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
//
//            this.mCustomView = null;
//
//            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
//
//            setRequestedOrientation(this.mOriginalOrientation);
//
//            this.mCustomViewCallback.onCustomViewHidden();
//
//            this.mCustomViewCallback = null;
//
//        }
//
//
//
//        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
//
//        {
//
//            if (this.mCustomView != null)
//
//            {
//
//                onHideCustomView();
//
//                return;
//
//            }
//
//            this.mCustomView = paramView;
//
//            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
//
//            this.mOriginalOrientation = getRequestedOrientation();
//
//            this.mCustomViewCallback = paramCustomViewCallback;
//
//            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
//
//            getWindow().getDecorView().setSystemUiVisibility(3846);
//
//        }
//
 //   }

}
