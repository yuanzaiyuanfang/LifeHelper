package com.yzyfdf.lifehelper.ui.other.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.yzyfdf.lifehelper.ui.other.contract.SettingContract;
import com.yzyfdf.lifehelper.util.GlideCacheUtil;
import com.yzyfdf.lifehelper.util.MyCallBack;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class SettingPresenter extends SettingContract.Presenter {

    @Override
    public void clearCache() {
        GlideCacheUtil.getInstance().clearImageDiskCache(mContext, new MyCallBack() {

            @Override
            public void success() {
                mView.returnClearCache(true);
            }

            @Override
            public void error() {
                mView.returnClearCache(true);
            }
        });
    }
}
