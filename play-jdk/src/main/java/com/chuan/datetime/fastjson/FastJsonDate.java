package com.chuan.datetime.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author xucy-e
 */
@Data
public class FastJsonDate {
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    @JSONField(format = "yyyy-MM-dd")
    private LocalDate localDate;
}
