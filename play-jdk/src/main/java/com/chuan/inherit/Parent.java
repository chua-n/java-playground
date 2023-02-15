package com.chuan.inherit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xucy-e
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Parent {
    public String name;
    public int age;
    public String email;

    public String sayEmail() {
        return "My email is: " + this.getEmail();
    }

    @Override
    public String toString() {
        return "Parent(name=" + this.name + ", age=" + this.age + ", email=" + this.email + ")";
    }
}
