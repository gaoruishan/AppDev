/**
 * Copyright 2016,Smart Haier.All rights reserved
 */
package com.commlibs.base.annotations;

import java.lang.reflect.Field;

/**
 * <p class="note">File Note</p>
 * created by qibin at 2017/6/28 
 */
public interface IProcessor {
    void process(Object obj, Field f);
}
