package com.example.generator.bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * hsf_face_data
 * 
 * @author kjp
 * @date 2020/08/31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HsfFaceData {
    /**
     * id
     */
    private Integer id;

    /**
     * 人脸id
     */
    private String faceId;

    /**
     * 性别  0、男   1、女   2、其他
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 到店时间
     */
    private Date arriveTime;

    /**
     * 到店次数
     */
    private Integer arriveCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 测试参数
     */
    private String test;
}