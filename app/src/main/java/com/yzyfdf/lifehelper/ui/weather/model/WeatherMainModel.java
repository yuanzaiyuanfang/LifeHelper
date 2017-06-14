package com.yzyfdf.lifehelper.ui.weather.model;

import android.content.Context;

import com.google.gson.Gson;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.weather.AddressBean;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;
import com.yzyfdf.lifehelper.ui.weather.contract.WeatherMainContract;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class WeatherMainModel implements WeatherMainContract.Model {

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

    @Override
    public Observable<AddressBean> getAddress() {
        return Observable.create((Observable.OnSubscribe<AddressBean>) subscriber -> {
            AddressBean addressBean = new AddressBean();
            try {
                InputStreamReader inputReader = new InputStreamReader(mContext.getResources().getAssets().open("address.txt"));
                BufferedReader bufReader = new BufferedReader(inputReader);
                String line = "";
                String Result = "";
                while ((line = bufReader.readLine()) != null)
                    Result += line;

                addressBean = new Gson().fromJson(Result, AddressBean.class);

            } catch (Exception e) {
                e.printStackTrace();
            }

            subscriber.onNext(addressBean);
            subscriber.onCompleted();

        }).compose(RxSchedulers.io_main());
    }

}
