package com.yzyfdf.lifehelper.ui.cookbook.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface CookMainContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void queryCookHome(int num);
        public abstract void smsTimer();
    }

    interface Model extends BaseModel {
        Observable<List<CookMainBean.ResultBean.ListBean>> queryCookHome(int num);
    }

    interface View extends BaseView {
        void returnCookHome(List<CookMainBean.ResultBean.ListBean> list);
        void returnCookHomeHead(ArrayList<CookMainBean.ResultBean.ListBean> headList);
        void returnSmsTimer(Long second);
    }

}
