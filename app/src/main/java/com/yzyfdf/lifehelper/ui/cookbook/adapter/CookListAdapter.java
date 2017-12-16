package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookRBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookRecipeActivity;

import java.util.ArrayList;


/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookListAdapter extends BaseAdapter<CookRBean, BaseAdapter.BaseRVViewHolder> {

    private GridLayoutManager mLayoutManager;
    public static final int SPAN_COUNT_SMALL = 1;
    public static final int SPAN_COUNT_BIG   = 2;

    public CookListAdapter(Context ctx, ArrayList<CookRBean> list, GridLayoutManager layoutManager) {
        super(ctx, list);
        mLayoutManager = layoutManager;
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (mLayoutManager.getSpanCount() == SPAN_COUNT_SMALL) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_cook_list1, parent, false);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_cook_list2, parent, false);
        }
        return new BaseRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        final CookRBean rBean = mList.get(position);
        holder.setImage(R.id.iv_pic, rBean.getP());
        holder.setText(R.id.tv_name, rBean.getN());
        TextView tv_desc = holder.getTextView(R.id.tv_desc);
        tv_desc.setText(TextUtils.isEmpty(rBean.getCookstory()) ? "暂无介绍" : rBean.getCookstory());
        if (mLayoutManager.getSpanCount() == SPAN_COUNT_SMALL) {
            tv_desc.setVisibility(View.VISIBLE);
        } else {
            tv_desc.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(v -> {
            CookRecipeActivity.startSelf(mContext, rBean);
        });
    }


}
