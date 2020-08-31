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
@TableName("msg-send")
public class MessageSend {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 发送电话号
     */
    private String sendPhone;
    /**
     * 模板id
     */
    private Integer templateId;
    /**
     * 内容id
     */
    private String content;
    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 发送状态   0、未发送  1、已发送
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;


}
