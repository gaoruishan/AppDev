package com.grs.apphome;

import android.support.v4.app.Fragment;

import com.commlibs.base.SimpleFragmentActivity;


public class HomeActivity extends SimpleFragmentActivity {

	@Override
	protected Fragment getV4Fragment() {
		return HomeFragment.getInstance(null);
	}

}
