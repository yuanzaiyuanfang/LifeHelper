package com.yzyfdf.lifehelper.ui.cookbook.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.commonutils.LogUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.cookbean.MyFavoriteBean;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookFavoritesAdapter;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookFavoritesDeleteAdapter;
import com.yzyfdf.lifehelper.util.HawkUtil;

import java.util.ArrayList;

import butterknife.Bind;

public class CookFavoritesActivity extends BaseAppActivity {


    @Bind(R.id.toolbar)
    Toolbar       mToolbar;
    @Bind(R.id.xRecyclerView)
    XRecyclerView mRecyclerView;
    @Bind(R.id.layout_normal)
    LinearLayout  mLayoutNormal;
    @Bind(R.id.check_all)
    CheckBox      mCheckAll;
    @Bind(R.id.xRecyclerView_delete)
    RecyclerView  mXRecyclerViewDelete;
    @Bind(R.id.layout_delete)
    LinearLayout  mLayoutDelete;
    @Bind(R.id.tv_none)
    TextView      mTvNone;

    private ArrayList<MyFavoriteBean> mList = new ArrayList<>();
    private CookFavoritesAdapter       mAdapter;
    private boolean                    delete;
    private CookFavoritesDeleteAdapter mDeleteAdapter;
    private MenuItem                   mDeleteItem;

    public static void startSelf(Context context) {
        Intent intent = new Intent(context, CookFavoritesActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_favorites;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        //toolbar
        mToolbar.setTitle("我的收藏");
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        //RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CookFavoritesAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        //RecyclerViewDelete
        mXRecyclerViewDelete.setLayoutManager(new LinearLayoutManager(this));
        mDeleteAdapter = new CookFavoritesDeleteAdapter(this, mList);
        mXRecyclerViewDelete.setAdapter(mDeleteAdapter);
        mDeleteAdapter.setOnSelectStateListener((state, file) -> {
            boolean check = true;
            for (MyFavoriteBean myFavoriteBean : mList) {
                check = check & myFavoriteBean.isDelete();
            }
            mCheckAll.setOnCheckedChangeListener(null);
            mCheckAll.setChecked(check);
            mCheckAll.setOnCheckedChangeListener(mChangeListener);
        });

        //CheckBox
        mCheckAll.setOnCheckedChangeListener(mChangeListener);

    }

    private void initData() {
        ArrayList<MyFavoriteBean> list = HawkUtil.getFavorite();
        mList.addAll(list);
        checkNone(list);
    }

    CompoundButton.OnCheckedChangeListener mChangeListener = (buttonView, isChecked) -> {
        for (MyFavoriteBean myFavoriteBean : mList) {
            myFavoriteBean.setDelete(isChecked);
        }
        mDeleteAdapter.notifyDataSetChanged();
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cook_favorites, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete) {
            if (mList.size() == 0) {
                showShortToast("还没有收藏,快去找你喜欢的美食吧~");
                return true;
            }
            mDeleteItem = item;
            switchLayoutAndIcon(item, false);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayoutAndIcon(MenuItem item, boolean back) {
        if (delete) {
            if (!back)
                delete();
            mLayoutDelete.setVisibility(View.GONE);
            mLayoutNormal.setVisibility(View.VISIBLE);
            mAdapter.notifyDataSetChanged();
            item.setIcon(getResources().getDrawable(R.mipmap.delete));
        } else {
            mLayoutDelete.setVisibility(View.VISIBLE);
            mLayoutNormal.setVisibility(View.GONE);
            mDeleteAdapter.notifyDataSetChanged();
            item.setIcon(getResources().getDrawable(R.mipmap.ok));
        }
        delete = !delete;
        LogUtils.logv("收藏数" + mList.size());
    }

    private void delete() {
        ArrayList<MyFavoriteBean> list = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).isDelete()) {
                list.add(mList.get(i));
            }
        }
        mList.removeAll(list);
        checkNone(mList);
        HawkUtil.removeFavorites(list);
    }

    private void checkNone(ArrayList<MyFavoriteBean> list) {
        if (list.size() == 0) {
            mTvNone.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCheckAll.setChecked(false);
        mList.clear();
        initData();
        mAdapter.notifyDataSetChanged();
        mDeleteAdapter.notifyDataSetChanged();
    }


    

    @Override
    public void onBackPressed() {
        if (delete) {
            mCheckAll.setChecked(false);
            switchLayoutAndIcon(mDeleteItem, true);
            for (MyFavoriteBean myFavoriteBean : mList) {
                myFavoriteBean.setDelete(false);
            }
            return;
        }
        super.onBackPressed();
    }

}
