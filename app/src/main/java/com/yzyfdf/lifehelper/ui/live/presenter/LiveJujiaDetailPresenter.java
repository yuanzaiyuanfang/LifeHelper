package com.yzyfdf.lifehelper.ui.live.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.live.LiveJujiaDetailBean;
import com.yzyfdf.lifehelper.ui.live.contract.LiveJujiaDetailContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class LiveJujiaDetailPresenter extends LiveJujiaDetailContract.Presenter {

    @Override
    public void getJujiaDetail(String id) {
        mRxManage.add(mModel.getJujiaDetail(id).subscribe(new RxSubscriber<LiveJujiaDetailBean.DataBean>(mContext, true) {
            @Override
            protected void _onNext(LiveJujiaDetailBean.DataBean bean) {
                mView.returnJujiaDetail(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
