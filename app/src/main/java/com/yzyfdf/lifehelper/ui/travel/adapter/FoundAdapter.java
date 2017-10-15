package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundBean;
import com.yzyfdf.lifehelper.ui.travel.view.FoundActivity;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class FoundAdapter extends BaseAdapter<TravelFoundBean.DataBean.GuidesBean, BaseAdapter.BaseRVViewHolder> {

    public static final String level1 = "level1";
    public static final String level2 = "level2";
    private             String mLevel = "";

    public FoundAdapter(Context ctx, List<TravelFoundBean.DataBean.GuidesBean> list, String level) {
        super(ctx, list);
        if (!TextUtils.isEmpty(level))
            mLevel = level;
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
                        case 1://标题
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
        return TextUtils.isEmpty(mList.get(position).getName()) ? 1 : 2;
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
        TravelFoundBean.DataBean.GuidesBean bean = mList.get(position);
        int type = getItemViewType(position);
        switch (type) {
            case 1:
                holder.setText(R.id.where, bean.getCountry());
                TextView more = holder.getTextView(R.id.more);
                if (TextUtils.equals(mLevel, level1)) {
                    more.setVisibility(View.VISIBLE);
                    more.setOnClickListener(v ->
                            FoundActivity.startSelf(mContext, position == 0 ? position : 1));
                } else {
                    more.setVisibility(View.GONE);
                }
                break;
            case 2:
                holder.setText(R.id.tv_name, bean.getName());
                holder.setText(R.id.tv_name_en, bean.getName_en());
                holder.setImage(R.id.iv_pic, bean.getImg());
                holder.itemView.setOnClickListener(v -> ToastUtils.showShortToast(bean.getId() + ""));
                break;
        }


    }


}
