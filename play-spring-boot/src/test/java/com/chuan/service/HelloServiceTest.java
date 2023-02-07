package com.chuan.service;

import com.chuan.component.RequestScopeTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xucy-e
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Autowired
    private HelloService helloService;
    @Autowired
    private RequestScopeTester requestScopeTester;

    @Test
    public void testSayHello() {
        helloService.sayHello();
    }

    @Test
    public void testRequestScope() {
        // 这里没有HTTP请求，那产生实际的Bean了没？
        requestScopeTester.saySomething();
        requestScopeTester.saySomething();
    }
}
