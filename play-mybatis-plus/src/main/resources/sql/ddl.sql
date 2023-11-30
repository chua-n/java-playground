-- `play-mybatis-plus`.`user` definition

CREATE TABLE `user`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`         varchar(30)                                                  DEFAULT NULL COMMENT '姓名',
    `age`          int(11)                                                      DEFAULT NULL COMMENT '年龄',
    `email`        varchar(50)                                                  DEFAULT NULL COMMENT '邮箱',
    `create_time`  datetime   NOT NULL,
    `update_time`  datetime                                                     DEFAULT NULL,
    `user_qr_code` varchar(100)                                                 DEFAULT NULL COMMENT '二维码',
    `gender`       enum ('MALE','FEMALE')                                       DEFAULT NULL COMMENT '性别',
    `introduction` varchar(255)                                                 DEFAULT NULL,
    `district`     enum ('雁塔区','碑林区','莲湖区','新城区','未央区','灞桥区') DEFAULT NULL COMMENT '行政区',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10010
  DEFAULT CHARSET = utf8;
