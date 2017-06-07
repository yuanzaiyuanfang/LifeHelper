package com.yzyfdf.lifehelper.base.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public abstract class BaseVPAdapter<T> extends PagerAdapter {


    protected Context mContext;
    protected ArrayList<T> mList;
    protected View mView;

    public BaseVPAdapter(Context context,ArrayList<T> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mView = LayoutInflater.from(container.getContext()).inflate(getLayout(), container, false);
        setView(mView, container, position);
        container.addView(mView);
        return mView;
    }


    protected abstract int getLayout();

    protected abstract void setView(View view, ViewGroup container, int position);

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
