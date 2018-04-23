
package com.commlibs.base.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.commlibs.base.adapter.RecyclerAdapter;
import com.commlibs.base.list.footer.IFooterTool;
import com.commlibs.base.list.refresh.IRefreshTool;


/**
 * <p class="note">Base List interface</p>
 * */
public interface IBaseList<T> extends IBaseRequest<T> {

    /** 提供LayoutManager*/
    LinearLayoutManager generateLayoutManager();
    /** 设置Adapter*/
    RecyclerAdapter<T> generateAdapter();
    /** 设置ItemDecoration*/
    RecyclerView.ItemDecoration generateItemDecoration();
    /** 设置ItemAnimator*/
    RecyclerView.ItemAnimator generateItemAnimator();
    /** 设置IRefreshTool*/
    IRefreshTool generateRefreshTool();
    /** 设置IFooterTool*/
    IFooterTool generateFooterTool();

    /** 获取Adapter*/
    RecyclerAdapter<T> getAdapter();
    /** 获取RecyclerView*/
    RecyclerView getRecyclerView();
    /** 获取LayoutManager*/
    LinearLayoutManager getLayoutManager();
    /** 获取IRefreshTool*/
    IRefreshTool getRefreshTool();
    /** 获取IFooterTool*/
    IFooterTool getFooterTool();

    /** 页码从几开始*/
    int startPage();
    /** 获取当前页， 数据加载成功后+1*/
    int getCurrentPage();
    /** 设置当前页*/
    void setCurrentPage(int page);

    /** 是否在加载时显示加载中*/
    boolean showFooter();
    /** 是否可下拉刷新*/
    boolean refreshEnable();

    /** 上报是否为缓存数据*/
    void reportIsCache(boolean isCache);
}
