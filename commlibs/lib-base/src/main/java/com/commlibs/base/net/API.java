package com.commlibs.base.net;

import com.commlibs.utils.App;
import com.commlibs.utils.common.LogUtil;

/**
 * 服务器接口
 * @作者:gaoruishan
 * @时间:2018/2/12/11:09
 * @邮箱:grs0515@163.com
 */

public class API {

	/** start linkcook服务器*/
	//测试
	public static final String TEST_SERVER_LINKCOOK = "http://api.haieco.com:8080/";

	//线上
	public static final String OL_SERVER_LINKCOOK = "http://apilinkcook.onehaier.com/";

	public static String getServerLinkcook() {
		String url = App.isDebug() ? TEST_SERVER_LINKCOOK : OL_SERVER_LINKCOOK;
		LogUtil.e(url);
		return url;
	}

}
