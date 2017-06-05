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



public class TimePickerDialog extends Dialog {
    private Activity mContext;
    private int sel_hour, sel_minute;

    public interface onTimePickedListener {
        void onPicked(int hour, int minute);
    }

    public TimePickerDialog(Activity context, final onTimePickedListener listener) {
        super(context);
        mContext = context;
        Calendar mCalendar = Calendar.getInstance();
        sel_hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        sel_minute = mCalendar.get(Calendar.MINUTE);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        getWindow().setWindowAnimations(R.style.AnimBottom);
        View rootView = getLayoutInflater().inflate(R.layout.dialog_time_picker, null);
        int screenWidth = mContext.getWindowManager().getDefaultDisplay().getWidth();
        LayoutParams params = new LayoutParams(screenWidth, LayoutParams.MATCH_PARENT);
        super.setContentView(rootView, params);
        TimePicker time_picker = (TimePicker) findViewById(R.id.time_picker);
        time_picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hour, int minute) {
                sel_hour = hour;
                sel_minute = minute;
            }
        });
        View done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPicked(sel_hour, sel_minute);
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
