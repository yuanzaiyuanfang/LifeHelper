package com.yzyfdf.lifehelper.ui.other.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.utils.ToastUtils;
import com.jaydenxiao.common.baseapp.AppManager;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookCategoryActivity;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookFavoritesActivity;
import com.yzyfdf.lifehelper.ui.cookbook.activity.CookMainFragment;
import com.yzyfdf.lifehelper.ui.other.contract.HomeContract;
import com.yzyfdf.lifehelper.ui.other.model.HomeModel;
import com.yzyfdf.lifehelper.ui.other.presenter.HomePresenter;
import com.yzyfdf.lifehelper.ui.read.activity.ReadMainFragment;

import java.util.ArrayList;

import butterknife.Bind;

public class HomeActivity extends BaseAppActivity<HomePresenter, HomeModel> implements HomeContract.View, NavigationView.OnNavigationItemSelectedListener {


    @Bind(R.id.toolbar)
    Toolbar        mToolbar;
    @Bind(R.id.frameLayout)
    FrameLayout    mFrameLayout;
    @Bind(R.id.content_main)
    RelativeLayout mContentMain;
    @Bind(R.id.nav_view)
    NavigationView mNavView;
    @Bind(R.id.drawer_layout)
    DrawerLayout   mDrawerLayout;
    @Bind(R.id.fab)
    public FloatingActionButton mFab;

    private ActionBar mActionBar;
    private long mTime = 0;

    private ArrayList<BaseAppFragment> mFragmentList = new ArrayList<>();
    private ReadMainFragment mReadMainFragment;
    private CookMainFragment mCookMainFragment;

    private static final int      cookbook  = 0;
    private static final int      read      = 1;
    private              int      mNowPager = read;
    private              String[] mTitles   = {"美食", "阅读"};
    private              int[]    mMenuIds  = {R.id.nav_cookbook, R.id.nav_read};

    public static void startSelf(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        //        SetTranslanteBar();

        //toolbar
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle(mTitles[mNowPager]);

        //DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        //第NavigationView一次选择第一项食谱
        mNavView.setCheckedItem(mMenuIds[mNowPager]);
        mNavView.setNavigationItemSelectedListener(this);


        initFragment();
    }

    private void initFragment() {
        mCookMainFragment = new CookMainFragment();
        mReadMainFragment = new ReadMainFragment();

        mFragmentList.add(mCookMainFragment);
        mFragmentList.add(mReadMainFragment);

        BaseAppFragment fragment = mFragmentList.get(mNowPager);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, fragment).show(fragment)
                .commit();
        setFab(fragment);
    }

    private void switchFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseAppFragment fragment = mFragmentList.get(mNowPager);
        hideFragment(transaction);
        setFab(fragment);
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.frameLayout, fragment).show(fragment);
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        for (BaseAppFragment fragment : mFragmentList) {
            //此处必须...NoClassDefFoundError
            if (fragment instanceof CookMainFragment) {
                transaction.hide(fragment);
            }
            if (fragment instanceof ReadMainFragment) {
                transaction.hide(fragment);
            }
        }
    }

    private void setFab(BaseAppFragment fragment) {
        switch (mNowPager) {
            case cookbook:
                mFab.setOnClickListener(v -> ((CookMainFragment) fragment).mXRecyclerView.scrollToPosition(0));
                break;
            case read:
                mFab.setOnClickListener(v -> ((ReadMainFragment) fragment).getCurrentRecyclerView().scrollToPosition(0));
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_cookbook) {
            mActionBar.setTitle("美食");
            mNowPager = cookbook;
            switchFragment();
        } else if (id == R.id.nav_read) {
            mActionBar.setTitle("阅读");
            mNowPager = read;
            switchFragment();
        } else if (id == R.id.nav_slideshow) {
            showShortToast("敬请期待");
        } else if (id == R.id.nav_manage) {
            showShortToast("敬请期待");
        } else if (id == R.id.nav_share) {
            showShortToast("敬请期待");
        } else if (id == R.id.nav_send) {
            SettingActivity.startSelf(this);
        }
        supportInvalidateOptionsMenu();
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //        getMenuInflater().inflate(R.menu.home_cook, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //        menu.clear();
        switch (mNowPager) {
            case cookbook:
                getMenuInflater().inflate(R.menu.home_cook, menu);
                break;
            case read:
                getMenuInflater().inflate(R.menu.home_read, menu);
                break;
            default:
                break;
        }
        ((MenuBuilder) menu).setOptionalIconsVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.cook_category:
                CookCategoryActivity.startSelf(this);
                return true;
            case R.id.my_favorites_cook:
                CookFavoritesActivity.startSelf(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            backPressed();
        }
    }

    private void backPressed() {
        long timeMillis = System.currentTimeMillis();
        if (timeMillis - mTime < 2000) {
            AppManager.getAppManager().AppExit(this, false);
        }
        mTime = timeMillis;
        ToastUtils.showShortToast("再按一下返回键退出");
    }

}
