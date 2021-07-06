/*
 Navicat Premium Data Transfer

 Source Server         : 本地开发8
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 127.0.0.1:3308
 Source Schema         : vcode

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 06/07/2021 17:05:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `name` varchar(50)   NULL DEFAULT NULL,
  `sex` varchar(50)   NULL DEFAULT NULL,
  `birthday` timestamp(0) NULL DEFAULT NULL,
  `region` varchar(50)   NULL DEFAULT NULL,
  `remark` varchar(1024)   NULL DEFAULT NULL,
  `description` varchar(512)   NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES (1, '川川', '男', '2021-07-01 16:14:15', '杭州', '这是川川的测试', '描述这是我的川川基础信息');
INSERT INTO `demo` VALUES (2, '娜娜', '女', '2021-01-01 16:15:21', '杭州', '这是娜娜的测试', '描述这是我的娜娜基础信息');

SET FOREIGN_KEY_CHECKS = 1;
