package com.chuan.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xucy-e
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RequestScopeTester {
    public String something = "I am something";

    public static String staticSomething = "I am static something";

    public RequestScopeTester() {
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
