package com.yzyfdf.lifehelper.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jaydenxiao.common.commonutils.GlideRoundTransformUtil;
import com.yzyfdf.lifehelper.R;

import java.util.List;

/**
 * Created by Vincent Woo
 * Date: 2016/10/14
 * Time: 15:42
 */

public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected Context                  mContext;
    protected List<T>                  mList;
    protected OnSelectStateListener<T> mOnSelectStateListener;

    public BaseAdapter(Context ctx, List<T> list) {
        mContext = ctx;
        mList = list;
    }

    //    @Override
    //    public void onBindViewHolder(VH holder, int position) {
    //
    //    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public void add(List<T> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void add(T file) {
        mList.add(file);
        notifyDataSetChanged();
    }

    public void add(int index, T file) {
        mList.add(index, file);
        notifyDataSetChanged();
    }

    public void refresh(List<T> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void refresh(T file) {
        mList.clear();
        mList.add(file);
        notifyDataSetChanged();
    }

    public void clearAll() {
        mList.clear();
        notifyDataSetChanged();
    }

    public List<T> getDataSet() {
        return mList;
    }

    public void setOnSelectStateListener(OnSelectStateListener<T> listener) {
        mOnSelectStateListener = listener;
    }

    public interface OnSelectStateListener<T> {
        void OnSelectStateChanged(boolean state, T file);
    }


    public class BaseRVViewHolder extends RecyclerView.ViewHolder {

        private SparseArray<View> mViewMap = new SparseArray<>();

        public BaseRVViewHolder(View itemView) {
            super(itemView);
        }

        public View getView(int id) {
            View view = mViewMap.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                mViewMap.put(id, view);
            }
            return view;
        }

        public TextView getTextView(int id) {
            return ((TextView) getView(id));
        }

        public void setText(int id, String text) {
            getTextView(id).setText(text);
        }

        public ImageView getImageView(int id) {
            return ((ImageView) getView(id));
        }

        public void setBigImage(int id, String url) {
            if (TextUtils.isEmpty(url)) {
                setDefaultImage(id);
                return;
            }
            if (url.endsWith("gif")) {
                Glide.with(mContext)
                        .load(url).asGif()
                        .error(R.mipmap.no_pic)
                        .placeholder(R.mipmap.no_pic)
                        .into(getImageView(id));
            } else {
                Glide.with(mContext)
                        .load(url).thumbnail(0.1f)
                        .error(R.mipmap.no_pic)
                        .placeholder(R.mipmap.no_pic)
                        .into(getImageView(id));
            }

        }

        public void setRoundImage(int id, String url) {
            if (TextUtils.isEmpty(url)) {
                setDefaultImage(id);
                return;
            }
            Glide.with(mContext).load(url)
                    .error(R.drawable.toux2)
                    .placeholder(R.mipmap.toux2)
                    .centerCrop()
                    .transform(new GlideRoundTransformUtil(mContext))
                    .into(getImageView(id));

        }

        public void setSmallImage(int id, String url) {
            if (TextUtils.isEmpty(url)) {
                setDefaultImage(id);
                return;
            }
            Glide.with(mContext)
                    .load(url)
//                    .override(SizeUtils.dp2px(80), SizeUtils.dp2px(80))
                    .centerCrop()
                    .error(R.mipmap.no_pic)
                    .placeholder(R.mipmap.no_pic)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(getImageView(id));
        }

        public void setImage(int id, String url) {
            if (TextUtils.isEmpty(url)) {
                setDefaultImage(id);
                return;
            }
            Glide.with(mContext)
                    .load(url)
                    .error(R.mipmap.no_pic)
                    .placeholder(R.mipmap.no_pic)
                    .into(getImageView(id));
        }

        public void setDefaultImage(int id) {
            Glide.with(mContext)
                    .load(R.mipmap.no_pic)
                    .placeholder(R.mipmap.no_pic)
                    .error(R.mipmap.no_pic)
                    .into(getImageView(id));
        }


    }
}
