package com.yzyfdf.lifehelper.ui.other.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;
import com.yzyfdf.lifehelper.ui.other.contract.HomeContract;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class HomeModel implements HomeContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<WeatherBean.HeWeather5Bean> queryWeather(String city) {
        return Api.getInstance().queryWeather(mContext,city)
                .map(weatherBean -> weatherBean.getHeWeather5().get(0))
                .compose(RxSchedulers.io_main());
    }
}
