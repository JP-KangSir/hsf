package com.example.hsfprovider.controller;

import com.example.hsfprovider.bean.FaceData;
import com.example.hsfprovider.service.FaceDataService;
import com.example.hsfprovider.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;


@RestController
public class FaceDataController {

    @Autowired
    private FaceDataService faceDataService;

    @RequestMapping("/insert")
    public String insertFaceData(){
        String picture = FileUtil.GetImageStr("F:\\111.jpg");
        FaceData faceData = FaceData.builder()
                .faceId("kjp测试001")
                .age(18)
                .arriveCount(1)
                .arriveTime(new Date())
                .gender(0)
                .picture(picture)
                .build();
        // 存储人脸数据
        faceDataService.insertFaceData(faceData);
        return "ok,成功访问数据存储接口";
    }
}
