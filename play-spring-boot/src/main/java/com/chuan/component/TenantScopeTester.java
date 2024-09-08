package com.chuan.component;

import com.chuan.scope.TenantSpecific;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xucy-e
 */
@TenantSpecific
@Component
public class TenantScopeTester {
    public TenantScopeTester() {
        System.out.println(this.getClass().getSimpleName() + "#constructor");
    }

    public String saySomething() {
        return "I'm saying something.";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + "#postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + "#preDestroy");
    }
}
