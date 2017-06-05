package com.yzyfdf.lifehelper.ui.other.model;

import android.content.Context;

import com.yzyfdf.lifehelper.ui.other.contract.SplashContract;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class SplashModel implements SplashContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

}
