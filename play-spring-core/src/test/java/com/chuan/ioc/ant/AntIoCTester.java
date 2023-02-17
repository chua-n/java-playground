package com.chuan.ioc.ant;

import com.chuan.ioc.ant.autowired.AutowiredConfig;
import com.chuan.ioc.ant.autowired.UserServiceWithPrivateConstructor;
import com.chuan.ioc.ant.aware.AwareConfig;
import com.chuan.ioc.ant.aware.UserServiceInAwarePackage;
import com.chuan.ioc.ant.beanMethod.BeanConfig;
import com.chuan.ioc.ant.beanMethod.bean.BeanXX;
import com.chuan.ioc.ant.beanMethod.bean.BeanYY;
import com.chuan.ioc.ant.lifecyfle.LifecycleConfig;
import com.chuan.ioc.ant.lifecyfle.UserServiceInLifecyclePackage;
import com.chuan.ioc.ant.lookup.LookupConfig;
import com.chuan.ioc.ant.lookup.UserServiceInLookupPackage;
import com.chuan.ioc.ant.postProcessor.PostProcessorConfig;
import com.chuan.ioc.ant.propertyRead.PropertyReadConfig;
import com.chuan.ioc.ant.propertyRead.UserProperty;
import com.chuan.ioc.IUserDAO;
import com.chuan.util.MyPrinter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xucy-e
 */
public class AntIoCTester {

    @Test
    public void testLookup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LookupConfig.class);
        UserServiceInLookupPackage userService = applicationContext.getBean(UserServiceInLookupPackage.class);
        IUserDAO userDAO1 = userService.getUserDAO();
        IUserDAO userDAO2 = userService.getUserDAO();
        MyPrinter.println(userDAO1, userDAO2, userDAO1 == userDAO2);
        Assert.assertNotSame(userDAO1, userDAO2);
    }

    @Test
    public void testAware() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AwareConfig.class);
        System.out.println("\n>>>>>>>>>>>>>>> ioc container is created <<<<<<<<<<<<<<<\n");
        UserServiceInAwarePackage userService = applicationContext.getBean(UserServiceInAwarePackage.class);
        Assert.assertSame(applicationContext, userService.getApplicationContext());
        Assert.assertEquals("userServiceInAwarePackage", userService.getBeanName());
    }

    @Test
    public void testLifecycle() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        System.out.println("\n>>>>>>>>>>>>>>> ioc container is created <<<<<<<<<<<<<<<\n");
        applicationContext.start();
        UserServiceInLifecyclePackage userService = applicationContext.getBean(UserServiceInLifecyclePackage.class);
        applicationContext.stop();
        // applicationContext.close();
        IUserDAO userDAO = userService.getUserDAO();
        userDAO.find();
    }

    @Test
    public void testPrivateConstructor() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        UserServiceWithPrivateConstructor userService = applicationContext.getBean(UserServiceWithPrivateConstructor.class);
        Assert.assertNotEquals(null, userService);
    }

    @Test
    public void testPropertyRead() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyReadConfig.class);
        UserProperty userProperty = applicationContext.getBean(UserProperty.class);
        System.out.println(userProperty);
    }

    @Test
    public void testBeanMethod() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        BeanXX beanXX = applicationContext.getBean(BeanXX.class);
        BeanYY beanYY = applicationContext.getBean(BeanYY.class);
        Assert.assertSame(beanXX.getBeanX1(), beanXX.getBeanX2());
        Assert.assertNotSame(beanYY.getBeanY1(), beanYY.getBeanY2());
    }

    @Test
    public void testPostProcessor() {
        new AnnotationConfigApplicationContext(PostProcessorConfig.class);
    }
}
