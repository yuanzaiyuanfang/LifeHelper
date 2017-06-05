package com.yzyfdf.lifehelper.ui.cookbook.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.cookbean.CookSearchBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookSearchContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class CookSearchPresenter extends CookSearchContract.Presenter {

    @Override
    public void search(String keyWord, int num) {
        mRxManage.add(mModel.search(keyWord, num).subscribe(new RxSubscriber<CookSearchBean.ResultBean>(mContext, false) {
            @Override
            protected void _onNext(CookSearchBean.ResultBean bean) {
                mView.returnSearch(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
