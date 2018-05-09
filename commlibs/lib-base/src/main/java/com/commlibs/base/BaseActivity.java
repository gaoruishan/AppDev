package com.commlibs.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.commlibs.base.mvp.PresenterHelper;
import com.commlibs.libwidget.ActionBar;
import com.commlibs.utils.helper.AppManager;
import com.commlibs.utils.helper.IntentHelper;
import com.commlibs.utils.helper.ViewHelper;

/**
 * 这是一个基类
 * @作者:gaoruishan
 * @时间:2018/2/2/10:18
 * @邮箱:grs0515@163.com
 */

public abstract class BaseActivity extends AppCompatActivity {

	protected String TAG = BaseActivity.class.getSimpleName();
	protected long mCurrentMs = System.currentTimeMillis();
	protected Context mContext;
	protected ActionBar mActionBar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		TAG = this.getClass().getSimpleName();
		setContentView(getContentViewId());
		AppManager.add(this);
		onCreateActivity(savedInstanceState);
	}

	/**
	 * 重写填充视图
	 * @param layoutResID
	 */
	@Override
	public void setContentView(@LayoutRes int layoutResID) {
		if (isOpenActionBar()) {//打开ActionBar
			View view = getLayoutInflater().inflate(R.layout.activity_base_layout, null);
			view.setFitsSystemWindows(true);
			super.setContentView(view);
			FrameLayout mContentContainer = (FrameLayout) view.findViewById(R.id.content_container);
			View childView = getLayoutInflater().inflate(layoutResID, null);
			mContentContainer.addView(childView);
			mActionBar = (ActionBar) view.findViewById(R.id.action_bar);
			mActionBar.initDefaultActionBar(this);
		} else {
			super.setContentView(layoutResID);
		}

	}

	@Override
	protected void onDestroy() {
		PresenterHelper.onDestoryed(this, BaseActivity.class);
		AppManager.remove(this);
		super.onDestroy();
	}

	/**
	 * 获取setContentView布局
	 * @return
	 */
	public abstract int getContentViewId();

	/**
	 * 一般重写,进行初始设置
	 * @param savedInstanceState
	 */
	public abstract void onCreateActivity(Bundle savedInstanceState);
	/**
	 * 是否打开带ActionBar
	 * @return
	 */
	protected boolean isOpenActionBar() {
		return false;
	}

	/**
	 * 提供findViewById
	 * @param resId
	 * @param <T>
	 * @return
	 */
	protected final <T extends View> T f(@IdRes int resId) {
		return ViewHelper.f(this, resId);
	}

	@Override
	public void finish() {
		hideSoftKeyboard();
		super.finish();
		AppManager.remove(this);
	}

	/**
	 * 隐藏软键盘
	 */
	protected void hideSoftKeyboard() {
		if (getCurrentFocus() != null) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	/**
	 * Activity事件跳转
	 * 注意:startBuilder(Class<?> cls)方法 和 build()方法联合使用
	 * @param cls
	 * @return
	 */
	public IntentHelper startBuilder(Class<?> cls) {
		IntentHelper builder = getBuilder();
		builder.start(this, cls);
		return builder;
	}

	//获取IntentHelper
	public IntentHelper getBuilder() {
		return IntentHelper.get();
	}

	//全类名
	public void startActivityForName(String name) {
		try {
			Class clazz = Class.forName(name);
			startActivity(clazz);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	//Class类
	public void startActivity(Class clazz) {
		startActivity(new Intent(this, clazz));
	}

	//action
	public void startActivity(String action) {
		startActivity(new Intent(action));
	}

	//唯一ID
	public String getIdentifier() {
		return this.getClass().getName() + this.mCurrentMs;
	}
}
