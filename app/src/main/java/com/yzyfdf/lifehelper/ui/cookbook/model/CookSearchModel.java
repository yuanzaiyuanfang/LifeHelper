package com.yzyfdf.lifehelper.ui.cookbook.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.cookbean.CookSearchBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookSearchContract;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class CookSearchModel implements CookSearchContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<CookSearchBean.ResultBean> search(String keyWord, int num) {
        return Api.getInstance().search(mContext,keyWord,num)
                .map(CookSearchBean::getResult)
                .compose(RxSchedulers.io_main());
    }
}
