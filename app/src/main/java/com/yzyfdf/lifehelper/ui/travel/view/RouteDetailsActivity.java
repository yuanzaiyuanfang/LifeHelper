package com.yzyfdf.lifehelper.ui.travel.view;

import android.content.Context;
import android.content.Intent;
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
import com.jaydenxiao.common.commonutils.TimeUtil;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.travel.MyItineraryBean;
import com.yzyfdf.lifehelper.bean.travel.RouteDetailsBean;
import com.yzyfdf.lifehelper.ui.travel.adapter.RouteDetailsAdapter;
import com.yzyfdf.lifehelper.ui.travel.adapter.RouteDetailsMenuAdapter;
import com.yzyfdf.lifehelper.ui.travel.contract.RouteDetailsContract;
import com.yzyfdf.lifehelper.ui.travel.model.RouteDetailsModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.RouteDetailsPresenter;
import com.yzyfdf.lifehelper.util.ImageUtil;
import com.yzyfdf.lifehelper.widget.NoScrollGridView;
import com.yzyfdf.lifehelper.widget.ObservableScrollView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

import static com.jaydenxiao.common.commonutils.TimeUtil.dateFormatYMD2;

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
    private RouteDetailsAdapter mAdapter;

    private ArrayList<String> mMenuList = new ArrayList<>();
    private RouteDetailsMenuAdapter mMenuAdapter;

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
        mAdapter = new RouteDetailsAdapter(this, mList);
        mRecyclerviewItinerary.setAdapter(mAdapter);

        mRecyclerviewMenu.setLayoutManager(new LinearLayoutManager(this));
        mMenuAdapter = new RouteDetailsMenuAdapter(this, mMenuList);
        mRecyclerviewMenu.setAdapter(mMenuAdapter);
        mMenuAdapter.setOnSelectStateListener((state, file, position) -> {
            mDrawerLayout.closeDrawer(GravityCompat.END);
            int top = mRecyclerviewItinerary.getTop()+mRecyclerviewItinerary.getChildAt(position).getTop()-BarUtils.getStatusBarHeight(this)*2;
            mScrollView.scrollTo(0,top);
        });

    }

    @Override
    public void returnRouteDetails(RouteDetailsBean bean) {
        //出发时间
        String departure = bean.getDeparture_date();
        Date departure_date = TimeUtil.getDateByFormat(departure, dateFormatYMD2);
        //顶部信息
        setMsg1(bean);
        //标签
        setMsg2(bean);

        if (!TextUtils.isEmpty(bean.getIntro()))
            mTvIntro.setText(bean.getIntro());

        //行程
        setMsg3(bean, departure_date);
    }

    private void setMsg4(RouteDetailsBean bean) {


    }

    private void setMsg3(RouteDetailsBean bean, Date departure_date) {
        ArrayList<MyItineraryBean> list = new ArrayList<>();
        ArrayList<String> menuList = new ArrayList<>();

        List<RouteDetailsBean.ItineraryBean> itineraryList = bean.getItinerary();
        if (itineraryList != null && itineraryList.size() > 0) {
            for (int i = 0; i < itineraryList.size(); i++) {
                //每一天
                List<RouteDetailsBean.ItineraryBean.LocationsBean> locations = itineraryList.get(i).getLocations();
                if (locations != null & locations.size() > 0) {
                    String day = "DAY" + (i + 1);
                    String time = TimeUtil.getStringByOffset(departure_date, "yyyy.MM.dd", Calendar.DATE, i);
                    String week = TimeUtil.getWeekNumber(time, "yyyy.MM.dd");
                    //每天简介
                    list.add(new MyItineraryBean(new MyItineraryBean.MyItineraryTitle(day, time, week, itineraryList.get(i).getCity(), itineraryList.get(i).getDesc()), null));
                    menuList.add(day + "，" + itineraryList.get(i).getCity());
                    for (RouteDetailsBean.ItineraryBean.LocationsBean location : locations) {
                        //每个地点
                        list.add(new MyItineraryBean(null, location));
                        menuList.add(TextUtils.isEmpty(location.getName()) ? location.getName_en() : location.getName());
                    }
                }
            }
            //结束
            list.add(new MyItineraryBean(null, null));
            menuList.add("THE END");
            mAdapter.refresh(list);
            mMenuAdapter.refresh(menuList);
        }
    }

    private void setMsg2(RouteDetailsBean bean) {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        if (!TextUtils.isEmpty(bean.getDeparture_date())) {
            Map<String, String> map = new HashMap<>();
            map.put("text1", "出发时间：");
            map.put("text2", bean.getDeparture_date());
            list.add(map);
        }
        if (!TextUtils.isEmpty(bean.getCompact())) {
            Map<String, String> map = new HashMap<>();
            map.put("text1", "紧凑程度：");
            map.put("text2", bean.getCompact() + "（" + bean.getDuration() + "天," + bean.getLocations() + "个地点）");
            list.add(map);
        }
        if (!TextUtils.isEmpty(bean.getAverage())) {
            Map<String, String> map = new HashMap<>();
            map.put("text1", "人均花费：");
            map.put("text2", "￥" + bean.getAverage() + "/人");
            list.add(map);
        }
        if (!TextUtils.isEmpty(bean.getGowith())) {
            Map<String, String> map = new HashMap<>();
            map.put("text1", "和谁一起：");
            map.put("text2", bean.getGowith());
            list.add(map);
        }
        String[] from = {"text1", "text2"};
        int[] to = {R.id.text1, R.id.text2};
        SimpleAdapter gridAdapter = new SimpleAdapter(this, list, R.layout.item_textview_travel, from, to);
        mGridView.setAdapter(gridAdapter);

        //标签
        String label = bean.getLabel();
        if (label != null) {
            String[] strings = label.split("、");
            for (String string : strings) {
                TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.item_textview_travel2, mLayoutTips, false);
                tv.setText(string);
                mLayoutTips.addView(tv);
            }
        }

    }

    private void setMsg1(RouteDetailsBean bean) {
        //背景
        ImageUtil.setBigImage(this, mTitleBkg, bean.getBackground_image());
        //标题
        mTitle = bean.getTitle();
        mTvName.setText(mTitle);
        //地点
        StringBuffer sb = new StringBuffer("————·");
        for (RouteDetailsBean.DestinationsBean destinationsBean : bean.getDestinations()) {
            sb.append(destinationsBean.getName() + "·");
        }
        sb.append("————");
        mTvDesc.setText(sb.toString());
        //作者
        mTvAuthor.setText(bean.getUsername());
        ImageUtil.setRoundImage(this, mIvAuthor, bean.getAvatar());
    }


    @OnClick({R.id.iv_author, R.id.map, R.id.menu_close})
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
}
