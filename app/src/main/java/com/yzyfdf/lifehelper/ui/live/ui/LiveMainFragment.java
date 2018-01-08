package com.yzyfdf.lifehelper.ui.live.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.live.LiveHomeDynamicBean;
import com.yzyfdf.lifehelper.ui.live.adapter.LiveMainAdapter;
import com.yzyfdf.lifehelper.ui.live.contract.LiveMainContract;
import com.yzyfdf.lifehelper.ui.live.model.LiveMainModel;
import com.yzyfdf.lifehelper.ui.live.presenter.LiveMainPresenter;
import com.yzyfdf.lifehelper.ui.other.activity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class LiveMainFragment extends BaseAppFragment<LiveMainPresenter, LiveMainModel>
        implements LiveMainContract.View {
    @Bind(R.id.layout_jujia)
    TextView mLayoutJujia;
    @Bind(R.id.layout_dajia)
    TextView mLayoutDajia;
    @Bind(R.id.xRecyclerView)
    XRecyclerView mXRecyclerView;

    private FloatingActionButton mFab;
    private LiveMainAdapter mAdapter;

    private ArrayList<LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean> mList;
    private String start_id;
    private int type = 1;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_livemain;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mFab = ((HomeActivity) getContext()).mFab;

        //RecyclerView
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new LiveMainAdapter(getContext(), mList);
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
                start_id = "";
                mPresenter.getHomeDynamic(start_id, type);
            }

            //上拉
            @Override
            public void onLoadMore() {
                mPresenter.getHomeDynamic(start_id, type);
            }
        });
        start_id = "";
        mPresenter.getHomeDynamic(start_id, type);
    }

    @OnClick({R.id.layout_jujia, R.id.layout_dajia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_jujia:
                LiveJujiaActivity.startSelf(getContext());
                break;
            case R.id.layout_dajia:
                break;
        }
    }


    @Override
    public void returnHomeDynamic(LiveHomeDynamicBean.DataBean bean) {
        List<LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean> list = bean.getRows().getFeeds();

        if (list == null || list.size() == 0) {
            return;
        }

        if (TextUtils.isEmpty(start_id)) {
            mAdapter.refresh(list);
            mXRecyclerView.refreshComplete();
        } else {
            mAdapter.add(list);
            start_id = list.get(list.size() - 1).getFeed_id();
            mXRecyclerView.loadMoreComplete();
        }
    }
}
