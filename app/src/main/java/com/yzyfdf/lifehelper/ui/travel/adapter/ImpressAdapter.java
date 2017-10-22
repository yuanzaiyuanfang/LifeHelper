package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.MyImpressBean;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;
import com.yzyfdf.lifehelper.ui.travel.view.ImpressDetailsActivity;
import com.yzyfdf.lifehelper.util.TravelUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

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
        holder.setText(R.id.tv_location, poiBean.getName());
        String city = TextUtils.isEmpty(poiBean.getCity()) ? "" : poiBean.getCity() + " ";
        holder.setText(R.id.tv_country, city + poiBean.getCountry());
        holder.setText(R.id.tv_favs, poiBean.getFavs() + "");
        holder.setText(R.id.tv_adds, poiBean.getAdds() + "");
        ImageView iv_location = holder.getImageView(R.id.iv_location);
        if (poiBean.getImages() != null && poiBean.getImages().size() > 0) {
            Glide.with(mContext)
                    .load(poiBean.getImages().get(0) + "!320")
                    .override(160,160)
                    .error(R.mipmap.scenic_big)
                    .placeholder(R.mipmap.scenic_big)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(iv_location);
        } else {
            iv_location.setImageResource(R.mipmap.scenic_big);
        }


        //图
        List<TravelImpressBean.DataBean.PcBean> pcBeanList = bean.getPc();

        TravelImpressBean.DataBean.PcBean pcBean = pcBeanList.get(0);
        holder.setText(R.id.tv_author, pcBean.getUsername());
        holder.setText(R.id.tv_feel, JournalDetailsAdapter.getFeel(pcBean.getRating()));
        holder.setText(R.id.tv_likes, pcBean.getLikes() + "");
        holder.setText(R.id.tv_desc, pcBean.getDesc());
        holder.setRoundImage(R.id.iv_author, pcBean.getAvatar());
        holder.setBigImage(R.id.iv_images, Constant.travel_image + TravelUtil.getimage(pcBean.getImages()) + "!600");

        MaterialRatingBar rating = (MaterialRatingBar) holder.getView(R.id.rating);
        rating.setRating(pcBean.getRating());

        String location = !TextUtils.isEmpty(poiBean.getName()) ? poiBean.getName() : (!TextUtils.isEmpty(poiBean.getName_en()) ? poiBean.getName_en() : "未知");

        holder.itemView.setOnClickListener(v -> ImpressDetailsActivity.startSelf(mContext,
                new MyImpressBean(pcBean.getDesc(),location,pcBean.getCreated_at(),pcBean.getPlan_name(),
                        Arrays.asList(TravelUtil.getimages(pcBean.getImages())),pcBean.getAvatar(),pcBean.getUsername(),pcBean.getRating())));
        //                ViewPager viewPager = (ViewPager) holder.getView(R.id.viewpager);
        //                viewPager.setPageMargin(30);
        //                viewPager.setOffscreenPageLimit(2);
        //                viewPager.setAdapter(new ImpressItemAdapter(mContext, pcBeanList,bean.getPoi().getImages()));

        //        RecyclerView recyclerview = (RecyclerView) holder.getView(R.id.recyclerview);
        //        recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        //        recyclerview.setAdapter(new ImpressItemAdapter(mContext,pcBeanList,bean.getPoi().getImages()));


    }

//    private String getimage(String s) {
//        String[] strings = getimages(s);
//        return strings[0];
//    }
//
//    private String[] getimages(String s) {
//        String replace = s.replace("\"", "").replace("[", "").replace("]", "");
//        String[] split = replace.split(",");
//        return split;
//    }
}
