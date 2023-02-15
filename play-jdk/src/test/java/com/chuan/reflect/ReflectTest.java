package com.chuan.reflect;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xucy-e
 */
public class ReflectTest {
    private BaseBean baseBean;
    private SubBean subBean;

    @Before
    public void setUp() {
        baseBean = new BaseBean("ZhangSan", true, 17);
        subBean = new SubBean();
    }

    @Test
    public void testClassSingleton() {
        Class<? extends BaseBean> class1 = baseBean.getClass();
        Class<? extends BaseBean> class2 = baseBean.getClass();
        Assert.assertSame(class1, class2);
    }

    @Test
    public void testFieldPrototype() throws NoSuchFieldException, IllegalAccessException {
        Class<? extends BaseBean> baseBeanClass = baseBean.getClass();
        Field ageField1 = baseBeanClass.getDeclaredField("age");
        Field ageField2 = baseBeanClass.getDeclaredField("age");
        // 同一个字段的不同 Field 对象，其并非同一个引用，setAccessible 的效果也不能相通
        Assert.assertNotSame(ageField1, ageField2);
        ageField1.setAccessible(true);
        Assert.assertEquals(17, ageField1.getInt(baseBean));
        Assert.assertThrows(IllegalAccessException.class, () -> ageField2.getInt(baseBean));
    }

    @Test
    public void testMethodPrototype() throws NoSuchMethodException {
        Class<? extends BaseBean> baseBeanClass = baseBean.getClass();
        // 方法也不是单例的
        Method method1 = baseBeanClass.getDeclaredMethod("sayName");
        Method method2 = baseBeanClass.getDeclaredMethod("sayName");
        Assert.assertNotSame(method1, method2);
    }

    @Test
    public void testAccessible() throws NoSuchFieldException, IllegalAccessException {
        Class<? extends BaseBean> baseBeanClass = baseBean.getClass();
        // protected 字段可以直接访问
        Field genderField = baseBeanClass.getDeclaredField("gender");
        Assert.assertTrue(genderField.getBoolean(baseBean));

        // private 字段需要设置 setAccessible(true)
        Field ageField = baseBeanClass.getDeclaredField("age");
        Assert.assertThrows(IllegalAccessException.class, () -> ageField.getInt(baseBean));
    }

    @Test
    public void testFieldInheritance() {
        Class<? extends BaseBean> baseBeanClass = baseBean.getClass();
        Class<? extends SubBean> subBeanClass = subBean.getClass();

        // getFields() 返回的全都是 public 的
        for (Field field : baseBeanClass.getFields()) {
            Assert.assertTrue(Modifier.toString(field.getModifiers()).contains("public"));
        }
        for (Field field : subBeanClass.getFields()) {
            Assert.assertTrue(Modifier.toString(field.getModifiers()).contains("public"));
        }

        // getFields() 能够获取到父类的 public 的
        Set<Field> basePublicFields = Arrays.stream(baseBeanClass.getFields()).collect(Collectors.toSet());
        Assert.assertTrue(Arrays.stream(subBeanClass.getFields()).anyMatch(basePublicFields::contains));

        // getDeclaredFields() 获取当前类中定义的所有字段，不包含父类，不在乎权限
        Field[] baseDeclaredFields = baseBeanClass.getDeclaredFields();
        System.out.println(Arrays.toString(baseDeclaredFields));
        Assert.assertEquals(4, baseDeclaredFields.length);
        Field[] subDeclaredFields = subBeanClass.getDeclaredFields();
        System.out.println(Arrays.toString(subDeclaredFields));
        Assert.assertEquals(0, subDeclaredFields.length);
    }

    @Test
    public void testMethodOverride() throws NoSuchMethodException {
        Class<? extends BaseBean> baseBeanClass = baseBean.getClass();
        Class<? extends SubBean> subBeanClass = subBean.getClass();
        // 其实因为同一个类的同一个Method都是多例的，那子类和父类的也必然不可能是相同引用了，这个单元测试写得有点寂寞
        // 子类未进行覆盖的方法
        Method baseSayNameMethod = baseBeanClass.getDeclaredMethod("sayName");
        Method subSayNameMethod = subBeanClass.getMethod("sayName");
        Assert.assertNotSame(baseSayNameMethod, subSayNameMethod);
        // 子类覆盖了父类的方法
        Method baseSayGenderMethod = baseBeanClass.getDeclaredMethod("sayGender");
        Method subSayGenderMethod = subBeanClass.getDeclaredMethod("sayGender");
        Assert.assertNotSame(baseSayGenderMethod, subSayGenderMethod);
    }
}
