package com.example.flowable.controller;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 初始化流程图
     */
    @GetMapping("/intDeployment")
    public Deployment initDeployment() {
        String path = "processes/holiday-request.bpmn20.xml";
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource(path)
                .deploy();
        return deployment;
    }
}
