package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.bean.cookbean.CookSearchBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookRecipeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookSearchAdapter extends BaseAdapter<CookSearchBean.ResultBean.ListBean.RBean, BaseAdapter.BaseRVViewHolder> {
    public CookSearchAdapter(Context ctx, ArrayList<CookSearchBean.ResultBean.ListBean.RBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cook_search, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        CookSearchBean.ResultBean.ListBean.RBean rBean = mList.get(position);
        ImageView pic = holder.getImageView(R.id.iv_pic);
        holder.setImage(R.id.iv_pic, rBean.getImg());
        holder.setText(R.id.tv_name, rBean.getN());

        StringBuilder sb = new StringBuilder();
        List<CookSearchBean.ResultBean.ListBean.RBean.MajorBean> majorList = rBean.getMajor();
        for (CookSearchBean.ResultBean.ListBean.RBean.MajorBean majorBean : majorList) {
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
