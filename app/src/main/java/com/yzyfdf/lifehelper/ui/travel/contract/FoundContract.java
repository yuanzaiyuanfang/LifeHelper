package com.yzyfdf.lifehelper.ui.travel.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundBean;

import rx.Observable;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public interface FoundContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getHots ();
    }

    interface Model extends BaseModel {
        Observable<TravelFoundBean.DataBean > getHots();

    }

    interface View extends BaseView {
        void returnHots(TravelFoundBean.DataBean bean);
    }

}
