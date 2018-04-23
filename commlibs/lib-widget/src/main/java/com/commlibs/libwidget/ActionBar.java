
package com.commlibs.libwidget;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActionBar extends RelativeLayout {
	private ImageView mLeft;
	private TextView mLeftText;
	private ImageView mRight;
	private ImageView mRight2;
	private TextView mRightText;
	private TextView mTitle;
	private View divide;
	public OnClickListener listener;

	/**
	 * @param context
	 */
	public ActionBar(Context context) {
		super(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public ActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public ActionBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mLeft = (ImageView) findViewById(R.id.action_bar_left);
		mLeftText = (TextView) findViewById(R.id.action_bar_left_text);
		mRight = (ImageView) findViewById(R.id.action_bar_right);
		mRight2 = (ImageView) findViewById(R.id.action_bar_right2);
		mRightText = (TextView) findViewById(R.id.action_bar_right_text);
		mTitle = (TextView) findViewById(R.id.action_bar_title);
		divide = findViewById(R.id.action_bar_divide);
	}

	/**
	 * @param isText
	 */
	public void setLeftMode(boolean isText) {
		if (isText) {
			mLeft.setVisibility(GONE);
			mLeftText.setVisibility(VISIBLE);
		} else {
			mLeft.setVisibility(VISIBLE);
			mLeftText.setVisibility(GONE);
		}
	}

	public void setRightMode(boolean isText) {
		if (isText) {
			mRight.setVisibility(GONE);
			mRightText.setVisibility(VISIBLE);
		} else {
			mRight.setVisibility(VISIBLE);
			mRightText.setVisibility(GONE);
		}
	}

	public View getBarDivide() {
		return divide;
	}

	/**
	 * 最Left ImageView
	 * @return the mLeft
	 */
	public ImageView getLeftImage() {
		return mLeft;
	}

	/**
	 * 最Left TextView
	 * @return
	 */
	public TextView getLeftText() {
		return mLeftText;
	}

	/**
	 * 中间的Title
	 * @return the mTitle
	 */
	public TextView getTitleView() {
		return mTitle;
	}

	/**
	 * 设置Title内容
	 * @param titleId
	 */
	public ActionBar setTitleText(@StringRes int titleId) {
		mTitle.setText(titleId);
		return this;
	}

	public ActionBar setTitleText(CharSequence title) {
		mTitle.setText(title);
		return this;
	}

	/**
	 * 最Right ImageView
	 * @return the mRight
	 */
	public ImageView getRightImage() {
		return mRight;
	}

	public ActionBar setRightImage(@DrawableRes int resId) {
		mRight.setImageResource(resId);
		return this;
	}

	/**
	 * 第二Right ImageView
	 * @return
	 */
	public ImageView getRight2Image() {
		return mRight2;
	}

	public ActionBar setRight2Image(@DrawableRes int resId) {
		mRight2.setImageResource(resId);
		return this;
	}

	/**
	 * 最Right TextView
	 * @return
	 */
	public TextView getRightTextView() {
		return mRightText;
	}

	public ActionBar setRightText(@StringRes int resId) {
		mRightText.setText(resId);
		return this;
	}

	public ActionBar setRightText(CharSequence resId) {
		mRightText.setText(resId);
		return this;
	}

	/**
	 * 设置onFinishClickListener
	 * @param listener
	 */
	public void onFinishClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	/**
	 * 初始化
	 * @param mContext
	 */
	public void initDefaultActionBar(final Activity mContext) {
		getLeftImage().setImageResource(R.drawable.nav_head_back);
		getLeftImage().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (listener != null) {
					listener.onClick(v);
				} else {
					mContext.finish();
				}
			}
		});
	}
}