package com.commlibs.base.mvp;


import android.util.Log;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * presenter基类 <br />
 */

public class Presenter<T extends IView> {


	public static final String TAG = Presenter.class.getSimpleName();
	/**
	 * 保存view
	 */
	private T mView;
	private long mCurrentMs = System.currentTimeMillis();
	protected CompositeSubscription mCompositeSubscription;

	/**
	 * 在view创建的时候调用
	 * @param view
	 */
	public void onCreate(T view) {
		if(mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()){
			mCompositeSubscription = new CompositeSubscription();
		}
		Log.e(TAG, "onCreate: ");
		mView = view;
	}

	/**
	 * 在view销毁的时候调用
	 */
	public void onDestory() {
		Log.e(TAG, "onDestory: ");
//        Http.cancel(getIdentifier());
		if (mCompositeSubscription != null && !mCompositeSubscription.isUnsubscribed()) {
			this.mCompositeSubscription.unsubscribe();
		}
		this.mCompositeSubscription = null;
		mView = null;
	}
	/**
	 * 添加Subscription
	 * @param subscription
	 */
	public void addSubscription(Subscription subscription){
		Log.d(TAG,"add subscription");
		mCompositeSubscription.add(subscription);
	}
	/**
	 *  将一些重复的操作提出来，放到父类以免里每个接口都有重复代码
	 * @param observable
	 * @param <T>
	 * @return
	 */
	protected  <T> Observable<T> observe(Observable<T> observable){
		return observable.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());
	}


	/**
	 * 获取view
	 * @return
	 */
	protected T getView() {
		if (hasView()) {
			return mView;
		}

		return null;
	}

	/**
	 * 判断view时候为空
	 * @return
	 */
	protected boolean hasView() {
		return mView != null;
	}

	public String getIdentifier() {
		if (!hasView() || getView().getIdentifier() == null) {
			return getClass().getName() + mCurrentMs;
		}
		return getView().getIdentifier();
	}
}
