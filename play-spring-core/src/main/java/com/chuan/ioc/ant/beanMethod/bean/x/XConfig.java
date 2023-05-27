package com.chuan.ioc.ant.beanMethod.bean.x;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xucy-e
 */
@Configuration
public class XConfig {
    @Bean
    public BeanX beanX() {
        return new BeanX("ZhangSan");
    }

    public BeanXX getBeanXX() {
        return new BeanXX(this.beanX(), this.beanX());
    }

}
