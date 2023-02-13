package com.chuan.datetime.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xucy-e
 */
public class FastJsonDateTest {
    @Test
    public void testToJson() {
        FastJsonDate fastJsonDate = new FastJsonDate();
        // Calendar calendar = Calendar.getInstance();
        // calendar.set(2022, 8, 12, 23, 30);
        // fastJsonDate.setDate(calendar.getTime());
        fastJsonDate.setDate(new Date("September 12, 2022 00:15:34"));
        fastJsonDate.setLocalDateTime(LocalDateTime.of(2022, 9, 12, 0, 15, 34));
        fastJsonDate.setLocalDate(LocalDate.of(2022, 9, 12));
        System.out.println(JSON.toJSONString(fastJsonDate));
    }

    @Test
    public void testJsonArray() {
        List<Integer> ints = Stream.of(1, 2, 3).collect(Collectors.toList());
        String s = JSONArray.toJSONString(ints);
        System.out.println(s);
        List<Integer> integers = JSONArray.parseArray(s, Integer.class);
        System.out.println(integers);
        Assert.assertEquals(ints, integers);
    }
}
