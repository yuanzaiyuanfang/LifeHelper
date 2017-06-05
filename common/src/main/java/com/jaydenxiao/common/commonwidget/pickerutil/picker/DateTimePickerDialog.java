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

import java.util.Calendar;




public class DateTimePickerDialog extends Dialog {
    private Activity mContext;
    private int sel_year, sel_month, sel_day, sel_hour, sel_minute;

    public interface onDateTimePickedListener {
        void onPicked(int year, int monthOfYear, int dayOfMonth, int hour, int minute);
    }

    public DateTimePickerDialog(Activity context, final onDateTimePickedListener listener) {
        super(context);
        mContext = context;
        Calendar mCalendar = Calendar.getInstance();
        sel_year = mCalendar.get(Calendar.YEAR);
        sel_month = mCalendar.get(Calendar.MONTH) + 1;
        sel_day = mCalendar.get(Calendar.DAY_OF_MONTH);
        sel_hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        sel_minute = mCalendar.get(Calendar.MINUTE);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        getWindow().setWindowAnimations(R.style.AnimBottom);
        View rootView = getLayoutInflater().inflate(R.layout.dialog_date_time_picker, null);
        int screenWidth = mContext.getWindowManager().getDefaultDisplay().getWidth();
        LayoutParams params = new LayoutParams(screenWidth, LayoutParams.MATCH_PARENT);
        super.setContentView(rootView, params);
        DateTimePicker date_time_picker = (DateTimePicker) findViewById(R.id.date_time_picker);
        date_time_picker.setOnDateTimeChangedListener(new DateTimePicker.OnDateTimeChangedListener() {
            @Override
            public void onDateTimeChanged(DateTimePicker view, int year, int monthOfYear, int dayOfMonth, int hour, int minute) {
                sel_year = year;
                sel_month = monthOfYear;
                sel_day = dayOfMonth;
                sel_hour = hour;
                sel_minute = minute;
            }
        });
        View done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPicked(sel_year, sel_month, sel_day, sel_hour, sel_minute);
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
}
