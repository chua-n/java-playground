package com.chuan.mybatis.plus;

import com.chuan.mybatis.plus.common.Gender;
import com.chuan.mybatis.plus.dao.UserMapper;
import com.chuan.mybatis.plus.entity.User;
import com.chuan.mybatis.plus.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testSelectAll() {
        System.out.println("----- selectAll method test ------");
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(6, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testUserServiceGetById() {
        User byNumber = userService.getById(1);
        User byString = userService.getById("1");
        Assert.assertEquals(byNumber, byString);
        System.out.printf("byNumber: %s\nbyString: %s%n", byNumber, byString);
    }

    @Test
    public void testInsert() throws InterruptedException {
        User user = User.builder()
                .id(10086L)
                .name("xucy-e")
                .email("xucy-e@glodon.com")
                .age(18)
                .gender(Gender.MALE)
                .build();
        userMapper.insert(user);
        Thread.sleep(1000);
        userMapper.updateById(user);
    }

    @Test
    public void testDelete() {
        userMapper.deleteById(10086L);
    }

    @Test
    @Transactional
    public void testStringLength() {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();
        for (int i = 0; i < 255; i++) {
            str1.append("x");
            str2.append("4");
            str3.append("我");
        }
        userMapper.insert(User.builder().id(132131L).introduction(str1.toString()).build());
        userMapper.insert(User.builder().introduction(str2.toString()).build());
        userMapper.insert(User.builder().introduction(str3.toString()).build());
    }

}
