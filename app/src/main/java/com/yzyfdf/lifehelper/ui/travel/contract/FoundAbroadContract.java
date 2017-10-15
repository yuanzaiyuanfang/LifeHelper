package com.yzyfdf.lifehelper.ui.travel.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundAbroadBean;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundDomesticBean;

import rx.Observable;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public interface FoundAbroadContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAbroad();
        public abstract void getDomestic();
    }

    interface Model extends BaseModel {
        Observable<TravelFoundAbroadBean.DataBean> getAbroad();
        Observable<TravelFoundDomesticBean.DataBean> getDomestic();

    }

    interface View extends BaseView {
        void returnAbroad(TravelFoundAbroadBean.DataBean bean);
        void returnDomestic(TravelFoundDomesticBean.DataBean bean);
    }

}
