package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ImpressAdapter extends BaseAdapter<TravelImpressBean.DataBean, BaseAdapter.BaseRVViewHolder> {
    public ImpressAdapter(Context ctx, ArrayList<TravelImpressBean.DataBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_impress, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        TravelImpressBean.DataBean bean = mList.get(position);
        //头部
        TravelImpressBean.DataBean.PoiBean poiBean = bean.getPoi();
        holder.setText(R.id.tv_name, poiBean.getName());
        String city = TextUtils.isEmpty(poiBean.getCity()) ? "" : poiBean.getCity() + " ";
        holder.setText(R.id.tv_country, city+poiBean.getCountry());
        holder.setText(R.id.tv_favs, poiBean.getFavs()+"");
        holder.setText(R.id.tv_adds, poiBean.getAdds()+"");
        if (poiBean.getImages() != null && poiBean.getImages().size() > 0) {
            holder.setSmallImage(R.id.iv_author, poiBean.getImages().get(0) + "!320");
        } else {
            holder.setDefaultImage(R.id.iv_author);
        }
        //图
        List<TravelImpressBean.DataBean.PcBean> pcBeanList = bean.getPc();

//        TravelImpressBean.DataBean.PcBean pcBean = pcBeanList.get(0);
//        holder.setText(R.id.tv_desc, pcBean.getDesc());
//        holder.setText(R.id.tv_likes, pcBean.getLikes() + "");
//        holder.setText(R.id.tv_name, pcBean.getUsername());
//
//        MaterialRatingBar rating = (MaterialRatingBar) holder.getView(R.id.rating);
//        ImageView iv_author = holder.getImageView(R.id.iv_author);
//        ImageView images = holder.getImageView(R.id.iv_images);
//
//        rating.setRating(pcBean.getRating());
//        ImageLoaderUtils.displayRound(mContext, iv_author, pcBean.getAvatar());
//        ImageLoaderUtils.displayBigPhoto(mContext, images, "http://img.chufaba.me/" + getimage(pcBean.getImages()) + "!600");


        //                ViewPager viewPager = (ViewPager) holder.getView(R.id.viewpager);
//                viewPager.setPageMargin(30);
//                viewPager.setOffscreenPageLimit(2);
//                viewPager.setAdapter(new ImpressItemAdapter(mContext, pcBeanList,bean.getPoi().getImages()));

        RecyclerView recyclerview = (RecyclerView) holder.getView(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerview.setAdapter(new ImpressItemAdapter(mContext,pcBeanList,bean.getPoi().getImages()));


    }

    private String getimage(String s) {
        String replace = s.replace("\"", "").replace("[", "").replace("]", "");
        String[] split = replace.split(",");
        return split[0];
    }
}
