/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-08-29 12:34:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', '123456', '管理员');

-- ----------------------------
-- Table structure for t_announcement
-- ----------------------------
DROP TABLE IF EXISTS `t_announcement`;
CREATE TABLE `t_announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createAdmin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKslwp3gcgudths92bk0kbak06t` (`createAdmin_id`),
  CONSTRAINT `FKslwp3gcgudths92bk0kbak06t` FOREIGN KEY (`createAdmin_id`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_announcement
-- ----------------------------

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `inputUser_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKspe5cxeewkudeg10usq127fji` (`inputUser_id`),
  CONSTRAINT `FKspe5cxeewkudeg10usq127fji` FOREIGN KEY (`inputUser_id`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `order_number` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_address` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `confirmTime` datetime DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `finalPrice` double DEFAULT NULL,
  `orderNumber` varchar(255) DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `shipTime` datetime DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_75ffb6s55q5aibdhqs2unu49q` (`user_id`),
  KEY `FK_9a6eb7iu2gbn1628cud5w836w` (`user_address`),
  CONSTRAINT `FK_75ffb6s55q5aibdhqs2unu49q` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_9a6eb7iu2gbn1628cud5w836w` FOREIGN KEY (`user_address`) REFERENCES `t_useraddress` (`id`),
  CONSTRAINT `FKho2r4qgj3txpy8964fnla95ub` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_n7j2urgoicw0qa2b5s2pidind` (`order_id`),
  KEY `FK_cxxgytqnjjrpm4x7k2grbm6iu` (`product`),
  KEY `FK2yx4lqm9mh15mysa9kppvf77r` (`product_id`),
  CONSTRAINT `FK2yx4lqm9mh15mysa9kppvf77r` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`),
  CONSTRAINT `FK_cxxgytqnjjrpm4x7k2grbm6iu` FOREIGN KEY (`product`) REFERENCES `t_product` (`id`),
  CONSTRAINT `FK_n7j2urgoicw0qa2b5s2pidind` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `FKj435mnwwxw5wci0t6xi15ddxk` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for t_payment
-- ----------------------------
DROP TABLE IF EXISTS `t_payment`;
CREATE TABLE `t_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_payment
-- ----------------------------

-- ----------------------------
-- Table structure for t_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `id` int(11) NOT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `updateAdmin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf820vwoskrv05yxj80mlbj226` (`updateAdmin_id`),
  CONSTRAINT `FKf820vwoskrv05yxj80mlbj226` FOREIGN KEY (`updateAdmin_id`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_picture
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `stock` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `inputUser_id` int(11) DEFAULT NULL,
  `masterPic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96wxe8531cmahwxjoen492n2h` (`inputUser_id`),
  KEY `FKknr9ckik7tms7787w9nkpis8g` (`masterPic_id`),
  CONSTRAINT `FK96wxe8531cmahwxjoen492n2h` FOREIGN KEY (`inputUser_id`) REFERENCES `t_admin` (`id`),
  CONSTRAINT `FKknr9ckik7tms7787w9nkpis8g` FOREIGN KEY (`masterPic_id`) REFERENCES `t_picture` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '2343434', '2013-07-10 15:01:26', '2a-dd-1s', '阿斯顿发楼思考点附近啦静安寺离开对方进来看撒经费等楼库萨克警方流口水京东方连空间撒离开的解放路口近代史路口附近', '/images/l_pro01.gif', '123', '3', '美的不锈钢酸奶机', null, null, null);
INSERT INTO `t_product` VALUES ('2', 'sdfsdf', '2013-07-30 15:03:29', 'df', '士大夫', '/images/l_pro02.gif', '3333', '123', '高级餐具', null, null, null);
INSERT INTO `t_product` VALUES ('3', 'sdfdsf', '2013-08-14 15:03:57', 'fddf', '进梵蒂冈', '/images/l_pro03.gif', '1000', '222', '红木茶具套装', null, null, null);

-- ----------------------------
-- Table structure for t_producttype
-- ----------------------------
DROP TABLE IF EXISTS `t_producttype`;
CREATE TABLE `t_producttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_producttype
-- ----------------------------
INSERT INTO `t_producttype` VALUES ('1', '电子电器');
INSERT INTO `t_producttype` VALUES ('2', '床上用品');
INSERT INTO `t_producttype` VALUES ('3', '厨房用具');
INSERT INTO `t_producttype` VALUES ('4', '运动健身');
INSERT INTO `t_producttype` VALUES ('5', '儿童用品');
INSERT INTO `t_producttype` VALUES ('6', '食品保健');

-- ----------------------------
-- Table structure for t_product_t_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_product_t_picture`;
CREATE TABLE `t_product_t_picture` (
  `Product_id` int(11) NOT NULL,
  `slavePic_id` int(11) NOT NULL,
  KEY `FKln4qvwbfxoiypk9mgwyedmtl1` (`slavePic_id`),
  KEY `FKmixcjvbg3qcrp0reaqha7ujk` (`Product_id`),
  CONSTRAINT `FKln4qvwbfxoiypk9mgwyedmtl1` FOREIGN KEY (`slavePic_id`) REFERENCES `t_picture` (`id`),
  CONSTRAINT `FKmixcjvbg3qcrp0reaqha7ujk` FOREIGN KEY (`Product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_product_t_picture
-- ----------------------------

-- ----------------------------
-- Table structure for t_remember
-- ----------------------------
DROP TABLE IF EXISTS `t_remember`;
CREATE TABLE `t_remember` (
  `id` varchar(255) NOT NULL,
  `addTime` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6uc4b3e4xdabyyiamthsb2bqa` (`user_id`),
  CONSTRAINT `FK6uc4b3e4xdabyyiamthsb2bqa` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_remember
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `password` varchar(14) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `spc` varchar(255) DEFAULT NULL,
  `tel_phone` varchar(11) DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `zip_code` varchar(6) DEFAULT NULL,
  `balance` bigint(20) DEFAULT NULL,
  `slat` varchar(255) DEFAULT NULL,
  `telPhone` varchar(11) DEFAULT NULL,
  `zipCode` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'lkewj123kf', '重庆市南岸区万达4栋29-18', '1234', '13888888888', '1239090', null, null, '02366666666', '周文滔', '400056', null, null, null, null);

-- ----------------------------
-- Table structure for t_useraddress
-- ----------------------------
DROP TABLE IF EXISTS `t_useraddress`;
CREATE TABLE `t_useraddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c0hoxg699yrbg42lrq6738j0n` (`user_id`),
  CONSTRAINT `FK_c0hoxg699yrbg42lrq6738j0n` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKivjwmwb9xngrc6ic856ryrb57` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_useraddress
-- ----------------------------
