package com.commlibs.utils.helper;

import android.app.Activity;

import java.util.Stack;

/**
 * <p class="note">File Note</p>
 */

public class AppManager {

    private Stack<Activity> mActivities = new Stack<>();
    private static AppManager sInstance;

    private static AppManager get() {
        if (sInstance == null) {
            sInstance = new AppManager();
        }
        return sInstance;
    }

    private AppManager() {
    }

    /**
     * 添加activity
     *
     * @param activity
     */
    public static void add(Activity activity) {
        get().mActivities.add(activity);
    }

    /**
     * 移除当前activity
     */
    public static void pop() {
        AppManager manager = get();
        if (manager.mActivities.isEmpty()) return;

        Activity a = manager.mActivities.lastElement();
        remove(a);
    }

    /**
     * 移除activity
     *
     * @param activity
     */
    public static void remove(Activity activity) {
        if (activity != null) {
            get().mActivities.remove(activity);
        }
    }

    /**
     * 移除指定activity
     *
     * @param activity
     */
    public static void finish(Class<?> activity) {
        AppManager manager = get();

        if (manager.mActivities.isEmpty()) { return;}

        for (Activity a : manager.mActivities) {
            if (a.getClass().equals(activity)) {
                a.finish();
                remove(a);
                return;
            }
        }
    }

    /**
     * 获取指定activity
     *
     * @param klass
     * @return
     */
    public static Activity get(Class<?> klass) {
        AppManager manager = get();
        for (Activity a : manager.mActivities) {
            if (a.getClass().equals(klass)) { return a;}
        }

        return null;
    }

    /**
     * 获取所有activity
     */
    public static Stack<Activity> getAll() {
        return get().mActivities;
    }

    /**
     * 获取栈顶的activity
     *
     * @return
     */
    public static Activity top() {
        AppManager manager = get();
        if (manager.mActivities.isEmpty()) {
            return null;
        }
        return manager.mActivities.peek();
    }

    public static void clear() {
        get().mActivities.clear();
    }
}