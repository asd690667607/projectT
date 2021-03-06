/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.15 : Database - red_packet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`red_packet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `red_packet`;

/*Table structure for table `asset_red_packet_send` */

DROP TABLE IF EXISTS `asset_red_packet_send`;

CREATE TABLE `asset_red_packet_send` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) DEFAULT NULL COMMENT '个人用户ID',
  `amount` decimal(30,8) DEFAULT NULL COMMENT '红包发送金额',
  `redPacketCount` int(11) DEFAULT NULL COMMENT '红包发送数量',
  `receiveAmount` decimal(30,8) DEFAULT NULL COMMENT '已领取的红包金额',
  `stock` int(12) NOT NULL COMMENT '红包剩余个数',
  `groupId` int(11) DEFAULT NULL COMMENT '群ID',
  `redPacketType` tinyint(4) DEFAULT NULL COMMENT '红包类型（1拼手气；2均分）',
  `redPacketStatus` tinyint(4) DEFAULT NULL COMMENT '红包状态（1无人领取；2部分领取；3全部领取；4余额退回）',
  `createTime` bigint(20) DEFAULT NULL COMMENT '红包发送时间',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8 COMMENT='红包发送记录';

/*Data for the table `asset_red_packet_send` */

insert  into `asset_red_packet_send`(`id`,`userId`,`amount`,`redPacketCount`,`receiveAmount`,`stock`,`groupId`,`redPacketType`,`redPacketStatus`,`createTime`,`updateTime`,`version`) values (169,1,'10.00000000',3,'0.00000000',2,NULL,1,4,20190415142519,20190415142600,0),(170,1,'10.00000000',3,'0.00000000',1,NULL,1,4,20190415142746,20190415142800,0),(171,1,'10.00000000',3,'0.00000000',2,NULL,1,4,20190415142746,20190415142800,0),(172,1,'10.00000000',3,'0.00000000',3,NULL,1,4,20190415142747,20190415142800,0),(173,1,'10.00000000',3,'0.00000000',2,NULL,1,4,20190415143007,20190415143100,0),(174,1,'10.00000000',3,'0.00000000',1,NULL,1,4,20190415143007,20190415143100,0),(175,1,'10.00000000',3,'0.00000000',3,NULL,1,4,20190415143008,20190415143100,0),(176,1,'10.00000000',3,'0.00000000',2,NULL,1,4,20190415143133,20190415143200,0),(177,1,'10.00000000',3,'0.00000000',2,NULL,1,4,20190415143133,20190415143200,0),(178,1,'10.00000000',3,'0.00000000',2,NULL,1,4,20190415143134,20190415143200,0),(179,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415151850,NULL,0),(180,1,'10.00000000',3,'0.00000000',3,NULL,1,4,20190415151851,20190415152000,0),(181,1,'10.00000000',3,'0.00000000',3,NULL,1,4,20190415151852,20190415152000,0),(182,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415152000,NULL,0),(183,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415152054,NULL,0),(184,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415152300,NULL,0),(185,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415152413,NULL,0),(186,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415152631,NULL,0),(187,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415153008,NULL,0),(188,1,'10.00000000',3,'0.00000000',2,NULL,1,2,20190415153334,NULL,0),(189,1,'10.00000000',3,'0.00000000',1,NULL,1,4,20190415153736,20190415153800,0);

/*Table structure for table `asset_wallet` */

DROP TABLE IF EXISTS `asset_wallet`;

CREATE TABLE `asset_wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `amount` decimal(30,8) DEFAULT NULL COMMENT '账户余额',
  `createTime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8 COMMENT='用户资产钱包';

/*Data for the table `asset_wallet` */

insert  into `asset_wallet`(`id`,`userId`,`amount`,`createTime`,`updateTime`) values (1,1,'358.98000000',NULL,20190415153800),(2,2,'546.72000000',NULL,20190415153740),(3,3,'513.55000000',NULL,20190415153743),(4,4,'500.00000000',NULL,20190413153509),(5,5,'500.00000000',NULL,NULL);

/*Table structure for table `red_packet_receive` */

DROP TABLE IF EXISTS `red_packet_receive`;

CREATE TABLE `red_packet_receive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `redPacketId` bigint(20) DEFAULT NULL COMMENT '红包ID（红包发送记录ID）',
  `fromUserId` int(11) DEFAULT NULL COMMENT '发送方用户ID',
  `toUserId` int(11) DEFAULT NULL COMMENT '领取方用户ID',
  `amount` decimal(30,8) DEFAULT NULL COMMENT '领取数量',
  `createTime` bigint(20) DEFAULT NULL COMMENT '领取时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 COMMENT='红包领取记录';

