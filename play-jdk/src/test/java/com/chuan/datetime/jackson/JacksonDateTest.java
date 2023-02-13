package com.chuan.datetime.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author xucy-e
 */
public class JacksonDateTest {

    @Test
    public void testToJson() throws JsonProcessingException {
        JacksonDate jacksonDate = new JacksonDate();
        jacksonDate.setDate(new Date("September 12, 2022 00:15:34"));
        jacksonDate.setLocalDateTime(LocalDateTime.of(2022, 9, 12, 0, 15, 34));
        jacksonDate.setLocalDate(LocalDate.of(2022, 9, 12));
        ObjectMapper mapper = new ObjectMapper();
        // java对象转换为json字符换
        String json = mapper.writeValueAsString(jacksonDate);
        // {"date":"2022-09-11 16:15:34","localDateTime":"2022-09-12 00:15:34","localDate":"2022-09-12"}
        System.out.println(json);
    }
}
