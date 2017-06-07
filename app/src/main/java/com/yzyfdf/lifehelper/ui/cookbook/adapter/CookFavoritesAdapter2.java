package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseVPAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.MyFavoriteBean;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookFavoritesAdapter2 extends BaseVPAdapter<MyFavoriteBean> {

    private OnItemLongClickListener mOnItemLongClickListener;

    public CookFavoritesAdapter2(Context context, ArrayList<MyFavoriteBean> list) {
        super(context, list);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_cook_favorites2;
    }

    @Override
    protected void setView(View view, ViewGroup container, int position) {
        MyFavoriteBean bean = mList.get(position);
        ImageView pic = (ImageView) mView.findViewById(R.id.iv_pic);
        Glide.with(mContext).load(bean.getrBean().getImg()).into(pic);
        mView.setOnLongClickListener(v -> {
            if (mOnItemLongClickListener != null)
                mOnItemLongClickListener.OnLongClick(position);
            return false;
        });
    }

    public interface OnItemLongClickListener {
        void OnLongClick(int position);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }
}
