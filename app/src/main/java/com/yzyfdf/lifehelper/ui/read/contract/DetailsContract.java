package com.yzyfdf.lifehelper.ui.read.contract;


import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */
public interface DetailsContract {

    abstract class Presenter extends BasePresenter<View, Model> {
                public abstract void queryZhiHuDetails (int id);
                public abstract void queryDouBanDetails (int id);
                public abstract void queryGuoKeDetails (int id);
    }

    interface Model extends BaseModel {
                Observable<ZhiHuDetailsBean> queryZhiHuDetails (int id);
                Observable<DouBanDetailsBean> queryDouBanDetails (int id);
                Observable<String> queryGuoKeDetails (int id);

    }

    interface View extends BaseView {
                void returnZhiHuDetails(ZhiHuDetailsBean bean);
                void returnDouBanDetails(DouBanDetailsBean bean);
                void returnGuoKeDetails(String content);
    }

}
