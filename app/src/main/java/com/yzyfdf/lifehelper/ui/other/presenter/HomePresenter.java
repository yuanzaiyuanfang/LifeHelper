package com.yzyfdf.lifehelper.ui.other.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;
import com.yzyfdf.lifehelper.ui.other.contract.HomeContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class HomePresenter extends HomeContract.Presenter {

    @Override
    public void queryWeather(String city) {
        mRxManage.add(mModel.queryWeather(city).subscribe(new RxSubscriber<WeatherBean.HeWeather5Bean>(mContext,false) {
            @Override
            protected void _onNext(WeatherBean.HeWeather5Bean bean) {
                mView.returnWeather(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
