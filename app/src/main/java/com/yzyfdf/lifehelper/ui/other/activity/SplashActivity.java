package com.yzyfdf.lifehelper.ui.other.activity;

import android.widget.TextView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.ui.other.contract.SplashContract;
import com.yzyfdf.lifehelper.ui.other.model.SplashModel;
import com.yzyfdf.lifehelper.ui.other.presenter.SplashPresenter;

import butterknife.Bind;
import butterknife.OnClick;

public class SplashActivity extends BaseAppActivity<SplashPresenter, SplashModel> implements SplashContract.View {


    @Bind(R.id.timer)
    TextView mTimer;

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
        mPresenter.smsTimer();
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
        HomeActivity.startSelf(this);
        finish();
    }

}
