package com.example.sysauth.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色查询接口DTO
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcRoleListDTO {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

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
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createdBy;

}
