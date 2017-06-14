package com.yzyfdf.lifehelper.ui.read.model

import android.content.Context
import com.jaydenxiao.common.baserx.RxSchedulers
import com.yzyfdf.lifehelper.app.Api
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean
import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean
import com.yzyfdf.lifehelper.ui.read.contract.ReadDetailsContract
import rx.Observable

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 */
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

class ReadDetailsModel : ReadDetailsContract.Model {

    internal var mContext: Context? = null

    override fun setTag(context: Context) {
        mContext = context
    }

    override fun queryZhiHuDetails(id: Int): Observable<ZhiHuDetailsBean> {
        return Api.getInstance().queryZhiHuDetails(mContext, id)
                .compose(RxSchedulers.io_main<ZhiHuDetailsBean>())
    }

    override fun queryDouBanDetails(id: Int): Observable<DouBanDetailsBean> {
        return Api.getInstance().queryDouBanDetails(mContext, id)
                .compose(RxSchedulers.io_main<DouBanDetailsBean>())
    }

    override fun queryGuoKeDetails(id: Int): Observable<String> {
        return Api.getInstance().queryGuoKeDetails(mContext, id)
                .compose(RxSchedulers.io_main<String>())
    }
}


//package com.yzyfdf.lifehelper.ui.read.model;
//
//import android.content.Context;
//
//import com.jaydenxiao.common.baserx.RxSchedulers;
//import com.yzyfdf.lifehelper.app.Api;
//import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
//import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean;
//import ReadDetailsContract;
//
//import rx.Observable;
//
///**
// * Created by Conan on 2017/2/23.
// */
//
///****************
// * 使用例子
// ****************/
////  Api.getInstance().errorObservable("失败");
////  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());
//
//public class ReadDetailsModel implements ReadDetailsContract.Model {
//
//    Context mContext;
//
//    @Override
//    public void setTag(Context context) {
//        mContext = context;
//    }
//
//    @Override
//    public Observable<ZhiHuDetailsBean> queryZhiHuDetails(int id) {
//        return Api.getInstance().queryZhiHuDetails(mContext,id)
//                .compose(RxSchedulers.io_main());
//    }
//
//    @Override
//    public Observable<DouBanDetailsBean> queryDouBanDetails(int id) {
//        return Api.getInstance().queryDouBanDetails(mContext,id)
//                .compose(RxSchedulers.io_main());
//    }
//
//    @Override
//    public Observable<String> queryGuoKeDetails(int id) {
//        return Api.getInstance().queryGuoKeDetails(mContext,id)
//                .compose(RxSchedulers.io_main());
//    }
//}
