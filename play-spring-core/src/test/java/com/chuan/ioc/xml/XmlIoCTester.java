package com.chuan.ioc.xml;

import com.chuan.ioc.IUserDAO;
import com.chuan.ioc.IUserService;
import com.chuan.ioc.xml.bean.XMLUserService;
import com.chuan.util.MyPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xucy-e
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:ioc.xml")
public class XmlIoCTester {

    private ClassPathXmlApplicationContext applicationContext;

    private XMLUserService userService;

    @Before
    public void setApplicationContext() {
        this.applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        this.userService = (XMLUserService) applicationContext.getBean("userServiceWithLookup");
    }

    @Test
    public void testMultiIoCContainers() {
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("ioc.xml");
        ClassPathXmlApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("ioc.xml");
        Assert.assertNotSame(applicationContext1, applicationContext2);

        IUserService userService1 = applicationContext1.getBean(IUserService.class);
        IUserService userService2 = applicationContext2.getBean(IUserService.class);
        Assert.assertNotSame(userService1, userService2);
    }

    @Test
    public void testGetBean() {
        IUserService userService1 = (IUserService) applicationContext.getBean("userServiceWithLookup");
        IUserService userService2 = applicationContext.getBean(IUserService.class);
        Assert.assertSame(userService1, userService2);
    }

    @Test
    public void testPrototypeAndLookup() {
        IUserDAO userDAO1 = userService.getUserDAO();
        IUserDAO userDAO2 = userService.getUserDAO();
        MyPrinter.println(userDAO1, userDAO2, userDAO1 == userDAO2);
        Assert.assertNotSame(userDAO1, userDAO2);
    }

    @Test
    public void testMethodReplacer() {
        MyPrinter.println(userService.introduce("ZhangSan"));
    }
}
