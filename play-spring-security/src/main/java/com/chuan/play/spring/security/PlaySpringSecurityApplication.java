package com.chuan.play.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class PlaySpringSecurityApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PlaySpringSecurityApplication.class, args);
        SecurityFilterChain securityFilterChain = applicationContext.getBean(DefaultSecurityFilterChain.class);
        System.out.println(securityFilterChain.getFilters());
    }

}
