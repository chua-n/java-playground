package com.chuan.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author xucy-e
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope(value = TenantSpecific.SCOPE_NAME)
public @interface TenantSpecific {
    String SCOPE_NAME = "tenant";

    /**
     * 如果不设置 proxyMode，则不会形成“代理对象的方法触发时重新触发 scope 的 get 方法”的效果。
     */
    @AliasFor(annotation = Scope.class)
    ScopedProxyMode proxyMode() default ScopedProxyMode.TARGET_CLASS;
}
