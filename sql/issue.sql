

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tele` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '1', '1', '1', '1');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime(0) NULL DEFAULT NULL,
  `issues_id` bigint(20) NOT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `open_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (12, '2020-02-08 06:53:41', 3, 2, 1);

-- ----------------------------
-- Table structure for issues
-- ----------------------------
DROP TABLE IF EXISTS `issues`;
CREATE TABLE `issues`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issues_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `issues_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `issues_num` int(11) NULL DEFAULT NULL,
  `issues_date` date NULL DEFAULT NULL,
  `issues_details` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `issues_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of issues
-- ----------------------------
INSERT INTO `issues` VALUES (2, '神舟战神笔记本电脑', '../images/AA.jpg', 100, '2020-02-08', '<p>低洼低洼和的<b>阿发货了</b></p>', 6999.90);
INSERT INTO `issues` VALUES (5, '化身瓜子矿泉水', '../images/AA.jpg', 222, '2020-02-08', '<p>低洼低洼和的<b>阿发货了</b></p>', 158.60);
INSERT INTO `issues` VALUES (6, '化身瓜子矿泉水', '../images/AA.jpg', 222, '2020-02-08', '<p>低洼低洼和的<b>阿发货了</b></p>', 158.60);
INSERT INTO `issues` VALUES (7, '电冰箱洗衣机', '../images/1581157908546.jpg', 100, '2020-02-08', '<p>1<span style=\"color: rgb(227, 55, 55);\">23</span><u>4<span style=\"color: rgb(32, 147, 97);\">56</span></u></p><hr><p style=\"text-align: right;\"><span style=\"color: rgb(227, 55, 55);\">3</span><u>4<span style=\"color: rgb(32, 147, 97);\">56</span></u><br></p>', 999.90);
INSERT INTO `issues` VALUES (8, '电冰箱洗衣机', '../images/1581158538330.gif', 100, '2020-02-08', '<blockquote><p>今天天气真好</p></blockquote><hr><h1 style=\"text-align: right;\"><span style=\"color: rgb(227, 55, 55);\">气</span><span style=\"color: rgb(226, 139, 65);\"><b>真好</b></span><br></h1>', 999.90);
INSERT INTO `issues` VALUES (9, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);
INSERT INTO `issues` VALUES (10, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);
INSERT INTO `issues` VALUES (11, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);
INSERT INTO `issues` VALUES (12, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);
INSERT INTO `issues` VALUES (13, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);
INSERT INTO `issues` VALUES (14, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);
INSERT INTO `issues` VALUES (15, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);
INSERT INTO `issues` VALUES (16, '最新增加的商品', '../images/1581424459407.jpg', 111, '2020-02-11', '<blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><hr><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote><blockquote><h1><b>哈哈哈哈哈<u>飞飞飞飞</u></b></h1></blockquote>', 999.90);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `issues_id` bigint(20) NOT NULL,
  `item_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `item_date` datetime(0) NULL DEFAULT NULL,
  `item_num` int(11) NULL DEFAULT NULL,
  `item_price` double NULL DEFAULT NULL,
  `item_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `open_id` bigint(20) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `issues_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (11, 8, '5YyX5Lqs5Lic5Z+O', '2020-02-12 04:05:05', 1, 999.9, '已收货', 3, 20200212120505899, NULL);
INSERT INTO `item` VALUES (12, 8, '5YyX5Lqs5Y2X5Z+O', '2020-02-12 11:23:53', 1, 999.9, '已收货', 3, 20200212192352588, NULL);
INSERT INTO `item` VALUES (13, 15, '5YyX5Lqs5Y2X5Z+O', '2020-02-12 11:23:53', 1, 999.9, '确认收货', 3, 20200212192352588, NULL);
INSERT INTO `item` VALUES (14, 15, '5YyX5Lqs5Lic5Z+O', '2020-02-12 11:52:05', 1, 999.9, '确认收货', 335, 20200212195204090, NULL);
INSERT INTO `item` VALUES (15, 5, '5YyX5Lqs5Lic5Z+O', '2020-02-12 11:52:05', 1, 158.6, '已收货', 335, 20200212195204090, NULL);

-- ----------------------------
-- Table structure for order_
-- ----------------------------
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `open_id` bigint(20) NOT NULL,
  `order_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `order_date` datetime(0) NULL DEFAULT NULL,
  `order_num` bigint(20) NOT NULL,
  `order_price` double NULL DEFAULT NULL,
  `order_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_
-- ----------------------------
INSERT INTO `order_` VALUES (1, 1, '1', '2020-02-08 06:53:48', 20200208145348944, 222, '待付款');
INSERT INTO `order_` VALUES (2, 2, '111', '2020-02-08 08:43:48', 20200208164348894, 666, '待付款');
INSERT INTO `order_` VALUES (3, 3, '北京东城', '2020-02-08 10:30:53', 20200208183053344, 6999.9, '确认收货');
INSERT INTO `order_` VALUES (4, 3, '北京东城', '2020-02-08 10:40:54', 20200208184053130, 9326.5, '确认收货');
INSERT INTO `order_` VALUES (5, 3, '北京东城', '2020-02-12 04:05:05', 20200212120505899, 999.9, '确认收货');
INSERT INTO `order_` VALUES (6, 3, '北京东城', '2020-02-12 11:23:53', 20200212192352588, 1999.8, '确认收货');
INSERT INTO `order_` VALUES (7, 335, '北京东城', '2020-02-12 11:52:05', 20200212195204090, 1158.5, '确认收货');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 336 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (335, '北京东城', '22', '2020-02-12 11:51:05', '请问你要来点兔子吗', '123456', '15871276231', '男', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
