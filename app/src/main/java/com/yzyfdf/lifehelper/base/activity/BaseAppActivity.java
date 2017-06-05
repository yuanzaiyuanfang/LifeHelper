package com.yzyfdf.lifehelper.base.activity;

import android.view.View;
import android.webkit.ValueCallback;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.commonutils.NetWorkUtils;
import com.yzyfdf.lifehelper.widget.ErrorLayout;
import com.yzyfdf.lifehelper.widget.PopupDialog;

/**
 * Created by conan on 2017/2/20.
 */

public abstract class BaseAppActivity<T extends BasePresenter, E extends BaseModel> extends BaseActivity<T, E> {
    //H5调用原生相机拍照所用临时变量
    public ValueCallback mUploadMessage;

    public PopupDialog confirmDialog;

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
        if (!NetWorkUtils.isNetConnected(this)) {
            error_layout.setVisibility(View.VISIBLE);
            error_layout.viewListener(listener);
        } else {
            listener.callListener();
        }
    }
}
