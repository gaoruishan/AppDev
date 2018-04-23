package com.commlibs.base;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.commlibs.utils.common.LogUtil;
import com.commlibs.utils.helper.IntentHelper;
import com.commlibs.utils.helper.ViewHelper;

/**
 * @作者:gaoruishan
 * @时间:2018/2/5/21:14
 * @邮箱:grs0515@163.com
 */

public abstract class BaseFragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(getLayoutId(), container, false);
		setup(rootView, savedInstanceState);
		return rootView;
	}

	protected abstract int getLayoutId();


	protected void setup(View rootView, @Nullable Bundle savedInstanceState) {

	}

	protected <T extends View> T f(View rootView, @IdRes int resId) {
		return ViewHelper.f(rootView, resId);
	}

	/**
	 * Activity事件跳转
	 * 注意:startBuilder(Class<?> cls)方法 和 build()方法联合使用
	 * @param cls
	 * @return
	 */
	public IntentHelper startBuilder(Class<?> cls) {
		IntentHelper builder = getBuilder();
		builder.start(this.getActivity(), cls);
		return builder;
	}

	//获取IntentHelper
	public IntentHelper getBuilder() {
		return IntentHelper.get();
	}

	//action
	public void startActivity(String action) {
		startActivity(new Intent(action));
	}

	//Class类
	public void startActivity(Class clazz) {
		startActivity(new Intent(this.getActivity(), clazz));
	}

	@Override
	public void startActivity(Intent intent) {
		try {
			super.startActivity(intent);
		} catch (ActivityNotFoundException e) {
			LogUtil.e("Activity", "No Activity found to handle intent " + intent);
		}
	}
}
