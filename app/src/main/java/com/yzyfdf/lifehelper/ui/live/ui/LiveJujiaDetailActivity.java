package com.yzyfdf.lifehelper.ui.live.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.blankj.utilcode.utils.ToastUtils;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.live.BlankInfoBean;
import com.yzyfdf.lifehelper.bean.live.LiveJujiaDetailBean;
import com.yzyfdf.lifehelper.bean.live.ShareInfoBean;
import com.yzyfdf.lifehelper.ui.live.contract.LiveJujiaDetailContract;
import com.yzyfdf.lifehelper.ui.live.model.LiveJujiaDetailModel;
import com.yzyfdf.lifehelper.ui.live.presenter.LiveJujiaDetailPresenter;
import com.yzyfdf.lifehelper.util.WxShareUtil;
import com.yzyfdf.lifehelper.widget.OWebView;

import butterknife.Bind;

/**
 * Created by MLRC-iOS-CI on 2018/1/10.
 */

public class LiveJujiaDetailActivity extends BaseAppActivity<LiveJujiaDetailPresenter, LiveJujiaDetailModel>
        implements LiveJujiaDetailContract.View {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.webview)
    OWebView mWebview;

    private String mTitle, share_url, mMsg;

    public static void startSelf(Context context, String id, String title) {
        Intent intent = new Intent(context, LiveJujiaDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_live_jujia_details;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        mTitle = intent.getStringExtra("title");
        initToolbar(mToolbar, mTitle);

        mPresenter.getJujiaDetail(id);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.read_details, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        ((MenuBuilder) menu).setOptionalIconsVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_share:
                ToastUtils.showShortToast("分享中...稍等");
                shareUrl();
                return true;
            case R.id.action_favorite:
                showShortToast("敬请期待");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void shareUrl() {
        if (!TextUtils.isEmpty(share_url))
            WxShareUtil.shareWebpage(share_url, mTitle, mMsg);
    }


    @Override
    public void returnJujiaDetail(LiveJujiaDetailBean.DataBean bean) {
        BlankInfoBean blankInfo = bean.getBlank_info();
        if (blankInfo != null) {
            String content = blankInfo.getContent();
            if (!TextUtils.isEmpty(content)) {
                mWebview.loadDetailDataAsync(content, Constant.TYPE_JUJIA_DETAIL, () -> {
                }, title -> mToolbar.setTitle(title));
            }
        }
        ShareInfoBean shareInfo = bean.getShare_info();
        if (shareInfo != null) {
            ShareInfoBean.WechatBean wechat = shareInfo.getWechat();
            if (wechat != null) {
                mTitle = wechat.getTitle();
                share_url = wechat.getUrl();
                mMsg = wechat.getDesc();
            }
        }

    }
}
