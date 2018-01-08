package com.yzyfdf.lifehelper.ui.live.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.live.LiveHomeDynamicBean;
import com.yzyfdf.lifehelper.ui.live.contract.LiveMainContract;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class LiveMainModel implements LiveMainContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<LiveHomeDynamicBean.DataBean> getHomeDynamic(String start_id, int type) {
        return Api.getInstance().getHomeDynamic(mContext, start_id, type)
                .map(LiveHomeDynamicBean::getData)
                .compose(RxSchedulers.io_main());
    }
}
