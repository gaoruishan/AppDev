package com.grs.home.view;

import com.commlibs.base.mvp.IView;
import com.grs.home.bean.NewContent;

/**
 * <p class="note">File Note</p>
 */

public interface INewContentView extends IView {
    void onNewContentList(NewContent content, boolean isCache);
    void onNewContentEmpty(boolean isCache);
    void onNewContentFailed(String msg);
}
