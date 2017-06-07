package com.yzyfdf.lifehelper.ui.other.activity;

import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.PermissionActivity;
import com.yzyfdf.lifehelper.ui.other.contract.SplashContract;
import com.yzyfdf.lifehelper.ui.other.model.SplashModel;
import com.yzyfdf.lifehelper.ui.other.presenter.SplashPresenter;

import butterknife.Bind;
import butterknife.OnClick;

public class SplashActivity extends PermissionActivity<SplashPresenter, SplashModel> implements SplashContract.View {


    @Bind(R.id.timer)
    TextView mTimer;

    private static final String APP_ID = "wx225167515bf0be19";
    public static IWXAPI mWXAPI;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        regToWx();

        mPresenter.smsTimer();

    }

    private void initPermission() {
        requestPermission(FORCE_REQUIRE_PERMISSIONS, true, new PermissionsResultListener() {
            @Override
            public void onPermissionGranted() {
                HomeActivity.startSelf(SplashActivity.this);
                finish();
            }

            @Override
            public void onPermissionDenied() {
                ToastUtils.showShortToast("拒绝申请权限");
            }
        });
    }

    private void regToWx() {
        mWXAPI = WXAPIFactory.createWXAPI(this, APP_ID, true);
        mWXAPI.registerApp(APP_ID);
    }


    @Override
    public void returnSmsTimer(Long second) {
        mTimer.setText(second + " S");
        if (second == 0) {
            goToHome();
        }
    }

    @OnClick(R.id.timer)
    public void onViewClicked() {
        if (SplashPresenter.mob != null) {
            SplashPresenter.mob.unsubscribe();
        }
        goToHome();
    }

    private void goToHome() {
        initPermission();

    }

}
