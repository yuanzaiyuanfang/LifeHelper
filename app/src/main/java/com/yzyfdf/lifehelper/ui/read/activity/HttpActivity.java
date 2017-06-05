package com.yzyfdf.lifehelper.ui.read.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.widget.OWebView;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class HttpActivity extends BaseAppActivity {
    @Bind(R.id.toolbar)
    Toolbar  mToolbar;
    @Bind(R.id.webview)
    OWebView mWebview;

    private boolean mDone;

    public static void startSelf(Context context, String url) {
        Intent intent = new Intent(context, HttpActivity.class);
        intent.putExtra(Constant.READ_URL, url);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        String url = getIntent().getStringExtra(Constant.READ_URL);

        mToolbar.setTitle(" ");
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showLoading();
                mDone = false;

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pageFinished();
            }
        });

        mWebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (!TextUtils.equals("about:blank", title)) {
                    mToolbar.setTitle(title);
                }
            }
        });

        mWebview.loadUrl(url);
    }

    public synchronized void pageFinished() {
        if (!mDone) {
            mDone = true;
            stopLoading();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
            mWebview.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
