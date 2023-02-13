package com.chuan.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xucy-e
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Beta {
    String value() default "";

    int beta() default 2;
}