/*Data for the table `red_packet_receive` */

insert  into `red_packet_receive`(`id`,`redPacketId`,`fromUserId`,`toUserId`,`amount`,`createTime`) values (117,169,1,2,'4.07000000',20190415142526),(118,170,1,2,'0.49000000',20190415142752),(119,170,1,3,'4.92000000',20190415142755),(120,171,1,2,'3.75000000',20190415142758),(121,173,1,2,'3.51000000',20190415143013),(122,174,1,2,'2.60000000',20190415143017),(123,174,1,3,'4.35000000',20190415143020),(124,176,1,2,'2.81000000',20190415143144),(125,177,1,2,'0.40000000',20190415143146),(126,178,1,2,'5.79000000',20190415143148),(127,179,1,2,'1.40000000',20190415151857),(128,182,1,2,'2.29000000',20190415152005),(129,183,1,2,'1.49000000',20190415152058),(130,184,1,2,'0.23000000',20190415152320),(131,185,1,2,'3.50000000',20190415152420),(132,186,1,2,'2.96000000',20190415152635),(133,187,1,2,'6.37000000',20190415153015),(134,188,1,2,'1.01000000',20190415153338),(135,189,1,2,'4.05000000',20190415153740),(136,189,1,3,'4.28000000',20190415153743);

/*Table structure for table `user_bill` */

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
) ENGINE=InnoDB AUTO_INCREMENT=86239 DEFAULT CHARSET=utf8 COMMENT='资产账单信息';

/*Data for the table `user_bill` */

