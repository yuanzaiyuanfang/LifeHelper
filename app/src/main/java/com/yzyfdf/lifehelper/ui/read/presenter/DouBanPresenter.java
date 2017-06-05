package com.yzyfdf.lifehelper.ui.read.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.read.DouBanListBean;
import com.yzyfdf.lifehelper.ui.read.contract.DouBanContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class DouBanPresenter extends DouBanContract.Presenter {


    @Override
    public void queryMoment(String date) {
        mRxManage.add(mModel.queryMoment(date).subscribe(new RxSubscriber<DouBanListBean>(mContext, false) {
            @Override
            protected void _onNext(DouBanListBean douBanListBean) {
                mView.returnMoment(douBanListBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
