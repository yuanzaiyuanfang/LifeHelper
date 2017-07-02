package com.yzyfdf.lifehelper.ui.travel.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.TravelRoutesBean;

import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface RoutesContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void getRoutes (int num);
    }

    interface Model extends BaseModel {
                Observable<List<TravelRoutesBean.ItemsBean>> getRoutes (int num);

    }

    interface View extends BaseView {
                void returnRoutes(List<TravelRoutesBean.ItemsBean> list);
    }

}
