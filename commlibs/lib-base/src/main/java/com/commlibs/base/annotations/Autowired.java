/**
 * Copyright 2016,Smart Haier.All rights reserved
 */
package com.commlibs.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p class="note">File Note</p>
 * created by qibin at 2017/6/27 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {
}
