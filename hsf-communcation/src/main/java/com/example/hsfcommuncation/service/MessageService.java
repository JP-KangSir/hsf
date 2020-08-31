package com.example.hsfcommuncation.service;

import com.example.hsfcommuncation.bean.User;

import java.util.Map;

public interface MessageService {

    /**
     * 生成短信模板，消息扔给mq
     * @param user
     * @param templateId
     * @param datas
     */
    public void sendMessage(User user, Integer templateId, Map<String,Object> datas);

    /**
     * 发送短信（收费）
     */
    public void SendSms();
}
