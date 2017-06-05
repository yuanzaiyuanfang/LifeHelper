package com.yzyfdf.lifehelper.ui.read.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.read.ZhiHuListBean;
import com.yzyfdf.lifehelper.ui.read.adapter.ZhiHuAdapter;
import com.yzyfdf.lifehelper.ui.read.contract.ZhiHuContract;
import com.yzyfdf.lifehelper.ui.read.model.ZhiHuModel;
import com.yzyfdf.lifehelper.ui.read.presenter.ZhiHuPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ZhiHuFragment extends BaseAppFragment<ZhiHuPresenter, ZhiHuModel> implements ZhiHuContract.View {
    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private ArrayList<ZhiHuListBean.StoriesBean> mList = new ArrayList<>();
    private ZhiHuAdapter mAdapter;
    private String url = "latest";

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_read_zhihu;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //RecyclerView
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ZhiHuAdapter(getContext(), mList);
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
                url = "latest";
                mPresenter.queryNews(url);
            }

            //上拉
            @Override
            public void onLoadMore() {
                mPresenter.queryNews(url);
            }
        });

        mPresenter.queryNews(url);
    }


    @Override
    public void returnNews(ZhiHuListBean bean) {
        List<ZhiHuListBean.StoriesBean> list = bean.getStories();
        if (TextUtils.equals(url, "latest")) {
            mAdapter.refresh(list);
            mXRecyclerView.refreshComplete();
        } else {
            mAdapter.add(list);
            mXRecyclerView.loadMoreComplete();
        }
        url = "before/" + bean.getDate();
    }
}
