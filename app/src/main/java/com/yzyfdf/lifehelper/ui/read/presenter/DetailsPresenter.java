package com.yzyfdf.lifehelper.ui.read.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean;
import com.yzyfdf.lifehelper.ui.read.contract.DetailsContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class DetailsPresenter extends DetailsContract.Presenter {

    @Override
    public void queryZhiHuDetails(int id) {
        mRxManage.add(mModel.queryZhiHuDetails(id).subscribe(new RxSubscriber<ZhiHuDetailsBean>(mContext, true) {
            @Override
            protected void _onNext(ZhiHuDetailsBean zhiHuDetailsBean) {
                mView.returnZhiHuDetails(zhiHuDetailsBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void queryDouBanDetails(int id) {
        mRxManage.add(mModel.queryDouBanDetails(id).subscribe(new RxSubscriber<DouBanDetailsBean>(mContext, true) {
            @Override
            protected void _onNext(DouBanDetailsBean douBanDetailsBean) {
                mView.returnDouBanDetails(douBanDetailsBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void queryGuoKeDetails(int id) {
        mRxManage.add(mModel.queryGuoKeDetails(id).subscribe(new RxSubscriber<String>(mContext, true) {
            @Override
            protected void _onNext(String s) {
                mView.returnGuoKeDetails(s);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
