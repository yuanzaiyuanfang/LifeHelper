package com.yzyfdf.lifehelper.ui.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.MyCsBean;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookCategoryActivity;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookSearchActivity;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookCategoryAdapter extends BaseAdapter<MyCsBean, BaseAdapter.BaseRVViewHolder> {


    private String mCategoryName;

    public CookCategoryAdapter(Context ctx, ArrayList<MyCsBean> list, String categoryName) {
        super(ctx, list);
        mCategoryName = categoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }


    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type) {
                        case 1:
                            return 3;
                        case 2:
                            return 1;
                        default:
                            return 3;
                    }
                }
            });
        }
    }

    public int getLayoutId(int viewType) {
        switch (viewType) {
            case 1:
                return R.layout.item_cook_category1;
            case 2:
                return R.layout.item_cook_category2;
            default:
                return R.layout.item_cook_category1;
        }
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(getLayoutId(viewType), parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        MyCsBean myCsBean = mList.get(position);
        int type = getItemViewType(position);
        switch (type) {
            case 1:
                if ("".equals(myCsBean.getName())) {
                    holder.setText(R.id.tv_classify, mCategoryName);
                } else {
                    holder.setText(R.id.tv_classify, myCsBean.getName());
                }
                break;
            case 2:
                holder.setText(R.id.tv_name, myCsBean.getName());
                holder.itemView.setOnClickListener(v -> {
                    SearchView searchView = ((CookCategoryActivity) mContext).mSearchView;
                    CookSearchActivity.startSelf(mContext, myCsBean.getName());
                });
                break;
            default:
                break;
        }
    }


}
