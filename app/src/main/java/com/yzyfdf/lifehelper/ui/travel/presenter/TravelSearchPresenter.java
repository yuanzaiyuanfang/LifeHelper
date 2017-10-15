package com.yzyfdf.lifehelper.ui.travel.presenter;

/**
 * Created by Conan on 2017/2/23.
 */

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.yzyfdf.lifehelper.bean.travel.HotSearch;
import com.yzyfdf.lifehelper.ui.travel.contract.TravelSearchContract;

import java.util.List;

/****************
 * 使用例子
 ****************/
//mRxManage.add(mModel.demoMethod(params...).subscribe(new RxSubscriber<Object>(mContext, true) {method...}));
public class TravelSearchPresenter extends TravelSearchContract.Presenter {


    @Override
    public void getKeyWords() {
        mRxManage.add(mModel.getKeyWords().subscribe(new RxSubscriber<HotSearch>(mContext, false) {
            @Override
            protected void _onNext(HotSearch bean) {
                List<String> keywords = bean.getKeywords();
                if (keywords != null || keywords.size() > 0) {
                    mView.returnKeyWords(bean);
                }
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void getSuggests(String keyWord) {
        mRxManage.add(mModel.getSuggests(keyWord).subscribe(new RxSubscriber<HotSearch>(mContext, false) {
            @Override
            protected void _onNext(HotSearch bean) {
                List<String> keywords = bean.getKeywords();
                if (keywords != null || keywords.size() > 0) {
                    mView.returnSuggests(bean);
                }
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
