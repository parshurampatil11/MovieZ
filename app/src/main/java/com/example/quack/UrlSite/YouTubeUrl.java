package com.example.quack.UrlSite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.quack.Adapter.MovieDetails;
import com.example.quack.R;

public class YouTubeUrl extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_url);
        MovieDetails movieDetails = (MovieDetails) getIntent().getExtras().getSerializable("MOVIE_DETAIL");
        mWebView = (WebView)findViewById(R.id.youTubeWebView);
        WebSettings mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.youtube.com/results?q="+movieDetails.getOriginal_title()+"&sxsrf=ALeKk03TIsy_c1HE1ALUm-Pu-fLI4Wcz9w%3A1614601617462&source=lnms&tbm=vid&sa=X&ved=2ahUKEwjr2PLei4_vAhVOeX0KHU-ODzUQ_AUoA3oECAMQBQ&biw=1366&bih=630");
        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {

        if(mWebView.canGoBack()){
            mWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}