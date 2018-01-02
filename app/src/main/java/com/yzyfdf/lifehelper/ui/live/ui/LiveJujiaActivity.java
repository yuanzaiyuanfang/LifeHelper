package com.yzyfdf.lifehelper.ui.live.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.live.LiveChannelDataBean;
import com.yzyfdf.lifehelper.ui.live.adapter.LiveJujiaAdapter;
import com.yzyfdf.lifehelper.ui.live.contract.LiveJujiaContract;
import com.yzyfdf.lifehelper.ui.live.model.LiveJujiaModel;
import com.yzyfdf.lifehelper.ui.live.presenter.LiveJujiaPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class LiveJujiaActivity extends BaseAppActivity<LiveJujiaPresenter, LiveJujiaModel>
        implements LiveJujiaContract.View {

    @Bind(R.id.toolbar)
    Toolbar       mToolbar;
    @Bind(R.id.tabLayout)
    TabLayout     mTabLayout;
    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    public static final String mTitle = "居家经验";
    private LinearLayoutManager mLayoutManager;
    private List<LiveChannelDataBean.DataBean.RowsBean> mList = new ArrayList<>();
    private List<String>     mChannelList;
    private LiveJujiaAdapter mAdapter;
    private int position   = 0;
    private int page       = 1;
    private int searchType = 2;
    private int mIs_over;

    public static void startSelf(Context context) {
        Intent intent = new Intent(context, LiveJujiaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_live_jujia;
    }

    @Override
    public void initPresenter() {
        initToolbar(mToolbar, mTitle);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        mTabLayout.setTabTextColors(getResources().getColor(R.color.item_666666), getResources().getColor(R.color.colorPrimary));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                page = 1;
                mPresenter.getChannelData(mChannelList.get(position), page, searchType);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                page = 1;
                mPresenter.getChannelData(mChannelList.get(position), page, searchType);
            }
        });

        //XRecyclerView
        mLayoutManager = new LinearLayoutManager(this);
        mXRecyclerView.setLayoutManager(mLayoutManager);
        mXRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new LiveJujiaAdapter(this, mList);
        mXRecyclerView.setAdapter(mAdapter);
        mXRecyclerView.setLoadingMoreEnabled(true);
        mXRecyclerView.setPullRefreshEnabled(true);
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.LineScalePulseOut);
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            //下拉
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.getChannelData(mChannelList.get(position), page, searchType);
            }

            //上拉
            @Override
            public void onLoadMore() {
                if (mIs_over == 0) {
                    page++;
                    mPresenter.getChannelData(mChannelList.get(position), page, searchType);
                } else {
                    mXRecyclerView.loadMoreComplete();
                }
            }
        });

        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        mPresenter.getChannel(2);
    }

    @Override
    public void returnChannel(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.add(0, "全部");
        mChannelList = list;
        for (String s : list) {
            mTabLayout.addTab(mTabLayout.newTab().setText(s));
        }
        mPresenter.getChannelData(list.get(position), page, searchType);
    }

    @Override
    public void returnChannelData(LiveChannelDataBean.DataBean bean) {
        mXRecyclerView.setNoMore(false);
        mXRecyclerView.refreshComplete();
        mXRecyclerView.loadMoreComplete();
        List<LiveChannelDataBean.DataBean.RowsBean> list = bean.getRows();
        if (list == null || list.size() == 0) {
            return;
        }
        if (page == 1) {
            mAdapter.refresh(list);
            mXRecyclerView.scrollToPosition(0);
        } else {
            mAdapter.add(list);
        }
        mIs_over = bean.getIs_over();
        if (mIs_over == 1) {
            showShortToast("没有更多了");
            mXRecyclerView.setNoMore(true);
        }
    }


}
