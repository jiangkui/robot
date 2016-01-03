#建表语句：
CREATE DATABASE one
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE one;

CREATE TABLE `user` (
  `id`             BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cid`            BIGINT(20)          DEFAULT NULL
  COMMENT '用户id',
  `uid`            VARCHAR(100)        DEFAULT NULL
  COMMENT '用户账号',
  `nickname`       VARCHAR(500)        DEFAULT NULL
  COMMENT '昵称',
  `IP_address`     VARCHAR(500)        DEFAULT NULL
  COMMENT 'ip地址',
  `avatar_name`    VARCHAR(100)        DEFAULT NULL
  COMMENT '头像名称',
  `avatar_prefix`  VARCHAR(500)        DEFAULT NULL
  COMMENT '头像前缀',
  `IP`             VARCHAR(100)        DEFAULT NULL
  COMMENT 'IP',
  `mobile`         VARCHAR(100)        DEFAULT NULL
  COMMENT '手机号',
  `free_coin`      VARCHAR(100)        DEFAULT NULL,
  `is_first_login` VARCHAR(100)        DEFAULT NULL,
  `coin`           VARCHAR(100)        DEFAULT NULL,
  `bonus_num`      VARCHAR(100)        DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid_UNIQUE` (`cid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `period_winner` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `period`      BIGINT(20)          DEFAULT NULL
  COMMENT '期号',
  `cid`         BIGINT(20)          DEFAULT NULL
  COMMENT '用户id',
  `gid`         BIGINT(20)          DEFAULT NULL
  COMMENT '商品id',
  `owner_cost`  VARCHAR(45)         DEFAULT NULL
  COMMENT '本期参与次数',
  `lucky_code`  VARCHAR(45)         DEFAULT NULL
  COMMENT '幸运号码',
  `duobao_time` DATETIME            DEFAULT NULL
  COMMENT '夺宝时间',
  `calc_time`   DATETIME            DEFAULT NULL
  COMMENT '揭晓时间',
  `status`      VARCHAR(45)         DEFAULT NULL
  COMMENT '状态',
  `cost`        VARCHAR(45)         DEFAULT NULL
  COMMENT 'cost',
  PRIMARY KEY (`id`),
  UNIQUE KEY `period_UNIQUE` (`period`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;