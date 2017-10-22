package com.yzyfdf.lifehelper.ui.travel.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.ThemeDetailsBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface ThemeDetailsContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getThemeDetails(String url);
    }

    interface Model extends BaseModel {
        Observable<ThemeDetailsBean> getThemeDetails(String url);

    }

    interface View extends BaseView {
        void returnThemeDetails(ThemeDetailsBean bean);
    }

}
