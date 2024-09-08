package com.chuan.controller;

import com.chuan.component.TenantScopeTester;
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
    @Autowired
    private TenantScopeTester tenantScopeTester;

    @GetMapping("/bean/scopes/request")
    public String requestScopeSaySomething() {
        return requestScopeTester.saySomething();
    }

    @GetMapping("/bean/scopes/tenant")
    public String projectScopeSaySomething() {
        return tenantScopeTester.saySomething();
    }
}
