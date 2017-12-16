package com.yzyfdf.lifehelper.ui.cookbook.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.cookbean.CookRBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface CookRecipeContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void getDetail (int id);
    }

    interface Model extends BaseModel {
                Observable<CookRBean> getDetail(int id);

    }

    interface View extends BaseView {
                void returnDetail(CookRBean bean);
    }

}
