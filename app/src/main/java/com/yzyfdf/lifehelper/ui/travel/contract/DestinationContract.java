package com.yzyfdf.lifehelper.ui.travel.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.DestinationBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface DestinationContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getDestination(int id);
    }

    interface Model extends BaseModel {
        Observable<DestinationBean.DataBean> getDestination(int id);

    }

    interface View extends BaseView {
        void returnDestination(DestinationBean.DataBean bean);
    }

}
