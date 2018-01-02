package com.yzyfdf.lifehelper.ui.live.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.yzyfdf.lifehelper.bean.live.LiveChannelDataBean;

import java.util.List;

import rx.Observable;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public interface LiveJujiaContract {
    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getChannel(int channel_type);
        public abstract void getChannelData(String keyword, int page, int search_type);

    }

    interface Model extends BaseModel {
        Observable<List<String>> getChannel(int channel_type);
        Observable<LiveChannelDataBean.DataBean> getChannelData(String keyword, int page, int search_type);


    }

    interface View extends BaseView {
        void returnChannel(List<String> list);
        void returnChannelData(LiveChannelDataBean.DataBean bean);

    }
}
