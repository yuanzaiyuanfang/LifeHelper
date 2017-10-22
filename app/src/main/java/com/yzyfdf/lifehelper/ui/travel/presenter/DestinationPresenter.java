package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.DestinationBean;
import com.yzyfdf.lifehelper.ui.travel.contract.DestinationContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class DestinationPresenter extends DestinationContract.Presenter {

    @Override
    public void getDestination(int id) {
        mRxManage.add(mModel.getDestination(id).subscribe(new RxSubscriber<DestinationBean.DataBean>(mContext, true) {

            @Override
            protected void _onNext(DestinationBean.DataBean bean) {
                mView.returnDestination(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));

    }
}
