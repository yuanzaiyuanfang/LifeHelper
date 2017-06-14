package com.yzyfdf.lifehelper.ui.read.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.read.ZhiHuListBean;
import com.yzyfdf.lifehelper.ui.read.activity.ReadDetailsActivity;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ZhiHuAdapter extends BaseAdapter<ZhiHuListBean.StoriesBean, BaseAdapter.BaseRVViewHolder> {
    public ZhiHuAdapter(Context ctx, ArrayList<ZhiHuListBean.StoriesBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_read_zhihu, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        ZhiHuListBean.StoriesBean bean = mList.get(position);
        holder.setText(R.id.tv_title, bean.getTitle());
        holder.setImage(R.id.iv_pic, bean.getImages().get(0));
        holder.itemView.setOnClickListener(v -> ReadDetailsActivity.startSelf(mContext, Constant.TYPE_ZHIHU, bean.getId(),bean.getTitle(),""));
    }
}
