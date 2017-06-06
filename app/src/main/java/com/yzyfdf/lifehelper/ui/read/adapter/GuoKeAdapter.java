package com.yzyfdf.lifehelper.ui.read.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.read.GuoKeListBean;
import com.yzyfdf.lifehelper.ui.read.activity.DetailsActivity;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class GuoKeAdapter extends BaseAdapter<GuoKeListBean.ResultBean, BaseAdapter.BaseRVViewHolder> {
    public GuoKeAdapter(Context ctx, ArrayList<GuoKeListBean.ResultBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_read_zhihu, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        GuoKeListBean.ResultBean bean = mList.get(position);
        holder.setText(R.id.tv_title, bean.getTitle());
        holder.setImage(R.id.iv_pic, bean.getHeadline_img_tb());
        holder.itemView.setOnClickListener(v -> DetailsActivity.Companion.startSelf(mContext, Constant.TYPE_GUOKE, bean.getId(),bean.getTitle()));

    }
}
