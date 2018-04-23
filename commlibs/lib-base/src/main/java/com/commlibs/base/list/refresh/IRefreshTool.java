package com.commlibs.base.list.refresh;

import android.view.View;

/**
 * <p class="note">File Note</p>
 */

public interface IRefreshTool {
    /** 附加一个view用于提供刷新功能(RefreshView)*/
    void attach(View view);

    /** RefreshView的初始化*/
    void setup();

    /** 标识RefreshView是否可用*/
    void enable(boolean enable);

    /** 开始刷新*/
    void startRefresh();

    /** 停止刷新*/
    void endRefresh();

    /** 设置刷新Listener*/
    void setOnRefreshListener(OnRefreshListener li);

    /** 是否正在刷新*/
    boolean isRefreshing();

    /** 获取RefreshView*/
    View getView();

    public interface OnRefreshListener {
        void onRefresh(View view);
    }
}
