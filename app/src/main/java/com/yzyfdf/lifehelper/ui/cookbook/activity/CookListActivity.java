package com.yzyfdf.lifehelper.ui.cookbook.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.bean.cookbean.CookRBean;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookListAdapter;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookListContract;
import com.yzyfdf.lifehelper.ui.cookbook.model.CookListModel;
import com.yzyfdf.lifehelper.ui.cookbook.presenter.CookListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.yzyfdf.lifehelper.ui.cookbook.adapter.CookListAdapter.SPAN_COUNT_BIG;
import static com.yzyfdf.lifehelper.ui.cookbook.adapter.CookListAdapter.SPAN_COUNT_SMALL;

public class CookListActivity extends BaseAppActivity<CookListPresenter, CookListModel> implements CookListContract.View {

    @Bind(R.id.toolbar)
    Toolbar       mToolbar;
    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private ArrayList<CookRBean> mList = new ArrayList<>();
    private int                  num   = 0;
    private int                  id    = 0;
    private CookListAdapter mAdapter;
    private GridLayoutManager mLayoutManager;

    public static void startSelf(Context context, CookMainBean.ResultBean.ListBean.MBean mBean) {
        Intent intent = new Intent(context, CookListActivity.class);
        intent.putExtra(Constant.MBean, mBean);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_list;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        CookMainBean.ResultBean.ListBean.MBean mBean = (CookMainBean.ResultBean.ListBean.MBean) getIntent().getSerializableExtra(Constant.MBean);
        id = mBean.getId();
        String title = mBean.getT();

        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setTitle(title);
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        //XRecyclerView
        mLayoutManager = new GridLayoutManager(this,SPAN_COUNT_SMALL);
        mXRecyclerView.setLayoutManager(mLayoutManager);
        mXRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new CookListAdapter(this, mList, mLayoutManager);
        mXRecyclerView.setAdapter(mAdapter);

//解决NestedScrollView 嵌套 RecyclerView出现的滑动冲突问题
//        linearLayoutManager.setSmoothScrollbarEnabled(true);
//        linearLayoutManager.setAutoMeasureEnabled(true);
//        mXRecyclerView.setHasFixedSize(true);
//        mXRecyclerView.setNestedScrollingEnabled(false);


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
                mPresenter.queryCookList(id, num);
            }

            //上拉
            @Override
            public void onLoadMore() {
                num += 20;
                mPresenter.queryCookList(id, num);
            }
        });

        mPresenter.queryCookList(id, num);
    }


    @Override
    public void returnCookList(List<CookRBean> list) {
        if (list == null || list.size() == 0) {
            showShortToast("没有更多了");
        }
        if (num == 0) {
            mXRecyclerView.refreshComplete();
            mAdapter.refresh(list);
        } else {
            mXRecyclerView.loadMoreComplete();
            mAdapter.add(list);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cook_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.switch_count) {
            switchLayout();
            switchIcon(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout() {
        if (mLayoutManager.getSpanCount() == SPAN_COUNT_SMALL) {
            mLayoutManager.setSpanCount(SPAN_COUNT_BIG);
        } else {
            mLayoutManager.setSpanCount(SPAN_COUNT_SMALL);
        }
        mAdapter.notifyDataSetChanged();
    }

    private void switchIcon(MenuItem item) {
        if (mLayoutManager.getSpanCount() == SPAN_COUNT_BIG) {
            item.setIcon(getResources().getDrawable(R.mipmap.list_grid));
        } else {
            item.setIcon(getResources().getDrawable(R.mipmap.list_list));
        }
    }
}
