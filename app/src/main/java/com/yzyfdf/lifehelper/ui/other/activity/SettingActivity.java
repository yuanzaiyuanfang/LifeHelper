package com.yzyfdf.lifehelper.ui.other.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.commonwidget.pickerutil.picker.PickerDialog;
import com.orhanobut.hawk.Hawk;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.ui.other.contract.SettingContract;
import com.yzyfdf.lifehelper.ui.other.model.SettingModel;
import com.yzyfdf.lifehelper.ui.other.presenter.SettingPresenter;
import com.yzyfdf.lifehelper.util.GlideCacheUtil;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingActivity extends BaseAppActivity<SettingPresenter, SettingModel> implements SettingContract.View {

    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.layout_clearCache)
    LinearLayout mLayout_clearCache;
    @Bind(R.id.tv_cache)
    TextView     mTvCache;
    @Bind(R.id.tv_nowpage)
    TextView     mTvNowpage;
//    @Bind(R.id.tv_today_step)
//    TextView     mTvTodayStep;

//    private ISportStepInterface iSportStepInterface;
//    private Handler mDelayHandler = new Handler(new TodayStepCounterCall());
//    private int mStepSum;
//    private static final int  REFRESH_STEP_WHAT     = 0;
    //循环取当前时刻的步数中间的间隔时间
//    private              long TIME_INTERVAL_REFRESH = 500;


    public static void startSelf(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("设置");
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        initData();
    }

    protected void initData() {
        mTvCache.setText(GlideCacheUtil.getInstance().getCacheSize(this));
        mTvNowpage.setText(Constant.mTitles[Hawk.get(Constant.nowpage, 0)]);
//        initTodayStep();
    }

    @Override
    public void returnClearCache(boolean isClear) {
        if (isClear) {
            showShortToast("清理完成");
            mTvCache.setText(GlideCacheUtil.getInstance().getCacheSize(this));
        } else {
            showShortToast("清理失败");
        }
    }

    @OnClick({R.id.toolbar, R.id.layout_clearCache, R.id.layout_nowpage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                break;
            case R.id.layout_clearCache:
                mPresenter.clearCache();
                break;
            case R.id.layout_nowpage:
                selectModule();
                break;
        }
    }

    private void selectModule() {
        List<String> strings = Arrays.asList(Constant.mTitles);
        int position = Hawk.get(Constant.nowpage, 0);
        PickerDialog dialog = new PickerDialog(this, strings, position, result -> {
            mTvNowpage.setText(result);
            Hawk.put(Constant.nowpage, strings.indexOf(result));
        });
        dialog.show();
    }


//    private void initTodayStep() {
//
//        //开启计步Service，同时绑定Activity进行aidl通信
//        Intent intent = new Intent(this, TodayStepService.class);
//        startService(intent);
//        bindService(intent, new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//                //Activity和Service通过aidl进行通信
//                iSportStepInterface = ISportStepInterface.Stub.asInterface(service);
//                try {
//                    mStepSum = iSportStepInterface.getCurrentTimeSportStep();
//                    updateStepCount();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//                mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT, TIME_INTERVAL_REFRESH);
//
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//
//            }
//        }, Context.BIND_AUTO_CREATE);
//    }
//
//    class TodayStepCounterCall implements Handler.Callback {
//
//        @Override
//        public boolean handleMessage(Message msg) {
//            switch (msg.what) {
//                case REFRESH_STEP_WHAT: {
//                    //每隔500毫秒获取一次计步数据刷新UI
//                    if (null != iSportStepInterface) {
//                        int step = 0;
//                        try {
//                            step = iSportStepInterface.getCurrentTimeSportStep();
//                        } catch (RemoteException e) {
//                            e.printStackTrace();
//                        }
//                        if (mStepSum != step) {
//                            mStepSum = step;
//                            updateStepCount();
//                        }
//                    }
//                    mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT, TIME_INTERVAL_REFRESH);
//
//                    break;
//                }
//            }
//            return false;
//        }
//    }
//
//    private void updateStepCount() {
//        if (!isDestroyed())
//            mTvTodayStep.setText(mStepSum + "步");
//    }


}
