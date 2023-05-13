package com.chuan.comparator;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xucy-e
 */
public class PersonTest {
    private List<Person> people;

    @Before
    public void prepareData() {
        this.people = Stream.of(
                Person.builder().gender(true).age(18).name("ZhangSan").build(),
                Person.builder().gender(false).age(17).name("ZhangSan").build(),
                Person.builder().gender(true).age(20).name("LiSi").build(),
                Person.builder().gender(false).age(17).name("WangWu").build(),
                Person.builder().gender(true).age(20).name("WangWu").build()
        ).collect(Collectors.toList());
        System.out.println(people);
    }

    @Test
    public void testJdk8Comparator() {
        // 直接排序
        people.sort(Comparator.comparing(Person::getGender).thenComparing(Person::getAge).thenComparing(Person::getName));
        System.out.println(people);

        // 测试含 null 的情况
        people.get(0).setAge(null);
        people.get(1).setGender(null);
        people.get(2).setName(null);
        people.sort(Comparator.comparing(Person::getGender, Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(Person::getAge, Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(Person::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println(people);
    }
}
