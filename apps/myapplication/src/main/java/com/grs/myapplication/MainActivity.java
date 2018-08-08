package com.grs.myapplication;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.commlibs.base.BaseActivity;
import com.commlibs.utils.util.StatusBarUtil;
import com.grs.myapplication.view.IBottomNavigationView;
import com.grs.myapplication.view.XBottomNavigationView;

public class MainActivity extends BaseActivity implements IBottomNavigationView {

	private TextView mTitleTv;

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

		Toolbar mToolbar = f(R.id.common_toolbar);
		mToolbar.setNavigationIcon(null);//隐藏
		//设置
		setSupportActionBar(mToolbar);
		ActionBar actionBar = getSupportActionBar();
		assert actionBar != null;
		actionBar.setDisplayShowTitleEnabled(false);

		mTitleTv = f(R.id.common_toolbar_title_tv);
		mTitleTv.setText(getString(R.string.home_pager));
		StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.main_status_bar_blue), 1f);

	}


	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {

	}

	@Override
	public void switchMainPager() {
		mTitleTv.setText(getString(R.string.home_pager));
	}

	@Override
	public void switchKnowledgeHierarchy() {
		mTitleTv.setText(getString(R.string.knowledge_hierarchy));
	}

	@Override
	public void switchNavigation() {
		mTitleTv.setText(getString(R.string.navigation));
	}

	@Override
	public void switchProject() {
		mTitleTv.setText(getString(R.string.project));
	}
}
