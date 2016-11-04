/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50710
Source Host           : 127.0.0.1:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2015-12-31 13:05:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `goddess`
-- ----------------------------
DROP TABLE IF EXISTS `goddess`;
CREATE TABLE `goddess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别(0-男,1-女)',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `createUser` varchar(30) DEFAULT NULL COMMENT '创建者',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  `updateUser` varchar(30) DEFAULT NULL COMMENT '修改者',
  `updateDate` date DEFAULT NULL COMMENT '修改时间',
  `isdel` int(11) DEFAULT NULL COMMENT '是否删除(0-否,1-是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='女神表';

-- ----------------------------
-- Records of goddess
-- ----------------------------
INSERT INTO `goddess` VALUES ('1', '耿梦涵', '1', '25', '1990-10-01', 'amber_hh@163.com', '18317059960', '王翔', '2015-12-30', null, null, '0');
INSERT INTO `goddess` VALUES ('2', '小美', '0', '34', '2015-12-30', '57469614@qq.com', '15472214555', '王翔', '2015-12-30', '王翔', '2015-12-30', '0');
INSERT INTO `goddess` VALUES ('3', '王翔', '1', '18', '1990-08-15', '574693894@qq.com', '18721472363', '王翔', '2015-12-31', null, null, '1');
