package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookRBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookRecipeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookSearchAdapter extends BaseAdapter<CookRBean, BaseAdapter.BaseRVViewHolder> {
    public CookSearchAdapter(Context ctx, ArrayList<CookRBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cook_search, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        CookRBean rBean = mList.get(position);
        ImageView pic = holder.getImageView(R.id.iv_pic);
        holder.setImage(R.id.iv_pic, rBean.getImg());
        holder.setText(R.id.tv_name, rBean.getN());

        StringBuilder sb = new StringBuilder();
        List<CookRBean.MajorBean> majorList = rBean.getMajor();
        for (CookRBean.MajorBean majorBean : majorList) {
            sb.append(majorBean.getTitle() + "、");
        }
        sb.deleteCharAt(sb.length() - 1);
        holder.setText(R.id.tv_major, sb.toString());

        holder.setText(R.id.tv_love, rBean.getFc() + "收藏  " + rBean.getDc() + "作品");

        holder.itemView.setOnClickListener(v -> {
            CookRecipeActivity.startSelf(mContext, rBean.getId());
        });
    }
}
