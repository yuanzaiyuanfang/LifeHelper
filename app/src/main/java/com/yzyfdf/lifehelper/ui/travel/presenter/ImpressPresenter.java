package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;
import com.yzyfdf.lifehelper.ui.travel.contract.ImpressContract;

import java.util.List;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class ImpressPresenter extends ImpressContract.Presenter {


    @Override
    public void getImpress(String time) {
        mRxManage.add(mModel.getImpress(time).subscribe(new RxSubscriber<List<TravelImpressBean.DataBean>>(mContext, false) {
            @Override
            protected void _onNext(List<TravelImpressBean.DataBean> dataBeen) {
                mView.returnImpress(dataBeen);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
