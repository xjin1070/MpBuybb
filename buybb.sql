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

 Date: 23/03/2023 21:44:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart_info
-- ----------------------------
DROP TABLE IF EXISTS `cart_info`;
CREATE TABLE `cart_info`  (
  `pno` int(0) NOT NULL COMMENT '商品编号',
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品名字',
  `pnum` int(0) NULL DEFAULT NULL COMMENT '商品数量',
  `tno` int(0) NULL DEFAULT NULL COMMENT '商品类型编号',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格/单价',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品简介',
  `checked` int(0) NULL DEFAULT 0 COMMENT '商品是否被选中，1代表true,0代表false，默认为0',
  PRIMARY KEY (`pno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '订单编号',
  `amount` double(255, 2) NULL DEFAULT NULL COMMENT '总价格',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '支付状态',
  `postage` int(0) NULL DEFAULT 0 COMMENT '邮费',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '收货地址',
  `pno` int(0) NULL DEFAULT NULL COMMENT '商品编号',
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品名称',
  `pnum` int(0) NULL DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, NULL, 121212.00, NULL, 1221, NULL, '21212323', 212121, '12121', 21211, NULL);
INSERT INTO `order_info` VALUES (2, '2023-03-23 21:07:041081', 6499.00, '0', 0, '2023-03-23 21:07:04', '南华大学', 108, '小米13Ultimate', 1, 6499.00);
INSERT INTO `order_info` VALUES (3, '2023-03-23 21:09:071081', 6499.00, '0', 0, '2023-03-23 21:09:07', '南华大学', 108, '小米13Ultimate', 1, 6499.00);
INSERT INTO `order_info` VALUES (4, '1082023-03-23 21:32:581', 6499.00, '0', 0, '2023-03-23 21:32:58', '南华大学', 108, '小米13Ultimate', 1, 6499.00);
INSERT INTO `order_info` VALUES (5, '202303232133456', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `order_info` VALUES (6, '1082023-03-23 21:35:551', 6499.00, '0', 0, '2023-03-23 21:35:55', '南华大学', 108, '小米13Ultimate', 1, 6499.00);
INSERT INTO `order_info` VALUES (7, '1082023-03-23 21:37:091', 6499.00, '0', 0, '2023-03-23 21:37:09', '南华大学', 108, '小米13Ultimate', 1, 6499.00);
INSERT INTO `order_info` VALUES (8, '108java.text.SimpleDateFormat@5069d9601', 6499.00, '0', 0, '2023-03-23 21:40:27', '南华大学', 108, '小米13Ultimate', 1, 6499.00);
INSERT INTO `order_info` VALUES (9, '108202303232141121', 6499.00, '0', 0, '2023-03-23 21:41:12', '南华大学', 108, '小米13Ultimate', 1, 6499.00);

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `pno` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品价格/单价',
  `pinvent` int(0) NULL DEFAULT 0 COMMENT '商品库存',
  `punit` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品单位',
  `pnw` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品净重',
  `pexp` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品保质期',
  `pintro` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品简介',
  `tno` int(0) NULL DEFAULT NULL COMMENT '商品类型',
  `tname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品类型名称',
  `status` int(0) NULL DEFAULT 0 COMMENT '商品状态',
  `deleted` int(0) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除状态',
  `imgs` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`pno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES (102, '红米K60pro', 3299.00, 100, '台', '255g', '一年有限保修', '红米是小米的子品牌', 108, '手机', 0, 0, NULL);
INSERT INTO `product_info` VALUES (103, '一加Ace2V', 2999.00, 100, '台', '288g', '一年有限保修', '一加手机是OPPO的子品牌', 108, '手机', 0, 0, NULL);
INSERT INTO `product_info` VALUES (104, '一加Ace2pro', 3999.00, 100, '台', '288g', '一年有限保修', '一加手机是OPPO的子品牌', 106, '电子设备', 1, 0, NULL);

-- ----------------------------
-- Table structure for type_info
-- ----------------------------
DROP TABLE IF EXISTS `type_info`;
CREATE TABLE `type_info`  (
  `tno` int(0) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `tname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '类型名称',
  `status` int(0) NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`tno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type_info
-- ----------------------------
INSERT INTO `type_info` VALUES (2, '生活用品', 1);
INSERT INTO `type_info` VALUES (101, '油炸', 0);
INSERT INTO `type_info` VALUES (106, '电子设备', 0);
INSERT INTO `type_info` VALUES (107, '肯德基疯狂星期四V我50', 0);
INSERT INTO `type_info` VALUES (108, '手机', 1);

-- ----------------------------
-- Table structure for usr_info
-- ----------------------------
DROP TABLE IF EXISTS `usr_info`;
CREATE TABLE `usr_info`  (
  `id` int(0) NOT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `position` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usr_info
-- ----------------------------
INSERT INTO `usr_info` VALUES (111, '123456', '啊啊啊', '222333112@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (115, '123456', '大傻卢', '222333116@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (116, 'eb160de1de89d9058fcb0b968dbbbd68', '蔡徐坤', '222333117@qq.com', '清洁员', '');
INSERT INTO `usr_info` VALUES (117, '5ef059938ba799aaa845e1c2e8a762bd', '黄知晓', '222333118@qq.com', '清洁员', '');
INSERT INTO `usr_info` VALUES (118, '07e1cd7dca89a1678042477183b7ac3f', '刘畅', '222333119@qq.com', '清洁员', '');
INSERT INTO `usr_info` VALUES (120, '7f6ffaa6bb0b408017b62254211691b5', '金嘉恒', '222333121@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (128, '698d51a19d8a121ce581499d7b701668', '宋连发', '222333129@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (129, '7f6ffaa6bb0b408017b62254211691b5', '黄杰', '222333130@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (130, '73278a4a86960eeb576a8fd4c9ec6997', '卢婉婷', '222333131@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (131, '5fd0b37cd7dbbb00f97ba6ce92bf5add', '张三', '222333132@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (132, '2b44928ae11fb9384c4cf38708677c48', '李四', '222333133@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (133, 'c45147dee729311ef5b5c3003946c48f', '王五', '222333134@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (134, 'eb160de1de89d9058fcb0b968dbbbd68', '赵六', '222333135@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (135, '5ef059938ba799aaa845e1c2e8a762bd', '刘七', '222333136@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (136, '07e1cd7dca89a1678042477183b7ac3f', 'Siri', '222333137@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (137, '698d51a19d8a121ce581499d7b701668', 'Android', '222333138@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (138, '7f6ffaa6bb0b408017b62254211691b5', '鸿蒙', '222333139@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (139, '73278a4a86960eeb576a8fd4c9ec6997', '张萌', '222333140@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (140, '5fd0b37cd7dbbb00f97ba6ce92bf5add', '李玉', '222333141@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (141, '2b44928ae11fb9384c4cf38708677c48', '小艺小艺', '222333142@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (142, 'c45147dee729311ef5b5c3003946c48f', '小爱同学', '222333143@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (143, 'eb160de1de89d9058fcb0b968dbbbd68', '徐奥路', '222333144@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (144, '5ef059938ba799aaa845e1c2e8a762bd', '小红', '222333145@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (145, '07e1cd7dca89a1678042477183b7ac3f', '小明', '222333146@qq.com', '普通员工', '');
INSERT INTO `usr_info` VALUES (146, '202cb962ac59075b964b07152d234b70', '小卢卢', '222333147@qq.com', '收银员', '');
INSERT INTO `usr_info` VALUES (147, '7f6ffaa6bb0b408017b62254211691b5', '牛牛', '222333148@qq.com', '收银员', '');
INSERT INTO `usr_info` VALUES (148, '73278a4a86960eeb576a8fd4c9ec6997', '卢撒子', '222333149@qq.com', '收银员', '');
INSERT INTO `usr_info` VALUES (149, '5fd0b37cd7dbbb00f97ba6ce92bf5add', '小傻子', '222333150@qq.com', '收银员', '');
INSERT INTO `usr_info` VALUES (150, '123456', '宋宋', '222333151@qq.com', '店长', '');
INSERT INTO `usr_info` VALUES (151, '123456', 'shhshcncdsshn', '随随便便', '', '');

SET FOREIGN_KEY_CHECKS = 1;
