package com.chuan.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xucy-e
 */
@Component
public class SmartLifecycleTester implements SmartLifecycle {
    @Autowired
    private ApplicationContext applicationContext;

    private boolean running = false;

    @PostConstruct
    public void postConstruct() {
        System.out.println("smart postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("smart preDestroy");
    }

    @Override
    public void start() {
        System.out.println("smart start");
        this.running = true;
    }

    @Override
    public void stop() {
        System.out.println("smart stop");
        this.running = false;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }
}
