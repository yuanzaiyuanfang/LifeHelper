package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseVPAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookListActivity;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookMainHeadAdapter extends BaseVPAdapter<CookMainBean.ResultBean.ListBean> {


    public CookMainHeadAdapter(Context context, ArrayList<CookMainBean.ResultBean.ListBean> list) {
        super(context, list);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_cook_main_head;
    }

    @Override
    protected void setView(View view, ViewGroup container, int position) {
        ImageView pic = (ImageView) view.findViewById(R.id.iv_pic);
        CookMainBean.ResultBean.ListBean.MBean mBean = mList.get(position).getM();
        Glide.with(container.getContext())
                .load(mBean.getB())
                .thumbnail( 0.1f )
                .error(R.mipmap.no_pic)
                .into(pic);
        pic.setOnClickListener(v -> CookListActivity.startSelf(mContext,mBean));
    }
}
