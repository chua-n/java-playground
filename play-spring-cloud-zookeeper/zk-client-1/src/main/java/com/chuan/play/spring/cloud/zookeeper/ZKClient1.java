package com.chuan.play.spring.cloud.zookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xucy-e
 */
@SpringBootApplication
@RestController
public class ZKClient1 {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{serviceId}")
    public List<ServiceInstance> getInstances(@PathVariable String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, I'm zk-client1, you find me!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ZKClient1.class, args);
    }

}
