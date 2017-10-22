package com.yzyfdf.lifehelper.ui.travel.view;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;
import com.yzyfdf.lifehelper.ui.travel.adapter.ImpressAdapter;
import com.yzyfdf.lifehelper.ui.travel.contract.ImpressContract;
import com.yzyfdf.lifehelper.ui.travel.model.ImpressModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.ImpressPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${远方 -  精选  行程}
 */

public class ImpressFragment extends BaseAppFragment<ImpressPresenter, ImpressModel> implements ImpressContract.View {
    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private String                                time  = "";
    private ArrayList<TravelImpressBean.DataBean> mList = new ArrayList<>();
    private ImpressAdapter mAdapter;
    private boolean again = true;

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
        mAdapter = new ImpressAdapter(getContext(), mList);
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
                time = "";
                again = true;
                mPresenter.getImpress(time);
            }

            //上拉
            @Override
            public void onLoadMore() {
                again = true;
                mPresenter.getImpress(time);
            }
        });
        again = true;
        mPresenter.getImpress(time);
    }


    @Override
    public void returnImpress(List<TravelImpressBean.DataBean> list) {
        if (TextUtils.isEmpty(time)) {
            mAdapter.refresh(list);
            mXRecyclerView.refreshComplete();
        } else {
            mAdapter.add(list);
            mXRecyclerView.loadMoreComplete();
        }
        if (list.size() > 0)
            time = list.get(list.size() - 1).getTime();

        if (again) {
            mPresenter.getImpress(time);
        }
        again = !again;
    }
}
