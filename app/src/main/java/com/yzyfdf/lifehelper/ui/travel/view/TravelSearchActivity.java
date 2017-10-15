package com.yzyfdf.lifehelper.ui.travel.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.jianlv.chufaba.connection.HttpSecret;
import com.yzyfdf.lifehelper.R;
import com.yzyfdf.lifehelper.base.activity.BaseAppActivity;
import com.yzyfdf.lifehelper.base.adapter.BaseAdapter;
import com.yzyfdf.lifehelper.bean.travel.HotSearch;
import com.yzyfdf.lifehelper.ui.travel.contract.TravelSearchContract;
import com.yzyfdf.lifehelper.ui.travel.model.TravelSearchModel;
import com.yzyfdf.lifehelper.ui.travel.presenter.TravelSearchPresenter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */
@Deprecated
public class TravelSearchActivity extends BaseAppActivity<TravelSearchPresenter, TravelSearchModel>
        implements TravelSearchContract.View, SearchView.OnQueryTextListener {
    @Bind(R.id.searchView)
    SearchView   mSearchView;
    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.layout_hotSearch)
    LinearLayout mLayoutHotSearch;
    @Bind(R.id.recyclerview_hot)
    RecyclerView mRecyclerviewHot;
    @Bind(R.id.recyclerview_suggest)
    RecyclerView mRecyclerviewSuggest;
    @Bind(R.id.layout_searchResult)
    LinearLayout mLayoutSearchResult;
    private BaseAdapter<String, BaseAdapter.BaseRVViewHolder> mAdapterSuggest;

    public static void startSelf(Context context) {
        Intent intent = new Intent(context, TravelSearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_travel_search;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        initToolbar(mToolbar, "搜索");

        mSearchView.onActionViewExpanded();
        mSearchView.setOnQueryTextListener(this);

        mPresenter.getKeyWords();
    }

    @Override
    public void returnKeyWords(HotSearch bean) {
        mLayoutHotSearch.setVisibility(View.VISIBLE);
        mRecyclerviewHot.setLayoutManager(new GridLayoutManager(this, 3));
        BaseAdapter<String, BaseAdapter.BaseRVViewHolder> adapterHot = new BaseAdapter<String, BaseAdapter.BaseRVViewHolder>(this, bean.getKeywords()) {
            @Override
            public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cook_category2, parent, false));
            }

            @Override
            public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
                String text = mList.get(position);
                holder.setText(R.id.tv_name, text);
                holder.itemView.setOnClickListener(v -> mSearchView.setQuery(text, true));
            }
        };
        mRecyclerviewHot.setAdapter(adapterHot);
    }

    @Override
    public void returnSuggests(HotSearch bean) {
        mRecyclerviewSuggest.setVisibility(View.VISIBLE);
        mRecyclerviewSuggest.setLayoutManager(new LinearLayoutManager(this));
        if (mAdapterSuggest == null) {
            mAdapterSuggest = new BaseAdapter<String, BaseAdapter.BaseRVViewHolder>(this, bean.getKeywords()) {
                @Override
                public BaseRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    return new BaseRVViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_travel_search_suggest, parent, false));

                }

                @Override
                public void onBindViewHolder(BaseAdapter.BaseRVViewHolder holder, int position) {
                    String text = mList.get(position);
                    holder.setText(R.id.tv_name, text);
                    holder.itemView.setOnClickListener(v -> mSearchView.setQuery(text, true));
                }
            };
            mRecyclerviewSuggest.setAdapter(mAdapterSuggest);
        } else {
            mAdapterSuggest.refresh(bean.getKeywords());
        }
    }


    //searchView监听
    @Override
    public boolean onQueryTextSubmit(String query) {
        // TODO: 2017/8/23 搜索
        showShortToast("搜索 " + query);
        System.out.println("搜索:" + aaa(query));

        return false;
    }

    String http_secret1="je@5z*r";
    String http_secret10="hoin-e";
    String http_secret2="nib-";
    String http_secret3="*[628zr";
    String http_secret4="trot-";
    String http_secret5="-uc-gey-";
    String http_secret6="-wyab-";
    String http_secret7="oo-";
    String http_secret8="yak-gu";
    String http_secret9="-mut-";

    public static String aaa(String paramString)
    {



        long l = new Date().getTime();
        System.out.println("l:" + l);

        HttpSecret.HttpGetSecret localHttpGetSecret = new HttpSecret.HttpGetSecret();
        localHttpGetSecret.setSecret1("TTz9?");
        localHttpGetSecret.setSecret2("*[628zr");
        localHttpGetSecret.setSecret3("-fienph");
        localHttpGetSecret.setSecret4("@9#]yz");
        localHttpGetSecret.setSecret5("+8/39&r");
        localHttpGetSecret.setSecret6("je@5z*r");
        localHttpGetSecret.setSecret7("nib-");
        localHttpGetSecret.setSecret9("-uc-gey-");
        localHttpGetSecret.setSecret8("trot-");
        localHttpGetSecret.setSecret10("hic");
        localHttpGetSecret.setSecret11("+t4?@fw");
        localHttpGetSecret.setSecret12("ap");
        localHttpGetSecret.setSecret13("-wyab-");
        localHttpGetSecret.setSecret14("oo-");
        localHttpGetSecret.setSecret15("yak-gu");
        localHttpGetSecret.setSecret16("-mut-");
        localHttpGetSecret.setSecret17("hoin-e");


        String s = "";
        try {
            s = URLEncoder.encode(new StringBuilder().append(paramString).append("").toString(), "utf-8")
                    + "+" + URLEncoder.encode(String.valueOf(3), "utf-8")
                    + "+" + URLEncoder.encode(String.valueOf(0), "utf-8")
                    + "+" + l +
                    new HttpSecret().getSecret(localHttpGetSecret);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            s = "";
        }
        return a(s).toLowerCase(Locale.getDefault());

    }


    public static String a(String paramString) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramString.getBytes());
            byte[] arrayOfByte = localMessageDigest.digest();
            StringBuffer localStringBuffer = new StringBuffer("");
            for (int i = 0; i < arrayOfByte.length; i++) {
                int j = arrayOfByte[i];
                if (j < 0)
                    j += 256;
                if (j < 16)
                    localStringBuffer.append("0");
                localStringBuffer.append(Integer.toHexString(j));
            }
            String str = localStringBuffer.toString();
            return str;
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            System.out.println(localNoSuchAlgorithmException);
        }
        return "";
    }



    @Override
    public boolean onQueryTextChange(String newText) {
        mLayoutSearchResult.setVisibility(View.GONE);
        if (TextUtils.isEmpty(newText)) {
            mRecyclerviewSuggest.setVisibility(View.GONE);
        } else {
            mPresenter.getSuggests(newText);
        }
        return false;
    }


}
