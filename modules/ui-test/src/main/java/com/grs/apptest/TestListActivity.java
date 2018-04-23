package com.grs.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.commlibs.base.adapter.RecyclerAdapter;
import com.commlibs.base.annotations.AnnotionProcessor;
import com.commlibs.base.annotations.Autowired;
import com.commlibs.base.list.SupportRecyclerActivity;
import com.commlibs.utils.common.LogUtil;
import com.commlibs.utils.common.ToastUtil;
import com.grs.apptest.adapter.InfoFlowAdapter;
import com.grs.test.bean.NewContent;
import com.grs.test.presenter.NewContentPresenter;
import com.grs.test.view.INewContentView;

public class TestListActivity extends SupportRecyclerActivity<NewContent.ResultsBean> implements INewContentView {

	@Autowired
	private NewContentPresenter mPresenter;

	public TestListActivity() {
		AnnotionProcessor.of(this);
	}

	@Override
	protected void setup(@Nullable Bundle savedInstanceState) {
		super.setup(savedInstanceState);
		int intExtra = getBuilder().getIntExtra(this);
		LogUtil.e(intExtra);
		newData();//加载数据
	}

	@Override
	public boolean isOpenActionBar() {
		return true;
	}

	@Override
	public int getContentViewId() {
		return R.layout.activity_test_list;
	}

	@Override
	public void request() {
		mPresenter.getNewContent(-1, 0, "917420171108111147", 0, getCurrentPage(), 20);
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

}
