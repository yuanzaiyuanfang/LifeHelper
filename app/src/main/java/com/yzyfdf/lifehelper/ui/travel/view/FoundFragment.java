package com.yzyfdf.lifehelper.ui.travel.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
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

    private ArrayList<TravelFoundBean.DataBean.GuidesBean> mList = new ArrayList<>();
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
        mAdapter = new FoundAdapter(getContext(), mList,FoundAdapter.level1);
        mXRecyclerView.setAdapter(mAdapter);


        mPresenter.getHots();

    }

    @Override
    public void returnHots(TravelFoundBean.DataBean bean) {
        ArrayList<TravelFoundBean.DataBean.GuidesBean> list = new ArrayList<>();

        list.add(new TravelFoundBean.DataBean.GuidesBean("境内"));
        TravelFoundBean.DataBean.DomesticBean domesticBean = bean.getDomestic();
        list.addAll(domesticBean.getGuides());

        list.add(new TravelFoundBean.DataBean.GuidesBean("境外"));
        TravelFoundBean.DataBean.AbroadBean abroadBean = bean.getAbroad();
        list.addAll(abroadBean.getGuides());

        mAdapter.refresh(list);


    }


}
