package com.chuan.play.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xucy-e
 */
@RequestMapping("/play/spring/security")
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, spring security!";
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi, chuan!";
    }
}
