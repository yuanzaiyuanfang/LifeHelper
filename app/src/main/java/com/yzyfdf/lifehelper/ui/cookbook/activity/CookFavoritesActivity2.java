//package com.yzyfdf.lifehelper.ui.cookbook.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.app.ActionBar;
//import android.support.v7.widget.Toolbar;
//
//import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
//import com.yzyfdf.lifehelper.R;
//import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
//import com.yzyfdf.lifehelper.bean.cookbean.MyFavoriteBean;
//import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookFavoritesAdapter2;
//import com.yzyfdf.lifehelper.util.HawkUtil;
//
//import java.util.ArrayList;
//
//import butterknife.Bind;
//
//public class CookFavoritesActivity2 extends BaseAppActivity {
//
//
//    @Bind(R.id.toolbar)
//    Toolbar mToolbar;
//    @Bind(R.id.cViewPager)
//    HorizontalInfiniteCycleViewPager mCViewPager;
//
//
//    private ArrayList<MyFavoriteBean> mList = new ArrayList<>();
//    private CookFavoritesAdapter2 mAdapter;
//
//    public static void startSelf(Context context) {
//        Intent intent = new Intent(context, CookFavoritesActivity2.class);
//        context.startActivity(intent);
//    }
//
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_cook_favorites2;
//    }
//
//    @Override
//    public void initPresenter() {
//
//    }
//
//    @Override
//    public void initView() {
//        initData();
//        //toolbar
//        mToolbar.setTitle("我的收藏");
//        setSupportActionBar(mToolbar);
//        ActionBar bar = getSupportActionBar();
//        bar.setDisplayHomeAsUpEnabled(true);
//        mToolbar.setNavigationOnClickListener(v -> finish());
//
//        mAdapter = new CookFavoritesAdapter2(this, mList);
//        mCViewPager.setAdapter(mAdapter);
//        mAdapter.setOnItemLongClickListener(position -> {
//            showShortToast(mList.get(position).getrBean().getN());
//            mList.remove(position);
//            mCViewPager.notifyDataSetChanged();
//        });
//
//    }
//
//    private void initData() {
//        ArrayList<MyFavoriteBean> list = HawkUtil.getFavorite();
//        mList.addAll(list);
//    }
//
//}
