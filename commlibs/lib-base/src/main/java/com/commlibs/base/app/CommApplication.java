package com.commlibs.base.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.commlibs.base.R;

/**
 * @作者:gaoruishan
 * @时间:2018/5/9/10:04
 * @邮箱:grs0515@163.com
 */
public class CommApplication extends Application{
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
