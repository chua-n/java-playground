package com.chuan.play.spring.cloud.nacos;

import com.chuan.play.spring.cloud.nacos.feign.Nacos1Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Nacos1ClientTest {

    @Autowired
    private Nacos1Client nacos1Client;

    @Test
    public void sayHello() {
        String response = nacos1Client.sayHello();
        System.out.println(response);
        Assert.assertNotNull(response);
    }
}
