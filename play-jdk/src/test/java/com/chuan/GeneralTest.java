package com.chuan;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

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
}
