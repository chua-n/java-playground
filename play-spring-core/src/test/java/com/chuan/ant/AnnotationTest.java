package com.chuan.ant;

import com.chuan.ant.alias.InnerAntAliasTesterConfig;
import com.chuan.ant.composition.CrossAntAliasTester;
import com.chuan.ant.composition.CrossAntAliasTesterConfig;
import com.chuan.ant.composition.PlaceHolderBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @author xucy-e
 */
public class AnnotationTest {

    @Test
    public void testInnerAntAlias() {
        // 注解中互为别名的属性，其默认值应该相同
        Assert.assertThrows(BeanDefinitionStoreException.class, () -> new AnnotationConfigApplicationContext(InnerAntAliasTesterConfig.class));
    }

    @Test
    public void testComposedAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CrossAntAliasTesterConfig.class);
        PlaceHolderBean bean = applicationContext.getBean(PlaceHolderBean.class);
        System.out.println("@AliasFor注解给跨注解属性设置别名的方式使用正确！");
    }

    @Test
    public void testSpringAnnotationUtils() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CrossAntAliasTesterConfig.class);
        PlaceHolderBean bean = applicationContext.getBean(PlaceHolderBean.class);

        CrossAntAliasTester annotationByClass1 = bean.getClass().getAnnotation(CrossAntAliasTester.class);
        CrossAntAliasTester annotationByClass2 = bean.getClass().getAnnotation(CrossAntAliasTester.class);
        Assert.assertSame(annotationByClass1, annotationByClass2);

        CrossAntAliasTester annotationBySpring1 = AnnotationUtils.getAnnotation(bean.getClass(), CrossAntAliasTester.class);
        CrossAntAliasTester annotationBySpring2 = AnnotationUtils.getAnnotation(bean.getClass(), CrossAntAliasTester.class);
        // TODO
        Assert.assertSame(annotationBySpring1, annotationBySpring2);
    }
}
