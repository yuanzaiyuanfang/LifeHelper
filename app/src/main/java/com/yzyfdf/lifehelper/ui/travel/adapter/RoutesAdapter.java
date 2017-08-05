package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jaydenxiao.common.commonutils.ToastUitl;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.TravelRoutesBean;
import com.yzyfdf.lifehelper.ui.travel.view.RouteDetailsActivity;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class RoutesAdapter extends BaseAdapter<TravelRoutesBean.ItemsBean, BaseAdapter.BaseRVViewHolder> {
    public RoutesAdapter(Context ctx, ArrayList<TravelRoutesBean.ItemsBean> list) {
        super(ctx, list);
    }


    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_route, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        TravelRoutesBean.ItemsBean bean = mList.get(position);
        holder.setText(R.id.tv_name, bean.getTitle());
        holder.setText(R.id.tv_desc, getDesc(bean.getDestinations()));
        holder.setImage(R.id.iv_pic, bean.getBackground_image());
        holder.itemView.setOnClickListener(v -> {
            if (bean.getRes_type() == 3) {
                RouteDetailsActivity.startSelf(mContext,bean.getUrl());
            } else {
                ToastUitl.showShort(bean.getId()+"");
            }
        });
    }

    private String getDesc(String destinations) {
        StringBuffer sb = new StringBuffer("————·");
        try {
            String[] strings = destinations.split("、");
            for (String s : strings) {
                sb.append(s + "·");
            }
        } catch (Exception e) {
            sb.delete(0, sb.length());
            sb.append("————·" + destinations + "·");
        }
        sb.append("————");
        return sb.toString();
    }
}
