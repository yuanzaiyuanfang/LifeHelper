package com.yzyfdf.lifehelper.ui.live.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.live.LiveChannelDataBean;
import com.yzyfdf.lifehelper.ui.live.contract.LiveJujiaContract;

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

public class LiveJujiaModel implements LiveJujiaContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<List<String>> getChannel(int channel_type) {
        return Api.getInstance().getChannel(mContext, channel_type)
                .map(liveChannelBean -> liveChannelBean.getData().getRows())
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<LiveChannelDataBean.DataBean> getChannelData(String keyword, int page, int search_type) {
        return Api.getInstance().getChannelData(mContext, keyword, page, search_type)
                .map(LiveChannelDataBean::getData)
                .compose(RxSchedulers.io_main());
    }
}
