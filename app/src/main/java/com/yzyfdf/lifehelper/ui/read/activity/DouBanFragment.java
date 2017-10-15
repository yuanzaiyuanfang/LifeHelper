package com.yzyfdf.lifehelper.ui.read.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;

import com.jaydenxiao.common.commonutils.TimeUtil;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.read.DouBanListBean;
import com.yzyfdf.lifehelper.ui.read.adapter.DouBanAdapter;
import com.yzyfdf.lifehelper.ui.read.contract.DouBanContract;
import com.yzyfdf.lifehelper.ui.read.model.DouBanModel;
import com.yzyfdf.lifehelper.ui.read.presenter.DouBanPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class DouBanFragment extends BaseAppFragment<DouBanPresenter, DouBanModel> implements DouBanContract.View {

    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private DouBanAdapter mAdapter;
    private ArrayList<DouBanListBean.PostsBean> mList = new ArrayList<>();
    private String date = TimeUtil.getCurrentDate(TimeUtil.dateFormatYMD);

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_xrecyclerview;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //RecyclerView
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new DouBanAdapter(getContext(), mList);
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
                date = TimeUtil.getCurrentDate(TimeUtil.dateFormatYMD);
                mPresenter.queryMoment(date);
            }

            //上拉
            @Override
            public void onLoadMore() {
                date = TimeUtil.getBeforeDay(date);
                mPresenter.queryMoment(date);
            }
        });

        mPresenter.queryMoment(date);
    }

    @Override
    public void returnMoment(DouBanListBean bean) {
        List<DouBanListBean.PostsBean> list = bean.getPosts();
        if (TextUtils.equals(date, TimeUtil.getCurrentDate(TimeUtil.dateFormatYMD))) {
            mAdapter.refresh(list);
            mXRecyclerView.refreshComplete();
        } else {
            mAdapter.add(list);
            mXRecyclerView.loadMoreComplete();
        }
    }
}
