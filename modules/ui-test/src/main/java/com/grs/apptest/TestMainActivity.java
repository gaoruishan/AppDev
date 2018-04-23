package com.grs.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.commlibs.base.BaseActivity;
import com.commlibs.utils.App;
import com.commlibs.utils.common.LogUtil;


public class TestMainActivity extends BaseActivity {

	Button btn;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		f(R.id.btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				App.toast("点击了");
				startBuilder(TestListActivity.class).buildExtra(1).build();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void setup(@Nullable Bundle savedInstanceState) {
		super.setup(savedInstanceState);
		LogUtil.e(this.getClass().getSimpleName());

	}

	@Override
	public int getContentViewId() {
		return R.layout.activity_main_test;
	}
}
