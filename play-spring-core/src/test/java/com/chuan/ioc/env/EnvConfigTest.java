package com.chuan.ioc.env;

import com.chuan.ioc.env.profile.ProfileConfigFromSys;
import com.chuan.ioc.env.profile.bean.BeanDefault;
import com.chuan.ioc.env.profile.bean.BeanDev;
import com.chuan.ioc.env.profile.bean.BeanTest;
import com.chuan.ioc.env.propertyRead.PropertyReadConfig;
import com.chuan.ioc.env.propertyRead.UserProperty;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

/**
 * @author xucy-e
 */
public class EnvConfigTest {
    private static final String keyActiveProfile = "spring.profiles.active";
    private static final String keyDefaultProfile = "spring.profiles.default";


    @Test
    public void testDefaultProfileToString() {
        System.setProperty(keyActiveProfile, "dev");
        System.setProperty(keyDefaultProfile, "test");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfigFromSys.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // Spring的人类迷惑行为：environment
        System.out.println(environment);
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println(environment);
    }

    @Test
    public void testProfileActivation() {
        System.setProperty(keyActiveProfile, "dev");
        System.setProperty(keyDefaultProfile, "test");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfigFromSys.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Assert.assertTrue(Arrays.asList(environment.getActiveProfiles()).contains("dev"));
        Assert.assertTrue(Arrays.asList(environment.getDefaultProfiles()).contains("test"));
        Assert.assertNotNull(applicationContext.getBean(BeanDefault.class));
        Assert.assertNotNull(applicationContext.getBean(BeanDev.class));
        Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(BeanTest.class));
    }

    @Test
    public void testProfileActivationFromPropertyFile() {
        // 在Spring Framework中，通过常规的配置文件似乎无法激活spring的相关配置
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfigFromSys.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Assert.assertFalse(Arrays.asList(environment.getActiveProfiles()).contains("dev"));
        Assert.assertFalse(Arrays.asList(environment.getDefaultProfiles()).contains("test"));
        Assert.assertNotNull(applicationContext.getBean(BeanDefault.class));
        Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(BeanDev.class));
        Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(BeanTest.class));
    }

    @Test
    public void testPropertyRead() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyReadConfig.class);
        UserProperty userProperty = applicationContext.getBean(UserProperty.class);
        System.out.println(userProperty);
    }

    @After
    public void removeSystemExtraProperties() {
        System.clearProperty(keyDefaultProfile);
        System.clearProperty(keyActiveProfile);
    }
}
