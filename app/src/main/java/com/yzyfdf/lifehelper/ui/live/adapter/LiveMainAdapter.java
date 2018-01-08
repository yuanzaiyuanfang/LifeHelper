package com.yzyfdf.lifehelper.ui.live.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.live.LiveHomeDynamicBean;

import java.util.List;

/**
 * Created by MLRC-iOS-CI on 2018/1/8.
 */

public class LiveMainAdapter extends BaseAdapter<LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean,BaseAdapter.BaseRVViewHolder> {
    public LiveMainAdapter(Context ctx, List<LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {

    }
}
