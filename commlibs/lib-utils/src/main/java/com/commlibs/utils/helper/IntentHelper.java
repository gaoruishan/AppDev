package com.commlibs.utils.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import java.util.ArrayList;

import static com.commlibs.utils.common.Constant.EXTRA_DATA_INT;
import static com.commlibs.utils.common.Constant.EXTRA_DATA_OBJECT;
import static com.commlibs.utils.common.Constant.EXTRA_DATA_OBJECT_LIST;
import static com.commlibs.utils.common.Constant.EXTRA_DATA_STRING;

/**
 * @作者:gaoruishan
 * @时间:2018/2/2/15:13
 * @邮箱:grs0515@163.com
 */

public class IntentHelper {

	//当前事件
	private Intent intent;
	private Context mActivity;
	//单例
	private static volatile IntentHelper intentHelper;
	//
	public static IntentHelper get() {
		if (intentHelper == null) {
			synchronized (IntentHelper.class) {
				if (intentHelper == null) {
					intentHelper = new IntentHelper();
				}
			}
		}
		return intentHelper;
	}

	private IntentHelper() {
	}

	/**
	 * 注意:startBuilder(Class<?> cls)方法 和 build()方法联合使用
	 * @param cls
	 * @return
	 */
	public IntentHelper start(Context activity, Class<?> cls) {
		if (activity != null) {
			this.mActivity = activity;
			intent = new Intent(activity, cls);
		}
		return this;
	}

	public IntentHelper buildExtra(int data) {
		if (intent != null) {
			intent.putExtra(EXTRA_DATA_INT, data);
		}
		return this;
	}

	public IntentHelper buildExtra(String data) {
		if (intent != null) {
			intent.putExtra(EXTRA_DATA_STRING, data);
		}
		return this;
	}

	public IntentHelper buildExtra(Parcelable data) {
		if (intent != null) {
			intent.putExtra(EXTRA_DATA_OBJECT, data);
		}
		return this;
	}

	public IntentHelper buildExtra(ArrayList<? extends Parcelable> data) {
		if (intent != null) {
			intent.putExtra(EXTRA_DATA_OBJECT_LIST, data);
		}
		return this;
	}

	public IntentHelper build() {
		if (intent != null && mActivity != null) {
			mActivity.startActivity(intent);
		}
		return this;
	}

	public String getStringExtra(Activity activity) {
		if (activity != null && activity.getIntent() != null) {
			return activity.getIntent().getStringExtra(EXTRA_DATA_STRING);
		}
		return null;
	}

	public int getIntExtra(Activity activity) {
		if (activity != null && activity.getIntent() != null) {
			return activity.getIntent().getIntExtra(EXTRA_DATA_INT, -1);
		}
		return -1;
	}

	public <T extends Parcelable> T getParcelableExtra(Activity activity, Class<T> t) {
		if (activity != null && activity.getIntent() != null) {
			return activity.getIntent().getParcelableExtra(EXTRA_DATA_OBJECT);
		}
		return null;
	}

	public <T extends Parcelable> ArrayList<T> getParcelableListExtra(Activity activity, Class<T> t) {
		if (activity != null && activity.getIntent() != null) {
			return activity.getIntent().getParcelableArrayListExtra(EXTRA_DATA_OBJECT_LIST);
		}
		return null;
	}

	/**
	 * 基本跳转
	 * @param activity
	 * @param cls
	 */
	public void startActivity(Activity activity, Class<?> cls) {
		Intent intent = new Intent(activity, cls);
		activity.startActivity(intent);
	}

}
