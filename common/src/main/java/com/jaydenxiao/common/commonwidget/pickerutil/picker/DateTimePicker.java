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



public class DateTimePicker extends LinearLayout implements NumberPicker.OnValueChangeListener, NumberPicker.Formatter {
    private QNumberPicker mHourPicker;
    private QNumberPicker mMinutePicker;
    private QNumberPicker mYearPicker;
    private QNumberPicker mMonthPicker;
    private QNumberPicker mDayOfMonthPicker;
    private Calendar mCalendar;
    private OnDateTimeChangedListener mOnDateTimeChangedListener;
    private LayoutInflater mLayoutInflater;

    public DateTimePicker(Context context) {
        this(context, null);
    }

    public DateTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        init();
    }

    private void init() {
        mCalendar = Calendar.getInstance();
        mLayoutInflater.inflate(R.layout.view_date_time_picker, this, true);
        mYearPicker = (QNumberPicker) findViewById(R.id.picker_year);
        mMonthPicker = (QNumberPicker) findViewById(R.id.picker_month);
        mDayOfMonthPicker = (QNumberPicker) findViewById(R.id.picker_day);
        mHourPicker = (QNumberPicker) findViewById(R.id.picker_hour);
        mMinutePicker = (QNumberPicker) findViewById(R.id.picker_minute);
        mYearPicker.setOnValueChangedListener(this);
        mMonthPicker.setOnValueChangedListener(this);
        mDayOfMonthPicker.setOnValueChangedListener(this);
        mHourPicker.setOnValueChangedListener(this);
        mMinutePicker.setOnValueChangedListener(this);
        mYearPicker.setFormatter(this);
        mMonthPicker.setFormatter(this);
        mDayOfMonthPicker.setFormatter(this);
        mHourPicker.setFormatter(this);
        mMinutePicker.setFormatter(this);
        mYearPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);// 禁止点击后打开键盘
        mMonthPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        mDayOfMonthPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        mHourPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);// 禁止点击后打开键盘
        mMinutePicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        mYearPicker.setMaxValue(2100);//设置最大值
        mYearPicker.setMinValue(1900);//设置最小值
        mMonthPicker.setMaxValue(12);
        mMonthPicker.setMinValue(1);
        mHourPicker.setMaxValue(23);
        mHourPicker.setMinValue(0);
        mMinutePicker.setMaxValue(59);
        mMinutePicker.setMinValue(0);
        mDayOfMonthPicker.setMaxValue(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        mDayOfMonthPicker.setMinValue(1);

        setDate(mCalendar.getTime());
    }

    public DateTimePicker setDate(Date date) {
        mCalendar.setTime(date);
        mYearPicker.setValue(mCalendar.get(Calendar.YEAR));
        mMonthPicker.setValue(mCalendar.get(Calendar.MONTH) + 1);
        mHourPicker.setValue(mCalendar.get(Calendar.HOUR_OF_DAY));
        mMinutePicker.setValue(mCalendar.get(Calendar.MINUTE));
        mDayOfMonthPicker.setValue(mCalendar.get(Calendar.DAY_OF_MONTH));
        setNumberPickerDividerColor(mYearPicker);
        setNumberPickerDividerColor(mMonthPicker);
        setNumberPickerDividerColor(mDayOfMonthPicker);
        setNumberPickerDividerColor(mHourPicker);
        setNumberPickerDividerColor(mMinutePicker);
        return this;
    }

    @Override
    public void onValueChange(final NumberPicker picker, final int oldVal, final int newVal) {
        if (picker == mYearPicker) {
            mCalendar.set(Calendar.YEAR, newVal);
            mDayOfMonthPicker.setMaxValue(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            if (mDayOfMonthPicker.getValue() > mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                mDayOfMonthPicker.setValue(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                invalidate();
            }
        } else if (picker == mMonthPicker) {
            mCalendar.set(Calendar.MONTH, newVal - 1);
            mDayOfMonthPicker.setMaxValue(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            if (mDayOfMonthPicker.getValue() > mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                mDayOfMonthPicker.setValue(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                invalidate();
            }
        } else if (picker == mDayOfMonthPicker) {
            mCalendar.set(Calendar.DAY_OF_MONTH, newVal);
        }else if (picker == mHourPicker) {
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

    public interface OnDateTimeChangedListener {
        void onDateTimeChanged(DateTimePicker view, int year, int monthOfYear, int dayOfMonth, int hour, int minute);
    }

    public DateTimePicker setOnDateTimeChangedListener(OnDateTimeChangedListener l) {
        mOnDateTimeChangedListener = l;
        return this;
    }

    private void notifyDateChanged() {
        if (mOnDateTimeChangedListener != null) {
            mOnDateTimeChangedListener.onDateTimeChanged(this, getYear(), getMonth(), getDayOfMonth(), getHour(), getMinute());
        }
    }

    public int getYear() {
        return mCalendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        return mCalendar.get(Calendar.MONTH) + 1;
    }

    public int getDayOfMonth() {
        return mCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getHour() {
        return mCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return mCalendar.get(Calendar.MINUTE);
    }

    private void setNumberPickerDividerColor(QNumberPicker numberPicker) {
        NumberPicker picker = numberPicker;
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try {
                    //设置分割线的颜色值
                    pf.set(picker, new ColorDrawable(this.getResources().getColor(R.color.transparent)));
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
