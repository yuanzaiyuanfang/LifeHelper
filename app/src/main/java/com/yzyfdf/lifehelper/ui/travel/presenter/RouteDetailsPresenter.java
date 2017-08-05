package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.RouteDetailsBean;
import com.yzyfdf.lifehelper.ui.travel.contract.RouteDetailsContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class RouteDetailsPresenter extends RouteDetailsContract.Presenter {


    @Override
    public void getRouteDetails(String url) {
        mRxManage.add(mModel.getRouteDetails(url).subscribe(new RxSubscriber<RouteDetailsBean>(mContext,true) {
            @Override
            protected void _onNext(RouteDetailsBean bean) {
                mView.returnRouteDetails(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
