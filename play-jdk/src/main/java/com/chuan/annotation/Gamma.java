package com.chuan.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xucy-e
 */
@Alpha
@Beta
@Retention(RetentionPolicy.RUNTIME)
public @interface Gamma {
    String alpha();

    String beta();
}
