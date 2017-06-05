package com.yzyfdf.lifehelper.ui.other.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

/**
 * Created by Conan on 2017/2/23.
 */
public interface SplashContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void smsTimer();
    }

    interface Model extends BaseModel {
        //        Observable<String> demoMethod(Object params...);

    }

    interface View extends BaseView {
        void returnSmsTimer(Long second);
    }

}
