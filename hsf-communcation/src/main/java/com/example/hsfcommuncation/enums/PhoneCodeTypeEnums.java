package com.example.hsfcommuncation.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  PhoneCodeTypeEnums {
    REGISTER("register", "注册短信验证码",true,false),
    TESTMESSAGE("testmessage","测试短信",false,false);

    String type;
    String desc;
    boolean checkCode; //校验图形验证码
    boolean needLogin; //是否需要登陆
}
