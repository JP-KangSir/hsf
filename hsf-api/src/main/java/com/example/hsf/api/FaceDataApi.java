package com.example.hsf.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-provider")
public interface FaceDataApi {

    @RequestMapping(value = "/insert" ,method = RequestMethod.GET)
    String insertFaceData();

}
