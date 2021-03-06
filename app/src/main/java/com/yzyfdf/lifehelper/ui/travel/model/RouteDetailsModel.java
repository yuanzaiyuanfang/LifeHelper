package com.yzyfdf.lifehelper.ui.travel.model;

import android.content.Context;
import android.text.TextUtils;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.travel.JournalDetailsBean;
import com.yzyfdf.lifehelper.bean.travel.MyItineraryBean;
import com.yzyfdf.lifehelper.bean.travel.MyRouteRvData;
import com.yzyfdf.lifehelper.bean.travel.RouteDetailsBean;
import com.yzyfdf.lifehelper.ui.travel.contract.RouteDetailsContract;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class RouteDetailsModel implements RouteDetailsContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }


    @Override
    public Observable<RouteDetailsBean> getRouteDetails(String url) {
        return Api.getInstance().getRouteDetails(mContext, url)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<MyRouteRvData> getRecyclerViewData(RouteDetailsBean bean) {
        return Observable.create((Observable.OnSubscribe<MyRouteRvData>) subscriber -> {

            ArrayList<MyItineraryBean> list = new ArrayList<>();
            ArrayList<String> menuList = new ArrayList<>();

//            Date departure_date = TimeUtil.getDateByFormat(bean.getDeparture_date(), dateFormatYMD2);

            List<List<JournalDetailsBean.ItineraryBean.LocationsBean>> routeList = bean.getRoute();
            if (routeList==null||routeList.size()==0)return;
            for (int i = 0; i < routeList.size(); i++) {
                //每一天
                List<JournalDetailsBean.ItineraryBean.LocationsBean> locationsList = routeList.get(i);
                //每天简介
                String day = "DAY" + (i + 1);
                list.add(new MyItineraryBean(new MyItineraryBean.MyItineraryTitle(day, "", "", locationsList.get(0).getCity(), bean.getDaily_highlights().get(i)), null));
                menuList.add(day + "，" + locationsList.get(0).getCity());
                for (JournalDetailsBean.ItineraryBean.LocationsBean location : locationsList) {
                    //每个地点
                    list.add(new MyItineraryBean(null, location));
                    menuList.add(!TextUtils.isEmpty(location.getName()) ? location.getName() : (!TextUtils.isEmpty(location.getName_en()) ? location.getName_en() : "未知"));

                }
            }
            //结束
            list.add(new MyItineraryBean(null, null));
            menuList.add("THE END");

//            List<JournalDetailsBean.ItineraryBean> itineraryList = bean.getItinerary();
//            if (itineraryList != null && itineraryList.size() > 0) {
//                for (int i = 0; i < itineraryList.size(); i++) {
//                    //每一天
//                    List<JournalDetailsBean.ItineraryBean.LocationsBean> locations = itineraryList.get(i).getLocations();
//                    if (locations != null & locations.size() > 0) {
//                        String day = "DAY" + (i + 1);
////                        String time = TimeUtil.getStringByOffset(departure_date, "yyyy.MM.dd", Calendar.DATE, i);
////                        String week = TimeUtil.getWeekNumber(time, "yyyy.MM.dd");
//                        //每天简介
//                        list.add(new MyItineraryBean(new MyItineraryBean.MyItineraryTitle(day, "", "", itineraryList.get(i).getCity(), itineraryList.get(i).getDesc()), null));
//                        menuList.add(day + "，" + itineraryList.get(i).getCity());
//                        for (JournalDetailsBean.ItineraryBean.LocationsBean location : locations) {
//                            //每个地点
//                            list.add(new MyItineraryBean(null, location));
//                            menuList.add(!TextUtils.isEmpty(location.getName()) ? location.getName() : (!TextUtils.isEmpty(location.getName_en()) ? location.getName_en() : "未知"));
//                        }
//                    }
//                    if (i > 30) {
//                        break;
//                    }
//                }
//                //结束
//                list.add(new MyItineraryBean(null, null));
//                menuList.add("THE END");
//
//            }
            MyRouteRvData data = new MyRouteRvData(list, menuList);

            subscriber.onNext(data);
            subscriber.onCompleted();

        }).compose(RxSchedulers.io_main());
    }
}
