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









//package com.yzyfdf.lifehelper.ui.read.activity
//
//import android.graphics.Bitmap
//import android.webkit.WebView
//import com.jaydenxiao.common.base.BaseModel
//import com.jaydenxiao.common.base.BasePresenter
//import kotlinx.android.synthetic.main.activity_details.*
//
///**
// * Created by SJJ .
// * 描述 ${TODO}
// */
//
//class HttpActivity : com.yzyfdf.lifehelper.base.activity.BaseAppActivity<BasePresenter<*, *>, BaseModel>() {
//
//    private var mDone: Boolean = false
//
//    override fun getLayoutId(): Int = com.yzyfdf.lifehelper.R.layout.activity_details
//
//    override fun initPresenter() {}
//
//    override fun initView() {
//
//        val url = intent.getStringExtra(com.yzyfdf.lifehelper.app.Constant.READ_URL)
//
//        toolbar?.title = " "
//        setSupportActionBar(toolbar)
//        val bar = supportActionBar
//        bar!!.setDisplayHomeAsUpEnabled(true)
//        toolbar!!.setNavigationOnClickListener { finish() }
//
//        webview!!.setWebViewClient(object : android.webkit.WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: android.webkit.WebView, url: String): Boolean {
//                view.loadUrl(url)
//                return true
//            }
//
//
//            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                showLoading()
//                mDone = false
//            }
//
//            override fun onPageFinished(view: android.webkit.WebView, url: String) {
//                pageFinished()
//            }
//        })
//
//        webview?.setWebChromeClient(object : android.webkit.WebChromeClient() {
//            override fun onReceivedTitle(view: android.webkit.WebView, title: String) {
//                super.onReceivedTitle(view, title)
//                if (!android.text.TextUtils.equals("about:blank", title)) {
//                    toolbar!!.title = title
//                }
//            }
//        })
//
//        webview?.loadUrl(url)
//    }
//
//    @Synchronized fun pageFinished() {
//        if (!mDone) {
//            mDone = true
//            stopLoading()
//        }
//    }
//
//    override fun onKeyDown(keyCode: Int, event: android.view.KeyEvent): Boolean {
//        if (keyCode == android.view.KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
//            webview?.goBack()// 返回前一个页面
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
//    companion object {
//        fun startSelf(context: android.content.Context, url: String) {
//            val intent = android.content.Intent(context, HttpActivity::class.java)
//            intent.putExtra(com.yzyfdf.lifehelper.app.Constant.READ_URL, url)
//            context.startActivity(intent)
//        }
//    }
//}