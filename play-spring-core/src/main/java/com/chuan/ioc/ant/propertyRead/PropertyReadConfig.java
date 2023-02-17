package com.chuan.ioc.ant.propertyRead;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

/**
 * @author xucy-e
 */
@PropertySource(value = "classpath:prop.properties", encoding="UTF-8")
@ComponentScan
@Configuration
public class PropertyReadConfig {

    @Bean
    public ConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(String.class, UserProperty.Single.class, str -> {
            boolean equals = "是".equals(str);
            return new UserProperty.Single(equals);
        });
        return conversionService;
    }
}
