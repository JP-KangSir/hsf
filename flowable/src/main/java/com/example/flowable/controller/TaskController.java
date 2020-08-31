package com.example.flowable.controller;

import com.example.flowable.service.IRuntimeService;
import com.example.flowable.service.ITaskService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private IRuntimeService runtimeService;

    @Autowired
    private ITaskService taskService;

    /**
     * 创建一个流程实例
     *
     * @param variables 表单参数
     * @return
     */
    @PostMapping("/startProcessInstance")
    public String startProcessInstance(@RequestBody Map<String, Object> variables) {
        String key = variables.get("key").toString();
        String businessKey = variables.get("businessKey").toString();
        String userId = variables.get("userId").toString();
        ProcessInstance processInstance = runtimeService.start(key, businessKey, userId, variables);
        return processInstance.getId();
    }

    /**
     * 查询某个用户的任务
     */
    @PostMapping("/selecTask")
    public List<Task> selecTask(@RequestBody Map<String, Object> map) {
        String name = map.get("name").toString();
        return taskService.selectTasks(name);
    }

    /**
     * 完成某个任务
     *
     * @param map 请求携带的参数（排他网关携带参数也可放在这里面）
     */
    @PostMapping("/complete")
    public void complete(@RequestBody Map<String, Object> map) {
        String taskId = map.get("taskId").toString();
        taskService.complete(taskId, map);
    }

}
