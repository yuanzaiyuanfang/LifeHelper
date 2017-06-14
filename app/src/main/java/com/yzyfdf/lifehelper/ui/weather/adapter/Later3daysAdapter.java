package com.yzyfdf.lifehelper.ui.weather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class Later3daysAdapter extends BaseAdapter<WeatherBean.HeWeather5Bean.DailyForecastBean, BaseAdapter.BaseRVViewHolder> {


    public Later3daysAdapter(Context ctx, ArrayList<WeatherBean.HeWeather5Bean.DailyForecastBean> list) {
        super(ctx, list);
    }

    @Override
    public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_weather_daily, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
        WeatherBean.HeWeather5Bean.DailyForecastBean bean = mList.get(position);
        holder.setText(R.id.tv_cond, bean.getCond().getTxt_d());
        holder.setText(R.id.tv_minMax, bean.getTmp().getMin() + "°/" + bean.getTmp().getMax() + "°");
        holder.setImage(R.id.iv_cond, Constant.weather_icon.replace("code", bean.getCond().getCode_d()));

        holder.setText(R.id.tv_day, position == 0 ? "今天" : (position == 1 ? "明天" : "后天"));
    }
}
