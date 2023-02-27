package com.chuan.play.spring.cloud.zookeeper;

import com.chuan.play.spring.cloud.zookeeper.feign.Zk1AliasClient;
import com.chuan.play.spring.cloud.zookeeper.feign.Zk1Client;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xucy-e
 */
@SpringBootTest
public class Zk1ClientTest {
    @Autowired
    private Zk1Client zk1Client;
    @Autowired
    private Zk1AliasClient zk1AliasClient;

    @Test
    public void testCallHello() {
        String response = zk1Client.sayHello();
        Assert.assertNotNull(response);
        System.out.println(response);
        Assert.assertEquals(response, zk1AliasClient.sayHello());
    }
}
