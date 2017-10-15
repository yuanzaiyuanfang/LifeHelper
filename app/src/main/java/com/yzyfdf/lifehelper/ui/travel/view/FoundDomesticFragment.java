package com.yzyfdf.lifehelper.ui.travel.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundAbroadBean;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundBean;
import com.yzyfdf.lifehelper.bean.travel.TravelFoundDomesticBean;
import com.yzyfdf.lifehelper.ui.travel.adapter.FoundAdapter;
import com.yzyfdf.lifehelper.ui.travel.contract.FoundAbroadContract;
import com.yzyfdf.lifehelper.ui.travel.model.FoundAbroadModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.FoundAbroadPresenter;

import java.util.List;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class FoundDomesticFragment extends BaseAppFragment<FoundAbroadPresenter, FoundAbroadModel>
        implements FoundAbroadContract.View {
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mPresenter.getDomestic();
    }


    @Override
    public void returnAbroad(TravelFoundAbroadBean.DataBean bean) {
        //无
    }

    @Override
    public void returnDomestic(TravelFoundDomesticBean.DataBean bean) {
        List<TravelFoundBean.DataBean.GuidesBean> list = bean.getGuides();
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        FoundAdapter adapter = new FoundAdapter(getContext(), list, FoundAdapter.level2);
        mRecyclerView.setAdapter(adapter);
    }
}
