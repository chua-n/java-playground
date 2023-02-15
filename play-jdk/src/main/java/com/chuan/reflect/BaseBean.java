package com.chuan.reflect;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author xucy-e
 */
@AllArgsConstructor
@NoArgsConstructor
public class BaseBean {

    public static char sign;

    public String name;
    protected boolean gender;
    private int age;

    public String sayName() {
        return this.name;
    }

    protected boolean sayGender() {
        return this.gender;
    }

    private int sayAge() {
        return this.age;
    }
}
