package com.example.flowable.service.impl;

import com.example.flowable.service.ITaskService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ITaskServiceImpl implements ITaskService {

    @Autowired
    private TaskService taskService;

    @Override
    public List<Task> selectTasks(String name) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(name).orderByTaskCreateTime().desc().list();
        //List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(name).list();
        return tasks;
    }

    @Override
    public void complete(String taskId, Map<String, Object> map) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("流程不存在");
        }
        taskService.complete(taskId, map);
    }
}
