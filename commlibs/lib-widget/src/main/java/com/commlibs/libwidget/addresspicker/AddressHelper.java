package com.commlibs.libwidget.addresspicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @作者:gaoruishan
 * @时间:2018/8/7/18:06
 * @邮箱:grs0515@163.com
 */
public class AddressHelper {

	public static void showDialog(Context context, AddressPickerView.ISelectAddressListener listener) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		AddressPickerView view = new AddressPickerView(context);
		builder.setCustomTitle(view);
		builder.setCancelable(true);
		final AlertDialog dialog = builder.show();
		view.setSelectAddressListener(listener);
		Window window = dialog.getWindow();
		window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
		WindowManager.LayoutParams layoutParams = window.getAttributes();
		layoutParams.gravity = Gravity.BOTTOM;
		layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
		window.setAttributes(layoutParams);
	}

}
