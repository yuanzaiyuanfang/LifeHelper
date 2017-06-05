package com.yzyfdf.lifehelper.ui.read.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.read.ZhiHuListBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface ZhiHuContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void queryNews (String url);
    }

    interface Model extends BaseModel {
                Observable<ZhiHuListBean> queryNews (String url);

    }

    interface View extends BaseView {
                void returnNews(ZhiHuListBean bean);
    }

}
