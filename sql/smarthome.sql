DROP TABLE IF EXISTS `home`;
CREATE TABLE `home` (
  `id` varchar(64) NOT NULL COMMENT '家庭id',
  `name` varchar(20) DEFAULT '恒大之光3#301' COMMENT '家庭名称',
  `picture` varchar(200)  DEFAULT '' COMMENT '家庭头像',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='家庭信息表';

DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` varchar(64) NOT NULL COMMENT '设备id',
  `name` varchar(20) DEFAULT '未命名设备' COMMENT '设备名称',
  `picture` varchar(200)  DEFAULT '' COMMENT '设备图片',
  `device_type` TINYINT   DEFAULT 0 COMMENT '设备类型：1	智能锁;2	智能门磁;3	智能开关;4	智能摄像头;5	煤气报警器;6	甲醛报警器;7	烟雾报警器;8	红外转发器;9	智能插座',
  `serial`  varchar(45)  DEFAULT NULL COMMENT '设备序列号',
  `soft_version` varchar(45) DEFAULT NULL COMMENT '软件版本号',
  `home_id`   varchar(64) DEFAULT '0' COMMENT '所属的家庭id',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父设备id',#有些设备使用zibee与网关通信,网关再通过互联网与服务器通信,所以zibee设备的父设备就是网关;有些设备使用WiFi/4G/nb-iot直接与服务器通信'
  `connect_type` TINYINT  DEFAULT 0 COMMENT '联网方式:0-有线连接;1-zibee通信;2-nb-iot;3-wifi;4-3/4/5G',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY(`id`),
  UNIQUE (`serial`),#序列号唯一
  UNIQUE KEY `home_serial` (`home_id`,`serial`),#一个设备只能属于一个家庭
  UNIQUE KEY `parent_serial` (`parent_id`,`serial`)#一个设备只能有一个父节点设备
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备信息表';


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL COMMENT '用户id',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `image_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime DEFAULT NULL COMMENT '最近登陆时间',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY idx_phone(phone)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';

DROP TABLE IF EXISTS `home_user`;
CREATE TABLE `home_user` (
  `home_id` varchar(255) NOT NULL  COMMENT '家庭id',
  `user_id` varchar(255) NOT NULL  COMMENT '用户id',
  PRIMARY KEY (`home_id`,`user_id`)/*联合主键*/
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭-用户关系表';

DROP TABLE IF EXISTS `sms_template`;
CREATE TABLE `sms_template` (
  `id` varchar(64) DEFAULT NULL COMMENT '短信模板id',
  `type` varchar(255) DEFAULT NULL COMMENT '模板类型:验证码,活动,消费通知',
  `content` varchar(255) DEFAULT NULL COMMENT '短信模板内容',
  `timeout` int(11) DEFAULT NULL COMMENT '超时时间',
  `is_enable` tinyint(255) DEFAULT NULL COMMENT '是否启动',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='短信模板表';

-- ----------------------------
-- Records of sms_template
-- ----------------------------
INSERT INTO `sms_template` VALUES ('1', 'VALIDATE', '尊敬的用户，您的验证码为[MSGCODE]，本验证码有效时间[TIMEOUT]分钟，请勿告知他人', '10', '1', '验证码短信', '2016-07-11 18:22:28', '2016-07-11 18:22:31', 'NORMAL');
INSERT INTO `sms_template` VALUES ('2', 'NOTICE_CASH_COMSUME', '您于[DATE]使用余额消费[AMOUNT]元，如有疑问请致电18600536683', null, '1', '资金消费', '2016-11-20 21:51:56', '2016-11-20 21:51:59', 'NORMAL');

DROP TABLE IF EXISTS `sms_history`;
CREATE TABLE `sms_history` (
  `id` varchar(64) DEFAULT NULL COMMENT '短信历史记录id',
  `phone` varchar(255) DEFAULT NULL COMMENT '短信接收者手机号码',
  `content` varchar(255) DEFAULT NULL COMMENT '短信内容',
  `timeout` int(11) DEFAULT NULL COMMENT '超时时间',
  `type` varchar(255) DEFAULT NULL COMMENT '模板类型:验证码,活动,消费通知',
  `sender` varchar(255) DEFAULT NULL COMMENT '发送者',
  `receiver_id` int(11) DEFAULT NULL COMMENT '接收者id',
  `user_ip` varchar(255) DEFAULT NULL COMMENT '用户ip',
  `validate` varchar(255) DEFAULT NULL COMMENT '验证码',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信历史记录表';


DROP TABLE IF EXISTS `lock_password`;
CREATE TABLE `lock_password` (
  `id` varchar(64) DEFAULT NULL COMMENT '密码id',
  `index` int(11) DEFAULT 0 COMMENT '密码的索引',
  `name` varchar(64) DEFAULT NULL COMMENT '备注名',
  `content` varchar(64) DEFAULT NULL COMMENT '设置的开锁密码',
  `start_time` datetime DEFAULT NULL COMMENT '有效开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '有效结束时间',
  `use_count_max` int(11) DEFAULT -1 COMMENT '最大使用次数 临时密码在使用超过最大次数后就不能开锁，长期密码最大使用次数为-1',
  `used_count` int(11) DEFAULT 0 COMMENT '已经使用的次数',
  `password_type` tinyint DEFAULT 0 COMMENT '密码类型:0-管理员密码;1-数字类型;2-卡片类型;3-指纹类型',
  `device_id` varchar(64) DEFAULT NULL COMMENT '所属的锁id',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  UNIQUE KEY `PASSWORD_INDEX` (`index`,`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门锁密码表';

-- -----------------------------------------------------
-- 电话提醒套餐
--
-- -----------------------------------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package` (
  `id` varchar(64) DEFAULT NULL COMMENT '套餐id',
  `name` varchar(64) DEFAULT NULL COMMENT '套餐名',
  `description` text DEFAULT NULL COMMENT '电话提醒套餐描述',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电话提醒套餐';
INSERT INTO `package` VALUES ('1', '免费赠送', '新用户体验礼包', '--', '2016-11-08 13:50:44', '2016-11-08 13:50:46', 'NORMAL');
INSERT INTO `package` VALUES ('2', '自定义套餐', '由用户自主选择提醒的条目', '--', '2016-11-08 13:50:44', '2016-11-08 13:50:46', 'NORMAL');



-- -----------------------------------------------------
-- 设备-套餐表
-- 一个设备使用哪一款套餐
-- -----------------------------------------------------
DROP TABLE IF EXISTS `device_package`;
CREATE TABLE `device_package` (
  `id` varchar(64) DEFAULT NULL COMMENT 'id',
  `device_id` varchar(64) DEFAULT NULL COMMENT '设备id',
  `package_id` varchar(64) DEFAULT NULL COMMENT '套餐id',
  `start_time` datetime DEFAULT NULL COMMENT '有效期开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '有效期结束时间',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备-套餐表';

-- -----------------------------------------------------
-- 电话提醒条目
-- -----------------------------------------------------
DROP TABLE IF EXISTS `remind_item`;
CREATE TABLE `remind_item` (
  `id` varchar(64) DEFAULT NULL COMMENT '条目id',
  `name` varchar(64) DEFAULT NULL COMMENT '条目名',
  `description` varchar(255) DEFAULT NULL COMMENT '电话提醒条目描述',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电话提醒条目';

INSERT INTO `remind_item` VALUES ('0e9ca1860adc4365bd6dc520b0f80d7c', '门铃提醒', '门铃响起时进行电话提醒', '--', '2016-11-08 13:50:44', '2016-11-08 13:50:46', 'NORMAL');
INSERT INTO `remind_item` VALUES ('0e9ca1860adc4365bd6dc520b0f80e7d', '防盗提醒', '锁孔盖开启时进行电话提醒', '--', '2016-11-08 13:50:44', '2016-11-08 13:50:46', 'NORMAL');
INSERT INTO `remind_item` VALUES ('0e9ca1860adc4365bd6dc520b0f80f8e', '防劫持提醒', '当使用报警指纹/卡片/数字密码时，向指定号码进行电话提醒', '--', '2016-11-08 13:50:44', '2016-11-08 13:50:46', 'NORMAL');

-- -----------------------------------------------------
-- 设备套餐详情表
-- 一个设备使用的套餐详情，一个套餐包含一个或多个提醒条目，比如豪华套餐包含门铃提醒，防盗提醒和防劫持提醒；比如来访套餐只包含门铃提醒
-- -----------------------------------------------------
DROP TABLE IF EXISTS `device_package_detail`;
CREATE TABLE `device_package_detail` (
  `id` varchar(64) DEFAULT NULL COMMENT '套餐详情id',
  `device_package_id` varchar(64) DEFAULT NULL COMMENT '设备-套餐id',
  `remind_item_id` varchar(64) DEFAULT NULL COMMENT '提醒条目id',
  `use_count_max` int(11) DEFAULT -1 COMMENT '最大使用次数 在使用超过最大次数后就不进行电话提醒，长期进行电话提醒则最大使用次数为-1',
  `price` double(3,2) DEFAULT 0.00  COMMENT '超出最大使用次数后，每条提醒收费价格',
  `auto_off` TINYINT(4) DEFAULT 0 COMMENT '使用次数等于最大使用次数后是否自动停止使用，这样就能避免超出后收费',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `package_remind_item` (`package_id`,`remind_item_id`)#同一个套餐里不能存在多条相同的提醒条目，
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='套餐详情表';

-- -----------------------------------------------------
-- 设备每个电话提醒条目使用情况
-- 一个设备使用的套餐详情，统计这个设备每个电话提醒条目已经使用的次数
-- -----------------------------------------------------
DROP TABLE IF EXISTS `device_remind_use`;
CREATE TABLE `device_remind_use` (
  `id` varchar(64) DEFAULT NULL COMMENT 'id',
  `device_id` varchar(64) DEFAULT NULL COMMENT '设备id',
  `remind_item_id` varchar(64) DEFAULT NULL COMMENT '提醒条目id',
  `used_count` int(11) DEFAULT 0 COMMENT '已经使用的次数',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `device_remind_item` (`device_id`,`remind_item_id`)#同一个设备里不能存在多条相同的提醒条目，
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备-提醒条目关系表';

-- -----------------------------------------------------
-- 设备-电话提醒条目配置详情
-- 这个设备使用哪个密码时触发某一个提醒条目会向哪个手机号码打电话
-- -----------------------------------------------------
DROP TABLE IF EXISTS `device_remind_config`;
CREATE TABLE `device_remind_config` (
  `id` varchar(64) DEFAULT NULL COMMENT 'id',
  `device_id` varchar(64) DEFAULT NULL COMMENT '设备id',
  `remind_item_id` varchar(64) DEFAULT NULL COMMENT '提醒条目id',
  `remind_phone` varchar(12) DEFAULT NULL COMMENT '向哪些手机号码打电话提醒',
  `password_id` varchar(64) DEFAULT NULL COMMENT '使用哪些密码时会触发电话提醒',
  `threshold_value` int(11) DEFAULT 0 COMMENT '阈值，当设备某个值超过threshold_value阈值时触发提醒',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备-电话提醒条目配置详情表';
