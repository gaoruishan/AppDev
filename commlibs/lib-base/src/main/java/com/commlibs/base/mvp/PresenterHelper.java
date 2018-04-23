package com.commlibs.base.mvp;

import java.lang.reflect.Field;

/**
 * Presenter Helper
 */
public class PresenterHelper {
    /**
     * presenter创建帮助类
     * @param klass presenter class
     * @param view View
     * @param <T> T of View
     * @param <P> P of Presenter
     * @return presenter
     */
    public static <T extends IView, P extends Presenter> P create(Class<P> klass, T view) {
        try {
            P presenter = klass.newInstance();
            presenter.onCreate(view);

            return presenter;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Activity销毁的时候
     * @param object
     * @param superClass
     * @param <T>
     */
    public static <T> void onDestoryed(T object, Class<?> superClass) {
        for (Class<?> klass = object.getClass(); !superClass.equals(klass); klass = klass.getSuperclass()) {
            Field[] fs = klass.getDeclaredFields();
            Presenter p;

            for (Field f : fs) {
                if (!Presenter.class.isAssignableFrom(f.getType())) { continue;}
                f.setAccessible(true);
                try {
                    p = (Presenter) f.get(object);
                    p.onDestory();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                f.setAccessible(false);
            }
        }
    }
}
