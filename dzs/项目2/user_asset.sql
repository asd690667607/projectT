/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2019-03-27 10:26:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_asset
-- ----------------------------
DROP TABLE IF EXISTS `user_asset`;
CREATE TABLE `asset_wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `amount` decimal(30,8) DEFAULT NULL COMMENT '账户余额',
  `createTime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=665 DEFAULT CHARSET=utf8 COMMENT='用户资产钱包';
