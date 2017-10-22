package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ThemeDetailsAdapter extends BaseAdapter<TravelImpressBean.DataBean.PoiBean, BaseAdapter.BaseRVViewHolder> {
    public ThemeDetailsAdapter(Context ctx, ArrayList<TravelImpressBean.DataBean.PoiBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_theme_details, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        TravelImpressBean.DataBean.PoiBean poiBean = mList.get(position);
        //头部
        holder.setText(R.id.tv_location, poiBean.getName());
        String city = TextUtils.isEmpty(poiBean.getCity()) ? "" : poiBean.getCity() + " ";
        holder.setText(R.id.tv_country, city + poiBean.getCountry());
        holder.setText(R.id.tv_favs, poiBean.getFavs() + "");
        holder.setText(R.id.tv_adds, poiBean.getAdds() + "");
        ImageView iv_location = holder.getImageView(R.id.iv_location);
        if (poiBean.getImages() != null && poiBean.getImages().size() > 0) {
            Glide.with(mContext)
                    .load(poiBean.getImages().get(0) + "!320")
                    .override(160, 160)
                    .error(R.mipmap.scenic_big)
                    .placeholder(R.mipmap.scenic_big)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(iv_location);
        } else {
            iv_location.setImageResource(R.mipmap.scenic_big);
        }

        holder.setText(R.id.tv_desc, poiBean.getNote());
        holder.setBigImage(R.id.iv_images, poiBean.getImages().get(0) + "!600");

//        holder.itemView.setOnClickListener(v -> );

    }

}
