package com.grs.appknowlege;

import com.commlibs.base.app.CommApplication;
import com.commlibs.utils.common.LogUtil;

/**
 * @作者:gaoruishan
 * @时间:2018/1/27/23:50
 * @邮箱:grs0515@163.com
 */

public class KnowledgeApp extends CommApplication {
	@Override
	public void onCreate() {
		super.onCreate();
		LogUtil.e(KnowledgeApp.class.getSimpleName());
	}
}
