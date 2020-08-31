package com.example.hsfprovider.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("hsf_face_data")
public class FaceData {

    @TableId(type = IdType.AUTO)
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
     * 修改时间
     */
    private Date updateTime;

    /**
     * 人脸图像
     */
    @TableField(exist = false)
    private String picture;

}
