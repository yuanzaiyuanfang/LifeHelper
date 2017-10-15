package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundAbroadBean;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundDomesticBean;
import com.yzyfdf.lifehelper.ui.travel.contract.FoundAbroadContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class FoundAbroadPresenter extends FoundAbroadContract.Presenter {


    @Override
    public void getAbroad() {
        mRxManage.add(mModel.getAbroad().subscribe(new RxSubscriber<TravelFoundAbroadBean.DataBean>(mContext, false) {
            @Override
            protected void _onNext(TravelFoundAbroadBean.DataBean bean) {
                mView.returnAbroad(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void getDomestic() {
        mRxManage.add(mModel.getDomestic().subscribe(new RxSubscriber<TravelFoundDomesticBean.DataBean>(mContext, false) {
            @Override
            protected void _onNext(TravelFoundDomesticBean.DataBean bean) {
                mView.returnDomestic(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
