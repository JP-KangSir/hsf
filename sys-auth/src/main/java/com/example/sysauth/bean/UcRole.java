package com.example.sysauth.bean;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户中心-角色表
 * uc_role
 * 
 * @author kjp
 * @date 2020/09/01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcRole {
    /**
     * 
     */
    @ApiModelProperty(value = "唯一标识")
    private Integer id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

    /**
     * 角色类型
     */
    @ApiModelProperty(value = "角色类型")
    private Byte roleType;

    /**
     * 角色描述信息
     */
    @ApiModelProperty(value = "角色描述信息")
    private String description;

    /**
     * 是否删除(0：未删除 1：已删除)
     */
    @ApiModelProperty(value = "是否删除(0：未删除 1：已删除)")
    private Byte isDeleted;

    /**
     * 是否可用(0：不可用 1：可用)
     */
    @ApiModelProperty(value = "是否可用(0：不可用 1：可用)")
    private Byte isEnable;

    /**
     * 父级角色
     */
    @ApiModelProperty(value = "父级角色")
    private Integer parentId;

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

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreated;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}