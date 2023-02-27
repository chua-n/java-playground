package com.chuan.play.spring.cloud.zookeeper.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xucy-e
 */
@FeignClient("zk-client1")
public interface Zk1Client {

    @GetMapping("/hello")
    String sayHello();
}
