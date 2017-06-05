package com.yzyfdf.lifehelper.base.model;

import android.content.Context;

import com.yzyfdf.lifehelper.base.contract.DemoContract;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class DemoModel implements DemoContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

}
