package com.yzyfdf.lifehelper.ui.travel.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.blankj.utilcode.utils.BarUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.travel.MyItineraryBean;
import com.yzyfdf.lifehelper.bean.travel.MyRouteRvData;
import com.yzyfdf.lifehelper.bean.travel.RouteDetailsBean;
import com.yzyfdf.lifehelper.ui.travel.adapter.JournalDetailsAdapter;
import com.yzyfdf.lifehelper.ui.travel.adapter.RouteDetailsMenuAdapter;
import com.yzyfdf.lifehelper.ui.travel.contract.RouteDetailsContract;
import com.yzyfdf.lifehelper.ui.travel.model.RouteDetailsModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.RouteDetailsPresenter;
import com.yzyfdf.lifehelper.widget.NoScrollGridView;
import com.yzyfdf.lifehelper.widget.ObservableScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import jp.wasabeef.blurry.Blurry;

/**
 * Created by SJJ .
 * 描述 ${远方 -  精选  行程详情}
 */

public class RouteDetailsActivity extends BaseAppActivity<RouteDetailsPresenter, RouteDetailsModel>
        implements RouteDetailsContract.View {

    @Bind(R.id.tv_name)
    TextView             mTvName;
    @Bind(R.id.tv_desc)
    TextView             mTvDesc;
    @Bind(R.id.iv_author)
    ImageView            mIvAuthor;
    @Bind(R.id.title_bkg)
    ImageView            mTitleBkg;
    @Bind(R.id.tip_bkg)
    ImageView            mTipBkg;
    @Bind(R.id.menu_bkg)
    ImageView            mMenuBkg;
    @Bind(R.id.tv_author)
    TextView             mTvAuthor;
    @Bind(R.id.gridview)
    NoScrollGridView     mGridView;
    @Bind(R.id.layout_tips)
    LinearLayout         mLayoutTips;
    @Bind(R.id.tv_intro)
    TextView             mTvIntro;
    @Bind(R.id.recyclerview_itinerary)
    RecyclerView         mRecyclerviewItinerary;
    @Bind(R.id.toolbar)
    Toolbar              mToolbar;
    @Bind(R.id.recyclerview_menu)
    RecyclerView         mRecyclerviewMenu;
    @Bind(R.id.map)
    TextView             mMap;
    @Bind(R.id.menu_close)
    ImageView            mMenuClose;
    @Bind(R.id.drawer_layout)
    DrawerLayout         mDrawerLayout;
    @Bind(R.id.scrollView)
    ObservableScrollView mScrollView;

    private String mTitle;

    private ArrayList<MyItineraryBean> mList = new ArrayList<>();
    private JournalDetailsAdapter mAdapter;

    private ArrayList<String> mMenuList = new ArrayList<>();
    private RouteDetailsMenuAdapter mMenuAdapter;
    private Bitmap                  mBitmapBg;
    private int                     mSize;

    public static void startSelf(Context context, String url) {
        Intent intent = new Intent(context, RouteDetailsActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_travel_route_details;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        ((View) mTipBkg.getParent()).setVisibility(View.GONE);

        String url = getIntent().getStringExtra("url");
        mPresenter.getRouteDetails(url);

        mScrollView.setScrollViewListener((scrollView, x, y, oldx, oldy) -> {
            int[] locationTitleBkg = new int[2];
            mTitleBkg.getLocationOnScreen(locationTitleBkg);
            int mTitleBkgBottom = locationTitleBkg[1] + mTitleBkg.getHeight();

            int[] locationToolbar = new int[2];
            mToolbar.getLocationOnScreen(locationToolbar);
            int mToolbarBottom = locationToolbar[1] + mToolbar.getHeight();

            if (mTitleBkgBottom < mToolbarBottom) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                mToolbar.setTitle(mTitle);
            } else {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
                mToolbar.setTitle("");
            }
        });

        //toolbar
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("");
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        //行程
        mRecyclerviewItinerary.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mAdapter = new JournalDetailsAdapter(this, mList);
        mRecyclerviewItinerary.setAdapter(mAdapter);

        mRecyclerviewMenu.setLayoutManager(new LinearLayoutManager(this));
        mMenuAdapter = new RouteDetailsMenuAdapter(this, mMenuList);
        mRecyclerviewMenu.setAdapter(mMenuAdapter);
        mMenuAdapter.setOnSelectStateListener((state, file, position) -> {
            mDrawerLayout.closeDrawer(GravityCompat.END);
            int top = mRecyclerviewItinerary.getTop() + mRecyclerviewItinerary.getChildAt(position).getTop() - BarUtils.getStatusBarHeight(this) * 2;
            mScrollView.scrollTo(0, top);
        });

    }

    @Override
    public void returnRouteDetails(RouteDetailsBean bean) {
        //行程
        mAdapter.setTitle(bean.getTitle(),"","", bean.getUrl());
        mPresenter.getRecyclerViewData(bean);
        //顶部信息
        setMsg1(bean);
        //标签
//        setMsg2(bean);


        if (!TextUtils.isEmpty(bean.getDesc()))
            mTvIntro.setText(bean.getDesc());

//        if (bean.getItinerary() != null && bean.getItinerary().size() > 30) {
//            mSize = bean.getItinerary().size();
//            showLongToast("当前行程共" + mSize + "天，暂时只支持查看一个月");
//        }

    }

    @Override
    public void returnRecyclerViewData(MyRouteRvData bean) {
        mAdapter.refresh(bean.getList());
        mMenuAdapter.refresh(bean.getMenuList());

    }


    private void setMsg2(RouteDetailsBean bean) {
        ArrayList<Map<String, String>> list = new ArrayList<>();

//        Map<String, String> map = new HashMap<>();
//        map.put("text1", "出发时间：");
//        map.put("text2", TextUtils.isEmpty(bean.getDeparture_date()) ? "未填写" : bean.getDeparture_date());
//        list.add(map);

        Map<String, String> map2 = new HashMap<>();
        map2.put("text1", "紧凑程度：");
        map2.put("text2", TextUtils.isEmpty(bean.getCompact()) ? "未填写" : bean.getCompact() + "（" + bean.getDays() + "天," + bean.getComments() + "个地点）");
        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("text1", "人均花费：");
        map3.put("text2", TextUtils.isEmpty(bean.getAverage()) ? "未填写" : "￥" + bean.getAverage() + "/人");
        list.add(map3);

        Map<String, String> map4 = new HashMap<>();
        map4.put("text1", "和谁一起：");
        map4.put("text2", TextUtils.isEmpty(bean.getGowith()) ? "未填写" : bean.getGowith());
        list.add(map4);

        String[] from = {"text1", "text2"};
        int[] to = {R.id.text1, R.id.text2};
        SimpleAdapter gridAdapter = new SimpleAdapter(this, list, R.layout.item_textview_travel, from, to);
        mGridView.setAdapter(gridAdapter);

        //标签
        String label = bean.getLabel();
        if (TextUtils.isEmpty(label)) {
            label = "无标签";
        }
        String[] strings = label.split("、");
        for (String string : strings) {
            TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.item_textview_travel2, mLayoutTips, false);
            tv.setText(string);
            mLayoutTips.addView(tv);
        }

    }

    private void setMsg1(RouteDetailsBean bean) {
        //背景
        Glide.with(mContext)
                .load(bean.getBackground_image()).asBitmap()
                .thumbnail(0.1f)
                .error(R.mipmap.no_pic)
//                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .priority(Priority.IMMEDIATE)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        mBitmapBg = resource;
                        mTitleBkg.setImageBitmap(mBitmapBg);

//                        Blurry.with(RouteDetailsActivity.this)
//                                .radius(25)
//                                .sampling(8)
//                                .from(mBitmapBg)
//                                .into(mTipBkg);

                        Blurry.with(RouteDetailsActivity.this)
                                .radius(30)
                                .sampling(10)
                                .from(mBitmapBg)
                                .into(mMenuBkg);
                    }
                });
        //标题
        mTitle = bean.getTitle();
        mTvName.setText(mTitle);
        //地点
        StringBuffer sb = new StringBuffer("————·");
        sb.append(bean.getHighlights());
//        for (JournalDetailsBean.DestinationsBean destinationsBean : bean.getDestinations()) {
//            sb.append(destinationsBean.getName() + "·");
//        }
        sb.append("————");
        mTvDesc.setText(sb.toString());
        //作者
//        mTvAuthor.setText(bean.getUsername());
//        ImageUtil.setRoundImage(this, mIvAuthor, bean.getAvatar());
    }


    @OnClick({R.id.iv_author, R.id.map, R.id.menu_close, R.id.open_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_author:
                showShortToast("作者 敬请期待");
                break;
            case R.id.map:
                showShortToast("地图 敬请期待");
                break;
            case R.id.menu_close:
                mDrawerLayout.closeDrawer(GravityCompat.END);
                break;
            case R.id.open_menu:
                if (!mDrawerLayout.isDrawerOpen(GravityCompat.END))
                    mDrawerLayout.openDrawer(GravityCompat.END);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mList = null;
        mMenuList = null;
        System.gc();
    }
}
