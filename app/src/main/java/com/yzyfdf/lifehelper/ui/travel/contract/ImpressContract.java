package com.yzyfdf.lifehelper.ui.travel.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;

import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface ImpressContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void getImpress (String time);
    }

    interface Model extends BaseModel {
                Observable<List<TravelImpressBean.DataBean>> getImpress(String time);

    }

    interface View extends BaseView {
                void returnImpress(List<TravelImpressBean.DataBean> list);
    }

}
