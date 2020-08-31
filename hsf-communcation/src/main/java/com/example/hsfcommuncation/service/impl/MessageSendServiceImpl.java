package com.example.hsfcommuncation.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.hsfcommuncation.bean.MessageSend;
import com.example.hsfcommuncation.bean.Template;
import com.example.hsfcommuncation.dao.MessageSendDao;
import com.example.hsfcommuncation.dao.TemplateDao;
import com.example.hsfcommuncation.service.MessageSendService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MessageSendServiceImpl extends ServiceImpl<MessageSendDao, MessageSend> implements MessageSendService {


}
