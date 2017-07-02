package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.TravelRoutesBean;
import com.yzyfdf.lifehelper.ui.travel.contract.RoutesContract;

import java.util.List;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class RoutesPresenter extends RoutesContract.Presenter {

    @Override
    public void getRoutes(int num) {
        mRxManage.add(mModel.getRoutes(num).subscribe(new RxSubscriber<List<TravelRoutesBean.ItemsBean>>(mContext,false) {
            @Override
            protected void _onNext(List<TravelRoutesBean.ItemsBean> list) {
                mView.returnRoutes(list);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
