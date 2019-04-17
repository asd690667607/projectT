/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2019-03-27 10:27:13
*/
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_bill
-- ----------------------------
DROP TABLE IF EXISTS `user_bill`;
CREATE TABLE `user_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `availableVariation` decimal(30,8) DEFAULT NULL COMMENT '可用变化量',
  `availableBalance` decimal(30,8) DEFAULT NULL COMMENT '可用余额',
  `billExplain` varchar(1000) DEFAULT NULL COMMENT '账单说明',
  `walletId` bigint(20) DEFAULT NULL COMMENT '钱包ID',
  `bizId` varchar(200) DEFAULT NULL COMMENT '业务ID',
  `createTime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85733 DEFAULT CHARSET=utf8 COMMENT='资产账单信息';
