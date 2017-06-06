package com.yzyfdf.lifehelper.ui.read.activity

import android.content.Context
import android.content.Intent
import android.support.v7.view.menu.MenuBuilder
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import com.blankj.utilcode.utils.ToastUtils
import com.yzyfdf.lifehelper.R
import com.yzyfdf.lifehelper.app.Constant
import com.yzyfdf.lifehelper.app.Constant.*
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean
import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean
import com.yzyfdf.lifehelper.ui.read.contract.DetailsContract
import com.yzyfdf.lifehelper.ui.read.model.DetailsModel
import com.yzyfdf.lifehelper.ui.read.presenter.DetailsPresenter
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseAppActivity<DetailsPresenter, DetailsModel>(), DetailsContract.View {

    private var mReadType: Int = 0
    private var mId: Int = 0

    override fun getLayoutId(): Int {
        return R.layout.activity_details
    }

    override fun initPresenter() {
        mPresenter.setVM(this, mModel)
    }

    override fun initView() {
        val intent = intent
        mReadType = intent.getIntExtra(READ_TYPE, -1)
        mId = intent.getIntExtra(READ_ID, -1)
        val title = intent.getStringExtra(READ_TITLE)

        when (mReadType) {
            TYPE_ZHIHU -> mPresenter.queryZhiHuDetails(mId)
            TYPE_DOUBAN -> mPresenter.queryDouBanDetails(mId)
            TYPE_GUOKE -> mPresenter.queryGuoKeDetails(mId)
            else -> {}
        }

        //toolbar
        toolbar?.title = title
        setSupportActionBar(toolbar)
        val bar = supportActionBar
        bar!!.setDisplayHomeAsUpEnabled(true)
        toolbar?.setNavigationOnClickListener { finish() }

    }


    override fun returnZhiHuDetails(bean: ZhiHuDetailsBean) {
        webview?.loadDetailDataAsync(bean.body, TYPE_ZHIHU, { }) { title -> toolbar?.title = title }
    }

    override fun returnDouBanDetails(bean: DouBanDetailsBean) {
        webview?.loadDetailDataAsync(bean, TYPE_DOUBAN, { }) { title -> toolbar?.title = title }
    }

    override fun returnGuoKeDetails(content: String) {
        webview?.loadDetailDataAsync(content, TYPE_GUOKE, { }) { title -> toolbar?.title = title }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview!!.canGoBack()) {
            webview?.goBack()// 返回前一个页面
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.read_details, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        (menu as MenuBuilder).setOptionalIconsVisible(true)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_share -> {
                ToastUtils.showShortToast("分享中...稍等")
                saveUrl()
                return true
            }
            R.id.action_favorite -> {
                //                CookFavoritesActivity.startSelf(this);
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    private fun saveUrl() {
        val url = ""
        when (mReadType) {
            TYPE_ZHIHU -> mPresenter.queryZhiHuDetails(mId)
            TYPE_DOUBAN -> mPresenter.queryDouBanDetails(mId)
            TYPE_GUOKE -> mPresenter.queryGuoKeDetails(mId)
            else -> {
            }
        }
    }

    companion object {
        fun startSelf(context: Context, read_type: Int, id: Int, title: String) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(Constant.READ_TYPE, read_type)
            intent.putExtra(Constant.READ_ID, id)
            intent.putExtra(Constant.READ_TITLE, title)
            context.startActivity(intent)
        }
    }
}









//package com.yzyfdf.lifehelper.ui.read.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.app.ActionBar;
//import android.support.v7.view.menu.MenuBuilder;
//import android.support.v7.widget.Toolbar;
//import android.view.KeyEvent;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import com.blankj.utilcode.utils.ToastUtils;
//import com.yzyfdf.lifehelper.R;
//import com.yzyfdf.lifehelper.app.Constant;
//import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
//import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
//import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean;
//import com.yzyfdf.lifehelper.ui.read.contract.DetailsContract;
//import com.yzyfdf.lifehelper.ui.read.model.DetailsModel;
//import com.yzyfdf.lifehelper.ui.read.presenter.DetailsPresenter;
//
//import butterknife.Bind;
//
//import static com.yzyfdf.lifehelper.app.Constant.READ_ID;
//import static com.yzyfdf.lifehelper.app.Constant.READ_TITLE;
//import static com.yzyfdf.lifehelper.app.Constant.READ_TYPE;
//import static com.yzyfdf.lifehelper.app.Constant.TYPE_DOUBAN;
//import static com.yzyfdf.lifehelper.app.Constant.TYPE_GUOKE;
//import static com.yzyfdf.lifehelper.app.Constant.TYPE_ZHIHU;
//
//public class DetailsActivity2 extends BaseAppActivity<DetailsPresenter, DetailsModel> implements DetailsContract.View {
//
//
//    @Bind(R.id.toolbar)
//    Toolbar                               mToolbar;
//    @Bind(R.id.webview)
//    com.yzyfdf.lifehelper.widget.OWebView mWebview;
//    private int mReadType;
//    private int mId;
//
//
//    public static void startSelf(Context context, int read_type, int id, String title) {
//        Intent intent = new Intent(context, DetailsActivity2.class);
//        intent.putExtra(Constant.READ_TYPE, read_type);
//        intent.putExtra(Constant.READ_ID, id);
//        intent.putExtra(Constant.READ_TITLE, title);
//        context.startActivity(intent);
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_details;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//        Intent intent = getIntent();
//        mReadType = intent.getIntExtra(READ_TYPE, -1);
//        mId = intent.getIntExtra(READ_ID, -1);
//        String title = intent.getStringExtra(READ_TITLE);
//
//        switch (mReadType) {
//            case TYPE_ZHIHU:
//                mPresenter.queryZhiHuDetails(mId);
//                break;
//            case TYPE_DOUBAN:
//                mPresenter.queryDouBanDetails(mId);
//                break;
//            case TYPE_GUOKE:
//                mPresenter.queryGuoKeDetails(mId);
//                break;
//            default:
//                break;
//        }
//
//        //toolbar
//        mToolbar.setTitle(title);
//        setSupportActionBar(mToolbar);
//        ActionBar bar = getSupportActionBar();
//        bar.setDisplayHomeAsUpEnabled(true);
//        mToolbar.setNavigationOnClickListener(v -> finish());
//
//    }
//
//
//    @Override
//    public void returnZhiHuDetails(ZhiHuDetailsBean bean) {
//        mWebview.loadDetailDataAsync(bean.getBody(), TYPE_ZHIHU,() -> {},title -> mToolbar.setTitle(title));
//    }
//
//    @Override
//    public void returnDouBanDetails(DouBanDetailsBean bean) {
//        mWebview.loadDetailDataAsync(bean, TYPE_DOUBAN,() -> {},title -> mToolbar.setTitle(title));
//    }
//
//    @Override
//    public void returnGuoKeDetails(String content) {
//        mWebview.loadDetailDataAsync(content, TYPE_GUOKE,() -> {},title -> mToolbar.setTitle(title));
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
//            mWebview.goBack();// 返回前一个页面
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.read_details, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        ((MenuBuilder) menu).setOptionalIconsVisible(true);
//        return super.onPrepareOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.action_share:
//                ToastUtils.showShortToast("分享中...稍等");
//                saveUrl();
//                return true;
//            case R.id.action_favorite:
////                CookFavoritesActivity.startSelf(this);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }
//
//    private void saveUrl() {
//        String url = "";
//        switch (mReadType) {
//            case TYPE_ZHIHU:
//                mPresenter.queryZhiHuDetails(mId);
//                break;
//            case TYPE_DOUBAN:
//                mPresenter.queryDouBanDetails(mId);
//                break;
//            case TYPE_GUOKE:
//                mPresenter.queryGuoKeDetails(mId);
//                break;
//            default:
//                break;
//        }
//    }
//}
