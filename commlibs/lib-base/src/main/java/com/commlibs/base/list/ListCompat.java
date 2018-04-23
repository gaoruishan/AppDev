package com.commlibs.base.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.commlibs.base.R;
import com.commlibs.base.adapter.RecyclerAdapter;
import com.commlibs.base.list.footer.IFooterTool;
import com.commlibs.base.list.refresh.IRefreshTool;
import com.commlibs.utils.helper.ViewHelper;

import java.util.List;

/**
 * <p class="note">RecyclerView compat for Activity and Fragment</p>
 * */
public final class ListCompat<T> {

    private IBaseList mBaseList;

    protected IRefreshTool mRefreshTool;
    protected IFooterTool mFooterTool;

    protected RecyclerView mRecyclerView;
    protected LinearLayoutManager mLayoutManager;
    protected RecyclerAdapter<T> mAdapter;

    private int mCurrentPage;
    private int mPageCount;
    private boolean currentIsCache;
    private boolean isLoading;

    private ListCompat(IBaseList<T> baseList, View contentView) {
        mBaseList = baseList;

        mRecyclerView = ViewHelper.f(contentView, R.id.list);
        View refreshView = ViewHelper.f(contentView, R.id.refresh);

        mLayoutManager = baseList.generateLayoutManager();
        mAdapter = baseList.generateAdapter();
        RecyclerView.ItemDecoration decoration = baseList.generateItemDecoration();
        RecyclerView.ItemAnimator animator = baseList.generateItemAnimator();

        if (decoration != null) {
            mRecyclerView.addItemDecoration(baseList.generateItemDecoration());
        }

        if (animator != null) {
            mRecyclerView.setItemAnimator(baseList.generateItemAnimator());
        }

        mRecyclerView.setLayoutManager(mLayoutManager);

        if (mBaseList.showFooter()) {
            mFooterTool = mBaseList.generateFooterTool();
            if (mFooterTool != null) {
                mFooterTool.setup(contentView.getContext(), mRecyclerView);
                mAdapter.footer(mFooterTool.getView());
            }
        }

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mScrollListener);

        if (refreshView != null) {
            mRefreshTool = baseList.generateRefreshTool();
            mRefreshTool.attach(refreshView);

            mRefreshTool.setup();
            mRefreshTool.enable(baseList.refreshEnable());
            mRefreshTool.setOnRefreshListener(new IRefreshTool.OnRefreshListener() {
                @Override
                public void onRefresh(View view) { newData();}
            });
        }
    }

    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (currentIsCache) { return;}
            if (isLoading) { return;}
            if (mPageCount != -1 && getCurrentPage() > mPageCount) { return;}

            if (mLayoutManager.getOrientation() == LinearLayoutManager.HORIZONTAL) {
                if (dx <= 0) { return;}
            } else {
                if (dy <= 0) { return;}
            }

            int lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            int itemCount = mLayoutManager.getItemCount();
            if (lastVisibleItem < itemCount - 1) { return;}

            getData();
        }
    };

    public void newData() {
        mCurrentPage = 0;
        getData();
    }

    public void getData() {
        isLoading = true;
        if (mBaseList.showFooter()) { mFooterTool.startLoading();}
        if (getCurrentPage() != 1) {
            if (mBaseList.showFooter()) {
                mLayoutManager.scrollToPosition(mLayoutManager.getItemCount() - 1);
            }
        }

        mBaseList.request();
    }

    public void onSuccess(int pageCount, List<T> data) {
        mPageCount = pageCount;
        reset(true);
        if (data == null) {
            if (getCurrentPage() == 1) {
                mAdapter.clear();
            }
            return;
        }

//        mRecyclerView.stopScroll();
        if (getCurrentPage() == 1) {
            mAdapter.setData(data);
            mLayoutManager.scrollToPosition(0);
        } else {
            mAdapter.addData(data);
        }
        if (!currentIsCache) { mCurrentPage++;}
    }

    public void onFailed(String msg) {
        reset(false);
        if (getCurrentPage() == 1) {
            mAdapter.clear();
        }
    }

    public void reportIsCache(boolean isCache) {
        currentIsCache = isCache;
    }

    private void reset(boolean success) {
        isLoading = false;
        if (mRefreshTool != null) {
            mRefreshTool.endRefresh();
        }
        if (!mBaseList.showFooter() || mFooterTool == null) { return;}
        mFooterTool.endLoading();
    }

    /**
     * the next page
     * @return
     */
    public int getCurrentPage() {
        return mCurrentPage + mBaseList.startPage();
    }

    public void setCurrentPage(int page) {
        mCurrentPage = page - mBaseList.startPage();
    }

    public static <T> ListCompat<T> with(IBaseList<T> baseList, View contentView) {
        return new ListCompat<>(baseList, contentView);
    }
}
