package com.yzyfdf.lifehelper.ui.cookbook.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.cookbean.CookCategoryBean;

import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface CookCategoryContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void qureyCatalogs  ();
    }

    interface Model extends BaseModel {
                Observable<List<CookCategoryBean.ResultBean.CsBeanXX>> qureyCatalogs();

    }

    interface View extends BaseView {
                void returnQureyCatalogs(List<CookCategoryBean.ResultBean.CsBeanXX> list);
    }

}
