package com.grs.appnavigation;

import android.app.Application;

import com.commlibs.utils.common.LogUtil;

/**
 * @作者:gaoruishan
 * @时间:2018/1/27/23:50
 * @邮箱:grs0515@163.com
 */

public class TestApp extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		LogUtil.e(TestApp.class.getSimpleName());
	}
}
