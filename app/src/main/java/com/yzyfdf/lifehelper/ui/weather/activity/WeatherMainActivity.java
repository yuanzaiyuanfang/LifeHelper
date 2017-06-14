package com.yzyfdf.lifehelper.ui.weather.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.weather.AddressBean;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;
import com.yzyfdf.lifehelper.ui.weather.adapter.Later3daysAdapter;
import com.yzyfdf.lifehelper.ui.weather.adapter.MyAddressProvider;
import com.yzyfdf.lifehelper.ui.weather.contract.WeatherMainContract;
import com.yzyfdf.lifehelper.ui.weather.model.WeatherMainModel;
import com.yzyfdf.lifehelper.ui.weather.presenter.WeatherMainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import chihane.jdaddressselector.AddressSelector;

import static com.yzyfdf.lifehelper.app.Constant.location;


public class WeatherMainActivity extends BaseAppActivity<WeatherMainPresenter, WeatherMainModel> implements WeatherMainContract.View {


    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.tv_nowTmp)
    TextView     mTvNowTmp;
    @Bind(R.id.tv_cond)
    TextView     mTvCond;
    @Bind(R.id.tv_minMax)
    TextView     mTvMinMax;
    @Bind(R.id.tv_aqi)
    TextView     mTvAqi;
    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerview;//后三天气温

    private AlertDialog     mDialog;
    private AddressSelector mAddressSelector;
    private ArrayList<WeatherBean.HeWeather5Bean.DailyForecastBean> mDailyList = new ArrayList<>();
    private Later3daysAdapter mLater3daysAdapter;

    public static void startSelf(Context context) {
        Intent intent = new Intent(context, WeatherMainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_weather_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        //toolbar
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("");
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mLater3daysAdapter = new Later3daysAdapter(this,mDailyList);
        mRecyclerview.setAdapter(mLater3daysAdapter);

        String location = Hawk.get(Constant.location, "");
        if (TextUtils.isEmpty(location)) {
            initAddressDialog();
            mPresenter.getAddress();
        } else {
            mToolbar.setTitle(location);
            mPresenter.queryWeather(location);
        }

    }

    private void initAddressDialog() {
        mAddressSelector = new AddressSelector(this);
        //        addressSelector.setAddressProvider(new MyAddressProvider());
        mAddressSelector.setOnAddressSelectedListener((province, city, county, street) -> {
            mPresenter.queryWeather(county.name);
            mDialog.dismiss();
            Hawk.put(location, county.name);
            mToolbar.setTitle(county.name);
        });
        View view = mAddressSelector.getView();
        mDialog = new AlertDialog.Builder(this).setView(view).create();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.weather_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.select_location) {
            if (mDialog == null) {
                initAddressDialog();
                mPresenter.getAddress();
            } else {
                mDialog.show();
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void returnWeather(WeatherBean.HeWeather5Bean bean) {
        String tmp = bean.getNow().getTmp();
        mTvNowTmp.setText(tmp);//温度

        String cond = bean.getNow().getCond().getTxt();
        mTvCond.setText(cond);//天气

        List<WeatherBean.HeWeather5Bean.DailyForecastBean> dailyList = bean.getDaily_forecast();
        String min = dailyList.get(0).getTmp().getMin();
        String max = dailyList.get(0).getTmp().getMax();
        mTvMinMax.setText(min + "℃ ~ " + max + "℃");//温度范围

        if (bean.getAqi() == null) {//aqi
            mTvAqi.setText("");
        } else {
            String aqi = bean.getAqi().getCity().getAqi();
            String qlty = bean.getAqi().getCity().getQlty();
            mTvAqi.setText(aqi + "·" + qlty);
        }

        mLater3daysAdapter.refresh(dailyList);
    }

    @Override
    public void returnAddress(AddressBean bean) {
        mAddressSelector.setAddressProvider(new MyAddressProvider(bean));
        mDialog.show();
    }


}
