package com.example.sysauth.bean;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户中心-用户角色关系表
 * uc_user_role_relation
 * 
 * @author kjp
 * @date 2020/09/01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcUserRoleRelation {
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Integer roleId;

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
    private Date gmtCreated;

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