package com.yzyfdf.lifehelper.ui.travel.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundAbroadBean;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundDomesticBean;
import com.yzyfdf.lifehelper.ui.travel.contract.FoundAbroadContract;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class FoundAbroadModel implements FoundAbroadContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<TravelFoundAbroadBean.DataBean> getAbroad() {
        return Api.getInstance().getGuidesAbroad(mContext)
                .map(TravelFoundAbroadBean::getData)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<TravelFoundDomesticBean.DataBean> getDomestic() {
        return Api.getInstance().getGuidesDomestic(mContext)
                .map(TravelFoundDomesticBean::getData)
                .compose(RxSchedulers.io_main());
    }
}
