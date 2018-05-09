package com.grs.appproject;

import android.os.Bundle;

import com.commlibs.base.BaseActivity;
import com.commlibs.utils.common.LogUtil;

public class TestMain2Activity extends BaseActivity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int intExtra = getBuilder().getIntExtra(this);
		LogUtil.e(intExtra);
	}

	@Override
	public int getContentViewId() {
		return R.layout.activity_test_main2;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {

	}
}
