package com.chuan.ioc.ant.postProcessor;

import com.chuan.ioc.IUserDAO;
import com.chuan.ioc.IUserService;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xucy-e
 */
@Service
public class UserServiceInPostProcessorPackage implements IUserService, Lifecycle {

    private boolean isRunning = false;

    @Override
    public String introduce(String userName) {
        return null;
    }

    @Override
    public IUserDAO getUserDAO() {
        return null;
    }

    @PostConstruct
    private void init() {
        System.out.printf("%s is initialized!\n", this.getClass().getSimpleName());
    }

    @PreDestroy
    private void destroy() {
        System.out.printf("%s is destroyed!\n", this.getClass().getSimpleName());
    }

    @Override
    public void start() {
        System.out.printf("%s is started!\n", this.getClass().getSimpleName());
        this.isRunning = true;
    }

    @Override
    public void stop() {
        System.out.printf("%s is stopped!\n", this.getClass().getSimpleName());
    }

    @Override
    public boolean isRunning() {
        System.out.println("---------------invoke isRunning()---------------");
        return this.isRunning;
    }
}
