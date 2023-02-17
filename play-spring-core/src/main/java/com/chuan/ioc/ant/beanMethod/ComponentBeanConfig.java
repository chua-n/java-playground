package com.chuan.ioc.ant.beanMethod;

import com.chuan.ioc.ant.beanMethod.bean.BeanY;
import com.chuan.ioc.ant.beanMethod.bean.BeanYY;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author xucy-e
 */
@Component
public class ComponentBeanConfig {

    @Bean
    private BeanY beanY() {
        return new BeanY("ZhangSan");
    }

    @Bean
    private BeanYY beanYY() {
        return new BeanYY(this.beanY(), this.beanY());
    }
}
