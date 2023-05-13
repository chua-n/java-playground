package com.chuan.comparator;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author xucy-e
 */
@ToString
@Builder
@Data
public class Person {
    private Boolean gender;
    private Integer age;
    private String name;
}
