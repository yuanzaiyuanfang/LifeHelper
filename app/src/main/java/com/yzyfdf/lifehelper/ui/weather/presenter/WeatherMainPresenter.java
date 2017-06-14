package com.yzyfdf.lifehelper.ui.weather.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.weather.AddressBean;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;
import com.yzyfdf.lifehelper.ui.weather.contract.WeatherMainContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class WeatherMainPresenter extends WeatherMainContract.Presenter {

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

    @Override
    public void getAddress() {
        mRxManage.add(mModel.getAddress().subscribe(new RxSubscriber<AddressBean>(mContext,false) {
            @Override
            protected void _onNext(AddressBean addressBean) {
                mView.returnAddress(addressBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
