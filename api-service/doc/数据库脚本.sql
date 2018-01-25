SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `company_no` char(6) DEFAULT NULL COMMENT '商户编号',
  `company_name` varchar(100) DEFAULT NULL COMMENT '商户名称',
  `contact` varchar(20) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(60) DEFAULT NULL COMMENT '联系电话',
  `open_key` varchar(100) DEFAULT NULL,
  `open_secret` varchar(100) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'NOTACTIVE' COMMENT 'ACTIVE("正常"),CLOSED("关闭"),NOTACTIVE("未激活"),PAUSE("暂停")',
  `itime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='商户';

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '0', '000001', 'zw的测试', '张三', '0755-80555000', 'aaaaaa', 'aaaaaa', 'ACTIVE', '2017-07-21 11:35:30', '2017-07-21 11:35:34');

-- ----------------------------
-- Table structure for issue
-- ----------------------------
DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `issue_no` varchar(20) DEFAULT NULL COMMENT '奖期编号',
  `game_type` varchar(20) DEFAULT NULL COMMENT '玩法 双色球(SSQ)',
  `bonus_code` varchar(30) DEFAULT NULL COMMENT '开奖号码',
  `start_time` datetime DEFAULT NULL COMMENT '奖期开启时间',
  `stop_time` datetime DEFAULT NULL COMMENT '奖期截止时间',
  `official_start_time` datetime DEFAULT NULL COMMENT '官方奖期开启时间',
  `official_stop_time` datetime DEFAULT NULL COMMENT '官方奖期截止时间',
  `issue_type` varchar(20) DEFAULT 'END' COMMENT '奖期状态  在售(SALING) 预售(BOOKING) 已开奖(BONUS) 已截止(END)\r\n            ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='奖期';

-- ----------------------------
-- Table structure for printissue
-- ----------------------------
DROP TABLE IF EXISTS `printissue`;
CREATE TABLE `printissue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `issue_no` varchar(20) DEFAULT NULL COMMENT '奖期编号',
  `game_type` varchar(20) DEFAULT NULL COMMENT '玩法 双色球(SSQ)',
  `bonus_code` varchar(30) DEFAULT NULL COMMENT '开奖号码',
  `start_time` datetime DEFAULT NULL COMMENT '奖期开启时间',
  `stop_time` datetime DEFAULT NULL COMMENT '奖期截止时间',
  `official_start_time` datetime DEFAULT NULL COMMENT '官方奖期开启时间',
  `official_stop_time` datetime DEFAULT NULL COMMENT '官方奖期截止时间',
  `issue_type` varchar(20) DEFAULT 'END' COMMENT '预开启或奖期未开启(0) 开启新奖期(1) 暂停销售(2) 奖期截止(3) 完成期结，可以执行销量查询,没完成返奖,此时可以返奖() 完成返奖()，可执行返奖查询()，没完成期结() 发送开奖号码() 完成期结和返奖,可执行返奖，销量查询()',
  `is_bonus` varchar(20) DEFAULT 'NO' COMMENT '兑过奖(YES) 未兑(NO)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `name` varchar(100) NOT NULL,
  `version` bigint(20) NOT NULL,
  `cacheCount` int(11) DEFAULT NULL,
  `indexNum` bigint(20) NOT NULL,
  `modMaxNum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('msgId', '0', '1000', '1', '100000000');
INSERT INTO `sequence` VALUES ('orderId', '0', '1000', '1', '100000000');

-- ----------------------------
-- Table structure for ssqbonus
-- ----------------------------
DROP TABLE IF EXISTS `ssqbonus`;
CREATE TABLE `ssqbonus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `issue_no` varchar(20) DEFAULT NULL COMMENT '奖期编号',
  `company_no` char(6) DEFAULT NULL COMMENT '公司编号',
  `ssq_order_no` varchar(60) DEFAULT NULL COMMENT '双色球订单号',
  `play_type` varchar(20) DEFAULT NULL,
  `bonus_count` int(11) DEFAULT '0' COMMENT '中奖注数',
  `bonus_amount` decimal(12,2) DEFAULT NULL COMMENT '中奖金额',
  `bonus_code` varchar(200) DEFAULT NULL COMMENT '中奖号码',
  `bonus_level` varchar(20) DEFAULT NULL COMMENT '中奖奖等',
  `bonus_level_amount` decimal(12,2) DEFAULT NULL COMMENT '中奖奖等金额',
  `is_bom_bonus` varchar(20) DEFAULT NULL COMMENT '是否为大奖 是（YES） 否（NO）',
  `itime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='双色球中奖信息';

-- ----------------------------
-- Table structure for ssqorder
-- ----------------------------
DROP TABLE IF EXISTS `ssqorder`;
CREATE TABLE `ssqorder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `company_no` char(6) DEFAULT NULL COMMENT '商户编号',
  `ssq_order_no` varchar(60) DEFAULT NULL COMMENT '订单编号',
  `ticket_no` varchar(60) DEFAULT NULL COMMENT '票号',
  `issue_no` varchar(60) DEFAULT NULL COMMENT '奖期编号',
  `play_type` varchar(20) DEFAULT NULL COMMENT '投注方式',
  `times` int(11) DEFAULT '1' COMMENT '倍数',
  `lotterys` varchar(500) DEFAULT NULL COMMENT '彩票号',
  `amount` decimal(12,2) DEFAULT '0.00' COMMENT '金额',
  `card_no` varchar(40) DEFAULT NULL COMMENT '身份证号码',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `status` varchar(20) DEFAULT NULL COMMENT '处理状态 SUCCESS(成功) FAIL(失败) DEALING(处理中)',
  `descs` varchar(200) DEFAULT NULL COMMENT '说明',
  `itime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='双色球订单';

-- ----------------------------
-- Table structure for ssqorder_temp
-- ----------------------------
DROP TABLE IF EXISTS `ssqorder_temp`;
CREATE TABLE `ssqorder_temp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT '0',
  `company_no` char(6) DEFAULT NULL COMMENT '商户编号',
  `ssq_order_no` varchar(60) DEFAULT NULL COMMENT '订单编号',
  `ticket_no` varchar(60) DEFAULT NULL COMMENT '票号',
  `issue_no` varchar(60) DEFAULT NULL COMMENT '奖期编号',
  `play_type` varchar(20) DEFAULT NULL COMMENT '投注方式',
  `times` int(11) DEFAULT '1' COMMENT '倍数',
  `lotterys` varchar(500) DEFAULT NULL COMMENT '彩票号',
  `amount` decimal(12,2) DEFAULT '0.00' COMMENT '金额',
  `card_no` varchar(40) DEFAULT NULL COMMENT '身份证号码',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `status` varchar(20) DEFAULT NULL COMMENT '处理状态 SUCCESS(成功) FAIL(失败) DEALING(处理中)',
  `descs` varchar(200) DEFAULT NULL COMMENT '说明',
  `itime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='双色球订单';

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `key_id` varchar(60) NOT NULL,
  `key_value` varchar(200) DEFAULT NULL,
  `key_group` varchar(60) DEFAULT NULL,
  `descs` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`key_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('60000', '2017265', '600', '最近开奖期');
INSERT INTO `sys_config` VALUES ('60001', '2017266', '600', '在售奖期');


DROP TABLE IF EXISTS `bonuscollection`;
CREATE TABLE `bonuscollection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_no` varchar(20) DEFAULT NULL,
  `issue_no` varchar(20) DEFAULT NULL,
  `game_type` varchar(20) DEFAULT NULL,
  `bonus_code` varchar(100) DEFAULT NULL,
  `bonus_count` int(11) DEFAULT NULL,
  `bonus_amount` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
