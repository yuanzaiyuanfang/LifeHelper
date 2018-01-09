package com.yzyfdf.lifehelper.ui.live.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.utils.ScreenUtils;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.live.LiveHomeDynamicBean;

import java.util.List;

/**
 * Created by MLRC-iOS-CI on 2018/1/8.
 */

public class LiveMainAdapter extends BaseAdapter<LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean, BaseAdapter.BaseRVViewHolder> {
    public LiveMainAdapter(Context ctx, List<LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_live_main, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean bean = mList.get(position);
        LiveHomeDynamicBean.DataBean.RowsBean.FeedsBean.PhotoDataBean.PhotoInfoBean photoInfo = bean.getPhoto_data().getPhoto_info();
        holder.setText(R.id.remark, photoInfo.getRemark());

        ImageView iv = holder.getImageView(R.id.iv_pic);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) iv.getLayoutParams();
        String picUrl = photoInfo.getNew_pic_url();
        int picSize = getPicSize(picUrl, lp);
        holder.setBigImage(R.id.iv_pic, picUrl);

        ViewGroup.LayoutParams lp2 = holder.itemView.getLayoutParams();
        lp2.height = lp2.height + picSize;

    }

    private int getPicSize(String picUrl, LinearLayout.LayoutParams lp) {
        int oriH = lp.height;
        lp.width = ScreenUtils.getScreenWidth();
        lp.height = (int) (lp.width * 1.5);
        int width = lp.width;
        int height = lp.height;

        try {
            if (picUrl.contains("w=")) {
                int i = picUrl.indexOf("w=");
                width = Integer.parseInt(picUrl.substring(i + 2, i + 5));
            }
            if (picUrl.contains("h=")) {
                int i = picUrl.indexOf("h=");
                height = Integer.parseInt(picUrl.substring(i + 2, i + 5));
            }
            lp.height = lp.width * height / width;
        } catch (Exception e) {
            lp.width = ScreenUtils.getScreenWidth();
            lp.height = (int) (lp.width * 1.5);
        }

        return oriH - lp.height;
    }


}
