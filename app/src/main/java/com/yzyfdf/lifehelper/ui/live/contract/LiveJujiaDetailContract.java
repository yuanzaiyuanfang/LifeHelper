package com.yzyfdf.lifehelper.ui.live.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.live.LiveJujiaDetailBean;

import rx.Observable;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public interface LiveJujiaDetailContract {
    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getJujiaDetail(String id);

    }

    interface Model extends BaseModel {
        Observable<LiveJujiaDetailBean.DataBean> getJujiaDetail(String id);
    }

    interface View extends BaseView {
        void returnJujiaDetail(LiveJujiaDetailBean.DataBean bean);

    }
}
