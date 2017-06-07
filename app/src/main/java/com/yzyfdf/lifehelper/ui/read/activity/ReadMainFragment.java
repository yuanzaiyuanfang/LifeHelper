package com.yzyfdf.lifehelper.ui.read.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.jaydenxiao.common.base.BaseFragmentAdapter;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.ui.other.activity.HomeActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ReadMainFragment extends BaseAppFragment   {
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private List<String>        mTitleList    = new ArrayList<>();
    private String[]            mTitles       = {"知乎", "豆瓣", "果壳"};
    private BaseFragmentAdapter  mAdapter;
    private FloatingActionButton mFab;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_readmain;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mFab = ((HomeActivity) getContext()).mFab;
//        mViewpager = (ViewPager) rootView.findViewById(R.id.viewpager);

        ZhiHuFragment zhiHuFragment = new ZhiHuFragment();
        DouBanFragment douBanFragment = new DouBanFragment();
        GuoKeFragment guoKeFragment = new GuoKeFragment();

        mFragmentList.clear();
        mFragmentList.add(zhiHuFragment);
        mFragmentList.add(douBanFragment);
        mFragmentList.add(guoKeFragment);

        mTitleList = Arrays.asList(mTitles);

        mAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mFragmentList, mTitleList);
        mViewpager.setAdapter(mAdapter);
        mViewpager.setOnPageChangeListener(mOnPageChangeListener );
        mTabLayout.setupWithViewPager(mViewpager);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        mTabLayout.setTabTextColors(getResources().getColor(R.color.item_666666), getResources().getColor(R.color.colorPrimary));
    }

    public RecyclerView getCurrentRecyclerView() {
        int currentItem = mViewpager.getCurrentItem();
        Fragment fragment = mFragmentList.get(currentItem);
        switch (currentItem) {
            case 0:
                return ((ZhiHuFragment) fragment).mXRecyclerView;
            case 1:
                return ((DouBanFragment) fragment).mXRecyclerView;
            case 2:
                return ((GuoKeFragment) fragment).mXRecyclerView;
        }
        return ((ZhiHuFragment) fragment).mXRecyclerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        show();
    }

    private void show() {
        mFab.setOnClickListener(v -> getCurrentRecyclerView().scrollToPosition(0));
    }

    @Override
    public void onPause() {
        super.onPause();
        hide();
    }

    private void hide() {
        mFab.setOnClickListener(null);
    }

    ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mFab.setOnClickListener(v -> getCurrentRecyclerView().scrollToPosition(0));
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
