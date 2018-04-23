package com.grs.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.commlibs.base.BaseActivity;
import com.commlibs.utils.common.LogUtil;


public class TestMainActivity extends BaseActivity {

	Button btn;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		f(R.id.btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startBuilder(TestMain2Activity.class).buildExtra(1).build();
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

	//	@OnClick({R,btn})
//	public void clickEvent(View view) {
//		switch (view.getId()) {
//			case btn:
//				startBuilder(TestMain2Activity.class).buildExtra(1).build();
//				break;
//		}
//	}
	@Override
	public int getContentViewId() {
		return R.layout.activity_main_test;
	}
}
