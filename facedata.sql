CREATE TABLE `hsf_face_data` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`face_id` varchar(32) NULL COMMENT '人脸id',
`gender` int(1) NULL COMMENT '性别  0、男   1、女   2、其他',
`age` int(2) NULL COMMENT '年龄',
`arrive_time` datetime NULL COMMENT '到店时间',
`arrive_count` int(5) NULL COMMENT '到店次数',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL,
PRIMARY KEY (`id`) 
);

