package com.commlibs.base.list.refresh;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.commlibs.base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/**
 * <p class="note">File Note</p>
 */

public class SmartRefreshTool implements IRefreshTool {

    private SmartRefreshLayout mRefreshLayout;

    @Override
    public void attach(View view) {
        if (!(view instanceof SmartRefreshLayout)) {
            throw new IllegalArgumentException("view must be SmartRefreshLayout");
        }

        mRefreshLayout = (SmartRefreshLayout) view;
    }

    @Override
    public void setup() {
        mRefreshLayout.setRefreshHeader(new AnimationRefreshHeader(mRefreshLayout.getContext()));
    }

    @Override
    public void enable(boolean enable) {
        mRefreshLayout.setEnabled(enable);
    }

    @Override
    public void startRefresh() {
    }

    @Override
    public void endRefresh() {
        mRefreshLayout.finishRefresh();
    }

    @Override
    public boolean isRefreshing() {
        return mRefreshLayout.isRefreshing();
    }

    @Override
    public void setOnRefreshListener(final OnRefreshListener li) {
        mRefreshLayout.setOnRefreshListener(new com.scwang.smartrefresh.layout.listener.OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                li.onRefresh(mRefreshLayout);
            }
        });
    }

    @Override
    public View getView() {
        return mRefreshLayout;
    }

    /**
     * Created by tianpeng on 2017/8/4.
     */
    @SuppressLint("AppCompatCustomView")
    static class AnimationRefreshHeader extends ImageView implements RefreshHeader {

        private AnimationDrawable animation;

        public AnimationRefreshHeader(Context context) {
            super(context);
            init(context);
        }

        public AnimationRefreshHeader(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public AnimationRefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public AnimationRefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            init(context);
        }

        private void init(Context context) {
            setImageResource(R.drawable.refresh_drawable_list);
        }

        @Override
        public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {
            if (animation == null) {
                animation = (AnimationDrawable) getDrawable();
            }

            if (percent > 0.3f) {
                if (!animation.isRunning()) {
                    animation.start();
                }
            }
        }

        @Override
        public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {
            if (percent == 0) {
                if (animation != null && animation.isRunning()) {
                    animation.stop();
                }
            }
        }

        @NonNull
        @Override
        public View getView() {
            return this;
        }

        @Override
        public SpinnerStyle getSpinnerStyle() {
            return SpinnerStyle.Translate;
        }

        @Override
        public void setPrimaryColors(int... colors) {

        }

        @Override
        public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

        }

        @Override
        public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

        }

        @Override
        public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {


        }

        @Override
        public int onFinish(RefreshLayout layout, boolean success) {
            return 0;
        }

        @Override
        public boolean isSupportHorizontalDrag() {
            return false;
        }

        @Override
        public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

        }
    }
}
