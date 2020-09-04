package com.example.sysauth.bean;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户中心-用户表
 * uc_user
 * 
 * @author kjp
 * @date 2020/09/01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcUser {
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 用户唯一标识
     */
    @ApiModelProperty(value = "用户唯一标识")
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码密文
     */
    @ApiModelProperty(value = "密码密文")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nick;

    /**
     * 头像图片地址
     */
    @ApiModelProperty(value = "头像图片地址")
    private String headUrl;

    /**
     * 用户类型(0：普通用户)
     */
    @ApiModelProperty(value = "用户类型(0：普通用户)")
    private Byte userType;

    /**
     * 是否可用(0：不可用 1：可用)
     */
    @ApiModelProperty(value = "是否可用(0：不可用 1：可用)")
    private Byte isEnable;

    /**
     * 是否被删除(0：未删除  1：已删除)
     */
    @ApiModelProperty(value = "是否被删除(0：未删除  1：已删除)")
    private Byte isDeleted;

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
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    private Date lastLogin;

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