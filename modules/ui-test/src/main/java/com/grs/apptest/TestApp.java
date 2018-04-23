package com.grs.apptest;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.commlibs.base.app.ModuleInitializer;

/**
 * @作者:gaoruishan
 * @时间:2018/1/27/23:50
 * @邮箱:grs0515@163.com
 */

public class TestApp extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		ModuleInitializer.init(this, true, R.drawable.default_icon);
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}
}
