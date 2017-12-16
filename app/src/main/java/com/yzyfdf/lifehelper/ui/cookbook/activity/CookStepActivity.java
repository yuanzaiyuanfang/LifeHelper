package com.yzyfdf.lifehelper.ui.cookbook.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.cookbean.CookRBean;
import com.yzyfdf.lifehelper.bean.cookbean.MyStepBean;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookStepAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class CookStepActivity extends BaseAppActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.viewpager)
    ViewPager    mViewpager;
    @Bind(R.id.tv_index)
    TextView     mTvIndex;
    @Bind(R.id.tv_desc)
    TextView     mTvDesc;
    @Bind(R.id.layout_tv)
    LinearLayout mLayoutTv;

    private ArrayList<CookRBean.CookstepBean> mList = new ArrayList<>();

    public static void startSelf(Context context, List<CookRBean.CookstepBean> list, int position) {
        Intent intent = new Intent(context, CookStepActivity.class);
        intent.putExtra(Constant.MYSTEPBEAN, new MyStepBean(list, position));
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_step;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        SetTranslanteBar();

        //ViewPager
        CookStepAdapter adapter = new CookStepAdapter(this,mList);
        mViewpager.setAdapter(adapter);
        mViewpager.setOnPageChangeListener(this);

        MyStepBean myStepBean = (MyStepBean) getIntent().getSerializableExtra(Constant.MYSTEPBEAN);
        mList.addAll(myStepBean.getList());
        adapter.notifyDataSetChanged();

        //页码 说明
        int index = myStepBean.getIndex();
        mViewpager.setCurrentItem(index);
        mTvIndex.setText(index + 1 + "/" + mList.size());
        mTvDesc.setText(mList.get(index).getContent());

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTvIndex.setText(mList.get(position).getPosition() + "/" + mList.size());
        mTvDesc.setText(mList.get(position).getContent());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @OnClick(R.id.close)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            default:
                break;
        }
    }
}
