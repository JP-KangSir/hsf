package com.example.sysauth.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 查询菜单数据DTO
 *
 * @author kjp
 * @date 2020/09/01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcAuthorityListDTO {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String name;

    /**
     * 是否可用(0：不可用 1：可用)
     */
    @ApiModelProperty(value = "是否可用(0：不可用 1：可用)")
    private Byte isEnable;

    /**
     * 是否被删除(0：未删除 1：已删除)
     */
    @ApiModelProperty(value = "是否被删除(0：未删除 1：已删除)")
    private Byte isDeleted;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createdBy;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private String modifiedBy;

}