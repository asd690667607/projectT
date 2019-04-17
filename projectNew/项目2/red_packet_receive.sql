/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2019-03-27 10:26:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for red_packet_receive
-- ----------------------------
DROP TABLE IF EXISTS `red_packet_receive`;
CREATE TABLE `red_packet_receive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `redPacketId` bigint(20) DEFAULT NULL COMMENT '红包ID（红包发送记录ID）',
  `fromUserId` int(11) DEFAULT NULL COMMENT '发送方用户ID',
  `toUserId` int(11) DEFAULT NULL COMMENT '领取方用户ID',
  `amount` decimal(30,8) DEFAULT NULL COMMENT '领取数量',
  `createTime` bigint(20) DEFAULT NULL COMMENT '领取时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2188 DEFAULT CHARSET=utf8 COMMENT='红包领取记录';
