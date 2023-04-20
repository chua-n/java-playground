package com.chuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.chuan.PlaySpringBootApplication;
import com.chuan.component.RequestScopeTester;
import com.chuan.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author xucy-e
 */
@RestController
@RequestMapping("/play")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RequestScopeTester requestScopeTester;

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println(1 / 0);
        return helloService.sayHello();
    }

    @GetMapping("/date/{date}")
    public Date echoDate(@PathVariable Date date) {
        System.out.println(date);
        return date;
    }

    @GetMapping("/string/{str}")
    public String echoString(@PathVariable String str) {
        System.out.println(str);
        return str;
    }

    @GetMapping("/thread/1")
    public String echoThread1() {
        return Thread.currentThread().getName();
    }

    @GetMapping("/thread/2")
    public String echoThread2() {
        return Thread.currentThread().getName();
    }

    @GetMapping("/controllerAdvice/modelAttribute")
    public String testModelAttribute(Model model) {
        return (String) model.getAttribute("userName");
    }

    @GetMapping("/bean/scopes/request")
    public String saySomething() {
        // 当开启这条语句，会发现同一语句在调试模式与正常运行模式下的执行效果是不同的：
        // 1. 如果在这条语句处打个断点，会发现RequestScopeTester的生命周期方法被执行了；
        // 2. 如果以非调试模式运行这条语句，则会发现RequestScopeTester的生命周期方法不会执行。
        // return "something...";
        return requestScopeTester.saySomething(); // 代理对象requestScopeTester的任何一个方法执行，都会导致目标对象初始化相应的Bean
    }

    @PostMapping("/appContext/start")
    public void appStart() {
        PlaySpringBootApplication.applicationContext.start();
    }

    @PostMapping("/appContext/stop")
    public void appStop() {
        PlaySpringBootApplication.applicationContext.stop();
    }

    @PostMapping("/appContext/refresh")
    public void appRefresh() {
        // TODO 为啥容器直接宕掉了
        PlaySpringBootApplication.applicationContext.refresh();
    }

    @PostMapping("/fastjson")
    public JSONObject testJsonObj(@RequestBody JSONObject jsonObj) {
        System.out.println(jsonObj);
        return jsonObj;
    }
}
