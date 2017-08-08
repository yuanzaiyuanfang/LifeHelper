package com.yzyfdf.lifehelper.ui.travel.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.MyRouteRvData;
import com.yzyfdf.lifehelper.bean.travel.RouteDetailsBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface RouteDetailsContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getRouteDetails(String url);
        public abstract void getRecyclerViewData(RouteDetailsBean bean);
    }

    interface Model extends BaseModel {
        Observable<RouteDetailsBean> getRouteDetails(String url);
        Observable<MyRouteRvData> getRecyclerViewData(RouteDetailsBean bean);

    }

    interface View extends BaseView {
        void returnRouteDetails(RouteDetailsBean bean);
        void returnRecyclerViewData(MyRouteRvData bean);
    }

}
