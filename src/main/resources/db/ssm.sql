SHOW DATABASES;
DROP DATABASE `ssm_db`;
SELECT VERSION();
-- 创建数据库
CREATE DATABASE IF NOT EXISTS ssm_db
DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
-- 创建表
DROP TABLE IF EXISTS `ssm_db`.`ssm_user` ;

CREATE TABLE `ssm_db`.`ssm_user` (
  `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID,自增',
  `user_name` VARCHAR (32) NOT NULL COMMENT '登录名',
  `nick_name` VARCHAR (32) DEFAULT '' COMMENT '昵称',
  `password` VARCHAR (32) NOT NULL COMMENT '密码',
  `user_phone` VARCHAR (32) NOT NULL COMMENT '手机号码',
  `id_delete` TINYINT (1) DEFAULT 0 COMMENT '删除标志,默认0,1删除',
  `user_status` TINYINT (1) DEFAULT 0 COMMENT '用户状态,默认0',
  `user_image` VARCHAR (64) DEFAULT '' COMMENT '用户头像,默认空字符串',
  `user_token` VARCHAR (64) DEFAULT '' COMMENT '用户身份令牌,默认空字符串',
  `add_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '添加时间,默认当前时间',
  `edit_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间,默认当前时间',
  PRIMARY KEY (`id`),
  INDEX index_user_name (`user_name`),
  INDEX inde_nick_name (`nick_name`),
  INDEX index_user_phone (`user_phone`),
  INDEX index_user_login (`user_name`, `password`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT '用户信息表' ;

