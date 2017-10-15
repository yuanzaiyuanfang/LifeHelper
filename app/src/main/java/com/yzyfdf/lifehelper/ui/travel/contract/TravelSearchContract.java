package com.yzyfdf.lifehelper.ui.travel.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.travel.HotSearch;

import rx.Observable;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public interface TravelSearchContract {

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getKeyWords();
        public abstract void getSuggests(String keyWord);
    }

    interface Model extends BaseModel {
        Observable<HotSearch> getKeyWords();
        Observable<HotSearch> getSuggests(String keyWord);

    }

    interface View extends BaseView {
        void returnKeyWords(HotSearch bean);
        void returnSuggests(HotSearch bean);
    }

}
