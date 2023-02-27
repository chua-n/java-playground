package com.chuan.play.spring.cloud.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xucy-e
 */
@EnableFeignClients
@SpringBootApplication
public class ZKClient2 {

    public static void main(String[] args) {
        SpringApplication.run(ZKClient2.class, args);
    }

}
