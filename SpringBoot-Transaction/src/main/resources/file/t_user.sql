/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : huhao

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-09-10 14:32:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) NOT NULL,
  `sex` int(3) NOT NULL DEFAULT '1',
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '1', '哈哈');
INSERT INTO `t_user` VALUES ('2', '李四', '1', '嘻嘻');
INSERT INTO `t_user` VALUES ('3', '王五', '0', '嘿嘿');
INSERT INTO `t_user` VALUES ('4', '黄三', '1', '小黄');
INSERT INTO `t_user` VALUES ('5', '张久', '1', '小张');
