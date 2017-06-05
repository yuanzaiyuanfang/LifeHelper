package com.yzyfdf.lifehelper.ui.read.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.read.GuoKeListBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface GuoKeContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void queryArticle (int num);
    }

    interface Model extends BaseModel {
                Observable<GuoKeListBean> queryArticle(int num);

    }

    interface View extends BaseView {
                void returnArticle(GuoKeListBean bean);
    }

}
