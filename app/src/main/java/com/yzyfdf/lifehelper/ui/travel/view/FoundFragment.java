package com.yzyfdf.lifehelper.ui.travel.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.travel.MyFoundBean;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundBean;
import com.yzyfdf.lifehelper.ui.travel.adapter.FoundAdapter;
import com.yzyfdf.lifehelper.ui.travel.contract.FoundContract;
import com.yzyfdf.lifehelper.ui.travel.model.FoundModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.FoundPresenter;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class FoundFragment extends BaseAppFragment<FoundPresenter, FoundModel> implements FoundContract.View {


    @Bind(R.id.xRecyclerView)
    RecyclerView mXRecyclerView;

    private ArrayList<MyFoundBean> mList = new ArrayList<>();
    private FoundAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_travel_found;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        //RecyclerView
        mXRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mAdapter = new FoundAdapter(getContext(), mList);
        mXRecyclerView.setAdapter(mAdapter);


        mPresenter.getHots();

    }

    @Override
    public void returnHots(TravelFoundBean.DataBean bean) {
        ArrayList<MyFoundBean> list = new ArrayList<>();

        list.add(new MyFoundBean("境内"));
        TravelFoundBean.DataBean.DomesticBean domesticBean = bean.getDomestic();
        for (TravelFoundBean.DataBean.GuidesBean guidesBean : domesticBean.getGuides()) {
            list.add(new MyFoundBean("",guidesBean));
        }

        list.add(new MyFoundBean("境外"));
        TravelFoundBean.DataBean.AbroadBean abroadBean = bean.getAbroad();
        for (TravelFoundBean.DataBean.GuidesBean guidesBean : abroadBean.getGuides()) {
            list.add(new MyFoundBean("",guidesBean));
        }

        mAdapter.refresh(list);


    }


}
