package com.commlibs.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 定义一个基本的抽象类适配器-----用于适配listview， gridview的数据 =>一种布局item
 * @param <T>
 */
public abstract class XBaseAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mDatas;
	protected LayoutInflater mInflater;
	private int layoutId;
	protected OnItemClickCallBack<T> callBack;
	protected boolean isChange;//改变布局
	public List<T> otherDatas;

	// 创建对象时，将数据和布局文件添加进来
	public XBaseAdapter(Context context, List<T> datas, int layoutId) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = datas;
		this.layoutId = layoutId;
	}


	//刷新数据
	public void setDatasChanged(List<T> datas) {
		this.mDatas = datas;
		notifyDataSetChanged();
	}
	public void setAppendDatasChanged(List<T> datas) {
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}
	public void setViewChanged(boolean isChange) {
		this.isChange = isChange;
		notifyDataSetChanged();
	}
	public void setOtherDatasChanged(List<T> otherDatas) {
		this.otherDatas = otherDatas;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		XViewHolder holder = XViewHolder.get(mContext, convertView, parent, layoutId, position);
		convert(holder, getItem(position));
		return holder.getConvertView();
	}

	/**
	 * 转换方法，设置holder和对象模型
	 * @param holder
	 * @param t
	 */
	public abstract void convert(XViewHolder holder, T t);

	/**
	 * 设置一个接口回调
	 * @param <T>
	 */
	public interface OnItemClickCallBack<T> {
		void setOnItemClickCallBack(T t, int postion);
	}

	public void setItemClickCallBack(OnItemClickCallBack<T> callBack) {
		this.callBack = callBack;
	}
}
