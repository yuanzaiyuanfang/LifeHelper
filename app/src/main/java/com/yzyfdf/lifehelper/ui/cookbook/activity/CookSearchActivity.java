package com.yzyfdf.lifehelper.ui.cookbook.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.SearchView;

import com.jaydenxiao.common.commonutils.KeyBordUtil;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.cookbean.CookSearchBean;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookSearchAdapter;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookSearchContract;
import com.yzyfdf.lifehelper.ui.cookbook.model.CookSearchModel;
import com.yzyfdf.lifehelper.ui.cookbook.presenter.CookSearchPresenter;

import java.util.ArrayList;

import butterknife.Bind;

public class CookSearchActivity extends BaseAppActivity<CookSearchPresenter, CookSearchModel> implements CookSearchContract.View, SearchView.OnQueryTextListener {


    @Bind(R.id.searchView)
    SearchView    mSearchView;
    @Bind(R.id.toolbar)
    Toolbar       mToolbar;
    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private int num = 0;
    private String mKeyWord;
    private ArrayList<CookSearchBean.ResultBean.ListBean.RBean> mList = new ArrayList<>();
    private CookSearchAdapter mAdapter;
    private ActionBar         mBar;

    public static void startSelf(Context context, String keyWord ) {
        Intent intent = new Intent(context, CookSearchActivity.class);
        intent.putExtra(Constant.KEY_WORD, keyWord);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_search;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        showLoading();
        mKeyWord = getIntent().getStringExtra(Constant.KEY_WORD);

        //toolbar
        setSupportActionBar(mToolbar);
        mBar = getSupportActionBar();
        mBar.setTitle(mKeyWord);
        mBar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> {
            KeyBordUtil.hideSoftKeyboard(mSearchView);
            finish();
        });

        //RecyclerView
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CookSearchAdapter(this, mList);
        mXRecyclerView.setAdapter(mAdapter);

        //设置是否支持上下拉刷新
        mXRecyclerView.setLoadingMoreEnabled(true);
        mXRecyclerView.setPullRefreshEnabled(true);
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.LineScalePulseOut);

        //设置监听
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            //下拉
            @Override
            public void onRefresh() {
                num = 0;
                mPresenter.search(mKeyWord, num);
            }

            //上拉
            @Override
            public void onLoadMore() {
                num += 20;
                mPresenter.search(mKeyWord, num);
            }
        });

        //SearchView
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setQuery(mKeyWord, false);
        mSearchView.clearFocus();
        //        KeyBordUtil.hideSoftKeyboard(mSearchView);

        mPresenter.search(mKeyWord, num);

    }


    @Override
    public void returnSearch(CookSearchBean.ResultBean bean) {
        mBar.setTitle(mKeyWord);

        if (isProgressLoading()) {
            stopLoading();
        }
        if (num == 0) {
            mXRecyclerView.smoothScrollToPosition(0);
            mList.clear();
            mXRecyclerView.refreshComplete();
        } else {
            mXRecyclerView.loadMoreComplete();
        }
        for (CookSearchBean.ResultBean.ListBean listBean : bean.getList()) {
            if (listBean.getType() == 13) {//13才是搜索结果,其余是广告
                mList.add(listBean.getR());
            }
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        num = 0;
        mKeyWord = query;
        mPresenter.search(mKeyWord, num);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    private void goBack() {
        if (getWindow().getAttributes().softInputMode
                == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
            KeyBordUtil.hideSoftKeyboard(mSearchView);
            mXRecyclerView.requestFocus();
        } else {
            finish();
        }
    }
}
