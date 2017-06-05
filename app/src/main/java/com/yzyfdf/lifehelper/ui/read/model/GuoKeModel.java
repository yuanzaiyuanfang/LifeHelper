package com.yzyfdf.lifehelper.ui.read.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.read.GuoKeListBean;
import com.yzyfdf.lifehelper.ui.read.contract.GuoKeContract;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class GuoKeModel implements GuoKeContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<GuoKeListBean> queryArticle(int num) {
        return Api.getInstance().queryArticle(mContext,num)
                .compose(RxSchedulers.io_main());
    }
}
