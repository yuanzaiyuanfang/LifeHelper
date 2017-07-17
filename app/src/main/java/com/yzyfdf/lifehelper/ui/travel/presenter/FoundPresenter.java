package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundBean;
import com.yzyfdf.lifehelper.ui.travel.contract.FoundContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class FoundPresenter extends FoundContract.Presenter {


    @Override
    public void getHots() {
        mRxManage.add(mModel.getHots().subscribe(new RxSubscriber<TravelFoundBean.DataBean>(mContext, false) {
            @Override
            protected void _onNext(TravelFoundBean.DataBean bean) {
                mView.returnHots(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
