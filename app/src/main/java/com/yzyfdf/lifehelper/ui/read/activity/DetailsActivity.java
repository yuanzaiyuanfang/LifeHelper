package com.yzyfdf.lifehelper.ui.read.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean;
import com.yzyfdf.lifehelper.ui.read.contract.DetailsContract;
import com.yzyfdf.lifehelper.ui.read.model.DetailsModel;
import com.yzyfdf.lifehelper.ui.read.presenter.DetailsPresenter;

import butterknife.Bind;

import static com.yzyfdf.lifehelper.app.Constant.READ_ID;
import static com.yzyfdf.lifehelper.app.Constant.READ_TITLE;
import static com.yzyfdf.lifehelper.app.Constant.READ_TYPE;
import static com.yzyfdf.lifehelper.app.Constant.TYPE_DOUBAN;
import static com.yzyfdf.lifehelper.app.Constant.TYPE_GUOKE;
import static com.yzyfdf.lifehelper.app.Constant.TYPE_ZHIHU;

public class DetailsActivity extends BaseAppActivity<DetailsPresenter, DetailsModel> implements DetailsContract.View {


    @Bind(R.id.toolbar)
    Toolbar                               mToolbar;
    @Bind(R.id.webview)
    com.yzyfdf.lifehelper.widget.OWebView mWebview;


    public static void startSelf(Context context, int read_type, int id, String title) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(Constant.READ_TYPE, read_type);
        intent.putExtra(Constant.READ_ID, id);
        intent.putExtra(Constant.READ_TITLE, title);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        int readType = intent.getIntExtra(READ_TYPE, -1);
        int id = intent.getIntExtra(READ_ID, -1);
        String title = intent.getStringExtra(READ_TITLE);

        switch (readType) {
            case TYPE_ZHIHU:
                mPresenter.queryZhiHuDetails(id);
                break;
            case TYPE_DOUBAN:
                mPresenter.queryDouBanDetails(id);
                break;
            case TYPE_GUOKE:
                mPresenter.queryGuoKeDetails(id);
                break;
            default:
                break;
        }

        //toolbar
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }


    @Override
    public void returnZhiHuDetails(ZhiHuDetailsBean bean) {
        mWebview.loadDetailDataAsync(bean.getBody(), TYPE_ZHIHU,() -> {},title -> mToolbar.setTitle(title));
    }

    @Override
    public void returnDouBanDetails(DouBanDetailsBean bean) {
        mWebview.loadDetailDataAsync(bean, TYPE_DOUBAN,() -> {},title -> mToolbar.setTitle(title));
    }

    @Override
    public void returnGuoKeDetails(String content) {
        mWebview.loadDetailDataAsync(content, TYPE_GUOKE,() -> {},title -> mToolbar.setTitle(title));
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
