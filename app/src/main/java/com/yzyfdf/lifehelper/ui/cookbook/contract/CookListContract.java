package com.yzyfdf.lifehelper.ui.cookbook.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.cookbean.CookListBean;

import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface CookListContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void queryCookList (int id,int num);
    }

    interface Model extends BaseModel {
                Observable<List<CookListBean.ResultBean.RBean>> queryCookList (int id,int num);

    }

    interface View extends BaseView {
                void returnCookList(List<CookListBean.ResultBean.RBean> list);
    }

}
