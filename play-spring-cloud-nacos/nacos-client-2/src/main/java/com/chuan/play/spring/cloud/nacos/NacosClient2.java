package com.chuan.play.spring.cloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xucy-e
 */
@EnableFeignClients
@SpringBootApplication
public class NacosClient2 {

    public static void main(String[] args) {
        SpringApplication.run(NacosClient2.class, args);
    }

}
