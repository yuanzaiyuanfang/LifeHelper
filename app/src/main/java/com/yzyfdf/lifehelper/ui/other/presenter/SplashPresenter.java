package com.yzyfdf.lifehelper.ui.other.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.baserx.RxSubscriber;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.yzyfdf.lifehelper.ui.other.contract.SplashContract;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class SplashPresenter extends SplashContract.Presenter {

    private int delayTime = 3;
    public static Subscription mob;

    @Override
    public void smsTimer() {
        mRxManage.add(mob=Observable.interval(1, TimeUnit.SECONDS).take(delayTime)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return delayTime - aLong - 1;
                    }
                }).compose(RxSchedulers.<Long>io_main()).subscribe(new RxSubscriber<Long>(mContext, false) {

                    @Override
                    protected void _onNext(Long aLong) {
                        mView.returnSmsTimer(aLong);
                        LogUtils.logv(aLong+"");
                    }

                    @Override
                    protected void _onError(String message) {
                    }

                }));
    }
}
