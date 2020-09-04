package com.example.generator.bean;

import io.swagger.annotations.ApiModelProperty;
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
 * @date 2020/09/01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HsfFaceData {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 人脸id
     */
    @ApiModelProperty(value = "人脸id")
    private String faceId;

    /**
     * 性别  0、男   1、女   2、其他
     */
    @ApiModelProperty(value = "性别  0、男   1、女   2、其他")
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 到店时间
     */
    @ApiModelProperty(value = "到店时间")
    private Date arriveTime;

    /**
     * 到店次数
     */
    @ApiModelProperty(value = "到店次数")
    private Integer arriveCount;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Date updateTime;

    /**
     * 测试参数
     */
    @ApiModelProperty(value = "测试参数")
    private String test;
}