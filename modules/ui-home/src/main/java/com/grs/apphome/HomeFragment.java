package com.grs.apphome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.commlibs.base.adapter.RecyclerAdapter;
import com.commlibs.base.annotations.AnnotionProcessor;
import com.commlibs.base.annotations.Autowired;
import com.commlibs.base.list.SupportRecyclerFragment;
import com.commlibs.utils.common.ToastUtil;
import com.grs.apphome.adapter.InfoFlowAdapter;
import com.grs.home.bean.NewContent;
import com.grs.home.presenter.NewContentPresenter;
import com.grs.home.view.INewContentView;
import com.lib.common.center.constants.ConstHome;

/**
 * @作者:gaoruishan
 * @时间:2018/5/9/11:14
 * @邮箱:grs0515@163.com
 */
public class HomeFragment extends SupportRecyclerFragment<NewContent.ResultsBean> implements INewContentView {

	@Autowired
	private NewContentPresenter mPresenter;

	public HomeFragment() {
		AnnotionProcessor.of(this);
	}

	public static Fragment getInstance(String param1) {
		Fragment fragment = new HomeFragment();
		Bundle args = new Bundle();
		args.putString(ConstHome.ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_home;
	}

	@Override
	protected void onCreateFragment(View rootView, @Nullable Bundle savedInstance) {
		super.onCreateFragment(rootView, savedInstance);
		newData();//加载数据
	}

	@Override
	public RecyclerAdapter<NewContent.ResultsBean> generateAdapter() {
		return new InfoFlowAdapter();
	}

	@Override
	public void onNewContentList(NewContent content, boolean isCache) {
		reportIsCache(isCache);
		onSuccess(content.getPageCount(), content.getResults());
	}

	@Override
	public void onNewContentEmpty(boolean isCache) {
		reportIsCache(isCache);
	}

	@Override
	public void onNewContentFailed(String msg) {
		ToastUtil.showShort(msg);
	}

	@Override
	public void request() {
		mPresenter.getNewContent(-1, 0, "917420171108111147", 0, getCurrentPage(), 20);
	}

	@Override
	public String getIdentifier() {
		return null;
	}
}
