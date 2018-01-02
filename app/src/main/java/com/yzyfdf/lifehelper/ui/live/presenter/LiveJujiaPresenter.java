package com.yzyfdf.lifehelper.ui.live.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.live.LiveChannelDataBean;
import com.yzyfdf.lifehelper.ui.live.contract.LiveJujiaContract;

import java.util.List;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class LiveJujiaPresenter extends LiveJujiaContract.Presenter {


    @Override
    public void getChannel(int channel_type) {
        mRxManage.add(mModel.getChannel(channel_type).subscribe(new RxSubscriber<List<String>>(mContext, false) {
            @Override
            protected void _onNext(List<String> list) {
                mView.returnChannel(list);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void getChannelData(String keyword, int page, int search_type) {
        mRxManage.add(mModel.getChannelData(keyword, page, search_type).subscribe(new RxSubscriber<LiveChannelDataBean.DataBean>(mContext, true) {
            @Override
            protected void _onNext(LiveChannelDataBean.DataBean bean) {
                mView.returnChannelData(bean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
