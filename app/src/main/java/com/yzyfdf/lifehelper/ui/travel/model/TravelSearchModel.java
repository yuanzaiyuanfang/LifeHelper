package com.yzyfdf.lifehelper.ui.travel.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.travel.HotSearch;
import com.yzyfdf.lifehelper.ui.travel.contract.TravelSearchContract;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class TravelSearchModel implements TravelSearchContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<HotSearch> getKeyWords() {
        return Api.getInstance().getKeyWords(mContext)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<HotSearch> getSuggests(String keyWord) {
        return Api.getInstance().getSuggests(mContext,keyWord)
                .compose(RxSchedulers.io_main());
    }


}
