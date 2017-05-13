DROP TABLE IF EXISTS `home`;
CREATE TABLE `home` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '家庭id',
  `name` varchar(20) DEFAULT '恒大之光3#301' COMMENT '家庭名称',
  `picture` varchar(200)  DEFAULT '' COMMENT '家庭头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='家庭信息表';

DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `name` varchar(20) DEFAULT '未命名设备' COMMENT '设备名称',
  `picture` varchar(200)  DEFAULT '' COMMENT '设备图片',
  `device_type` TINYINT   DEFAULT 0 COMMENT '设备类型：1	智能锁;2	智能门磁;3	智能开关;4	智能摄像头;5	煤气报警器;6	甲醛报警器;7	烟雾报警器;8	红外转发器;9	智能插座',
  `serial`  varchar(45)  DEFAULT NULL COMMENT '设备序列号',
  `soft_version` varchar(45) DEFAULT NULL COMMENT '软件版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `home_id` BIGINT DEFAULT 0 COMMENT '所属的家庭id',
  `parent_id` BIGINT DEFAULT 0 COMMENT '父设备id',#有些设备使用zibee与网关通信，网关再通过互联网与服务器通信，所以zibee设备的父设备就是网关;有些设备使用WiFi/4G/nb-iot直接与服务器通信
  `connect_type` TINYINT  DEFAULT 0 COMMENT '联网方式:0-有线连接;1-zibee通信;2-nb-iot;3-wifi;4-3/4/5G',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭信息表';


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `image_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime DEFAULT NULL COMMENT '最近登陆时间',
  PRIMARY KEY (`id`),
  KEY idx_phone(phone)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';

DROP TABLE IF EXISTS `home_user`;
CREATE TABLE `home_user` (
  `home_id` BIGINT NOT NULL  COMMENT '家庭id',
  `user_id` BIGINT NOT NULL  COMMENT '用户id',
  PRIMARY KEY (`home_id`,`user_id`)/*联合主键*/
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭-用户关系表';