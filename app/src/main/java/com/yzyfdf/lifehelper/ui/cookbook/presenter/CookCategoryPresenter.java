package com.yzyfdf.lifehelper.ui.cookbook.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.cookbean.CookCategoryBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookCategoryContract;

import java.util.List;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class CookCategoryPresenter extends CookCategoryContract.Presenter {

    @Override
    public void qureyCatalogs() {
        mRxManage.add(mModel.qureyCatalogs().subscribe(new RxSubscriber<List<CookCategoryBean.ResultBean.CsBeanXX>>(mContext, true) {
            @Override
            protected void _onNext(List<CookCategoryBean.ResultBean.CsBeanXX> list) {
                mView.returnQureyCatalogs(list);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
