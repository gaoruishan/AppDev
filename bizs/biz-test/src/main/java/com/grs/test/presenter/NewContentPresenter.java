package com.grs.test.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.commlibs.base.mvp.Presenter;
import com.commlibs.base.net.API;
import com.commlibs.base.net.RetrofitManager;
import com.grs.test.api.NewContentApi;
import com.grs.test.bean.NewContent;
import com.grs.test.bean.RetResult;
import com.grs.test.view.INewContentView;

import okhttp3.RequestBody;
import rx.Subscriber;


/**
 * <p class="note">File Note</p>
 */

public class NewContentPresenter extends Presenter<INewContentView> {

	private final NewContentApi newContentApi;

	public NewContentPresenter() {
		newContentApi = RetrofitManager.getInstance().getGsonRetrofit(API.getServerLinkcook()).create(NewContentApi.class);
	}


	//{"postColumnId":-1,"challengType":0,"userId":"917420171108111147","isDropLoading":0,"param":{"currentPage":3,"pageSize":12}}
	public void getNewContent(int postColumnId, int challengType, String userId, int isDropLoading, final int currentPage, final int pageSize) {
		JSONObject p = new JSONObject();
		p.put("postColumnId", postColumnId);
		p.put("challengType", challengType);
		p.put("userId", userId);
		p.put("isDropLoading", isDropLoading);
		p.put("param", new JSONObject() {{
			put("currentPage", currentPage);
			put("pageSize", pageSize);
		}});
		RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), p.toString());
		this.mCompositeSubscription.add(observe(newContentApi.newContent(body)).subscribe(new Subscriber<RetResult<NewContent>>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {
				Log.e(TAG, "onError: " + e.getMessage());
				getView().onNewContentFailed(e.getMessage());
			}

			@Override
			public void onNext(RetResult<NewContent> result) {
				if (!hasView()) {
					return;
				}
				if (result == null || result.getRetResult() == null) {
					getView().onNewContentEmpty(false);
					return;
				}
				getView().onNewContentList(result.getRetResult(), false);
			}
		}));
	}


}
