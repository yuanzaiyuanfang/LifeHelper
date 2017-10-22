package com.yzyfdf.lifehelper.ui.travel.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.travel.ThemeDetailsBean;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;
import com.yzyfdf.lifehelper.ui.travel.adapter.ThemeDetailsAdapter;
import com.yzyfdf.lifehelper.ui.travel.contract.ThemeDetailsContract;
import com.yzyfdf.lifehelper.ui.travel.model.ThemeDetailsModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.ThemeDetailsPresenter;
import com.yzyfdf.lifehelper.util.ImageUtil;
import com.yzyfdf.lifehelper.widget.ObservableScrollView;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${远方 -  精选  去处详情}
 */

public class ThemeDetailsActivity extends BaseAppActivity<ThemeDetailsPresenter, ThemeDetailsModel>
        implements ThemeDetailsContract.View {

    @Bind(R.id.tv_name)
    TextView             mTvName;
    @Bind(R.id.tv_desc)
    TextView             mTvDesc;
    @Bind(R.id.iv_author)
    ImageView            mIvAuthor;
    @Bind(R.id.tv_author)
    TextView             mTvAuthor;
    @Bind(R.id.title_bkg)
    ImageView            mTitleBkg;
    @Bind(R.id.tip_bkg)
    ImageView            mTipBkg;
    @Bind(R.id.tv_intro)
    TextView             mTvIntro;
    @Bind(R.id.recyclerview_itinerary)
    RecyclerView         mRecyclerView;
    @Bind(R.id.toolbar)
    Toolbar              mToolbar;
    @Bind(R.id.open_menu)
    ImageView            mOpenMenu;
    @Bind(R.id.scrollView)
    ObservableScrollView mScrollView;

    private String mTitle;

    private ArrayList<TravelImpressBean.DataBean.PoiBean> mList = new ArrayList<>();
    private ThemeDetailsAdapter mAdapter;


    public static void startSelf(Context context, String url) {
        Intent intent = new Intent(context, ThemeDetailsActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_travel_route_details;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        ((View) mTipBkg.getParent()).setVisibility(View.GONE);
        mIvAuthor.setVisibility(View.GONE);
        mTvAuthor.setVisibility(View.GONE);
        mOpenMenu.setVisibility(View.GONE);

        String url = getIntent().getStringExtra("url");
        mPresenter.getThemeDetails(url);

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mAdapter = new ThemeDetailsAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void returnThemeDetails(ThemeDetailsBean bean) {
        ImageUtil.setBigImage(this,mTitleBkg,bean.getImage());
        //标题
        mTitle = bean.getTitle();
        mTvName.setText(mTitle);
        //地点
        StringBuffer sb = new StringBuffer("————·");
        sb.append(bean.getHighlights());
        sb.append("————");
        mTvDesc.setText(sb.toString());

        if (!TextUtils.isEmpty(bean.getDesc()))
            mTvIntro.setText(bean.getDesc());

        mAdapter.refresh(bean.getNodes());

    }




}
