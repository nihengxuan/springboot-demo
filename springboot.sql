/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2022-04-12 23:46:38
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `create_time` date DEFAULT NULL COMMENT '出版时间',
  `cover` varchar(255) DEFAULT NULL,
  `u_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', 'java', '35', '35', '2022-01-09', 'http://localhost:8802/files/164d5f6b7f3f4541ba2115efed489dbc', '2');
INSERT INTO `book` VALUES ('3', 'javaweb', '35', '35', '2022-01-09', 'http://localhost:8802/files/53b37f41f7584835808979442deec3e7', '1');
INSERT INTO `book` VALUES ('4', '经济学', '22', '倪恒旋', '2022-01-09', 'http://localhost:8802/files/e3ecccb0e0c04bd79f2545ae2d061e54', '2');
INSERT INTO `book` VALUES ('5', '医学', '35', '22', '2022-01-09', 'http://localhost:8802/files/d3b335422c7c43c2a38414261edefb08', '1');
INSERT INTO `book` VALUES ('6', '计算机网络', '35', '35', '2022-01-09', null, '2');
INSERT INTO `book` VALUES ('12', '操作系统', '35', '35', '2022-01-09', null, '1');

-- ----------------------------
-- Table structure for `permissions`
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `path` varchar(20) DEFAULT NULL,
  `comment` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES ('1', 'User', '/user', '用户管理');
INSERT INTO `permissions` VALUES ('2', 'Book', '/book', '书籍管理');
INSERT INTO `permissions` VALUES ('3', 'News', '/news', '新闻管理');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `comment` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', 'admin');
INSERT INTO `role` VALUES ('2', '普通用户', 'user');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(10) NOT NULL,
  `permission_id` int(10) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('1', '3');
INSERT INTO `role_permission` VALUES ('2', '2');
INSERT INTO `role_permission` VALUES ('2', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(12) DEFAULT NULL COMMENT '用户名',
  `password` varchar(16) DEFAULT NULL,
  `nickName` varchar(16) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '倪恒旋', '123456', '1111111', '22', '女', '山东济南');
INSERT INTO `user` VALUES ('2', 'nihengxuan', '123456', '1', '1', '男', '1');
INSERT INTO `user` VALUES ('3', '1', null, null, null, null, null);
INSERT INTO `user` VALUES ('4', '2', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '3', null, null, null, null, null);
INSERT INTO `user` VALUES ('6', '4', null, null, null, null, null);
INSERT INTO `user` VALUES ('7', '5', null, null, null, null, null);
INSERT INTO `user` VALUES ('8', '6', null, null, null, null, null);
INSERT INTO `user` VALUES ('9', '7', null, null, null, null, null);
INSERT INTO `user` VALUES ('10', '8', null, null, null, null, null);
INSERT INTO `user` VALUES ('11', '9', null, null, null, null, null);
INSERT INTO `user` VALUES ('12', '10', null, null, null, null, null);
INSERT INTO `user` VALUES ('13', '11', null, null, null, null, null);
INSERT INTO `user` VALUES ('14', '12', null, null, null, null, null);
INSERT INTO `user` VALUES ('15', '13', null, null, null, null, null);
INSERT INTO `user` VALUES ('16', '14', null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
