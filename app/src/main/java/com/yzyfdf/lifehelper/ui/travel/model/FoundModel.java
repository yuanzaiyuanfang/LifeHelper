package com.yzyfdf.lifehelper.ui.travel.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundBean;
import com.yzyfdf.lifehelper.ui.travel.contract.FoundContract;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class FoundModel implements FoundContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<TravelFoundBean.DataBean > getHots() {
        return Api.getInstance().getHots(mContext)
                .map(TravelFoundBean::getData)
                .compose(RxSchedulers.io_main());
    }
}
