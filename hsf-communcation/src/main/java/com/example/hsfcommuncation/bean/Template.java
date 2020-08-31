package com.example.hsfcommuncation.bean;


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
@TableName("msg-template")
public class Template {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 描述
     */
    private String desc;

    /**
     * 模板内容
     */
    private String template;

    /**
     * 是否启用   0、启用    1、禁用
     */
    private Integer isEnable;

    private Date createTime;

    private Date updateTime;
}
