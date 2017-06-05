package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookStepActivity;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookRecipeAdapter extends BaseAdapter<CookMainBean.ResultBean.ListBean.RBean.CookstepBean,BaseAdapter.BaseRVViewHolder> {
    private ArrayList<String> urlList = new ArrayList<>();
    public CookRecipeAdapter(Context ctx, ArrayList<CookMainBean.ResultBean.ListBean.RBean.CookstepBean> list) {
        super(ctx, list);
        for (CookMainBean.ResultBean.ListBean.RBean.CookstepBean cookstepBean : list) {
            urlList.add(cookstepBean.getContent());
        }
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cook_recipe_step,parent,false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        final CookMainBean.ResultBean.ListBean.RBean.CookstepBean cookstepBean = mList.get(position);
        holder.setBigImage(R.id.iv_steppic, cookstepBean.getImage());
        holder.setText(R.id.tv_stepname, cookstepBean.getPosition() + "\u3000" + cookstepBean.getContent());
        holder.itemView.setOnClickListener(v -> CookStepActivity.startSelf(mContext,mList,position));
    }


}
