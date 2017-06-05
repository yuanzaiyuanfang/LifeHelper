package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseVPAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookStepAdapter extends BaseVPAdapter<CookMainBean.ResultBean.ListBean.RBean.CookstepBean> {


    public CookStepAdapter(Context context, ArrayList<CookMainBean.ResultBean.ListBean.RBean.CookstepBean> list) {
        super(context, list);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_cook_step;
    }

    @Override
    protected void setView(View view, ViewGroup container, int position) {
        PhotoView pic= (PhotoView) view.findViewById(R.id.iv_pic);
        Glide.with(container.getContext())
                .load(mList.get(position).getImage())
                .thumbnail( 0.1f )
                .error(R.mipmap.no_pic)
                .into(pic);

    }
}
