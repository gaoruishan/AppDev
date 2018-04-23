package com.commlibs.base.list.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.commlibs.utils.helper.ViewHelper;


/**
 * <p class="note">File Note</p>
 */

public class SwipeRefreshTool implements IRefreshTool {

    private SwipeRefreshLayout mRefreshLayout;

    @Override
    public void attach(View view) {
        if (!(view instanceof SwipeRefreshLayout)) {
            throw new IllegalArgumentException("view must be SwipeRefreshLayout");
        }
        mRefreshLayout = (SwipeRefreshLayout) view;
    }

    @Override
    public void setup() {
        ViewHelper.setRefreshColor(mRefreshLayout);
    }

    @Override
    public void enable(boolean enable) {
        mRefreshLayout.setEnabled(enable);
    }

    @Override
    public void startRefresh() {
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void endRefresh() {
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean isRefreshing() {
        return mRefreshLayout.isRefreshing();
    }

    @Override
    public void setOnRefreshListener(final OnRefreshListener li) {
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() { li.onRefresh(mRefreshLayout);}
        });
    }

    @Override
    public View getView() {
        return mRefreshLayout;
    }
}
