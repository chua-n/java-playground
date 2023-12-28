package com.chuan.overload;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FakeListTest {
    @Test
    public void testRemove() {
        List<String> names = Stream.of("ZhangSan", "LiSi", "WangWu").collect(Collectors.toList());
        FakeList<String> fakeList = new FakeList<>(names);
        Integer i = Integer.valueOf("1");
        boolean remove = fakeList.remove(i);
    }
}
