package com.chuan.ioc.ant;

import com.chuan.ioc.IUserDAO;
import com.chuan.ioc.ant.autowired.AutowiredConfig;
import com.chuan.ioc.ant.autowired.UserServiceWithPrivateConstructor;
import com.chuan.ioc.ant.aware.AwareConfig;
import com.chuan.ioc.ant.aware.UserServiceInAwarePackage;
import com.chuan.ioc.ant.beanMethod.BeanConfig;
import com.chuan.ioc.ant.beanMethod.bean.x.BeanXX;
import com.chuan.ioc.ant.beanMethod.bean.x.XConfig;
import com.chuan.ioc.ant.beanMethod.bean.y.BeanYY;
import com.chuan.ioc.ant.beanMethod.bean.y.YConfig;
import com.chuan.ioc.ant.lifecyfle.LifecycleConfig;
import com.chuan.ioc.ant.lifecyfle.UserServiceInLifecyclePackage;
import com.chuan.ioc.ant.lookup.LookupConfig;
import com.chuan.ioc.ant.lookup.UserServiceInLookupPackage;
import com.chuan.ioc.ant.postProcessor.PostProcessorConfig;
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
    public void testBeanMethod() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        // @Configuration中的@Bean方法会被Spring代理，两个beanX是从IoC容器里取的，所以两个beanX相同
        XConfig xConfig = applicationContext.getBean(XConfig.class);
        BeanXX beanXX = xConfig.getBeanXX();
        Assert.assertSame(beanXX.getBeanX1(), beanXX.getBeanX2());
        Assert.assertNotNull(beanXX.getBeanX1().getBeanO());

        // @Component中的@Bean方法不会被Spring代理，两个beanY就是new出来的，所以两个beanY不同
        YConfig yConfig = applicationContext.getBean(YConfig.class);
        BeanYY beanYY = yConfig.getBeanYY();
        Assert.assertNotSame(beanYY.getBeanY1(), beanYY.getBeanY2());
        Assert.assertNull(beanYY.getBeanY1().getBeanO());
    }

    @Test
    public void testPostProcessor() {
        new AnnotationConfigApplicationContext(PostProcessorConfig.class);
    }
}
