package com.commlibs.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public abstract class SimpleFragmentActivity extends BaseActivity {


	@Override
	public int getContentViewId() {
		return R.layout.activity_fragment_simple;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		FragmentManager fm = this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment v4Fragment = getV4Fragment();
		ft.add(R.id.fragment, v4Fragment, v4Fragment.getTag());
		ft.commit();
	}

	protected abstract android.support.v4.app.Fragment getV4Fragment();
}
