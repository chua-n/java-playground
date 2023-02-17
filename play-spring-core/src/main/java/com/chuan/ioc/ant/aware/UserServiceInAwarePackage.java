package com.chuan.ioc.ant.aware;

import com.chuan.ioc.IUserDAO;
import com.chuan.ioc.IUserService;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author xucy-e
 */
@Getter
@Service
public class UserServiceInAwarePackage implements IUserService, ApplicationContextAware, BeanNameAware {

    private ApplicationContext applicationContext;

    private String beanName;

    @Override
    public IUserDAO getUserDAO() {
        return null;
    }

    @Override
    public String introduce(String userName) {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.printf("---------------come in aware of %s#setApplicationContext--------------\n", this.getClass().getSimpleName());
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.printf("---------------come in aware of %s#setBeanName, with bean name %s---------------\n", this.getClass().getSimpleName(), s);
    }
}
