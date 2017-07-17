package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blankj.utilcode.utils.ToastUtils;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.MyFoundBean;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundBean;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class FoundAdapter extends BaseAdapter<MyFoundBean, BaseAdapter.BaseRVViewHolder>
        //        implements StickyRecyclerHeadersAdapter<BaseAdapter.BaseRVViewHolder>
{

    public FoundAdapter(Context ctx, ArrayList<MyFoundBean> list) {
        super(ctx, list);
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

    @Override
    public int getItemViewType(int position) {
        return TextUtils.isEmpty(mList.get(position).getTitle()) ? 2 : 1;
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(getLayoutId(viewType), parent, false));
    }

    public int getLayoutId(int viewType) {
        switch (viewType) {
            case 1:
                return R.layout.item_travel_found_head;
            case 2:
                return R.layout.item_travel_found;
            default:
                return R.layout.item_travel_found_head;
        }
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        MyFoundBean myFoundBean = mList.get(position);
        int type = getItemViewType(position);
        switch (type) {
            case 1:
                String title = myFoundBean.getTitle();
                holder.setText(R.id.where, title);
                holder.itemView.setOnClickListener(v -> ToastUtils.showShortToast(title));
                break;
            case 2:
                TravelFoundBean.DataBean.GuidesBean bean = myFoundBean.getGuidesBean();
                holder.setText(R.id.tv_name, bean.getName());
                holder.setText(R.id.tv_name_en, bean.getName_en());
                holder.setImage(R.id.iv_pic, bean.getImg());
                holder.itemView.setOnClickListener(v -> ToastUtils.showShortToast(bean.getId()+""));
                break;
        }


    }


}
