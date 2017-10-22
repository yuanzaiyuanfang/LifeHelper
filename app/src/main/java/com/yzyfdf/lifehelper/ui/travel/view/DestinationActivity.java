package com.yzyfdf.lifehelper.ui.travel.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.DestinationBean;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;
import com.yzyfdf.lifehelper.ui.travel.contract.DestinationContract;
import com.yzyfdf.lifehelper.ui.travel.model.DestinationModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.DestinationPresenter;
import com.yzyfdf.lifehelper.util.TravelUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import jp.wasabeef.blurry.Blurry;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class DestinationActivity extends BaseAppActivity<DestinationPresenter, DestinationModel>
        implements DestinationContract.View {

    @Bind(R.id.rootView)
    ImageView    mRootView;
    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.tv_name)
    TextView     mTvName;
    @Bind(R.id.tv_country)
    TextView     mTvCountry;
    @Bind(R.id.tv_name_en)
    TextView     mTvNameEn;
    @Bind(R.id.tv_intro)
    TextView     mTvIntro;
    @Bind(R.id.rv_poi)
    RecyclerView mRvPoi;
    @Bind(R.id.rv_themes)
    RecyclerView mRvThemes;
    @Bind(R.id.rv_routes)
    RecyclerView mRvRoutes;

    public static void startSelf(Context context, int id) {
        Intent intent = new Intent(context, DestinationActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_travel_destination;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        initToolbar(mToolbar, "目的地");
        mRvPoi.setNestedScrollingEnabled(false);
        mRvThemes.setNestedScrollingEnabled(false);
        mRvRoutes.setNestedScrollingEnabled(false);

        int id = getIntent().getIntExtra("id", 0);
        mPresenter.getDestination(id);

    }

    @Override
    public void returnDestination(DestinationBean.DataBean bean) {
        mTvName.setText(TextUtils.isEmpty(bean.getName()) ? "城市" : bean.getName());
        mTvCountry.setText(TextUtils.isEmpty(bean.getCountry()) ? "国家" : bean.getCountry());
        mTvNameEn.setText(TextUtils.isEmpty(bean.getName_en()) ? "City" : bean.getName_en());
        mTvIntro.setText(TextUtils.isEmpty(bean.getIntro()) ? "暂无介绍" : bean.getIntro());

        setBkg(bean.getImg());
        setThemes(bean.getThemes());
        setRoutes(bean.getRoutes());
        setPoi(bean.getPoi_comments());


    }

    //印象
    private void setPoi(List<TravelImpressBean.DataBean.PcBean> list) {
        mRvPoi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRvPoi.setAdapter(new BaseAdapter<TravelImpressBean.DataBean.PcBean, BaseAdapter.BaseRVViewHolder>(this, list) {

            @Override
            public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_route_small, parent, false));
            }

            @Override
            public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
                TravelImpressBean.DataBean.PcBean bean = mList.get(position);
                holder.setText(R.id.tv_name, bean.getPoi_name());
                holder.setImage(R.id.iv_pic, Constant.travel_image + TravelUtil.getimage(bean.getImages()) + Constant.travel_image_375);
                holder.itemView.setOnClickListener(v -> ImpressDetailsActivity.startSelf(DestinationActivity.this,bean));
            }
        });
    }

    //行程
    private void setRoutes(List<DestinationBean.DataBean.RoutesBean> list) {
        mRvRoutes.setLayoutManager(new LinearLayoutManager(this));
        mRvRoutes.setAdapter(new BaseAdapter<DestinationBean.DataBean.RoutesBean, BaseAdapter.BaseRVViewHolder>(this, list) {
            @Override
            public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_route, parent, false));
            }

            @Override
            public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
                DestinationBean.DataBean.RoutesBean bean = mList.get(position);
                holder.setText(R.id.tv_name, bean.getTitle());
                holder.setText(R.id.tv_desc, "————·" + bean.getHighlights() + "·————");
                holder.setImage(R.id.iv_pic, bean.getBackground_image());
                holder.itemView.setOnClickListener(v -> RouteDetailsActivity.startSelf(mContext, bean.getUrl()));
            }
        });
    }

    //去处
    private void setThemes(List<DestinationBean.DataBean.ThemesBean> list) {
        mRvThemes.setLayoutManager(new LinearLayoutManager(this));
        mRvThemes.setAdapter(new BaseAdapter<DestinationBean.DataBean.ThemesBean, BaseAdapter.BaseRVViewHolder>(this, list) {
            @Override
            public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_route, parent, false));
            }

            @Override
            public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
                DestinationBean.DataBean.ThemesBean bean = mList.get(position);
                holder.setText(R.id.tv_name, bean.getTitle());
                holder.setText(R.id.tv_desc, "————·" + bean.getHighlights() + "·————");
                holder.setImage(R.id.iv_pic, bean.getImage());
                holder.itemView.setOnClickListener(v -> ThemeDetailsActivity.startSelf(DestinationActivity.this,bean.getUrl()));
            }
        });
    }

    private void setBkg(String img) {
        Glide.with(this)
                .load(img).asBitmap()
                .thumbnail(0.1f)
                .error(R.mipmap.no_pic)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        Blurry.with(DestinationActivity.this)
                                .radius(15)
                                .sampling(10)
                                .from(resource)
                                .into(mRootView);
                    }
                });
    }


    @OnClick({R.id.more_poi, R.id.more_themes, R.id.more_routes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_poi:
                break;
            case R.id.more_themes:
                break;
            case R.id.more_routes:
                break;
        }
    }
}
