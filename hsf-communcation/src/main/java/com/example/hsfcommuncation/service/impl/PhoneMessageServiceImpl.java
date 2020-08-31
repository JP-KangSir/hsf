package com.example.hsfcommuncation.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.hsfcommuncation.bean.MessageSend;
import com.example.hsfcommuncation.bean.Template;
import com.example.hsfcommuncation.bean.User;
import com.example.hsfcommuncation.service.MessageSendService;
import com.example.hsfcommuncation.service.MessageService;
import com.example.hsfcommuncation.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PhoneMessageServiceImpl implements MessageService {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private MessageSendService messageSendService;

    @Override
    public void sendMessage(User user, Integer templateId, Map<String, Object> datas) {
        Template template = templateService.selectById(templateId);
        //参数校验    略
        putUserData(user, datas);
        String content = templateService.getContent(template.getTemplate(),datas);
        //存储到 msg-send 短信发送表
        MessageSend messageSend = MessageSend.builder()
                .userId(user.getId())
                .status(0)
                .templateId(templateId)
                .content(content)
                .sendPhone(user.getPhone())
                .build();
        messageSendService.insert(messageSend);
        //放到消息中间件中待消费


    }

    @Override
    public void SendSms() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "15538981030");
        request.putQueryParameter("SignName", "康金鹏");
        request.putQueryParameter("TemplateCode", "你好，kjp测试");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public void putUserData(User user,Map<String, Object> datas){
        datas.put("name",user.getName());
        //XXXX可扩充
    }
}
