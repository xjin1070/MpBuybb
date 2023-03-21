/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : buybb

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 21/03/2023 18:44:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for type_info
-- ----------------------------
DROP TABLE IF EXISTS `type_info`;
CREATE TABLE `type_info`  (
  `tno` int(0) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `tname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '类型名称',
  `status` int(0) NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`tno`) USING BTREE,
  UNIQUE INDEX `tname`(`tname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type_info
-- ----------------------------
INSERT INTO `type_info` VALUES (2, '蓝月壳洗衣液', 1);
INSERT INTO `type_info` VALUES (101, '油炸', 0);
INSERT INTO `type_info` VALUES (102, '了不起的盖茨比', 0);
INSERT INTO `type_info` VALUES (106, '好好好', 0);
INSERT INTO `type_info` VALUES (107, '肯德基疯狂星期四V我50', 0);

-- ----------------------------
-- Table structure for usr_info
-- ----------------------------
DROP TABLE IF EXISTS `usr_info`;
CREATE TABLE `usr_info`  (
  `id` int(0) NOT NULL,
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usr_info
-- ----------------------------
INSERT INTO `usr_info` VALUES (111, '123456', '小卢卢', '222333112@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (115, '123456', '大傻卢', '222333116@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (116, 'eb160de1de89d9058fcb0b968dbbbd68', '蔡徐坤', '222333117@qq.com', '清洁员');
INSERT INTO `usr_info` VALUES (117, '5ef059938ba799aaa845e1c2e8a762bd', '黄知晓', '222333118@qq.com', '清洁员');
INSERT INTO `usr_info` VALUES (118, '07e1cd7dca89a1678042477183b7ac3f', '刘畅', '222333119@qq.com', '清洁员');
INSERT INTO `usr_info` VALUES (120, '7f6ffaa6bb0b408017b62254211691b5', '金嘉恒', '222333121@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (128, '698d51a19d8a121ce581499d7b701668', '宋连发', '222333129@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (129, '7f6ffaa6bb0b408017b62254211691b5', '黄杰', '222333130@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (130, '73278a4a86960eeb576a8fd4c9ec6997', '卢婉婷', '222333131@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (131, '5fd0b37cd7dbbb00f97ba6ce92bf5add', '张三', '222333132@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (132, '2b44928ae11fb9384c4cf38708677c48', '李四', '222333133@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (133, 'c45147dee729311ef5b5c3003946c48f', '王五', '222333134@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (134, 'eb160de1de89d9058fcb0b968dbbbd68', '赵六', '222333135@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (135, '5ef059938ba799aaa845e1c2e8a762bd', '刘七', '222333136@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (136, '07e1cd7dca89a1678042477183b7ac3f', 'Siri', '222333137@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (137, '698d51a19d8a121ce581499d7b701668', 'Android', '222333138@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (138, '7f6ffaa6bb0b408017b62254211691b5', '鸿蒙', '222333139@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (139, '73278a4a86960eeb576a8fd4c9ec6997', '张萌', '222333140@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (140, '5fd0b37cd7dbbb00f97ba6ce92bf5add', '李玉', '222333141@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (141, '2b44928ae11fb9384c4cf38708677c48', '小艺小艺', '222333142@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (142, 'c45147dee729311ef5b5c3003946c48f', '小爱同学', '222333143@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (143, 'eb160de1de89d9058fcb0b968dbbbd68', '徐奥路', '222333144@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (144, '5ef059938ba799aaa845e1c2e8a762bd', '小红', '222333145@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (145, '07e1cd7dca89a1678042477183b7ac3f', '小明', '222333146@qq.com', '普通员工');
INSERT INTO `usr_info` VALUES (146, '202cb962ac59075b964b07152d234b70', '小卢卢', '222333147@qq.com', '收银员');
INSERT INTO `usr_info` VALUES (147, '7f6ffaa6bb0b408017b62254211691b5', '牛牛', '222333148@qq.com', '收银员');
INSERT INTO `usr_info` VALUES (148, '73278a4a86960eeb576a8fd4c9ec6997', '卢撒子', '222333149@qq.com', '收银员');
INSERT INTO `usr_info` VALUES (149, '5fd0b37cd7dbbb00f97ba6ce92bf5add', '小傻子', '222333150@qq.com', '收银员');
INSERT INTO `usr_info` VALUES (150, '123456', '宋宋', '222333151@qq.com', '店长');
INSERT INTO `usr_info` VALUES (151, '123456', '撒子', '111111111@qq.com', '店长');

SET FOREIGN_KEY_CHECKS = 1;
