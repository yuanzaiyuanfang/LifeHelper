package com.jaydenxiao.common.commonwidget.pickerutil.picker;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.jaydenxiao.common.R;

import java.util.Calendar;




public class DatePickerDialog extends Dialog {
    private Activity mContext;
    private int sel_year, sel_month, sel_day;

    public interface onDatePickedListener {
        void onPicked(int year, int monthOfYear, int dayOfMonth);
    }

    public DatePickerDialog(Activity context, String midStr, final View.OnClickListener midClick, final onDatePickedListener listener) {
        super(context);
        mContext = context;
        Calendar mCalendar = Calendar.getInstance();
        sel_year = mCalendar.get(Calendar.YEAR);
        sel_month = mCalendar.get(Calendar.MONTH) + 1;
        sel_day = mCalendar.get(Calendar.DAY_OF_MONTH);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        getWindow().setWindowAnimations(R.style.AnimBottom);
        View rootView = getLayoutInflater().inflate(R.layout.dialog_date_picker, null);
        int screenWidth = mContext.getWindowManager().getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(screenWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        super.setContentView(rootView, params);
        DatePicker date_picker = (DatePicker) findViewById(R.id.date_picker);
        date_picker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                sel_year = year;
                sel_month = monthOfYear;
                sel_day = dayOfMonth;
            }
        });
        View done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPicked(sel_year, sel_month, sel_day);
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

        if (!"".equals(midStr) && midClick != null) {
            TextView midBtn = (TextView) findViewById(R.id.midBtn);
            midBtn.setText(midStr);
            midBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dismiss();
                    midClick.onClick(v);
                }
            });
        }
    }

    public DatePickerDialog(Activity context, final onDatePickedListener listener) {
        this(context, "", null, listener);
    }
}
