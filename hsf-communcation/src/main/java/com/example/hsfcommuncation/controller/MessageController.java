package com.example.hsfcommuncation.controller;


import com.example.hsfcommuncation.bean.User;
import com.example.hsfcommuncation.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
        User user = User.builder()
                .name("康金鹏")
                .username("kjp")
                .password("123456")
                .phone("15538981030")
                .build();
        messageService.sendMessage(user,1,new HashMap<String, Object>());
        return "成功";
    }
}
