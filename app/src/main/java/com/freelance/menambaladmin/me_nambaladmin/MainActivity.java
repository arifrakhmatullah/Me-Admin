package com.freelance.menambaladmin.me_nambaladmin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private WebView view;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    mTextMessage.setText(R.string.home);
                    return true;
                case R.id.tutorial:
                    mTextMessage.setText(R.string.tutorial);
                    return true;
                case R.id.about_us:
                    mTextMessage.setText(R.string.about_us);
                    return true;
            }
            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        view = (WebView)
                this.findViewById(R.id.webView);
                view.getSettings().setJavaScriptEnabled(true);
                view.getSettings().setGeolocationEnabled(true);
                view.setWebViewClient(new MyBrowser());
                view.setWebChromeClient(new WebChromeClient());
                view.loadUrl("https://official-menambal.000webhostapp.com");
    }
        private class MyBrowser extends WebViewClient{
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        }

        public boolean onKeyDown (int keyCode, KeyEvent event){
            if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()){
                view.goBack(); // perintah untuk kembali ke halaman sebelumnya
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
}