insert  into `user_bill`(`id`,`userId`,`availableVariation`,`availableBalance`,`billExplain`,`walletId`,`bizId`,`createTime`) values (86185,1,'10.00000000','490.00000000','发送红包',1,NULL,20190415142519),(86186,2,'4.07000000','504.07000000','领取红包',2,NULL,20190415142526),(86187,1,'5.93000000','495.93000000','退回红包',1,NULL,20190415142600),(86188,1,'10.00000000','485.93000000','发送红包',1,NULL,20190415142746),(86189,1,'10.00000000','475.93000000','发送红包',1,NULL,20190415142746),(86190,1,'10.00000000','465.93000000','发送红包',1,NULL,20190415142747),(86191,2,'0.49000000','504.56000000','领取红包',2,NULL,20190415142752),(86192,3,'4.92000000','504.92000000','领取红包',3,NULL,20190415142755),(86193,2,'3.75000000','508.31000000','领取红包',2,NULL,20190415142758),(86194,1,'4.59000000','470.52000000','退回红包',1,NULL,20190415142800),(86195,1,'6.25000000','476.77000000','退回红包',1,NULL,20190415142800),(86196,1,'10.00000000','486.77000000','退回红包',1,NULL,20190415142800),(86197,1,'10.00000000','476.77000000','发送红包',1,NULL,20190415143007),(86198,1,'10.00000000','466.77000000','发送红包',1,NULL,20190415143007),(86199,1,'10.00000000','456.77000000','发送红包',1,NULL,20190415143008),(86200,2,'3.51000000','511.82000000','领取红包',2,NULL,20190415143013),(86201,2,'2.60000000','514.42000000','领取红包',2,NULL,20190415143017),(86202,3,'4.35000000','509.27000000','领取红包',3,NULL,20190415143020),(86203,1,'6.49000000','463.26000000','退回红包',1,NULL,20190415143100),(86204,1,'3.05000000','466.31000000','退回红包',1,NULL,20190415143100),(86205,1,'10.00000000','476.31000000','退回红包',1,NULL,20190415143100),(86206,1,'10.00000000','466.31000000','发送红包',1,NULL,20190415143133),(86207,1,'10.00000000','456.31000000','发送红包',1,NULL,20190415143133),(86208,1,'10.00000000','446.31000000','发送红包',1,NULL,20190415143134),(86209,2,'2.81000000','517.23000000','领取红包',2,NULL,20190415143144),(86210,2,'0.40000000','517.63000000','领取红包',2,NULL,20190415143146),(86211,2,'5.79000000','523.42000000','领取红包',2,NULL,20190415143148),(86212,1,'7.19000000','453.50000000','退回红包',1,NULL,20190415143200),(86213,1,'9.60000000','463.10000000','退回红包',1,NULL,20190415143200),(86214,1,'4.21000000','467.31000000','退回红包',1,NULL,20190415143200),(86215,1,'10.00000000','457.31000000','发送红包',1,NULL,20190415151850),(86216,1,'10.00000000','447.31000000','发送红包',1,NULL,20190415151851),(86217,1,'10.00000000','437.31000000','发送红包',1,NULL,20190415151852),(86218,2,'1.40000000','524.82000000','领取红包',2,NULL,20190415151857),(86219,1,'10.00000000','447.31000000','退回红包',1,NULL,20190415152000),(86220,1,'10.00000000','457.31000000','退回红包',1,NULL,20190415152000),(86221,1,'10.00000000','427.31000000','发送红包',1,NULL,20190415152000),(86222,2,'2.29000000','527.11000000','领取红包',2,NULL,20190415152005),(86223,1,'10.00000000','417.31000000','发送红包',1,NULL,20190415152054),(86224,2,'1.49000000','528.60000000','领取红包',2,NULL,20190415152058),(86225,1,'10.00000000','407.31000000','发送红包',1,NULL,20190415152300),(86226,2,'0.23000000','528.83000000','领取红包',2,NULL,20190415152320),(86227,1,'10.00000000','397.31000000','发送红包',1,NULL,20190415152413),(86228,2,'3.50000000','532.33000000','领取红包',2,NULL,20190415152420),(86229,1,'10.00000000','387.31000000','发送红包',1,NULL,20190415152631),(86230,2,'2.96000000','535.29000000','领取红包',2,NULL,20190415152635),(86231,1,'10.00000000','377.31000000','发送红包',1,NULL,20190415153008),(86232,2,'6.37000000','541.66000000','领取红包',2,NULL,20190415153015),(86233,1,'10.00000000','367.31000000','发送红包',1,NULL,20190415153334),(86234,2,'1.01000000','542.67000000','领取红包',2,NULL,20190415153338),(86235,1,'10.00000000','357.31000000','发送红包',1,NULL,20190415153736),(86236,2,'4.05000000','546.72000000','领取红包',2,NULL,20190415153740),(86237,3,'4.28000000','513.55000000','领取红包',3,NULL,20190415153743),(86238,1,'1.67000000','358.98000000','退回红包',1,NULL,20190415153800);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL COMMENT '个人用户ID',
  `payPass` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '支付密码',
  `paySalt` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '盐',
  `nickName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `realName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实姓名',
  `updateTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='个人用户信息';

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`payPass`,`paySalt`,`nickName`,`realName`,`updateTime`) values (1,'b594510740d2ac4261c1b2fe87850d08','admin','admin','丁兆双',20190327),(2,'447ccf160a8976bea6e07985d4c8a3f0','chg','chg','陈华庚',20190327),(3,'952f12230a1a73d8000d8a7212197462','guanyu','guanyu','关羽',20190327),(4,'0dd45439430ef361164886e9c956816b','user1','user1','用户1',20190403),(5,'45506e8e978cb84a35de8b69bf5da88e','user2','user2','用户2',20190403),(6,'f0f5fcfb256025340f24d6d1014653da','user3','user3','用户3',20190403),(7,'00cfe28d865d00c4c4905db7b0e93587','user4','user4','用户4',20190403),(8,'02fac2db1efcd599b82d514cf6f207b1','user5','user5','用户5',20190403),(9,'f867e42833cd11261eb2da5bb55024c2','user6','user6','用户6',20190403),(10,NULL,'user7','user7','用户7',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
