package com.grs.appproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.commlibs.base.BaseActivity;


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

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {

	}
}
