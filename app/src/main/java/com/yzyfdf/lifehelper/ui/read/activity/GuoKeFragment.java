package com.yzyfdf.lifehelper.ui.read.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.read.GuoKeListBean;
import com.yzyfdf.lifehelper.ui.read.adapter.GuoKeAdapter;
import com.yzyfdf.lifehelper.ui.read.contract.GuoKeContract;
import com.yzyfdf.lifehelper.ui.read.model.GuoKeModel;
import com.yzyfdf.lifehelper.ui.read.presenter.GuoKePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class GuoKeFragment extends BaseAppFragment<GuoKePresenter, GuoKeModel> implements GuoKeContract.View {

    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private ArrayList<GuoKeListBean.ResultBean> mList = new ArrayList<>();
    private GuoKeAdapter mAdapter;
    private int num = 0;

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
        mAdapter = new GuoKeAdapter(getContext(), mList);
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
                mPresenter.queryArticle(num);
            }

            //上拉
            @Override
            public void onLoadMore() {
                num += 20;
                mPresenter.queryArticle(num);
            }
        });

        mPresenter.queryArticle(num);
    }

    @Override
    public void returnArticle(GuoKeListBean bean) {
        List<GuoKeListBean.ResultBean> list = bean.getResult();
        if (num == 0) {
            mAdapter.refresh(list);
            mXRecyclerView.refreshComplete();
        } else {
            mAdapter.add(list);
            mXRecyclerView.loadMoreComplete();
        }

    }
}
