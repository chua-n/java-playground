package com.chuan.inherit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xucy-e
 */
public class InheritTest {
    private final Child child = new Child("ZhangSan", 17, "zhangsan@qq.com");

    @Before
    public void printChild() {
        System.out.println(child);
    }

    @Test
    public void testFieldBehaviorInMethodOverride() {
        // 子覆盖了父方法，因此是子的name
        Assert.assertEquals("ZhangSan", child.getName());
        // 子未覆盖父方法，实际执行的实际就是父的方法，因此获取父的age
        Assert.assertEquals(0, child.getAge());
    }

    @Test
    public void testMethodBehaviorInMethodOverride() {
        // 子类未覆盖父类方法，因此调用父类方法。然而，在父类方法super.sayEmail()的方法体中，其调用了getEmail()方法
        // 该parent#getEmail()方法被子类覆盖了，因此最终又会调用到子类方法child#getEmail()中
        String childSayEmail = child.sayEmail();
        System.out.println(childSayEmail);
        Assert.assertTrue(childSayEmail.endsWith("lisi@qq.com"));
    }
}
