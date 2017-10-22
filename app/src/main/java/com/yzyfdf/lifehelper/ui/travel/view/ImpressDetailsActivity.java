package com.yzyfdf.lifehelper.ui.travel.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.MyImpressBean;
import com.yzyfdf.lifehelper.util.ImageUtil;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ImpressDetailsActivity extends BaseAppActivity {
    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.tv_desc)
    TextView     mTvDesc;
    @Bind(R.id.tv_location)
    TextView     mTvLocation;
    @Bind(R.id.tv_writetime)
    TextView     mTvWritetime;
    @Bind(R.id.tv_from)
    TextView     mTvFrom;
    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @Bind(R.id.yinhao)
    ImageView    mYinhao;

    public static void startSelf(Context context, MyImpressBean myImpressBean) {
        Intent intent = new Intent(context, ImpressDetailsActivity.class);
        intent.putExtra("myImpressBean", myImpressBean);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_travel_impress_details;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initToolbar(mToolbar, "印象详情");

        MyImpressBean myImpressBean = (MyImpressBean) getIntent().getSerializableExtra("myImpressBean");
        String desc = myImpressBean.getDesc();
        if (TextUtils.isEmpty(desc)) {
            mYinhao.setVisibility(View.GONE);
            mTvDesc.setVisibility(View.GONE);
        } else {
            mTvDesc.setText(desc);
        }
        mTvLocation.setText("@" + myImpressBean.getLocation());
        if (!TextUtils.isEmpty(myImpressBean.getWriteTime()))
            mTvWritetime.setText(myImpressBean.getWriteTime().substring(0, 10) + " 发布");

        String from = "来自行程 " + myImpressBean.getFrom();
        SpannableString ss = new SpannableString(from);
        ss.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 5, ss.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTvFrom.setText(ss);

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRecyclerview.setAdapter(new BaseAdapter<String, BaseAdapter.BaseRVViewHolder>(this, myImpressBean.getImageList()) {
            @Override
            public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_impress_details, parent, false));
            }

            @Override
            public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
                String url = mList.get(position);
                if (!url.startsWith("http")) {
                    url = Constant.travel_image + url + "!600";
                }
                ImageUtil.setBigImage(mContext, (ImageView) holder.itemView, url);
            }
        });


    }


}
