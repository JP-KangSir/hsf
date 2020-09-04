package com.example.sysauth.bean;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户中心-字典表
 * uc_dictionary
 * 
 * @author kjp
 * @date 2020/09/01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcDictionary {
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 类型代码
     */
    @ApiModelProperty(value = "类型代码")
    private String typeCode;

    /**
     * 类型名称
     */
    @ApiModelProperty(value = "类型名称")
    private String typeName;

    /**
     * 键
     */
    @ApiModelProperty(value = "键")
    private String dicName;

    /**
     * 值
     */
    @ApiModelProperty(value = "值")
    private String dicValue;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 是否被删除(0：未删除  1：已删除)
     */
    @ApiModelProperty(value = "是否被删除(0：未删除  1：已删除)")
    private Byte isDeleted;

    /**
     * 是否可用(0：不可用 1：可用)
     */
    @ApiModelProperty(value = "是否可用(0：不可用 1：可用)")
    private Byte isEnable;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @ApiModelProperty(value = "创建用户")
    private String createdBy;

    /**
     * 修改用户
     */
    @ApiModelProperty(value = "修改用户")
    private String modifiedBy;
}