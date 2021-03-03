package com.example.quack.UrlSite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.quack.Adapter.MovieDetails;
import com.example.quack.R;

public class WebViewUrl extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_url);
        //String googleReview = "https://www.google.com/search?q="+movieDetails.getOriginal_title()+"+world+review&client=ubuntu&hs=inP&channel=fs&sxsrf=ALeKk03Imn0pQz8fAKhjdJ2eqRmVUCzY3w:1614678111596&source=lnms&tbm=nws&sa=X&ved=2ahUKEwjPs5LaqJHvAhVA7XMBHdVrCDsQ_AUoAnoECAUQBA&biw=1366&bih=630";

        MovieDetails movieDetails = (MovieDetails) getIntent().getExtras().getSerializable("MOVIE_DETAIL");

        mWebView = (WebView)findViewById(R.id.webView);
        WebSettings mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.google.com/search?q="+movieDetails.getOriginal_title()+"+world+review&client=ubuntu&hs=inP&channel=fs&sxsrf=ALeKk03Imn0pQz8fAKhjdJ2eqRmVUCzY3w:1614678111596&source=lnms&tbm=nws&sa=X&ved=2ahUKEwjPs5LaqJHvAhVA7XMBHdVrCDsQ_AUoAnoECAUQBA&biw=1366&bih=630");
        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {

        if(mWebView.canGoBack()){
            mWebView.goBack();

        }else {
            super.onBackPressed();
        }
    }
}