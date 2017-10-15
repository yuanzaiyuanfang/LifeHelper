package com.yzyfdf.lifehelper.ui.travel.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.jaydenxiao.common.base.BaseFragmentAdapter;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class FoundActivity extends BaseAppActivity {
    @Bind(R.id.toolbar)
    Toolbar   mToolbar;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private List<String>        mTitleList    = new ArrayList<>();
    private String[]            mTitles       = {"境内", "境外"};
    private BaseFragmentAdapter mAdapter;
    private int                 index;

    public static void startSelf(Context context, int index) {
        Intent intent = new Intent(context, FoundActivity.class);
        intent.putExtra("index", index);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_travel_found;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initToolbar(mToolbar, "目的地");

        index = getIntent().getIntExtra("index", 0);

        FoundDomesticFragment domesticFragment = new FoundDomesticFragment();
        FoundAbroadFragment abroadFragment = new FoundAbroadFragment();

        mFragmentList.clear();
        mFragmentList.add(domesticFragment);
        mFragmentList.add(abroadFragment);

        mTitleList = Arrays.asList(mTitles);

        mAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragmentList, mTitleList);
        mViewpager.setAdapter(mAdapter);
        //        mViewpager.setOnPageChangeListener(mOnPageChangeListener );
        mTabLayout.setupWithViewPager(mViewpager);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        mTabLayout.setTabTextColors(getResources().getColor(R.color.item_666666), getResources().getColor(R.color.colorPrimary));

        if (index != 0) {
            mViewpager.setCurrentItem(index, false);
        }

    }


}
