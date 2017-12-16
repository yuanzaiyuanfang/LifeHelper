package com.yzyfdf.lifehelper.ui.cookbook.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.cookbean.CookRBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookRecipeContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class CookRecipePresenter extends CookRecipeContract.Presenter {

    @Override
    public void getDetail( int id) {
        mRxManage.add(mModel.getDetail(id).subscribe(new RxSubscriber<CookRBean>(mContext, false) {
            @Override
            protected void _onNext(CookRBean bean) {
                mView.returnDetail(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
