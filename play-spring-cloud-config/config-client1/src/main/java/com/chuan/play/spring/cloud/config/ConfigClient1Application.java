package com.chuan.play.spring.cloud.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xucy-e
 */
@SpringBootApplication
public class ConfigClient1Application implements InitializingBean {

    @Value("${env.profile:default}")
    private String curProfile;

    @Override
    public void afterPropertiesSet() {
        System.out.println(curProfile);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient1Application.class, args);
    }

}
