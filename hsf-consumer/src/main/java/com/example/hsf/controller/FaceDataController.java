package com.example.hsf.controller;

import com.example.hsf.api.CommuncationApi;
import com.example.hsf.dto.FaceDataDTO;
import com.example.hsf.entity.FaceData;
import com.example.hsf.api.FaceDataApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class FaceDataController {

    @Autowired
    private FaceDataApi faceDataApi;

    @Autowired
    private CommuncationApi communcationApi;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/insertTest")
    public String insertFaceData(){
        FaceDataDTO faceDataDTO = new FaceDataDTO();
        System.out.println("Feign 方式访问");
        return faceDataApi.insertFaceData();
        /*return restTemplate.getForObject("http://service-provider/insert",
                String.class);*/
    }
}
