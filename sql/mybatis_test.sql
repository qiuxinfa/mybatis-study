/*
Navicat MySQL Data Transfer

Source Server         : mysql8
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : mybatis_test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-09-27 23:50:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product_store`
-- ----------------------------
DROP TABLE IF EXISTS `product_store`;
CREATE TABLE `product_store` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cnt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='产品库存表';

-- ----------------------------
-- Records of product_store
-- ----------------------------
INSERT INTO `product_store` VALUES ('p001', '产品A', '3');
INSERT INTO `product_store` VALUES ('p002', '产品B', '10');

-- ----------------------------
-- Table structure for `t_blog`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `title` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '博客标题',
  `user_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '博客作者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='博客';

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES ('1', 'CSDN博客', '123');
INSERT INTO `t_blog` VALUES ('2', '博客园', '123');
INSERT INTO `t_blog` VALUES ('3', '简书', '456');

-- ----------------------------
-- Table structure for `t_card`
-- ----------------------------
DROP TABLE IF EXISTS `t_card`;
CREATE TABLE `t_card` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `card_num` varchar(18) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号码',
  `card_time` date DEFAULT NULL COMMENT '有效日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='个人身份证';

-- ----------------------------
-- Records of t_card
-- ----------------------------
INSERT INTO `t_card` VALUES ('01', '440221199609195912', '2020-04-30');
INSERT INTO `t_card` VALUES ('02', '440221199609195915', '2020-06-06');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `role_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员');
INSERT INTO `t_role` VALUES ('2', '老师');
INSERT INTO `t_role` VALUES ('3', '学生');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `username` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `is_valid` int(1) DEFAULT NULL COMMENT '用户是否有效，0无效，1有效',
  `card_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('06', 'cc', '123456', '1', null);
INSERT INTO `t_user` VALUES ('1', '张三1', '123456', '1', null);
INSERT INTO `t_user` VALUES ('123', '张三', '123456', '1', '02');
INSERT INTO `t_user` VALUES ('2', '张三2', '123456', '1', null);
INSERT INTO `t_user` VALUES ('3', '张三3', '123456', '1', null);
INSERT INTO `t_user` VALUES ('4', 'aa', '123456', '0', null);
INSERT INTO `t_user` VALUES ('456', '李四', '123456', '0', '01');
INSERT INTO `t_user` VALUES ('5', 'bb', '123456', '0', null);

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色id',
  `role_id` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户-角色中间表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('001', '123', '1');
INSERT INTO `t_user_role` VALUES ('002', '123', '2');
INSERT INTO `t_user_role` VALUES ('003', '456', '3');

-- ----------------------------
-- Table structure for `user_balance`
-- ----------------------------
DROP TABLE IF EXISTS `user_balance`;
CREATE TABLE `user_balance` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户余额表';

-- ----------------------------
-- Records of user_balance
-- ----------------------------
INSERT INTO `user_balance` VALUES ('u001', '张三', '300');
INSERT INTO `user_balance` VALUES ('u002', '李四', '1000');
