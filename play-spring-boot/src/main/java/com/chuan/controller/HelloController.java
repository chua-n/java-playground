package com.chuan.controller;

import com.chuan.component.RequestScopeTester;
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
    private RequestScopeTester requestScopeTester;

    @GetMapping("/bean/scopes/request")
    public String saySomething() {
        return "something...";
    }
}
