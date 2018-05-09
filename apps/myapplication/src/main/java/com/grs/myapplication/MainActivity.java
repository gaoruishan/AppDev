package com.grs.myapplication;

import android.os.Bundle;

import com.commlibs.base.BaseActivity;
import com.grs.myapplication.view.IBottomNavigationView;
import com.grs.myapplication.view.XBottomNavigationView;

public class MainActivity extends BaseActivity implements IBottomNavigationView {

	@Override
	public int getContentViewId() {
		return R.layout.activity_main;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		XBottomNavigationView mBottomNavigationView = f(R.id.bottom_navigation_view);
		mBottomNavigationView.disableShiftMode();
		mBottomNavigationView.setIBottomNavigationViewListener(this);
		mBottomNavigationView.initFragment(getSupportFragmentManager());
	}


	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {

	}

	@Override
	public void switchMainPager() {

	}

	@Override
	public void switchKnowledgeHierarchy() {

	}

	@Override
	public void switchNavigation() {

	}

	@Override
	public void switchProject() {

	}
}
