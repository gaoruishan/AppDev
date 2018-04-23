package com.commlibs.base.image;

import android.content.Context;

import java.util.HashMap;

/**
 */

public class GlideOptionsFactory {
    private static HashMap<Type, GlideOptions> mOptions;

    private GlideOptionsFactory() {}

    public static void init(Context ctx, int defLoading) {
        if (mOptions == null) {
            mOptions = new HashMap<>();
            mOptions.put(Type.DEFAULT, new GlideOptions(defLoading, 0));
            mOptions.put(Type.RADIUS, new GlideOptions(defLoading, dip2px(ctx,10)));
        }
    }

    public static GlideOptions get(Type type) {
        if (mOptions.containsKey(type)) {
            return mOptions.get(type);
        }

        throw new IllegalArgumentException();
    }

    private static int dip2px(Context ctx, float dpValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public enum Type {
        DEFAULT (1), RADIUS (2);
        private int type;

        private Type(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "type:" + type;
        }
    }
}
