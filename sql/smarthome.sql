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
  `use_count_max` int(11) DEFAULT -1 COMMENT '最大使用次数 临时密码在使用超过最大次数后就能不能开锁，长期密码最大使用次数为-1',
  `password_type` tinyint DEFAULT 0 COMMENT '密码类型:0-管理员密码;1-数字类型;2-卡片类型;3-指纹类型',
  `device_id` varchar(64) DEFAULT NULL COMMENT '所属的锁id',
  `remarks` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  UNIQUE KEY `PASSWORD_INDEX` (`index`,`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门锁密码表';