package com.grs.knowledge.presenter;

import android.util.Log;

import com.commlibs.base.mvp.Presenter;
import com.commlibs.base.net.API;
import com.commlibs.base.net.RetrofitManager;
import com.grs.knowledge.api.KnowledgeApi;
import com.grs.knowledge.bean.DataResult;
import com.grs.knowledge.bean.KnowledgeTreeBean;
import com.grs.knowledge.view.IKnowledgeView;

import rx.Subscriber;


/**
 * @作者:gaoruishan
 * @时间:2018/2/12/15:41
 * @邮箱:grs0515@163.com
 */
public class KnowledgePresenter extends Presenter<IKnowledgeView> {

	private final KnowledgeApi knowledgeApi;

	public KnowledgePresenter() {
		knowledgeApi = RetrofitManager.getInstance().getGsonRetrofit(API.getServerWanAndroid()).create(KnowledgeApi.class);
	}


	public void getKnowledgeTree() {
		this.mCompositeSubscription.add(observe(knowledgeApi.getKnowledgeTree()).subscribe(new Subscriber<DataResult<KnowledgeTreeBean>>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {
				Log.e(TAG, "onError: " + e.getMessage());
				getView().onKnowledgeFailed(e.getMessage());
			}

			@Override
			public void onNext(DataResult<KnowledgeTreeBean> result) {
				if (!hasView()) {
					return;
				}
				if (result == null || result.getData() == null) {
					getView().onKnowledgeEmpty(false);
					return;
				}
				getView().onKnowledgeList(result.getData(), false);
			}
		}));
	}


}
