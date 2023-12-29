package com.chuan.aop;

import com.chuan.aop.introduction.IntroService;
import com.chuan.aop.introduction.MixinService;
import com.chuan.aop.order.service.IBuy;
import com.chuan.aop.order.service.impl.Buyer;
import com.chuan.aop.parameter.binding.ParameterBindingService;
import com.chuan.aop.proxy.Advice;
import com.chuan.aop.proxy.cglib.LickDog;
import com.chuan.aop.proxy.cglib.LickDogMethodInterceptor;
import com.chuan.aop.proxy.jdk.GunDog;
import com.chuan.aop.proxy.jdk.IDog;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

/**
 * @author xucy-e
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AOPAppConfig.class})
public class AOPTester {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private IBuy buyer;
    @Autowired
    private ParameterBindingService parameterBindingService;
    @Autowired
    private IntroService introService;

    @Test
    public void testBeanProxy() {
        // 代理后的bean已不是原来的类型
        Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(Buyer.class));
        IBuy buyer = applicationContext.getBean(IBuy.class);
        System.out.println(buyer.getClass().getSimpleName());
    }

    @Test
    public void testJDKDynamicProxy() {
        final GunDog gunDog = new GunDog(); //目标对象
        Advice advice = new Advice(); // 增强对象
        // 调用代理对象的任何方法，实质执行的都是invoke方法
        IDog proxyDog = (IDog) Proxy.newProxyInstance(
                gunDog.getClass().getClassLoader(), // 目标对象的类加载器
                gunDog.getClass().getInterfaces(), // 目标对象相同的接口字节码对象数组
                (proxy, method, args) -> { // InvocationHandler
                    advice.before();
                    Object res = method.invoke(gunDog, args); // 注意触发方法时传入的主调是目标对象`gunDog`
                    advice.afterReturning();
                    return res;
                }
        );
        System.out.println("----------------------目标对象的info方法调用结果----------------------");
        gunDog.info();
        System.out.println("----------------------代理对象的info方法调用结果----------------------");
        proxyDog.info();
        System.out.println("----------------------单独调用代理对象的speed方法----------------------");
        proxyDog.speed();
    }

    // TODO WTF 怎么能嵌套AOP了？？？
    @Test
    public void testCGLibDynamicProxy() {
        String tempDir = System.getProperty("java.io.tmpdir");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, tempDir);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(LickDog.class);
        enhancer.setCallback(new LickDogMethodInterceptor());
        LickDog proxyLickDog = (LickDog) enhancer.create();
        LickDog targetLickDog = new LickDog();
        System.out.println("----------------------目标对象的info方法调用结果----------------------");
        targetLickDog.info(true);
        System.out.println("----------------------代理对象的info方法调用结果----------------------");
        proxyLickDog.info(true);
        System.out.println("----------------------单独调用代理对象的speed方法----------------------");
        proxyLickDog.speed();
    }

    @Test
    public void testAspectOrder() {
        buyer.buy();
    }

    @Test
    public void testParameterBinding() {
        parameterBindingService.test("ZhangSan", 18);
    }

    @Test
    public void testIntroduction() {
        introService.test();
        ((MixinService) introService).mixinMethod1();
        ((MixinService) introService).mixinMethod2();

        System.out.println();

        MixinService mixinService = this.applicationContext.getBean(MixinService.class);
        ((IntroService) mixinService).test();
        Assert.assertSame(introService, mixinService);
    }
}
