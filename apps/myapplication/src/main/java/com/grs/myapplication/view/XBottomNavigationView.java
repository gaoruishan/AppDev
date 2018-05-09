package com.grs.myapplication.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;

import com.grs.apphome.HomeFragment;
import com.grs.appknowlege.fragment.KnowlegdeFragment;
import com.grs.myapplication.R;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @作者:gaoruishan
 * @时间:2018/5/7/10:40
 * @邮箱:grs0515@163.com
 */
public class XBottomNavigationView extends BottomNavigationView {

	private IBottomNavigationView iBottomNavigationView;
	private int mLastFgIndex;
	private HashMap<Integer, android.support.v4.app.Fragment> mFragmentMap = new HashMap<>();
	private FragmentManager supportFragmentManager;
	/**
	 * 条目选择
	 */
	private OnNavigationItemSelectedListener listener = new OnNavigationItemSelectedListener() {
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			int itemId = item.getItemId();
			switchFragment(itemId);
			//回调
			switch (itemId) {
				case R.id.tab_main_pager:
					if (iBottomNavigationView != null) {
						iBottomNavigationView.switchMainPager();
					}
					break;
				case R.id.tab_knowledge_hierarchy:
					if (iBottomNavigationView != null) {
						iBottomNavigationView.switchKnowledgeHierarchy();
					}
					break;
				case R.id.tab_navigation:
					if (iBottomNavigationView != null) {
						iBottomNavigationView.switchNavigation();
					}
					break;
				case R.id.tab_project:
					if (iBottomNavigationView != null) {
						iBottomNavigationView.switchProject();
					}
					break;
				default:
					break;
			}
			return true;
		}
	};

	public XBottomNavigationView(Context context) {
		this(context, null);
	}

	public XBottomNavigationView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public XBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		//点击监听
		setOnNavigationItemSelectedListener(listener);
	}

	/**
	 * 取消上档模式
	 * @param <></>
	 */
	@SuppressLint("RestrictedApi")
	public void disableShiftMode() {
		BottomNavigationMenuView menuView = (BottomNavigationMenuView) this.getChildAt(0);
		try {
			Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
			shiftingMode.setAccessible(true);
			shiftingMode.setBoolean(menuView, false);
			shiftingMode.setAccessible(false);
			for (int i = 0; i < menuView.getChildCount(); i++) {
				BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
				//noinspection RestrictedApi
				item.setShiftingMode(false);
				// set once again checked value, so view will be updated
				//noinspection RestrictedApi
//                item.setChecked(item.getItemData().isChecked());
			}
		} catch (NoSuchFieldException e) {
			Log.e("BNVHelper", "Unable to get shift mode field", e);
		} catch (IllegalAccessException e) {
			Log.e("BNVHelper", "Unable to change value of shift mode", e);
		}
	}

	public void setIBottomNavigationViewListener(IBottomNavigationView iBottomNavigationView) {
		this.iBottomNavigationView = iBottomNavigationView;
	}

	public void initFragment(android.support.v4.app.FragmentManager supportFragmentManager) {
		this.supportFragmentManager = supportFragmentManager;
		mFragmentMap.put(R.id.tab_main_pager, HomeFragment.getInstance(null));
		mFragmentMap.put(R.id.tab_knowledge_hierarchy, KnowlegdeFragment.getInstance(null));
		mFragmentMap.put(R.id.tab_navigation, HomeFragment.getInstance(null));
		mFragmentMap.put(R.id.tab_project, HomeFragment.getInstance(null));
		this.switchFragment(R.id.tab_main_pager);
	}

	public void switchFragment(int itemId) {

		boolean isNull = supportFragmentManager == null || mFragmentMap == null;
		if (isNull) return;

		FragmentTransaction ft = supportFragmentManager.beginTransaction();
		Fragment targetFg = mFragmentMap.get(itemId);
		Fragment lastFg = mFragmentMap.get(mLastFgIndex);
		mLastFgIndex = itemId;
		if (lastFg != null) {
			ft.hide(lastFg);
		}
		if (!targetFg.isAdded()) {
			ft.add(R.id.main_content_view, targetFg);
		} else {
			ft.show(targetFg);
		}
		ft.commitAllowingStateLoss();
	}
}
