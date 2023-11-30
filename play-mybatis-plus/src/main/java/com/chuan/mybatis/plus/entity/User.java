package com.chuan.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chuan.mybatis.plus.common.Gender;
import com.chuan.mybatis.plus.common.XianDistrict;
import lombok.*;

/**
 * @author xucy-e
 */
@Builder
@EqualsAndHashCode(callSuper = true)
@TableName
@ToString(callSuper = true)
@Data
public class User extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private Gender gender;

    private String email;

    @TableField("user_qr_code")
    private String userQRCode;

    private String introduction;

    private XianDistrict district;
}
