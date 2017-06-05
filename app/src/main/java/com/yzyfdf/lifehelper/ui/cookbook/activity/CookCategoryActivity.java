package com.yzyfdf.lifehelper.ui.cookbook.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;

import com.blankj.utilcode.utils.SizeUtils;
import com.jaydenxiao.common.commonutils.KeyBordUtil;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.bean.cookbean.CookCategoryBean;
import com.yzyfdf.lifehelper.bean.cookbean.MyCsBean;
import com.yzyfdf.lifehelper.ui.cookbook.adapter.CookCategoryAdapter;
import com.yzyfdf.lifehelper.ui.cookbook.contract.CookCategoryContract;
import com.yzyfdf.lifehelper.ui.cookbook.model.CookCategoryModel;
import com.yzyfdf.lifehelper.ui.cookbook.presenter.CookCategoryPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookCategoryActivity extends BaseAppActivity<CookCategoryPresenter, CookCategoryModel> implements CookCategoryContract.View, CompoundButton.OnCheckedChangeListener, SearchView.OnQueryTextListener {

    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.radio_group)
    RadioGroup   mRadioGroup;
    @Bind(R.id.rv_classify)
    RecyclerView mRvClassify;
    @Bind(R.id.searchView)
    public SearchView mSearchView;

    private ArrayList<MyCsBean> mCheckedList = new ArrayList<>();
    private CookCategoryAdapter                        mAdapter;
    private List<CookCategoryBean.ResultBean.CsBeanXX> mList;
    private String mCategoryName = "";

    public static void startSelf(Context context) {
        Intent intent = new Intent(context, CookCategoryActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cook_caegory;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSearchView.clearFocus();
    }

    @Override
    public void initView() {
        //toolbar
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("全部分类");
        bar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());

        //RecyclerView
        mRvClassify.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        mAdapter = new CookCategoryAdapter(this, mCheckedList, mCategoryName);
        mRvClassify.setAdapter(mAdapter);

        //SearchView
        //        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setOnQueryTextListener(this);


        mPresenter.qureyCatalogs();
    }

    @Override
    public void returnQureyCatalogs(List<CookCategoryBean.ResultBean.CsBeanXX> list) {
        mList = list;
        initRadioGroup(mList);
        mRadioGroup.check(0);
    }


    private void initRadioGroup(List<CookCategoryBean.ResultBean.CsBeanXX> list) {
        int r = SizeUtils.dp2px(15);
        for (int i = 0; i < list.size(); i++) {
            RadioButton rb = new RadioButton(this);
            Bitmap a = null;
            rb.setButtonDrawable(new BitmapDrawable(a));
            rb.setText(list.get(i).getName());
            rb.setTextSize(16);
            rb.setTextColor(getResources().getColor(R.color.light_gray));
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            rb.setLayoutParams(layoutParams);
            rb.setPadding(0, r, 0, r);
            rb.setBackgroundResource(R.drawable.selector_bg_button_cookcategory);
            rb.setGravity(Gravity.CENTER);
            rb.setOnCheckedChangeListener(this);
            rb.setId(i);

            mRadioGroup.addView(rb);
        }
    }

    private void initClassify(List<CookCategoryBean.ResultBean.CsBeanXX.CsBeanX> list) {
        mCheckedList.clear();
        for (CookCategoryBean.ResultBean.CsBeanXX.CsBeanX csBeanX : list) {
            mCheckedList.add(new MyCsBean(csBeanX.getName(), csBeanX.getId(), csBeanX.getJu(), 1));
            for (CookCategoryBean.ResultBean.CsBeanXX.CsBeanX.CsBean csBean : csBeanX.getCs()) {
                mCheckedList.add(new MyCsBean(csBean.getName(), csBean.getId(), csBean.getJu(), 2));
            }
        }
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            buttonView.setTextColor(getResources().getColor(R.color.colorPrimary));
            mAdapter.setCategoryName(mList.get(buttonView.getId()).getName());
            initClassify(mList.get(buttonView.getId()).getCs());
        } else {
            buttonView.setTextColor(getResources().getColor(R.color.light_gray));
        }
    }


    //搜索框监听
    @Override
    public boolean onQueryTextSubmit(String query) {
        CookSearchActivity.startSelf(this, query);
        mSearchView.setQuery("", false);//搜索框清空
        KeyBordUtil.hideSoftKeyboard(mSearchView);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}