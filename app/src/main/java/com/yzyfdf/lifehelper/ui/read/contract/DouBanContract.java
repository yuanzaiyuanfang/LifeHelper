package com.yzyfdf.lifehelper.ui.read.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.read.DouBanListBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface DouBanContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void queryMoment (String date);
    }

    interface Model extends BaseModel {
                Observable<DouBanListBean> queryMoment(String date);

    }

    interface View extends BaseView {
                void returnMoment(DouBanListBean bean);
    }

}
