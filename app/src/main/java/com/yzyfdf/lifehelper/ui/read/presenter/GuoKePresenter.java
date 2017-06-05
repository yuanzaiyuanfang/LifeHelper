package com.yzyfdf.lifehelper.ui.read.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.read.GuoKeListBean;
import com.yzyfdf.lifehelper.ui.read.contract.GuoKeContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class GuoKePresenter extends GuoKeContract.Presenter {


    @Override
    public void queryArticle(int num) {
        mRxManage.add(mModel.queryArticle(num).subscribe(new RxSubscriber<GuoKeListBean>(mContext, false) {
            @Override
            protected void _onNext(GuoKeListBean guoKeListBean) {
                mView.returnArticle(guoKeListBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
