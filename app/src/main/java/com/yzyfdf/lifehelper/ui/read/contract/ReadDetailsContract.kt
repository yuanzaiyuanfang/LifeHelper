package com.yzyfdf.lifehelper.ui.read.contract


import com.jaydenxiao.common.base.BaseModel
import com.jaydenxiao.common.base.BasePresenter
import com.jaydenxiao.common.base.BaseView
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean
import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean

import rx.Observable

/**
 * Created by Conan on 2017/2/23.
 */
interface ReadDetailsContract {

    abstract class Presenter : BasePresenter<View, Model>() {
        abstract fun queryZhiHuDetails(id: Int)
        abstract fun queryDouBanDetails(id: Int)
        abstract fun queryGuoKeDetails(id: Int)
    }

    interface Model : BaseModel {
        fun queryZhiHuDetails(id: Int): Observable<ZhiHuDetailsBean>
        fun queryDouBanDetails(id: Int): Observable<DouBanDetailsBean>
        fun queryGuoKeDetails(id: Int): Observable<String>

    }

    interface View : BaseView {
        fun returnZhiHuDetails(bean: ZhiHuDetailsBean)
        fun returnDouBanDetails(bean: DouBanDetailsBean)
        fun returnGuoKeDetails(content: String)
    }

}


//package com.yzyfdf.lifehelper.ui.read.contract;
//
//
//import com.jaydenxiao.common.base.BaseModel;
//import com.jaydenxiao.common.base.BasePresenter;
//import com.jaydenxiao.common.base.BaseView;
//import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
//import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean;
//
//import rx.Observable;
//
///**
// * Created by Conan on 2017/2/23.
// */
//public interface ReadDetailsContract {
//
//    abstract class Presenter extends BasePresenter<View, Model> {
//                public abstract void queryZhiHuDetails (int id);
//                public abstract void queryDouBanDetails (int id);
//                public abstract void queryGuoKeDetails (int id);
//    }
//
//    interface Model extends BaseModel {
//                Observable<ZhiHuDetailsBean> queryZhiHuDetails (int id);
//                Observable<DouBanDetailsBean> queryDouBanDetails (int id);
//                Observable<String> queryGuoKeDetails (int id);
//
//    }
//
//    interface View extends BaseView {
//                void returnZhiHuDetails(ZhiHuDetailsBean bean);
//                void returnDouBanDetails(DouBanDetailsBean bean);
//                void returnGuoKeDetails(String content);
//    }
//
//}
