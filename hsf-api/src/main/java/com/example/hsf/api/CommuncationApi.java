package com.example.hsf.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-communcation")
public interface CommuncationApi {

    @RequestMapping(value = "/sendMessage" ,method = RequestMethod.GET)
    String insertFaceData();

}
