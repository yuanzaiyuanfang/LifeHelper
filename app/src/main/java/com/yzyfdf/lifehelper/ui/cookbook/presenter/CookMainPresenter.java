package com.yzyfdf.lifehelper.ui.cookbook.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookMainContract;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class CookMainPresenter extends CookMainContract.Presenter {

    public Subscription mob;

    @Override
    public void queryCookHome(int num) {
        mRxManage.add(mModel.queryCookHome(num).subscribe(new RxSubscriber<List<CookMainBean.ResultBean.ListBean>>(mContext, false) {
            @Override
            protected void _onNext(List<CookMainBean.ResultBean.ListBean> list) {
                ArrayList<CookMainBean.ResultBean.ListBean> mList     = new ArrayList<>();
                ArrayList<CookMainBean.ResultBean.ListBean> mHeadList = new ArrayList<>();
                for (CookMainBean.ResultBean.ListBean bean : list) {
                    if (bean.getType().equals("3")) {
                        mHeadList.add(bean);
                    }
                    if (bean.getType().equals("2")) {
                        mList.add(bean);
                    }
                }
                mView.returnCookHomeHead(mHeadList);
                mView.returnCookHome(mList);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void smsTimer() {
        mRxManage.add(mob = Observable.interval(1, TimeUnit.SECONDS).take(5)
                .map(aLong -> 5 - aLong - 1).compose(RxSchedulers.io_main()).subscribe(new RxSubscriber<Long>(mContext, false) {

                    @Override
                    protected void _onNext(Long aLong) {
                        if (aLong == 0) {
                            mView.returnSmsTimer(aLong);
                        }
                    }

                    @Override
                    protected void _onError(String message) {
                    }

                }));
    }
}
