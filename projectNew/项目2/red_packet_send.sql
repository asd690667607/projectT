/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2019-03-27 10:26:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for asset_red_packet_send
-- ----------------------------
DROP TABLE IF EXISTS `asset_red_packet_send`;
CREATE TABLE `asset_red_packet_send` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) DEFAULT NULL COMMENT '个人用户ID',
  `amount` decimal(30,8) DEFAULT NULL COMMENT '红包发送金额',
  `redPacketCount` int(11) DEFAULT NULL COMMENT '红包发送数量',
  `receiveAmount` decimal(30,8) DEFAULT NULL COMMENT '已领取的红包金额',
  `groupId` int(11) DEFAULT NULL COMMENT '群ID',
  `redPacketType` tinyint(4) DEFAULT NULL COMMENT '红包类型（1拼手气；2均分）',
  `redPacketStatus` tinyint(4) DEFAULT NULL COMMENT '红包状态（1无人领取；2部分领取；3全部领取；4余额退回）',
  `createTime` bigint(20) DEFAULT NULL COMMENT '红包发送时间',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1991 DEFAULT CHARSET=utf8 COMMENT='红包发送记录';
