package com.grs.appknowlege.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.commlibs.base.BaseFragment;
import com.commlibs.base.adapter.XBaseAdapter;
import com.commlibs.base.adapter.XViewHolder;
import com.commlibs.base.annotations.AnnotionProcessor;
import com.commlibs.base.annotations.Autowired;
import com.grs.appknowlege.R;
import com.grs.knowledge.bean.KnowledgeTreeBean;
import com.grs.knowledge.presenter.KnowledgePresenter;
import com.grs.knowledge.view.IKnowledgeView;
import com.lib.common.center.constants.ConstHome;

import java.util.List;

/**
 * @作者:gaoruishan
 * @时间:2018/5/9/15:19
 * @邮箱:grs0515@163.com
 */
public class KnowlegdeFragment extends BaseFragment implements IKnowledgeView {

	@Autowired
	private KnowledgePresenter mPresenter;
	private ListView listView;


	public KnowlegdeFragment() {
		AnnotionProcessor.of(this);
	}

	public static Fragment getInstance(String param1) {
		Fragment fragment = new KnowlegdeFragment();
		Bundle args = new Bundle();
		args.putString(ConstHome.ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_knowlegde;
	}

	@Override
	protected void onCreateFragment(View rootView, @Nullable Bundle savedInstanceState) {
		mPresenter.getKnowledgeTree();
		listView = f(rootView, R.id.list);
	}

	@Override
	public void onKnowledgeList(List<KnowledgeTreeBean> content, boolean isCache) {
		listView.setAdapter(new XBaseAdapter<KnowledgeTreeBean>(getActivity(),content,R.layout.list_item){

			@Override
			public void convert(XViewHolder holder, KnowledgeTreeBean knowledgeTreeBean) {
				holder.setText(R.id.tv_item, knowledgeTreeBean.getName());
			}
		});
	}

	@Override
	public void onKnowledgeEmpty(boolean isCache) {

	}

	@Override
	public void onKnowledgeFailed(String msg) {

	}
}
