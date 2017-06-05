package com.jaydenxiao.common.commonwidget.pickerutil.picker;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.jaydenxiao.common.R;
import com.jaydenxiao.common.commonwidget.pickerutil.components.wheel.OnWheelChangedListener;
import com.jaydenxiao.common.commonwidget.pickerutil.components.wheel.OnWheelClickedListener;
import com.jaydenxiao.common.commonwidget.pickerutil.components.wheel.WheelView;
import com.jaydenxiao.common.commonwidget.pickerutil.components.wheel.adapter.AbstractWheelTextAdapter;

import java.util.ArrayList;
import java.util.List;

public class PickerDialog extends Dialog {

    private final static int DEFAULT_ITEMS = 5;
    private final static int DEFAULT_POSITION = 0;
    private Activity mContext;

    private List<String> list = new ArrayList<>();
    AbstractWheelTextAdapter pickerAdapter;
    WheelView wheel;


    public static interface onPickedListener {
        abstract void onPicked(String result);
    }

    public PickerDialog(Activity context, final List<String> listArray, final onPickedListener listener) {
        super(context);
        mContext = context;
        this.list.addAll(listArray);
        initDialog(list, DEFAULT_POSITION, listener);
    }

    public PickerDialog(Activity context, final String[] listArray, final onPickedListener listener) {
        super(context);
        mContext = context;
        for (String item : listArray) {
            list.add(item);
        }
        initDialog(list, DEFAULT_POSITION, listener);
    }

    public PickerDialog(Activity context, final List<String> listArray, int defaultPosition, final onPickedListener listener) {
        super(context);
        mContext = context;
        this.list.addAll(listArray);
        initDialog(list, defaultPosition, listener);
    }

    private void initDialog(final List<String> list, int defaultPosition, final onPickedListener listener) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        getWindow().setWindowAnimations(R.style.AnimBottom);
        View rootView = getLayoutInflater().inflate(R.layout.dialog_picker, null);
        int screenWidth = mContext.getWindowManager().getDefaultDisplay().getWidth();
        LayoutParams params = new LayoutParams(screenWidth, LayoutParams.MATCH_PARENT);
        super.setContentView(rootView, params);
        initViews();

        setDefaultArea(defaultPosition);

        View done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    String result = list.size() > 0 ? list.get(wheel.getCurrentItem()) : null;
                    listener.onPicked(result);
                }
                dismiss();
            }
        });

        View cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void setDefaultArea(int defalutPosition) {

        wheel.setCurrentItem(defalutPosition, false);

    }

    private void initViews() {

        wheel = (WheelView) findViewById(R.id.wheel);

        pickerAdapter = new AbstractWheelTextAdapter(mContext, R.layout.wheel_text) {

            @Override
            public int getItemsCount() {

                return list.size();
            }

            @Override
            protected CharSequence getItemText(int index) {

                return list.get(index);
            }
        };

        wheel.setViewAdapter(pickerAdapter);
        wheel.setCyclic(false);
        wheel.setVisibleItems(DEFAULT_ITEMS);

        OnWheelClickedListener clickListener = new OnWheelClickedListener() {

            @Override
            public void onItemClicked(WheelView wheel, int itemIndex) {
                if (itemIndex != wheel.getCurrentItem()) {
                    wheel.setCurrentItem(itemIndex, true, 500);
                }
            }
        };

        wheel.addClickingListener(clickListener);

        wheel.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // null
            }
        });
    }
}
