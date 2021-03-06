package com.yzyfdf.lifehelper.ui.cookbook.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.bumptech.glide.Glide;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.cookbean.CookRBean;
import com.yzyfdf.lifehelper.bean.cookbean.MyFavoriteBean;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookRecipeAdapter;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookRecipeContract;
import com.yzyfdf.lifehelper.ui.cookbook.model.CookRecipeModel;
import com.yzyfdf.lifehelper.ui.cookbook.presenter.CookRecipePresenter;
import com.yzyfdf.lifehelper.util.HawkUtil;
import com.yzyfdf.lifehelper.util.ShareUtil;
import com.yzyfdf.lifehelper.util.WxShareUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CookRecipeActivity extends BaseAppActivity<CookRecipePresenter, CookRecipeModel>
        implements CookRecipeContract.View {


    @Bind(R.id.image_view)
    ImageView            mImageView;
    @Bind(R.id.toolbar)
    Toolbar              mToolbar;
    @Bind(R.id.tv_time)
    TextView             mTvTime;
    @Bind(R.id.tv_desc)
    TextView             mTvDesc;
    @Bind(R.id.layout_list)
    LinearLayout         mLayoutList;
    @Bind(R.id.recyclerview)
    RecyclerView         mRecyclerview;
    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.share_view)
    LinearLayout         mShareView;
    @Bind(R.id.tv_stepnum)
    TextView             mTvStepnum;


    private boolean        mFavorite;
    private MyFavoriteBean mMyFavoriteBean;
    private CookRBean      mRBean;
    private ArrayList<String> mMajorList = new ArrayList<>();


    public static void startSelf(Context context, CookRBean rBean) {
        Intent intent = new Intent(context, CookRecipeActivity.class);
        intent.putExtra(Constant.RBean, rBean);
        context.startActivity(intent);
    }

    public static void startSelf(Context context, int id) {
        Intent intent = new Intent(context, CookRecipeActivity.class);
        intent.putExtra(Constant.COOK_ID, id);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_recipe;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        SetTranslanteBar();

        Intent intent = getIntent();
        int id = intent.getIntExtra(Constant.COOK_ID, 0);
        if (id == 0) {
            mRBean = (CookRBean) intent.getSerializableExtra(Constant.RBean);
            setData();
        } else {
            mPresenter.getDetail(id);
        }

    }

    private void setData() {
        mMyFavoriteBean = new MyFavoriteBean("cook" + mRBean.getId(), mRBean);
        //toolbar
        mToolbar.setTitle(mRBean.getN());
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());
        //iv
        Glide.with(getApplicationContext()).load(mRBean.getP()).into(mImageView);
        //描述
        if (TextUtils.isEmpty(mRBean.getCookstory())) {
            mTvDesc.setVisibility(View.GONE);
        } else {
            mTvDesc.setText(mRBean.getCookstory());
        }
        String cook_time = TextUtils.isEmpty(mRBean.getCook_time()) ? "未知" : mRBean.getCook_time();
        String cook_difficulty = TextUtils.isEmpty(mRBean.getCook_difficulty()) ? "未知" : mRBean.getCook_difficulty();
        mTvTime.setText("时间:" + cook_time + "\u3000难度:" + cook_difficulty);
        //配料
        List<CookRBean.MajorBean> major = mRBean.getMajor();
        for (CookRBean.MajorBean majorBean : major) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_cook_recipe_list, mLayoutList, false);
            TextView name = (TextView) view.findViewById(R.id.tv_listname);
            TextView num = (TextView) view.findViewById(R.id.tv_listnum);
            name.setText(majorBean.getTitle());
            num.setText(majorBean.getNote());
            mLayoutList.addView(view);
            mMajorList.add(majorBean.getTitle() + " ");
        }
        List<CookRBean.MinorBean> minor = mRBean.getMinor();
        for (CookRBean.MinorBean minorBean : minor) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_cook_recipe_list, mLayoutList, false);
            TextView name = (TextView) view.findViewById(R.id.tv_listname);
            TextView num = (TextView) view.findViewById(R.id.tv_listnum);
            name.setText(minorBean.getTitle());
            num.setText(minorBean.getNote());
            mLayoutList.addView(view);
            mMajorList.add(minorBean.getTitle() + " ");
        }

        //步骤
        ArrayList<CookRBean.CookstepBean> list = (ArrayList<CookRBean.CookstepBean>) mRBean.getCookstep();
        CookRecipeAdapter adapter = new CookRecipeAdapter(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setNestedScrollingEnabled(false);

        mRecyclerview.setAdapter(adapter);
        mTvStepnum.setText(String.format("共 %d 步 点击进入大图", mRBean.getStc() == 0 ? list.size() : mRBean.getStc()));

        //fab
        mFab.setOnClickListener(v -> {
            if (mFavorite) {
                if (HawkUtil.removeFavorite(mMyFavoriteBean)) {
                    showShortToast("这么好吃竟然不要了/(ㄒoㄒ)/~~");
                    mFab.setImageResource(R.mipmap.favorite_no);
                } else {
                    showShortToast("慢慢来 别急");
                }

            } else {
                if (HawkUtil.addFavorite(mMyFavoriteBean)) {
                    showShortToast("收藏成功");
                    mFab.setImageResource(R.mipmap.favorite_yes);
                } else {
                    showShortToast("慢慢来 别急");
                }
            }
            mFavorite = !mFavorite;
        });

        isFavourite();
    }


    protected void isFavourite() {
        mFavorite = HawkUtil.isFavorite(mMyFavoriteBean);
        if (mFavorite) {
            mFab.setImageResource(R.mipmap.favorite_yes);
        } else {
            mFab.setImageResource(R.mipmap.favorite_no);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cook_details, menu);
        return true;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        ((MenuBuilder) menu).setOptionalIconsVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_share:
                ToastUtils.showShortToast("分享中...稍等");
                //                savePic(mShareView);
                shareCookBook();
                return true;
            case R.id.my_favorites_cook:
                CookFavoritesActivity.startSelf(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void shareCookBook() {
        int id = mRBean.getId();
        String url = Constant.cook_share.replace("cookid", String.valueOf(id));
        WxShareUtil.shareWebpage(url, mRBean.getN(), mMajorList.toString());
    }


    private void savePic(LinearLayout linearLayout) {
        Observable.create((Observable.OnSubscribe<Bitmap>) subscriber -> {
            Bitmap bitmap = ShareUtil.getLinearLayoutBitmap(linearLayout);
            if (bitmap == null) {
                subscriber.onError(new RuntimeException("保存失败了"));
            }
            String fileDir = ShareUtil.getFileDir("share");
            boolean saveMyBitmap = ShareUtil.saveMyBitmap(bitmap, fileDir, mMyFavoriteBean.getId() + ".jpg");
            if (saveMyBitmap) {
                subscriber.onNext(bitmap);
                subscriber.onCompleted();
            } else {
                subscriber.onError(new RuntimeException("保存失败了"));
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {

                    @Override
                    public void onCompleted() {
                        showShortToast("保存成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        showShortToast(e.toString());
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                            bitmap = null;
                        }
                    }
                });
    }


    @Override
    public void returnDetail(CookRBean bean) {
        mRBean = bean;
        setData();
    }
}
