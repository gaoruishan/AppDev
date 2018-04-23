/**
 * Copyright 2016,Smart Haier.All rights reserved
 */
package com.commlibs.base.annotations;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * <p class="note">File Note</p>
 * created by qibin at 2017/6/27
 */
public class AnnotionProcessor {

	private static Processors processors = new Processors();

	public static void of(Object obj) {
		for (Class<?> klass = obj.getClass(); !isClassSuperBase(klass); klass = klass.getSuperclass()) {
			Field[] fields = klass.getDeclaredFields();
			for (Field f : fields) {
				process(obj, f);
			}
		}
	}

	private static void process(final Object obj, final Field f) {
		processors.map(new Processors.Mapper() {
			@Override
			public void on(Class<? extends Annotation> key, Class<? extends IProcessor> value) {
				if (f.isAnnotationPresent(key)) {
					IProcessor p = processors.get(key);
					if (p != null) {
						p.process(obj, f);
					}
				}
			}
		});
	}

	private static boolean isClassSuperBase(Class<?> klass) {
		return AppCompatActivity.class.equals(klass)
				|| Activity.class.equals(klass)
				|| Object.class.equals(klass);
	}
}
