package com.commlibs.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * @作者:gaoruishan
 * @时间:2018/1/25/21:53
 * @邮箱:grs0515@163.com
 */

public class Router {
	/**
	 * 默认的scheme跳转逻辑
	 */
	public static void schemeTo(Context context, String scheme) {
		if (!TextUtils.isEmpty(scheme)) {
			Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
			if (in.resolveActivity(context.getPackageManager()) != null) {
				context.startActivity(in);
			} else {
				Toast.makeText(context, R.string.common_not_install, Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(context, R.string.common_not_install, Toast.LENGTH_SHORT).show();
		}
	}

	public static void startActivityForName(Context context, String name) {
		try {
			Class clazz = Class.forName(name);
			startActivity(context, clazz);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void startActivityForAction(Context context, String action) {
		context.startActivity(new Intent(action));
	}

	public static void startActivity(Context context, Class clazz) {
		context.startActivity(getIntent(context, clazz));
	}

	/**
	 * 获取Intent
	 * @param context
	 * @param clazz
	 * @return
	 */
	private static Intent getIntent(Context context, Class clazz) {
		return new Intent(context, clazz);
	}
}
