package com.chuan.ioc.env.profile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xucy-e
 */
@PropertySource(value = "classpath:ioc/env/profileSettings.properties", encoding="UTF-8")
@ComponentScan("com.chuan.ioc.env.profile.bean")
@Configuration
public class ProfileConfigFromProp {
}
