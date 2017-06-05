package com.yzyfdf.lifehelper.ui.cookbook.model;

import android.content.Context;

import com.jaydenxiao.common.baserx.RxSchedulers;
import com.yzyfdf.lifehelper.app.Api;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookMainContract;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Conan on 2017/2/23.
 */

/****************
 * 使用例子
 ****************/
//  Api.getInstance().errorObservable("失败");
//  Api.getInstance().demoMethod(mContext, params...).flatMap(Func...).map(Func...).compose(RxSchedulers.<Object>io_main());

public class CookMainModel implements CookMainContract.Model {

    Context mContext;

    @Override
    public void setTag(Context context) {
        mContext = context;
    }

    @Override
    public Observable<List<CookMainBean.ResultBean.ListBean>> queryCookHome(int num) {
        return Api.getInstance().queryCookHome(mContext, num)
                .map(cookMainBean -> {
                    List<CookMainBean.ResultBean.ListBean> list = cookMainBean.getResult().getList();
                    List<CookMainBean.ResultBean.ListBean> newList = new ArrayList<>();
                    for (CookMainBean.ResultBean.ListBean listBean : list) {
                        if (listBean.getType().equals("2") || listBean.getType().equals("3")) {
                            newList.add(listBean);//2,3类型才是食谱相关
                        }
                    }
                    return newList;
                })
                .compose(RxSchedulers.io_main());
    }

    //    @Override
    //    public Observable<List<CookMainBean.ResultBean.ListBean>> queryCookHome(int num) {
    //        return Api.getInstance().queryCookHome(mContext,num)
    //                .map(new Func1<CookMainBean, List<CookMainBean.ResultBean.ListBean> >() {
    //                    @Override
    //                    public List<CookMainBean.ResultBean.ListBean>  call(CookMainBean cookMainBean) {
    //                        List<CookMainBean.ResultBean.ListBean> list = cookMainBean.getResult().getList();
    //                        List<CookMainBean.ResultBean.ListBean> newList = new ArrayList<>();
    //                        for (CookMainBean.ResultBean.ListBean listBean : list) {
    //                            if (listBean.getType().equals("2") || listBean.getType().equals("3")) {
    //                                newList.add(listBean);//2,3类型才是食谱相关
    //                            }
    //                        }
    //                        return newList;
    //                    }
    //                })
    //                .compose(RxSchedulers.<List<CookMainBean.ResultBean.ListBean> >io_main());
    //    }
}
