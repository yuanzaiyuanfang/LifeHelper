package com.jaydenxiao.common.commonwidget.pickerutil.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.jaydenxiao.common.R;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;


public class TimePicker extends LinearLayout implements NumberPicker.OnValueChangeListener, NumberPicker.Formatter {
    private QNumberPicker mHourPicker;
    private QNumberPicker mMinutePicker;
    private Calendar mCalendar;
    private OnTimeChangedListener mOnTimeChangedListener;
    private LayoutInflater mLayoutInflater;

    public TimePicker(Context context) {
        this(context, null);
    }

    public TimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        init();
    }

    private void init() {
        mLayoutInflater.inflate(R.layout.view_time_picker, this, true);
        mHourPicker = (QNumberPicker) findViewById(R.id.picker_hour);
        mMinutePicker = (QNumberPicker) findViewById(R.id.picker_minute);
        mHourPicker.setOnValueChangedListener(this);
        mMinutePicker.setOnValueChangedListener(this);
        mHourPicker.setFormatter(this);
        mMinutePicker.setFormatter(this);
        mHourPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);// 禁止点击后打开键盘
        mMinutePicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        mHourPicker.setMaxValue(23);
        mHourPicker.setMinValue(0);
        mMinutePicker.setMaxValue(59);
        mMinutePicker.setMinValue(0);
        mCalendar = Calendar.getInstance();
        setDate(mCalendar.getTime());
    }

    public TimePicker setDate(Date date) {
        mCalendar.setTime(date);
        mHourPicker.setValue(mCalendar.get(Calendar.HOUR_OF_DAY));
        mMinutePicker.setValue(mCalendar.get(Calendar.MINUTE));
        setNumberPickerDividerColor(mHourPicker);
        setNumberPickerDividerColor(mMinutePicker);
        return this;
    }

    @Override
    public void onValueChange(final NumberPicker picker, final int oldVal, final int newVal) {
        if (picker == mHourPicker) {
            mCalendar.set(Calendar.HOUR_OF_DAY, newVal);
        } else if (picker == mMinutePicker) {
            mCalendar.set(Calendar.MINUTE, newVal);
        }
        notifyDateChanged();
    }

    @Override
    public String format(int value) {
        String tmpStr = String.valueOf(value);
        if (value < 10) {
            tmpStr = "0" + tmpStr;
        }
        return tmpStr;
    }

    public interface OnTimeChangedListener {
        void onTimeChanged(TimePicker view, int hour, int minute);
    }

    public TimePicker setOnTimeChangedListener(OnTimeChangedListener l) {
        mOnTimeChangedListener = l;
        return this;
    }

    private void notifyDateChanged() {
        if (mOnTimeChangedListener != null) {
            mOnTimeChangedListener.onTimeChanged(this, getHour(), getMinute());
        }
    }

    public int getHour() {
        return mCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return mCalendar.get(Calendar.MINUTE);
    }

    private void setNumberPickerDividerColor(NumberPicker numberPicker) {
        NumberPicker picker = numberPicker;
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try {
                    //设置分割线的颜色值
                    pf.set(picker, new ColorDrawable(this.getResources().getColor(R.color.item_333333)));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
