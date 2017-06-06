package com.yzyfdf.lifehelper.ui.read.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.read.DouBanListBean;
import com.yzyfdf.lifehelper.ui.read.activity.DetailsActivity;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class DouBanAdapter extends BaseAdapter<DouBanListBean.PostsBean, BaseAdapter.BaseRVViewHolder> {
    public DouBanAdapter(Context ctx, ArrayList<DouBanListBean.PostsBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_read_zhihu, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        DouBanListBean.PostsBean bean = mList.get(position);
        holder.setText(R.id.tv_title, bean.getTitle());
        ImageView pic = holder.getImageView(R.id.iv_pic);
        if (bean.getThumbs() != null && bean.getThumbs().size() > 0) {
            holder.setImage(R.id.iv_pic, bean.getThumbs().get(0).getSmall().getUrl());
            pic.setVisibility(View.VISIBLE);
        } else {
            pic.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(v -> DetailsActivity.Companion.startSelf(mContext, Constant.TYPE_DOUBAN, bean.getId(),bean.getTitle()));

    }
}
