package com.yzyfdf.lifehelper.ui.read.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.read.ZhiHuListBean;
import com.yzyfdf.lifehelper.ui.read.contract.ZhiHuContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class ZhiHuPresenter extends ZhiHuContract.Presenter {

    @Override
    public void queryNews(String url) {
        mRxManage.add(mModel.queryNews(url).subscribe(new RxSubscriber<ZhiHuListBean>(mContext, false) {
            @Override
            protected void _onNext(ZhiHuListBean bean) {
                mView.returnNews(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
