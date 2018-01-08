package com.yzyfdf.lifehelper.ui.live.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.live.LiveHomeDynamicBean;

import rx.Observable;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public interface LiveMainContract {
    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getHomeDynamic(String start_id, int type);

    }

    interface Model extends BaseModel {
        Observable<LiveHomeDynamicBean.DataBean> getHomeDynamic(String start_id, int type);
    }

    interface View extends BaseView {
        void returnHomeDynamic(LiveHomeDynamicBean.DataBean bean);
    }
}
