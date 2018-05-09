package com.grs.appknowlege;

import android.support.v4.app.Fragment;

import com.commlibs.base.SimpleFragmentActivity;
import com.grs.appknowlege.fragment.KnowlegdeFragment;


public class KnowledgeActivity extends SimpleFragmentActivity {

	@Override
	protected Fragment getV4Fragment() {
		return KnowlegdeFragment.getInstance(null);
	}
}
