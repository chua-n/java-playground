package com.chuan.ioc.ant.bean.value;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author xucy-e
 */
@ToString
@Service
public class UserProperty {

    @Value("${user.name:xyz}")
    private String userName;

    @Value("${user.home}") // 读取成了操作系统用户的家目录
    private String home;

    @Value("${user.email:xyz@163.com}")
    private String emailAddress;

    @Value("${user.gender:false}")
    private Boolean gender;

    @Value("${user.single:false}")
    private Single single;

    @ToString
    @AllArgsConstructor
    public static class Single {
        private boolean flag;
    }
}
