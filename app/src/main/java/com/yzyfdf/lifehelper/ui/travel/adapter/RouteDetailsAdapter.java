package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jaydenxiao.common.commonutils.ToastUitl;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.MyItineraryBean;
import com.yzyfdf.lifehelper.bean.travel.RouteDetailsBean;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class RouteDetailsAdapter extends BaseAdapter<MyItineraryBean, BaseAdapter.BaseRVViewHolder> {
    public RouteDetailsAdapter(Context ctx, List<MyItineraryBean> list) {
        super(ctx, list);
    }

    @Override
    public int getItemViewType(int position) {
        MyItineraryBean myItineraryBean = mList.get(position);
        if (position == 0)
            return 0;
        if (myItineraryBean.getMyItineraryTitle() != null)
            return 1;
        if (myItineraryBean.getLocationsBean() != null)
            return 2;
        return 3;
    }

    public int getLayoutId(int viewType) {
        switch (viewType) {
            case 0:
                return R.layout.item_travel_routedetails_itinerary0;
            case 1:
                return R.layout.item_travel_routedetails_itinerary1;
            case 2:
                return R.layout.item_travel_routedetails_itinerary2;
            default:
                return R.layout.item_travel_routedetails_itinerary3;
        }
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(getLayoutId(viewType), parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        MyItineraryBean bean = mList.get(position);
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
            case 1:
                MyItineraryBean.MyItineraryTitle itineraryTitle = bean.getMyItineraryTitle();
                holder.setText(R.id.tv_day, itineraryTitle.getDay());
                holder.setText(R.id.tv_time_week_city, itineraryTitle.getTime() + "," + itineraryTitle.getWeek() + "," + itineraryTitle.getCity());
                View layout_desc = holder.getView(R.id.layout_desc);
                if (TextUtils.isEmpty(itineraryTitle.getDesc())) {
                    layout_desc.setVisibility(View.GONE);
                } else {
                    holder.setText(R.id.tv_desc, itineraryTitle.getDesc());
                    layout_desc.setVisibility(View.VISIBLE);
                }

                holder.getView(R.id.layout_day).setOnClickListener(v -> ToastUitl.showShort(itineraryTitle.getDay()));
                break;
            case 2:
                RouteDetailsBean.ItineraryBean.LocationsBean locationsBean = bean.getLocationsBean();
                ImageView type_loc = holder.getImageView(R.id.iv_type_loc);
                type_loc.setImageResource(getTypeLoc(locationsBean.getCategory()));
                holder.setText(R.id.tv_location, !TextUtils.isEmpty(locationsBean.getName()) ? locationsBean.getName() : (!TextUtils.isEmpty(locationsBean.getName_en()) ? locationsBean.getName_en() : "未知"));
                holder.getView(R.id.layout_location).setOnClickListener(v -> ToastUitl.showShort(locationsBean.getName()));

                FrameLayout layout_comment = (FrameLayout) holder.getView(R.id.layout_comment);
                RouteDetailsBean.ItineraryBean.LocationsBean.CommentBean comment = locationsBean.getComment();
                if (comment == null) {
                    layout_comment.setVisibility(View.GONE);
                } else {
                    layout_comment.setVisibility(View.VISIBLE);
                    ImageView iv = holder.getImageView(R.id.iv_images);
                    if (comment.getImages() != null && comment.getImages().size() > 0) {
                        holder.setBigImage(R.id.iv_images, "http://img.chufaba.me/" + comment.getImages().get(0) + "!600");
                        iv.setVisibility(View.VISIBLE);
                    } else {
                        iv.setVisibility(View.GONE);
                    }
                    holder.setText(R.id.tv_feel, getFeel(comment.getRating()));
                    holder.setText(R.id.tv_comment_desc, comment.getDesc());

                    MaterialRatingBar rating = (MaterialRatingBar) holder.getView(R.id.rating);
                    rating.setRating(comment.getRating());

                    layout_comment.setOnClickListener(v -> ToastUitl.showShort(comment.getImages().size() + "张"));
                }

                break;
            default:

                break;
        }
    }

    public static int getTypeLoc(String category) {
        switch (category) {
            case "美食":
                return R.mipmap.food;
            case "景点":
                return R.mipmap.scenic;
            case "住宿":
                return R.mipmap.hotel;
            default:
                return R.mipmap.other;
        }
    }

    public static String getFeel(float rating) {
        if (rating >= 4.5)
            return "觉得超赞";
        if (rating >= 3.5)
            return "觉得好";
        if (rating >= 2.5)
            return "觉得一般";
        if (rating >= 1.5)
            return "觉得较差";
        return "觉得很差";
    }
}
