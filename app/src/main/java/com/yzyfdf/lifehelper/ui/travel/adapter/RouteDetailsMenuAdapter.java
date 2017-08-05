package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jaydenxiao.common.commonutils.ToastUitl;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class RouteDetailsMenuAdapter extends BaseAdapter<String, BaseAdapter.BaseRVViewHolder> {
    public RouteDetailsMenuAdapter(Context ctx, List<String> list) {
        super(ctx, list);
    }


    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_routedetails_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        String str = mList.get(position);
        holder.setText(R.id.tv_item, str);
        ImageView bigdot = holder.getImageView(R.id.iv_bigdot);
        if (str.toUpperCase().contains("DAY") || str.toUpperCase().contains("END")) {
            bigdot.setVisibility(View.VISIBLE);
        } else {
            bigdot.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(v -> {
            if (mOnSelectStateListener != null) {
                mOnSelectStateListener.OnSelectStateChanged(true, str, position);
            }
        });
    }


}
