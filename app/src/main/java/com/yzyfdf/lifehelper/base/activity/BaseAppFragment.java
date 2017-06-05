package com.yzyfdf.lifehelper.base.activity;

import android.view.View;

import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.commonutils.NetWorkUtils;
import com.yzyfdf.lifehelper.widget.ErrorLayout;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public abstract class BaseAppFragment<T extends BasePresenter, E extends BaseModel> extends BaseFragment<T,E> {
    public void showLoading() {
        startProgressDialog();
    }

    public void showLoading(String title) {
        startProgressDialog(title);
    }

    public void stopLoading() {
        stopProgressDialog();
    }

    public void showErrorTip(String msg) {
        showShortToast(msg);
    }

    public void checkNetWork(ErrorLayout error_layout, ErrorLayout.CallClickListener listener) {
        if (!NetWorkUtils.isNetConnected(getContext())) {
            error_layout.setVisibility(View.VISIBLE);
            error_layout.viewListener(listener);
        } else {
            listener.callListener();
        }
    }
}
