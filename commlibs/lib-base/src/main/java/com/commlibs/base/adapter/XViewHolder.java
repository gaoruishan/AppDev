package com.commlibs.base.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spanned;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.commlibs.base.image.GlideUtil;

/**
 * 视图支持类，提供构造和方法类直接完成getview中的适配
 */
public class XViewHolder {
	private SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	private Context mContext;
	private int mLayoutId;

	/**
	 * 在getView()中创建，填充
	 * @param context
	 * @param parent
	 * @param layoutId
	 * @param position
	 */
	public XViewHolder(Context context, ViewGroup parent, int layoutId,
	                   int position) {
		mContext = context;
		mLayoutId = layoutId;
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		mConvertView.setTag(this);
	}

	public static XViewHolder get(Context context, View convertView,
	                              ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new XViewHolder(context, parent, layoutId, position);
		} else {
			XViewHolder holder = (XViewHolder) convertView.getTag();
			holder.mPosition = position;
			return holder;
		}
	}

	public int getPosition() {
		return mPosition;
	}

	public int getLayoutId() {
		return mLayoutId;
	}

	/**
	 * 通过viewId获取控件
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * 设置TextView的值
	 * @param viewId
	 * @param text
	 * @return
	 */
	public XViewHolder setText(int viewId, Spanned text) {
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}

	public XViewHolder setText(int viewId, String text) {
		TextView tv = getView(viewId);
		tv.setText(text + "");
		return this;
	}

	public XViewHolder setImageResource(int viewId, int resId) {
		ImageView view = getView(viewId);
		view.setImageResource(resId);
		return this;
	}

	public XViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bitmap);
		return this;
	}

	//Image直接添加URL
	public XViewHolder setImageUrl(int viewId, String url) {
		ImageView view = getView(viewId);
		//加载框架
		GlideUtil.display(view.getContext(),view,url);
		return this;
	}

	public XViewHolder setImageDrawable(int viewId, Drawable drawable) {
		ImageView view = getView(viewId);
		view.setImageDrawable(drawable);
		return this;
	}

	public XViewHolder setBackgroundColor(int viewId, int color) {
		View view = getView(viewId);
		view.setBackgroundColor(color);
		return this;
	}

	public XViewHolder setBackgroundRes(int viewId, int backgroundRes) {
		View view = getView(viewId);
		view.setBackgroundResource(backgroundRes);
		return this;
	}

	public XViewHolder setTextColor(int viewId, int textColor) {
		TextView view = getView(viewId);
		view.setTextColor(textColor);
		return this;
	}

	public XViewHolder setTextColorRes(int viewId, int textColorRes) {
		TextView view = getView(viewId);
		view.setTextColor(mContext.getResources().getColor(textColorRes));
		return this;
	}

	@SuppressLint("NewApi")
	public XViewHolder setAlpha(int viewId, float value) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getView(viewId).setAlpha(value);
		} else {
			// Pre-honeycomb hack to set Alpha value
			AlphaAnimation alpha = new AlphaAnimation(value, value);
			alpha.setDuration(0);
			alpha.setFillAfter(true);
			getView(viewId).startAnimation(alpha);
		}
		return this;
	}

	public XViewHolder setVisible(int viewId, boolean visible) {
		View view = getView(viewId);
		view.setVisibility(visible ? View.VISIBLE : View.GONE);
		return this;
	}

	public XViewHolder linkify(int viewId) {
		TextView view = getView(viewId);
		Linkify.addLinks(view, Linkify.ALL);
		return this;
	}

	public XViewHolder setTypeface(Typeface typeface, int... viewIds) {
		for (int viewId : viewIds) {
			TextView view = getView(viewId);
			view.setTypeface(typeface);
			view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
		}
		return this;
	}

	public XViewHolder setProgress(int viewId, int progress) {
		ProgressBar view = getView(viewId);
		view.setProgress(progress);
		return this;
	}

	public XViewHolder setProgress(int viewId, int progress, int max) {
		ProgressBar view = getView(viewId);
		view.setMax(max);
		view.setProgress(progress);
		return this;
	}

	public XViewHolder setMax(int viewId, int max) {
		ProgressBar view = getView(viewId);
		view.setMax(max);
		return this;
	}

	public XViewHolder setRating(int viewId, float rating) {
		RatingBar view = getView(viewId);
		view.setVisibility(View.VISIBLE);
		view.setRating(rating);
		return this;
	}

	public XViewHolder setRating(int viewId, float rating, int max) {
		RatingBar view = getView(viewId);
		view.setVisibility(View.VISIBLE);
		view.setMax(max);
		view.setRating(rating);
		return this;
	}

	public XViewHolder setTag(int viewId, Object tag) {
		View view = getView(viewId);
		view.setTag(tag);
		return this;
	}

	public XViewHolder setTag(int viewId, int key, Object tag) {
		View view = getView(viewId);
		view.setTag(key, tag);
		return this;
	}

	public XViewHolder setChecked(int viewId, boolean checked) {
		Checkable view = getView(viewId);
		view.setChecked(checked);
		return this;
	}

	/**
	 * 关于事件的
	 */
	public XViewHolder setOnClickListener(int viewId,
	                                      View.OnClickListener listener) {
		View view = getView(viewId);
		view.setOnClickListener(listener);
		return this;
	}

	public XViewHolder setOnTouchListener(int viewId,
	                                      View.OnTouchListener listener) {
		View view = getView(viewId);
		view.setOnTouchListener(listener);
		return this;
	}

	public XViewHolder setOnLongClickListener(int viewId,
	                                          View.OnLongClickListener listener) {
		View view = getView(viewId);
		view.setOnLongClickListener(listener);
		return this;
	}

}
