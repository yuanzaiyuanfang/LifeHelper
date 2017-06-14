package com.yzyfdf.lifehelper.ui.weather.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.weather.AddressBean;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface WeatherMainContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void queryWeather (String city);
        public abstract void getAddress();
    }

    interface Model extends BaseModel {
        Observable<WeatherBean.HeWeather5Bean> queryWeather (String city);
        Observable<AddressBean> getAddress ();

    }

    interface View extends BaseView {
        void returnWeather(WeatherBean.HeWeather5Bean bean);
        void returnAddress(AddressBean bean);
    }

}
