package com.example.hsfprovider.controller;

import com.example.hsfprovider.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class FileController {

    @Autowired
    private OssService ossService;

    @RequestMapping("/uploadTest")
    public String uploadPic(){
        String filename = "F:\\111.jpg";
        File file=new File(filename);
        String upload = ossService.upload(file, "kjp1.jpg");
        return upload;
    }
}
