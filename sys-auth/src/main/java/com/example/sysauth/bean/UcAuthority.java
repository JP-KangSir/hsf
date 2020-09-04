package com.example.sysauth.bean;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户中心-菜单表
 * uc_authority
 * 
 * @author kjp
 * @date 2020/09/02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcAuthority {
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String name;

    /**
     * 权限序号
     */
    @ApiModelProperty(value = "权限序号")
    private Byte authOrder;

    /**
     * 菜单层级
     */
    @ApiModelProperty(value = "菜单层级")
    private Byte authLevel;

    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识")
    private String authTag;

    /**
     * 资源地址
     */
    @ApiModelProperty(value = "资源地址")
    private String url;

    /**
     * 分组标识
     */
    @ApiModelProperty(value = "分组标识")
    private String groupFlag;

    /**
     * 上级菜单id
     */
    @ApiModelProperty(value = "上级菜单id")
    private Integer parentId;

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
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    private String description;

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

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date gmtCreated;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}