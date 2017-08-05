package com.yzyfdf.lifehelper.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jaydenxiao.common.commonutils.GlideRoundTransformUtil;
import com.yzyfdf.lifehelper.R;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ImageUtil {
    public static void setDefaultImage(Context context, ImageView iv) {
        Glide.with(context)
                .load(R.mipmap.no_pic)
                .placeholder(R.mipmap.no_pic)
                .error(R.mipmap.no_pic)
                .into(iv);
    }

    public static void setImage(Context context, ImageView iv, String url) {
        if (TextUtils.isEmpty(url)) {
            setDefaultImage(context, iv);
            return;
        }
        Glide.with(context)
                .load(url)
                .error(R.mipmap.no_pic)
                .placeholder(R.mipmap.no_pic)
                .into(iv);
    }

    public static void setSmallImage(Context context, ImageView iv, String url) {
        if (TextUtils.isEmpty(url)) {
            setDefaultImage(context, iv);
            return;
        }
        Glide.with(context)
                .load(url)
                .error(R.mipmap.no_pic)
                .placeholder(R.mipmap.no_pic)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(iv);
    }

    public static void setBigImage(Context context, ImageView iv, String url) {
        if (TextUtils.isEmpty(url)) {
            setDefaultImage(context, iv);
            return;
        }
        if (url.endsWith("gif")) {
//            Glide.with(context)
//                    .load(url).asGif()
//                    .error(R.mipmap.no_pic)
//                    .placeholder(R.mipmap.no_pic)
//                    .into(iv);
        } else {
            Glide.with(context)
                    .load(url).thumbnail(0.1f)
                    .error(R.mipmap.no_pic)
                    .placeholder(R.mipmap.no_pic)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(iv);
        }

    }

    public static void setRoundImage(Context context, ImageView iv, String url) {
        if (TextUtils.isEmpty(url)) {
            setDefaultImage(context, iv);
            return;
        }
        Glide.with(context).load(url)
                .error(R.drawable.toux2)
                .placeholder(R.mipmap.toux2)
                .centerCrop()
                .transform(new GlideRoundTransformUtil(context))
                .into(iv);

    }
}
