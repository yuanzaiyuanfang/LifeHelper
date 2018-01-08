package com.yzyfdf.lifehelper.ui.live.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.live.LiveHomeDynamicBean;
import com.yzyfdf.lifehelper.ui.live.contract.LiveMainContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class LiveMainPresenter extends LiveMainContract.Presenter {


    @Override
    public void getHomeDynamic(String start_id, int type) {
        mRxManage.add(mModel.getHomeDynamic(start_id, type).subscribe(new RxSubscriber<LiveHomeDynamicBean.DataBean>(mContext, true) {
            @Override
            protected void _onNext(LiveHomeDynamicBean.DataBean bean) {
                mView.returnHomeDynamic(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
