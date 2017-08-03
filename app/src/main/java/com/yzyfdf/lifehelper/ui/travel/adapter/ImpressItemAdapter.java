package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

//public class ImpressItemAdapter extends BaseVPAdapter<TravelImpressBean.DataBean.PcBean> {
//
//    private List<String> mImages;
//
//    public ImpressItemAdapter(Context context, List<TravelImpressBean.DataBean.PcBean> list, List<String> images) {
//        super(context, list);
//        mImages = images;
//    }
//
//    @Override
//    protected int getLayout() {
//        return R.layout.item_travel_impress_item;
//    }
//
//    @Override
//    protected void setView(View view, ViewGroup container, int position) {
//        TravelImpressBean.DataBean.PcBean bean = mList.get(position);
//
//        TextView desc = (TextView) view.findViewById(R.id.tv_desc);
//        TextView tv_likes = (TextView) view.findViewById(R.id.tv_likes);
//        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
//        MaterialRatingBar rating = (MaterialRatingBar) view.findViewById(R.id.rating);
//        ImageView iv_author = (ImageView) view.findViewById(R.id.iv_author);
//        ImageView images = (ImageView) view.findViewById(R.id.iv_images);
//
//
//        desc.setText(bean.getDesc());
//        tv_likes.setText(bean.getLikes()+"");
//        ImageLoaderUtils.displayRound(mContext,iv_author,bean.getAvatar());
//        tv_name.setText(bean.getUsername());
//        rating.setRating( bean.getRating());
//        ImageLoaderUtils.displayBigPhoto(mContext,images,"http://img.chufaba.me/"+getimage(bean.getImages())+"!600");
//
//
//    }
//
//    private String getimage(String s) {
//        String replace = s.replace("\"","").replace("[","").replace("]","");
//        String[] split = replace.split(",");
//        return split[0];
//    }
//
//}


public class ImpressItemAdapter extends BaseAdapter<TravelImpressBean.DataBean.PcBean, BaseAdapter.BaseRVViewHolder> {

    private List<String> mImages;

    public ImpressItemAdapter(Context ctx, List<TravelImpressBean.DataBean.PcBean> list, List<String> images) {
        super(ctx, list);
        mImages = images;
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_impress_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        TravelImpressBean.DataBean.PcBean bean = mList.get(position);
        holder.setText(R.id.tv_desc, bean.getDesc());
        holder.setText(R.id.tv_likes, bean.getLikes() + "");
        holder.setText(R.id.tv_name, bean.getUsername());
        holder.setBigImage(R.id.iv_images, "http://img.chufaba.me/" + getimage(bean.getImages()) + "!600");
        holder.setRoundImage(R.id.iv_author,bean.getAvatar());

        MaterialRatingBar rating = (MaterialRatingBar) holder.getView(R.id.rating);
        rating.setRating(bean.getRating());

    }

    private String getimage(String s) {
        String replace = s.replace("\"", "").replace("[", "").replace("]", "");
        String[] split = replace.split(",");
        return split[0];
    }
}