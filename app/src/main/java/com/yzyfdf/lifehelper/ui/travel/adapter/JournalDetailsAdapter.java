package com.yzyfdf.lifehelper.ui.travel.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jaydenxiao.common.commonutils.ToastUitl;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.JournalDetailsBean;
import com.yzyfdf.lifehelper.bean.travel.MyItineraryBean;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;
import com.yzyfdf.lifehelper.ui.travel.view.ImpressDetailsActivity;
import com.yzyfdf.lifehelper.util.TravelUtil;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class JournalDetailsAdapter extends BaseAdapter<MyItineraryBean, BaseAdapter.BaseRVViewHolder> {
    private String   mTitle    = "";
    private String   mUsername = "";
    private String   mAvatar   = "";
    private String   mUrl      = "";
    private String[] tipArrs   = {"出发君说：", "游玩方式：", "如何到达："};

    public JournalDetailsAdapter(Context ctx, List<MyItineraryBean> list) {
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
                holder.setText(R.id.tv_time_week_city, itineraryTitle.getTime() + itineraryTitle.getWeek() + itineraryTitle.getCity());
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
                JournalDetailsBean.ItineraryBean.LocationsBean locationsBean = bean.getLocationsBean();
                ImageView type_loc = holder.getImageView(R.id.iv_type_loc);
                type_loc.setImageResource(getTypeLoc(locationsBean.getCategory()));
                String location = !TextUtils.isEmpty(locationsBean.getName()) ? locationsBean.getName() : (!TextUtils.isEmpty(locationsBean.getName_en()) ? locationsBean.getName_en() : "未知");
                holder.setText(R.id.tv_location, location);
                holder.getView(R.id.layout_location).setOnClickListener(v -> ToastUitl.showShort(locationsBean.getName()));

                JournalDetailsBean.ItineraryBean.LocationsBean.CommentBean comment = locationsBean.getComment();
                FrameLayout layout_comment = (FrameLayout) holder.getView(R.id.layout_comment);
                ImageView iv = holder.getImageView(R.id.iv_images);
                MaterialRatingBar rating = (MaterialRatingBar) holder.getView(R.id.rating);
                LinearLayout layoutFeel = (LinearLayout) holder.getView(R.id.layout_feel);
                if (comment == null) {
                    List<String> images = locationsBean.getImages();
                    if (images != null && images.size() > 0) {
                        //route
                        layout_comment.setVisibility(View.VISIBLE);

                        holder.setBigImage(R.id.iv_images, images.get(0) + "!600");
                        iv.setVisibility(View.VISIBLE);

                        layoutFeel.setVisibility(View.GONE);
                        holder.setText(R.id.tv_comment_desc, getNote(locationsBean.getNote()));

//                        layout_comment.setOnClickListener(v -> ImpressDetailsActivity.startSelf(mContext,
//                                new TravelImpressBean.DataBean.PcBean(locationsBean.getIntro(),
//                                        images.toArray().toString(), location, mUrl, "", mTitle)));
                    } else {
                        layout_comment.setVisibility(View.GONE);
                    }
                } else {
                    //journal
                    layout_comment.setVisibility(View.VISIBLE);
                    List<String> images = comment.getImages();
                    if (images != null && images.size() > 0) {
                        holder.setBigImage(R.id.iv_images, Constant.travel_image + images.get(0) + "!600");
                        iv.setVisibility(View.VISIBLE);
                    } else {
                        iv.setVisibility(View.GONE);
                    }
                    holder.setText(R.id.tv_feel, getFeel(comment.getRating()));
                    holder.setText(R.id.tv_comment_desc, comment.getDesc());

                    rating.setRating(comment.getRating());

                    layout_comment.setOnClickListener(v -> {
                        TravelImpressBean.DataBean.PcBean pcBean = new TravelImpressBean.DataBean.PcBean(comment.getDesc(),
                                TravelUtil.toStrImages(images), location, "", comment.getCreated_at(), mTitle);
                        ImpressDetailsActivity.startSelf(mContext,pcBean);
                    });
                }

                break;
            default:

                break;
        }
    }

    private SpannableString getNote(String note) {
        if (TextUtils.isEmpty(note))
            return new SpannableString("\n无介绍");

        note = "\n" + note.replace("#", "");
        int i1 = note.indexOf("\n", 1);
        SpannableString ss = new SpannableString(note);
        ss.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, i1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        for (int j = 0; j < tipArrs.length; j++) {
            if (note.contains(tipArrs[j])) {
                int i = note.indexOf(tipArrs[j]);
                ss.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), i, i + tipArrs[j].length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }
        }
        return ss;
    }

    public static int getTypeLoc(String category) {
//        switch (category) {
//            case "美食":
//                return R.mipmap.food;
//            case "景点":
//                return R.mipmap.scenic;
//            case "住宿":
//                return R.mipmap.hotel;
//            default:
//                return R.mipmap.other;
//        }
        return 1;
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

    public void setTitle(String title, String username, String avatar, String url) {
        if (!TextUtils.isEmpty(title))
            mTitle = title;
        if (!TextUtils.isEmpty(username))
            mUsername = username;
        if (!TextUtils.isEmpty(avatar))
            mAvatar = avatar;
        if (!TextUtils.isEmpty(url))
            mUrl = url;
    }
}
