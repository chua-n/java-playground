package com.chuan.play.spring.cloud.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xucy-e
 */
@SpringBootApplication
public class ConfigClient2Application implements InitializingBean {

    @Value("${env.profile:default}")
    private String curProfile;
    @Value("${server.port}")
    private int port;

    @Override
    public void afterPropertiesSet() {
        System.out.println();
        System.out.printf("curProfile: %s, port: %d\n", curProfile, port);
        System.out.println();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient2Application.class, args);
    }

}
