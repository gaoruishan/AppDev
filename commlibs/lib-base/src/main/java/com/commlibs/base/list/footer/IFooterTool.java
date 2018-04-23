package com.commlibs.base.list.footer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p class="note">File Note</p>
 */

public interface IFooterTool {

    /** footer的初始化*/
    void setup(Context ctx, ViewGroup parent);

    /** 开始loading*/
    void startLoading();

    /** 停止loading*/
    void endLoading();

    /** 是否正在加载中*/
    boolean isLoading();

    /** 获取footer View*/
    View getView();
}
