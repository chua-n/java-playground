package com.chuan.ioc.ant.beanMethod.bean.y;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author xucy-e
 */
@Component
public class YConfig {

    @Bean
    private BeanY beanY() {
        return new BeanY("ZhangSan");
    }

    public BeanYY getBeanYY() {
        return new BeanYY(this.beanY(), this.beanY());
    }
}
