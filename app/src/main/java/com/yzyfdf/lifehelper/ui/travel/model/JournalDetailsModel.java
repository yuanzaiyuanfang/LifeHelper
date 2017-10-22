package com.yzyfdf.lifehelper.ui.travel.model;

import android.content.Context;
import android.text.TextUtils;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.commonutils.TimeUtil;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.travel.MyItineraryBean;
import com.yzyfdf.lifehelper.bean.travel.MyRouteRvData;
import com.yzyfdf.lifehelper.bean.travel.JournalDetailsBean;
import com.yzyfdf.lifehelper.ui.travel.contract.JournalDetailsContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rx.Observable;

import static com.jaydenxiao.common.commonutils.TimeUtil.dateFormatYMD2;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class JournalDetailsModel implements JournalDetailsContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }


    @Override
    public Observable<JournalDetailsBean> getRouteDetails(String url) {
        return Api.getInstance().getJournalDetails(mContext, url)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<MyRouteRvData> getRecyclerViewData(JournalDetailsBean bean) {
        return Observable.create((Observable.OnSubscribe<MyRouteRvData>) subscriber -> {

            ArrayList<MyItineraryBean> list = new ArrayList<>();
            ArrayList<String> menuList = new ArrayList<>();

            Date departure_date = TimeUtil.getDateByFormat(bean.getDeparture_date(), dateFormatYMD2);

            List<JournalDetailsBean.ItineraryBean> itineraryList = bean.getItinerary();
            if (itineraryList != null && itineraryList.size() > 0) {
                for (int i = 0; i < itineraryList.size(); i++) {
                    //每一天
                    String day = "DAY" + (i + 1);
                    String time = TimeUtil.getStringByOffset(departure_date, "yyyy.MM.dd", Calendar.DATE, i) + ",";
                    String week = TimeUtil.getWeekNumber(time, "yyyy.MM.dd") + ",";
                    //每天简介
                    list.add(new MyItineraryBean(new MyItineraryBean.MyItineraryTitle(day, time, week, itineraryList.get(i).getCity(), itineraryList.get(i).getDesc()), null));
                    menuList.add(day + "，" + itineraryList.get(i).getCity());
                    List<JournalDetailsBean.ItineraryBean.LocationsBean> locations = itineraryList.get(i).getLocations();
                    if (locations != null & locations.size() > 0) {
                        for (JournalDetailsBean.ItineraryBean.LocationsBean location : locations) {
                            //每个地点
                            list.add(new MyItineraryBean(null, location));
                            menuList.add(!TextUtils.isEmpty(location.getName()) ? location.getName() : (!TextUtils.isEmpty(location.getName_en()) ? location.getName_en() : "未知"));
                        }
                    }
                    if (i > 30) {
                        break;
                    }
                }
                //结束
                list.add(new MyItineraryBean(null, null));
                menuList.add("THE END");

            }
            MyRouteRvData data = new MyRouteRvData(list, menuList);

            subscriber.onNext(data);
            subscriber.onCompleted();

        }).compose(RxSchedulers.io_main());
    }
}
