package com.yzyfdf.lifehelper.ui.live.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.live.LiveChannelDataBean;
import com.yzyfdf.lifehelper.bean.live.UserInfoBean;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class LiveJujiaAdapter extends BaseAdapter<LiveChannelDataBean.DataBean.RowsBean, BaseAdapter.BaseRVViewHolder> {
    public LiveJujiaAdapter(Context ctx, List<LiveChannelDataBean.DataBean.RowsBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_live_jujia, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        LiveChannelDataBean.DataBean.RowsBean bean = mList.get(position);
        holder.setText(R.id.tv_title, bean.getTitle());
        holder.setBigImage(R.id.iv_pic, bean.getPic_url());

        UserInfoBean userInfoBean = bean.getUser_info();
        holder.setText(R.id.tv_author, userInfoBean.getNick());
        holder.setRoundImage(R.id.iv_author, userInfoBean.getAvatar());

        holder.itemView.setOnClickListener(v -> {
            if (mOnSelectStateListener != null) {
                mOnSelectStateListener.OnSelectStateChanged(true,bean,position);
            }
        });

    }
}
