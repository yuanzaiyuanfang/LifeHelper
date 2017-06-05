package com.yzyfdf.lifehelper.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.yzyfdf.lifehelper.R;


public class PopupDialog extends Dialog {

	private Context context;//上下文
	private String title;//标题
	private String confirmButtonText;//确定按钮文字
	private String cacelButtonText;//取消按钮文字
	private String content;//内容文本
	private ClickListenerInterface clickListenerInterface;//确定 取消 按钮回调接口

	public interface ClickListenerInterface {

		/**
		 * 确定按钮回调
		 */
		public void doConfirm();

		/**
		 * 取消按钮回调
		 */
		public void doCancel();
	}

	/**
	 * @param context
	 *            上下文
	 * @param title
	 *            标题
	 * @param contentText
	 *            内容
	 * @param confirmButtonText
	 *            确认按钮文字
	 * @param cacelButtonText
	 *            取消按钮文字
	 */
	public PopupDialog(Context context, String title, String contentText, String confirmButtonText,
					   String cacelButtonText) {
		super(context, R.style.DialogStyle3);
		this.context = context;
		this.title = title;
		this.confirmButtonText = confirmButtonText;
		this.cacelButtonText = cacelButtonText;
		this.content = contentText;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}

	/**
	 * 初始化
	 */
	public void init() {
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.dialog_popup, null);
		setContentView(view);

		TextView tvTitle = (TextView) view.findViewById(R.id.title);
		TextView tvConfirm = (TextView) view.findViewById(R.id.confirm);
		TextView tvCancel = (TextView) view.findViewById(R.id.cancel);
		TextView txt_content = (TextView) view.findViewById(R.id.txt_content);

		txt_content.setText(content);
		
		if (confirmButtonText != null && !confirmButtonText.equals("")) {
			tvConfirm.setText(confirmButtonText);
		}
		if (title != null && !title.equals("")) {
			tvTitle.setText(title);
			tvTitle.setVisibility(View.VISIBLE);
		}
		if (cacelButtonText != null && !cacelButtonText.equals("")) {
			tvCancel.setText(cacelButtonText);
			tvCancel.setVisibility(View.VISIBLE);
		}

		tvConfirm.setOnClickListener(new clickListener());
		tvCancel.setOnClickListener(new clickListener());

		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
		lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.6
		dialogWindow.setAttributes(lp);
	}

	public void setClicklistener(ClickListenerInterface clickListenerInterface) {
		this.clickListenerInterface = clickListenerInterface;
	}

	private class clickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id) {
				case R.id.confirm:
					clickListenerInterface.doConfirm();
					break;
				case R.id.cancel:
					clickListenerInterface.doCancel();
					break;
			}
		}
	}
}
