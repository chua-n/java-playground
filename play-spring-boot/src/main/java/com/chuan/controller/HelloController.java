package com.chuan.controller;

import com.chuan.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xucy-e
 */
@RestController
@RequestMapping("/play")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println(1 / 0);
        return helloService.sayHello();
    }
}
