package com.commlibs.libwidget.text;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class AlwaysMarqueeTextView extends TextView {

    public AlwaysMarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AlwaysMarqueeTextView(Context context) {
        super(context);
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setSingleLine();
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}