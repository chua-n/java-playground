package com.chuan.ioc.ant.postProcessor;

import com.chuan.util.MyPrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xucy-e
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String message = String.format("---------------come in %s#%s with beanName %s--------------", this.getClass().getSimpleName(), methodName, beanName);
        MyPrinter.println(message);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String message = String.format("---------------come in %s#%s with beanName %s--------------", this.getClass().getSimpleName(), methodName, beanName);
        MyPrinter.println(message);
        return bean;
    }
}
