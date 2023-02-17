package com.chuan.ioc.ant.beanMethod;

import com.chuan.ioc.ant.beanMethod.bean.BeanX;
import com.chuan.ioc.ant.beanMethod.bean.BeanXX;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xucy-e
 */
@Configuration
public class ConfigurationBeanConfig {
    @Bean
    public BeanX beanX() {
        return new BeanX("ZhangSan");
    }

    @Bean
    public BeanXX beanXX() {
        return new BeanXX(this.beanX(), this.beanX());
    }

}
