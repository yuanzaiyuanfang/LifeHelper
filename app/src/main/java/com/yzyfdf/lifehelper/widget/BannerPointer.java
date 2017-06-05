package com.yzyfdf.lifehelper.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.utils.SizeUtils;
import com.yzyfdf.lifehelper.R;


/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class BannerPointer extends RadioGroup {
    private Context mContext;
    private int     mSize;

    public BannerPointer(Context context) {
        this(context,null);
        mContext = context;

    }

    public BannerPointer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }



    private void initView() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.BOTTOM;
        setLayoutParams(layoutParams);

        setGravity(Gravity.CENTER);
        setOrientation(HORIZONTAL);
        int left = SizeUtils.dp2px(5);
        setPadding(left, left, left, left);


    }

    private void addDots(int size) {
        int r = SizeUtils.dp2px(10);
        for (int i = 0; i < size; i++) {
            RadioButton dot = new RadioButton(mContext);
            Bitmap a = null;
            dot.setButtonDrawable(new BitmapDrawable(a));
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(r, r);
            dot.setBackgroundResource(R.drawable.dot_bg);
            dot.setId(i);
            if (i == size - 1) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, 0, r, 0);
            }
            dot.setLayoutParams(layoutParams);
            addView(dot);
        }
        check(0);
        invalidate();
    }

    public void setSize(int size) {
        addDots(size);
        mSize = size;
    }

}
