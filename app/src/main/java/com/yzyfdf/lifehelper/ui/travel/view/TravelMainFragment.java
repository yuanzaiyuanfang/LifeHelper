package com.yzyfdf.lifehelper.ui.travel.view;

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

public class TravelMainFragment extends BaseAppFragment {
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;

    private FloatingActionButton mFab;

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private List<String>        mTitleList    = new ArrayList<>();
    private String[]            mTitles       = {"精选", "热门", "发现"};
    private BaseFragmentAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_travelmain;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mFab = ((HomeActivity) getContext()).mFab;

        RoutesFragment routesFragment = new RoutesFragment();
        ImpressFragment impressFragment = new ImpressFragment();
        FoundFragment foundFragment = new FoundFragment();

        mFragmentList.clear();
        mFragmentList.add(routesFragment);
        mFragmentList.add(impressFragment);
        mFragmentList.add(foundFragment);

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
                return ((RoutesFragment) fragment).mXRecyclerView;
            case 1:
                return ((ImpressFragment) fragment).mXRecyclerView;
            case 2:
                return ((FoundFragment) fragment).mXRecyclerView;
        }
        return ((RoutesFragment) fragment).mXRecyclerView;
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
