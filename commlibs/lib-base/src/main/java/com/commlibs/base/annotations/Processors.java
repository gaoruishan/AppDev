/**
 * Copyright 2016,Smart Haier.All rights reserved
 */
package com.commlibs.base.annotations;

import android.support.v4.util.ArrayMap;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <p class="note">File Note</p>
 * created by qibin at 2017/6/28 
 */
public class Processors {
    private ArrayMap<Class<? extends Annotation>, Class<? extends IProcessor>> map = new ArrayMap<>();

    public Processors() {
        put(Autowired.class, AutowiredProcessor.class);
    }

    public void put(Class<? extends Annotation> key, Class<? extends IProcessor> value) {
        map.put(key, value);
    }

    public <T extends IProcessor> T get(Class<? extends Annotation> key) {
        try {
            return (T) map.get(key).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void map(Mapper mapper) {
        for (Map.Entry<Class<? extends Annotation>, Class<? extends IProcessor>> entry
                : map.entrySet()) {
            mapper.on(entry.getKey(), entry.getValue());
        }
    }

    public interface Mapper {
        void on(Class<? extends Annotation> key, Class<? extends IProcessor> value);
    }
}
