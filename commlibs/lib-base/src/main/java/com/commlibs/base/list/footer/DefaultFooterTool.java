package com.commlibs.base.list.footer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.commlibs.base.R;


/**
 * <p class="note">File Note</p>
 */

public class DefaultFooterTool implements IFooterTool {

    private View mRootView;

    @Override
    public void setup(Context ctx, ViewGroup parent) {
        mRootView = LayoutInflater.from(ctx).inflate(R.layout.base_default_footer, parent, false);
    }

    @Override
    public void startLoading() {
        mRootView.setVisibility(View.VISIBLE);
    }

    @Override
    public void endLoading() {
        mRootView.setVisibility(View.GONE);
    }

    @Override
    public boolean isLoading() {
        return mRootView.isShown();
    }

    @Override
    public View getView() {
        return mRootView;
    }
}
