package com.yzyfdf.lifehelper.ui.cookbook.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.cookbean.CookListBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookListContract;

import java.util.List;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class CookListPresenter extends CookListContract.Presenter {

    @Override
    public void queryCookList(int id, int num) {
        mRxManage.add(mModel.queryCookList(id, num).subscribe(new RxSubscriber<List<CookListBean.ResultBean.RBean>>(mContext,false) {
            @Override
            protected void _onNext(List<CookListBean.ResultBean.RBean> list) {
                mView.returnCookList(list);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
