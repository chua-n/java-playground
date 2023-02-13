package com.chuan.datetime;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xucy-e
 */
public class DateTimeOperationTest {
    @Test
    public void testDateChange() {
        Calendar calendar = Calendar.getInstance();

        Date curTime = calendar.getTime();
        System.out.printf("当时时间：%s\n", curTime);

        calendar.add(Calendar.DATE, 1);
        Date tomorrowTime = calendar.getTime();
        System.out.printf("一天后的时间：%s\n", tomorrowTime);

        calendar.add(Calendar.DATE, 25);
        System.out.printf("25天后的时间：%s\n", calendar.getTime());

    }
}
