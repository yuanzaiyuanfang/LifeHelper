package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.utils.ScreenUtils;
import com.blankj.utilcode.utils.SizeUtils;
import com.bumptech.glide.Glide;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookRecipeActivity;

import java.util.ArrayList;


/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookMainAdapter extends BaseAdapter<CookMainBean.ResultBean.ListBean, BaseAdapter.BaseRVViewHolder> {
    public CookMainAdapter(Context ctx, ArrayList<CookMainBean.ResultBean.ListBean> list) {
        super(ctx, list);
    }

    //    @Override
    //    public int getItemViewType(int position) {
    //        CookMainBean.ResultBean.ListBean bean = mList.get(position);
    //        switch (bean.getType()) {
    //            case "2":
    //                return 1;//食谱
    //            case "3":
    //                return 2;//食谱集合
    //        }
    //        return 2;
    //    }


    public int getLayoutId(int viewType) {
        //        if (viewType == 1)
        return R.layout.item_cook_main_recipe;
        //        if (viewType == 2)
        //            return R.layout.item_cook_main_list;
        //        return 0;
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(getLayoutId(viewType), parent, false);
        return new BaseRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        //        final int viewType = getItemViewType(position);
        CookMainBean.ResultBean.ListBean bean = mList.get(position);
        //        if (viewType == 1) {
        final CookMainBean.ResultBean.ListBean.RBean rBean = bean.getR();
        setImage(holder, R.id.iv_pic, rBean.getImg());
        holder.setText(R.id.tv_name, rBean.getN());
        holder.setText(R.id.tv_desc, TextUtils.isEmpty(rBean.getCookstory()) ? "暂无介绍" : rBean.getCookstory());
        holder.itemView.setOnClickListener(v -> CookRecipeActivity.startSelf(mContext, rBean));
        //        } else {
        //            final CookMainBean.ResultBean.ListBean.MBean mBean = bean.getM();
        //            holder.setBigImage(R.id.iv_pic, mBean.getB());
        //            holder.setText(R.id.tv_name, mBean.getT());
        //            holder.setText(R.id.tv_num, "共" + mBean.getC() + "道菜");
        //            holder.itemView.setOnClickListener(v -> CookListActivity.startSelf(mContext, mBean));
        //        }

    }

    private void setImage(BaseRVViewHolder holder, int iv_pic, String img) {
        ImageView pic = holder.getImageView(iv_pic);
        ViewGroup.LayoutParams layoutParams = pic.getLayoutParams();
        int width = ScreenUtils.getScreenWidth() / 2 - SizeUtils.dp2px(5) * 2;
        int height = width * 225 / 300;
        layoutParams.width = width;
        layoutParams.height = height;
        pic.setLayoutParams(layoutParams);
        Glide.with(mContext)
                .load(img)
                .error(R.mipmap.no_pic)
                .into(pic);
    }

}
