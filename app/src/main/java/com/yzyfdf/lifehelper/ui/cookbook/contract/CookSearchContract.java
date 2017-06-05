package com.yzyfdf.lifehelper.ui.cookbook.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.cookbean.CookSearchBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface CookSearchContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void search (String keyWord,int num);
    }

    interface Model extends BaseModel {
                Observable<CookSearchBean.ResultBean> search (String keyWord, int num);

    }

    interface View extends BaseView {
                void returnSearch(CookSearchBean.ResultBean bean);
    }

}
