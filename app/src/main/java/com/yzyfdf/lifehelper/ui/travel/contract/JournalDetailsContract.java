package com.yzyfdf.lifehelper.ui.travel.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.MyRouteRvData;
import com.yzyfdf.lifehelper.bean.travel.JournalDetailsBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface JournalDetailsContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getRouteDetails(String url);
        public abstract void getRecyclerViewData(JournalDetailsBean bean);
    }

    interface Model extends BaseModel {
        Observable<JournalDetailsBean> getRouteDetails(String url);
        Observable<MyRouteRvData> getRecyclerViewData(JournalDetailsBean bean);

    }

    interface View extends BaseView {
        void returnRouteDetails(JournalDetailsBean bean);
        void returnRecyclerViewData(MyRouteRvData bean);
    }

}
