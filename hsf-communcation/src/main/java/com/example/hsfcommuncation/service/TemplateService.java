package com.example.hsfcommuncation.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.hsfcommuncation.bean.Template;

import java.util.Map;

public interface TemplateService extends IService<Template> {


    /**
     * 根据模板和参数组装短信内容
     * @param template
     * @param datas
     * @return
     */
    public String getContent(String template, Map<String,Object> datas);

}
