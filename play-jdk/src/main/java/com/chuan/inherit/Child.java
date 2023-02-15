package com.chuan.inherit;

import lombok.AllArgsConstructor;

/**
 * @author xucy-e
 */

@AllArgsConstructor
public class Child extends Parent {
    private String name;
    private int age;
    private String email;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return "lisi@qq.com";
    }

    public String toString() {
        return "Child(super=" + super.toString() + ", name=" + this.name + ", age=" + this.age + ", email=" + this.email + ")";
    }

}
