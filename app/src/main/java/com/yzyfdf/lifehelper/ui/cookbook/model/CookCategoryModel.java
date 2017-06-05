package com.yzyfdf.lifehelper.ui.cookbook.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.cookbean.CookCategoryBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookCategoryContract;

import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class CookCategoryModel implements CookCategoryContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<List<CookCategoryBean.ResultBean.CsBeanXX>> qureyCatalogs() {
        return Api.getInstance().qureyCatalogs(mContext)
                .map(bean -> bean.getResult().getCs() )
                .compose(RxSchedulers.io_main());
    }
}
