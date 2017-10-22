package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.ThemeDetailsBean;
import com.yzyfdf.lifehelper.ui.travel.contract.ThemeDetailsContract;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class ThemeDetailsPresenter extends ThemeDetailsContract.Presenter {


    @Override
    public void getThemeDetails(String url) {
        mRxManage.add(mModel.getThemeDetails(url).subscribe(new RxSubscriber<ThemeDetailsBean>(mContext,true) {
            @Override
            protected void _onNext(ThemeDetailsBean bean) {
                mView.returnThemeDetails(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }


}
