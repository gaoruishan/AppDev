/**
 * Copyright 2016,Smart Haier.All rights reserved
 */
package com.commlibs.base.annotations;


import com.commlibs.base.mvp.IView;
import com.commlibs.base.mvp.Presenter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p class="note">File Note</p>
 * created by qibin at 2017/6/28 
 */
public class AutowiredProcessor implements IProcessor {

    @Override
    public void process(Object obj, Field f) {
        Class<?> type = (Class<?>) f.getGenericType();
        if (type.isPrimitive()) { return;}
        f.setAccessible(true);

        try {
            f.set(obj, type.newInstance());
            if (Presenter.class.isAssignableFrom(type)) {
                processPresenter(obj, f, type);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        f.setAccessible(false);
    }

    private void processPresenter(Object obj, Field f, Class<?> type) throws IllegalAccessException {
        try {
            Method method = type.getMethod("onCreate", IView.class);
            method.invoke(f.get(obj), obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
