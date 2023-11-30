package com.chuan.mybatis.plus.common;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum XianDistrict {
    YT("雁塔区"),
    BL("碑林区"),
    LH("莲湖区"),
    XC("新城区"),
    WY("未央区"),
    BQ("灞桥区");

    @EnumValue
    private final String cnName;

    XianDistrict(String cnName) {
        this.cnName = cnName;
    }
}
