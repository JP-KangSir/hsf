package com.example.flowable.service.impl;

import com.example.flowable.service.IRuntimeService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.common.impl.identity.Authentication;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IRuntimeServiceImpl implements IRuntimeService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Override
    public ProcessInstance start(String processKey, String businessKey,String userId, Map<String, Object> map) {
        Authentication.setAuthenticatedUserId(userId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey, businessKey, map);
        //使用完毕置空
        Authentication.setAuthenticatedUserId(null);
        return processInstance;
    }

    @Override
    public void stop(String processInstanceId, String reason) {
        runtimeService.deleteProcessInstance(processInstanceId, reason);
    }

    @Override
    public void backToStep(String currentTaskId, String targetTaskKey) {
        Task currentTask = taskService.createTaskQuery().taskId(currentTaskId).singleResult();
        if (currentTask == null) {
            throw new RuntimeException("当前任务节点不存在");
        }
        List<String> currentTaskKeys = new ArrayList<>();
        currentTaskKeys.add(currentTask.getTaskDefinitionKey());
        runtimeService.createChangeActivityStateBuilder().processInstanceId(currentTask.getProcessInstanceId()).moveActivityIdsToSingleActivityId(currentTaskKeys, targetTaskKey);
    }

}
