package com.yzyfdf.lifehelper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jaydenxiao.common.commonutils.NetWorkUtils;
import com.yzyfdf.lifehelper.R;


public class ErrorLayout extends FrameLayout {

	private LayoutInflater inflater;

	private Context context;
	private FrameLayout error_view;

	private LinearLayout error_linearlayout;

	public ErrorLayout(Context context) {
		super(context, null);
	}

	public ErrorLayout(Context context, AttributeSet attr) {
		super(context, attr);
		this.context = context;
		init();
	}

	private void init() {
		inflater = LayoutInflater.from(context);
		error_view = (FrameLayout) inflater.inflate(R.layout.layout_error, this, false);
		error_linearlayout = (LinearLayout) error_view.findViewById(R.id.error_linearlayout);
		addView(error_view);
	}

	public void viewListener(final CallClickListener call) {

		error_linearlayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (NetWorkUtils.isNetConnected(context)) {
					call.callListener();
				} else {
					Toast.makeText(context, "网络出错,请稍后重试", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	public interface CallClickListener {
		void callListener();
	}

}
