package com.chuan.ioc.ant;

import com.chuan.ioc.ant.bean.UserServiceWithAware;
import com.chuan.ioc.ant.bean.UserServiceWithLifecycle;
import com.chuan.ioc.ant.bean.UserServiceWithLookup;
import com.chuan.ioc.ant.bean.autowired.UserServiceWithPrivateConstructor;
import com.chuan.ioc.ant.bean.otherbean.BeanXX;
import com.chuan.ioc.ant.bean.otherbean.BeanYY;
import com.chuan.ioc.ant.bean.value.UserProperty;
import com.chuan.ioc.bean.IUserDAO;
import com.chuan.util.MyPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xucy-e
 */
public class AntTester {

    private AnnotationConfigApplicationContext applicationContext;

    @Before
    public void setApplicationContext() {
        this.applicationContext = new AnnotationConfigApplicationContext(IoCAppConfig.class);
        System.out.println("\n>>>>>>>>>>>>>>> ioc container is created <<<<<<<<<<<<<<<\n");
    }

    @Test
    public void testLookup() {
        final String beanName = "userServiceWithLookup";
        UserServiceWithLookup userService = (UserServiceWithLookup) applicationContext.getBean(beanName);
        IUserDAO userDAO1 = userService.getUserDAO();
        IUserDAO userDAO2 = userService.getUserDAO();
        MyPrinter.println(userDAO1, userDAO2, userDAO1 == userDAO2);
        Assert.assertNotSame(userDAO1, userDAO2);
    }

    @Test
    public void testAware() {
        final String beanName = "userServiceWithAware";
        UserServiceWithAware userService = (UserServiceWithAware) applicationContext.getBean(beanName);
        Assert.assertSame(applicationContext, userService.getApplicationContext());
        Assert.assertEquals(beanName, userService.getBeanName());
    }

    @Test
    public void testLifecycle() {
        final String beanName = "userServiceWithLifecycle";
        applicationContext.start();
        UserServiceWithLifecycle userService = (UserServiceWithLifecycle) applicationContext.getBean(beanName);
        applicationContext.stop();
        // applicationContext.close();
        IUserDAO userDAO = userService.getUserDAO();
        userDAO.find();
    }

    @Test
    public void testPrivateConstructor() {
        final String beanName = "userServiceWithPrivateConstructor";
        UserServiceWithPrivateConstructor userService = (UserServiceWithPrivateConstructor) applicationContext.getBean(beanName);
        Assert.assertNotEquals(null, userService);
    }

    @Test
    public void testPropertyRead() {
        UserProperty userProperty = applicationContext.getBean(UserProperty.class);
        System.out.println(userProperty);
    }

    @Test
    public void testBeanMethod() {
        BeanXX beanXX = applicationContext.getBean(BeanXX.class);
        BeanYY beanYY = applicationContext.getBean(BeanYY.class);
        Assert.assertSame(beanXX.getBeanX1(), beanXX.getBeanX2());
        Assert.assertNotSame(beanYY.getBeanY1(), beanYY.getBeanY2());
    }
}
