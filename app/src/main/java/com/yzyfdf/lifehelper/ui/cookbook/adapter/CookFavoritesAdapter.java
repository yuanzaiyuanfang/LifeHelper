package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.bean.cookbean.MyFavoriteBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookRecipeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookFavoritesAdapter extends BaseAdapter<MyFavoriteBean, BaseAdapter.BaseRVViewHolder> {

    public CookFavoritesAdapter(Context ctx, ArrayList<MyFavoriteBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cook_favorites, parent, false);
        return new BaseRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        MyFavoriteBean myFavoriteBean = mList.get(position);
        CookMainBean.ResultBean.ListBean.RBean rBean = myFavoriteBean.getrBean();
        holder.setImage(R.id.iv_pic, rBean.getImg());
        holder.setText(R.id.tv_name, rBean.getN());

        StringBuilder sb = new StringBuilder();
        List<CookMainBean.ResultBean.ListBean.RBean.MajorBean> majorList = rBean.getMajor();
        for (CookMainBean.ResultBean.ListBean.RBean.MajorBean majorBean : majorList) {
            sb.append(majorBean.getTitle() + "、");
        }
        sb.deleteCharAt(sb.length() - 1);
        holder.setText(R.id.tv_major, sb.toString());

        holder.setText(R.id.tv_love, rBean.getFc() + "收藏  " + rBean.getDc() + "作品");

        holder.itemView.setOnClickListener(v -> {
            Gson gson = new Gson();
            String json = gson.toJson(rBean);
            CookMainBean.ResultBean.ListBean.RBean new_rBean = gson.fromJson(json, CookMainBean.ResultBean.ListBean.RBean.class);
            CookRecipeActivity.startSelf(mContext, new_rBean);
        });
    }
}
