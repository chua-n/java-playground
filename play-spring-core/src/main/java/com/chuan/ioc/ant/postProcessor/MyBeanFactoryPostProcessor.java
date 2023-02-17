package com.chuan.ioc.ant.postProcessor;

import com.chuan.util.MyPrinter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author xucy-e
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        MyPrinter.println(String.format("-----------------come in %s -----------------", this.getClass().getSimpleName()));

        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        BeanDefinition userServiceImpl = configurableListableBeanFactory.getBeanDefinition("userServiceInPostProcessorPackage");
        int count = configurableListableBeanFactory.getBeanDefinitionCount();
        MyPrinter.println(beanDefinitionNames, userServiceImpl, count);

        MyPrinter.println(String.format("-----------------leave %s -----------------", this.getClass().getSimpleName()));
    }
}
