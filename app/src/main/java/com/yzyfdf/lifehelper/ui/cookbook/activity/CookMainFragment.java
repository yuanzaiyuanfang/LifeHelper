package com.yzyfdf.lifehelper.ui.cookbook.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.utils.SizeUtils;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookMainAdapter;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookMainHeadAdapter;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookMainContract;
import com.yzyfdf.lifehelper.ui.cookbook.model.CookMainModel;
import com.yzyfdf.lifehelper.ui.cookbook.presenter.CookMainPresenter;
import com.yzyfdf.lifehelper.ui.other.activity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookMainFragment extends BaseAppFragment<CookMainPresenter, CookMainModel> implements CookMainContract.View {
    @Bind(R.id.xRecyclerView)
    public XRecyclerView mXRecyclerView;


    private ArrayList<CookMainBean.ResultBean.ListBean> mList     = new ArrayList<>();
    private ArrayList<CookMainBean.ResultBean.ListBean> mHeadList = new ArrayList<>();
    private CookMainAdapter mAdapter;
    private int num = 0;
    private FloatingActionButton mFab;
    private String TAG = "CookMainFragment";
    private TextView            mHeadName;
    private RadioGroup          mRadioGroup;
    private ViewPager           mViewPager;
    private CookMainHeadAdapter mHeadAdapter;
    private int                 mCurrentItem;
    private TextView            mHeadNum;
    private boolean             hasHeader;
    private View                mHeadView;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_cookmain;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        showLoading();
        initRecyclerView();

        mFab = ((HomeActivity) getContext()).mFab;

    }


    private void initRecyclerView() {

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mXRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new CookMainAdapter(getContext(), mList);
        mXRecyclerView.setAdapter(mAdapter);

        //设置分割线
        //        mXRecyclerView.setBackgroundColor(getResources().getColor(R.color.line_F4F5F9));
        //        mXRecyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));

        //设置是否支持上下拉刷新
        mXRecyclerView.setLoadingMoreEnabled(true);
        mXRecyclerView.setPullRefreshEnabled(true);
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.LineScalePulseOut);


        //设置监听
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            //下拉
            @Override
            public void onRefresh() {
                num = 0;
                mPresenter.queryCookHome(num);
            }

            //上拉
            @Override
            public void onLoadMore() {
                num += 30;
                mPresenter.queryCookHome(num);
            }
        });

        //头部
        mHeadView = LayoutInflater.from(getContext()).inflate(R.layout.layout_head_cook_main, (ViewGroup) rootView, false);
        mViewPager = ((ViewPager) mHeadView.findViewById(R.id.viewpager));
        mHeadName = ((TextView) mHeadView.findViewById(R.id.head_name));
        mRadioGroup = ((RadioGroup) mHeadView.findViewById(R.id.radioGroup));
        mHeadNum = ((TextView) mHeadView.findViewById(R.id.head_num));

        mHeadAdapter = new CookMainHeadAdapter(getContext(), mHeadList);
        mViewPager.setAdapter(mHeadAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                swipepager(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        if (!hasHeader) {
            //            mXRecyclerView.addHeaderView(mHeadView);
            hasHeader = true;
        }

        mPresenter.queryCookHome(num);

    }


    @Override
    public void returnCookHome(List<CookMainBean.ResultBean.ListBean> list) {
        if (num == 0) {
            mXRecyclerView.refreshComplete();
            mAdapter.refresh(list);
        } else {
            mXRecyclerView.loadMoreComplete();
            mAdapter.add(list);
        }


    }

    @Override
    public void returnCookHomeHead(ArrayList<CookMainBean.ResultBean.ListBean> headList) {
        if (isProgressLoading()) {
            stopLoading();
        }
        return;
//        if (headList.size() > 0) {
//
//        } else {
//        }
//        if (num == 0) {
//            mCurrentItem = 0;
//            addDots(headList.size());
//
//            mHeadList.clear();
//            mHeadList.addAll(headList);
//            mHeadAdapter.notifyDataSetChanged();
//
//            mViewPager.setCurrentItem(mCurrentItem);
//            swipepager(mCurrentItem);
//        }
    }

    private void swipepager(int position) {
        CookMainBean.ResultBean.ListBean.MBean mBean = mHeadList.get(position).getM();
        mRadioGroup.check(position);
        mHeadName.setText(mBean.getT());
        mHeadNum.setText("共" + mBean.getC() + "道菜");
    }

    @Override
    public void returnSmsTimer(Long second) {
        mCurrentItem = mViewPager.getCurrentItem();
        mViewPager.setCurrentItem(mCurrentItem == mHeadList.size() - 1 ? 0 : mCurrentItem + 1);
        mPresenter.smsTimer();
    }

    private void addDots(int size) {
        mRadioGroup.removeAllViews();
        int r = SizeUtils.dp2px(10);
        for (int i = 0; i < size; i++) {
            RadioButton dot = new RadioButton(getContext());
            Bitmap a = null;
            dot.setButtonDrawable(new BitmapDrawable(a));
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(r, r);
            dot.setBackgroundResource(R.drawable.dot_bg);
            dot.setId(i);
            if (i == size - 1) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, 0, r, 0);
            }
            dot.setLayoutParams(layoutParams);
            mRadioGroup.addView(dot);
        }
        mRadioGroup.check(0);
    }

    @Override
    public void onResume() {
        super.onResume();
        show();
    }

    private void show() {
        mFab.setOnClickListener(v -> mXRecyclerView.scrollToPosition(0));
        Log.i(TAG, "onHiddenChanged: 可见");
        mPresenter.smsTimer();
    }

    @Override
    public void onPause() {
        super.onPause();
        hide();
    }

    private void hide() {
        mFab.setOnClickListener(null);
        Log.i(TAG, "onHiddenChanged: 不可见");
        if (mPresenter.mob != null) {
            mPresenter.mob.unsubscribe();
        }
    }

    //    @Override
    //    public void onHiddenChanged(boolean hidden) {
    //        super.onHiddenChanged(hidden);
    //        if (hidden) {
    //            hide();
    //        } else {
    //            show();
    //        }
    //    }
}
