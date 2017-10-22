package com.yzyfdf.lifehelper.ui.travel.view;

import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.travel.TravelRoutesBean;
import com.yzyfdf.lifehelper.ui.travel.adapter.RoutesAdapter;
import com.yzyfdf.lifehelper.ui.travel.contract.RoutesContract;
import com.yzyfdf.lifehelper.ui.travel.model.RoutesModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.RoutesPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${远方 -  精选  行程}
 */

public class RoutesFragment extends BaseAppFragment<RoutesPresenter, RoutesModel> implements RoutesContract.View {
    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private int                                   num        = 0;
    private ArrayList<TravelRoutesBean.ItemsBean> mList      = new ArrayList<>();
    private ArrayList<TravelRoutesBean.ItemsBean> mArrayList = new ArrayList<>();
    private RoutesAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_travel_routes;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //RecyclerView
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new RoutesAdapter(getContext(), mList);
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
                mPresenter.getRoutes(num);
            }

            //上拉
            @Override
            public void onLoadMore() {
                mPresenter.getRoutes(num);
            }
        });

        mPresenter.getRoutes(num);
    }


    @Override
    public void returnRoutes(List<TravelRoutesBean.ItemsBean> list) {
        //过滤出类型3 请求条目按原来增加 纺织重复
        mArrayList.clear();
        for (TravelRoutesBean.ItemsBean bean : list) {
            if (bean.getRes_type() == 1 || bean.getRes_type() == 2 || bean.getRes_type() == 3) {
                mArrayList.add(bean);
            }
        }
        if (num == 0) {
            mAdapter.refresh(mArrayList);
            mXRecyclerView.refreshComplete();
        } else {
            mAdapter.add(mArrayList);
            mXRecyclerView.loadMoreComplete();
        }
        num += list.size();
    }
}
