package com.commlibs.base.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @作者:gaoruishan
 * @时间:2017/7/5/12:42
 * @邮箱:grs0515@163.com
 */

public abstract class XPagerAdapter<T> extends PagerAdapter {

	public static final String TAG = XPagerAdapter.class.getSimpleName();
	protected Context mContext;
	private List<T> mDatas;
	private int layoutId;

	public XPagerAdapter(Context mContext, List<T> mDatas, int layoutId) {
		this.mDatas = mDatas;
		this.mContext = mContext;
		this.layoutId = layoutId;
		notifyDataSetChanged();
	}

	/**
	 * 解决ViewPager 刷新问题
	 */
	@Override
	public int getItemPosition(Object object) {
		// 最简单解决 notifyDataSetChanged() 页面不刷新问题的方法
		return POSITION_NONE;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// 把 Object 强转为 View，然后将 view 从 ViewGroup 中清除
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup parent, int position) {
		View mConvertView;
		T t = mDatas.get(position);
		if (t == null) {
			return null;
		}
		mConvertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
		if (mConvertView != null) {
			convert(mConvertView, t);
			parent.addView(mConvertView, 0);
		}
		return mConvertView;
	}

	/**
	 * 转换方法-设置属性
	 * @param holder
	 * @param t
	 */
	public abstract void convert(View holder, T t);

}
