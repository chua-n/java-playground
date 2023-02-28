package com.chuan.play.spring.cloud.nacos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xucy-e
 */
@FeignClient("nacos-client-1")
public interface Nacos1Client {

    @GetMapping("/hello")
    String sayHello();
}
