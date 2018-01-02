package com.yzyfdf.lifehelper.ui.live.ui;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppFragment;
import com.yzyfdf.lifehelper.ui.other.activity.HomeActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class LiveMainFragment extends BaseAppFragment {
    @Bind(R.id.layout_jujia)
    LinearLayout mLayoutJujia;
    @Bind(R.id.layout_dajia)
    LinearLayout mLayoutDajia;

    private FloatingActionButton mFab;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_livemain;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mFab = ((HomeActivity) getContext()).mFab;
    }

    @OnClick({R.id.layout_jujia, R.id.layout_dajia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_jujia:
                LiveJujiaActivity.startSelf(getContext());
                break;
            case R.id.layout_dajia:
                break;
        }
    }


}
