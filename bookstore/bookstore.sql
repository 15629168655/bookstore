/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-04-22 12:35:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `catalogid` int(11) NOT NULL,
  `bookname` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `picture` varchar(30) NOT NULL,
  PRIMARY KEY (`bookid`),
  KEY `FK_Relationship_3` (`catalogid`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`catalogid`) REFERENCES `catalog` (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '4', 'ASP.NET 3.5 实用教程', '38', 'ASP.NET3.5.jpg');
INSERT INTO `book` VALUES ('2', '1', 'C#实用教程', '43', 'CSharp.jpg');
INSERT INTO `book` VALUES ('3', '1', 'C 实用教程', '36', 'C.jpg');
INSERT INTO `book` VALUES ('4', '1', 'C++实用教程', '40', 'C++.jpg');
INSERT INTO `book` VALUES ('5', '4', 'Flex4 开发实践', '45', 'Flex4.jpg');
INSERT INTO `book` VALUES ('6', '2', 'Java EE 基础实用教程', '35', 'JavaEEBasic.jpg');
INSERT INTO `book` VALUES ('7', '2', 'Java EE 实用教程', '39', 'JavaEE.jpg');
INSERT INTO `book` VALUES ('8', '2', 'Java 实用教程（第2版）', '50', 'Java.jpg');
INSERT INTO `book` VALUES ('9', '4', 'JSP 编程教程', '30', 'JSP.jpg');
INSERT INTO `book` VALUES ('10', '3', 'MySQL 实用教程', '37', 'MySQL.jpg');
INSERT INTO `book` VALUES ('11', '3', 'Oracle 实用教程（第3版）', '29', 'Oracle.jpg');
INSERT INTO `book` VALUES ('12', '4', 'PHP 实用教程', '35', 'PHP.jpg');
INSERT INTO `book` VALUES ('13', '3', 'SQL Server 实用教程（第3版）', '25', 'SQL Server.jpg');
INSERT INTO `book` VALUES ('14', '1', 'Visual C++教程（第2版）', '25', 'VC++.jpg');

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `catalogid` int(11) NOT NULL AUTO_INCREMENT,
  `catalogname` varchar(20) NOT NULL,
  PRIMARY KEY (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', 'C语言程序设计');
INSERT INTO `catalog` VALUES ('2', 'Java开发');
INSERT INTO `catalog` VALUES ('3', '数据库');
INSERT INTO `catalog` VALUES ('4', '网页编程');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderitemid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `orderid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderitemid`),
  KEY `FK_Relationship_2` (`orderid`),
  KEY `FK_Relationship_4` (`bookid`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1', '2', '3', '1');
INSERT INTO `orderitem` VALUES ('2', '3', '3', '1');
INSERT INTO `orderitem` VALUES ('3', '2', '5', '3');
INSERT INTO `orderitem` VALUES ('4', '13', '5', '3');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `orderdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderid`),
  KEY `FK_Relationship_1` (`userid`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('3', '30', '2016-04-18 18:27:38');
INSERT INTO `orders` VALUES ('4', '30', '2016-04-18 18:28:40');
INSERT INTO `orders` VALUES ('5', '30', '2016-04-18 18:29:04');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '李文滨', '940804', '男', '22');
INSERT INTO `user` VALUES ('29', 'liwenbin', '940804', '男', '22');
INSERT INTO `user` VALUES ('30', '李文滨', '111111', '男', '22');
