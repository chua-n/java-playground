package com.chuan;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneralTest {
    @Test
    public void testMapHashCode() {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("key", BigDecimal.ZERO);
        System.out.println(linkedHashMap.hashCode());

        linkedHashMap.put("key", null);
        System.out.println(linkedHashMap.hashCode());

        linkedHashMap.remove("key");
        System.out.println(linkedHashMap.hashCode());
    }

    @Test
    public void testBigDecimalHashCode() {
        BigDecimal[] zeros = new BigDecimal[]{
                BigDecimal.ZERO,
                new BigDecimal("0"),
                new BigDecimal("0.0"),
                new BigDecimal("0.00")
        };
        for (BigDecimal zero : zeros) {
            System.out.println(zero.hashCode());
        }
    }

    @Test
    public void testCollectionOf() {
        Set<String> set = Set.of("a", "b");
        Assert.assertTrue(set.contains("a"));
        Assert.assertThrows(NullPointerException.class, () -> set.contains(null));

        List<String> list = List.of("a", "b");
        Assert.assertFalse(list.contains("c"));
        Assert.assertThrows(NullPointerException.class, () -> list.contains(null));
    }
}
