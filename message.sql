CREATE TABLE `base-config` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`value` varchar(32) NULL COMMENT '模块值',
`desc` varchar(32) NULL COMMENT '描述',
`remark` varchar(32) NULL COMMENT '备注',
`is_enable` tinyint(4) NULL COMMENT '是否弃用   0、启用    1、未启用',
`create_time` datetime NULL,
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
);

CREATE TABLE `msg-template` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`type` int(4) NULL COMMENT '类型',
`desc` varchar(255) NULL COMMENT '描述',
`template` varchar(255) NULL COMMENT '模板',
`is_enable` tinyint(4) NULL COMMENT '是否启用   0、启用    1、禁用',
`create_time` datetime NULL,
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
);

CREATE TABLE `msg-send` (
`id` int(11) NOT NULL,
`user_id` int(11) NULL COMMENT '用户id',
`send_phone` int(11) NULL COMMENT '发送手机号',
`template_id` int(11) NULL COMMENT '模板id',
`content` varchar(255) NULL COMMENT '内容',
`send_time` datetime NULL COMMENT '发送时间',
`status` int(4) NULL COMMENT '发送状态   0、未发送  1、已发送',
`create_time` datetime NULL,
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
);

