package com.yzyfdf.lifehelper.ui.other.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.ui.other.contract.SettingContract;
import com.yzyfdf.lifehelper.ui.other.model.SettingModel;
import com.yzyfdf.lifehelper.ui.other.presenter.SettingPresenter;
import com.yzyfdf.lifehelper.util.GlideCacheUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingActivity extends BaseAppActivity<SettingPresenter, SettingModel> implements SettingContract.View {

    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.layout_clearCache)
    LinearLayout mLayout_clearCache;
    @Bind(R.id.tv_cache)
    TextView     mTvCache;


    public static void startSelf(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("设置");
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        initData();
    }

    protected void initData() {
        mTvCache.setText(GlideCacheUtil.getInstance().getCacheSize(this));
    }

    @Override
    public void returnClearCache(boolean isClear) {
        if (isClear) {
            showShortToast("清理完成");
            mTvCache.setText(GlideCacheUtil.getInstance().getCacheSize(this));
        } else {
            showShortToast("清理失败");
        }
    }

    @OnClick({R.id.toolbar, R.id.layout_clearCache})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                break;
            case R.id.layout_clearCache:
                mPresenter.clearCache();
                break;
        }
    }


}
