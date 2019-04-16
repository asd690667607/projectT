/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2019-03-27 10:32:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for personal_user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL COMMENT '个人用户ID',
  `payPass` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '支付密码',
  `paySalt` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '盐',
  `nickName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `realName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实姓名',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='个人用户信息';
