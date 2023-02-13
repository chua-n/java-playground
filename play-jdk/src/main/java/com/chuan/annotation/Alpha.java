package com.chuan.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xucy-e
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Alpha {
    String value() default "";

    int alpha() default 1;
}
