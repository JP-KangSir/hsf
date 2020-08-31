package com.example.flowable.service;


import org.flowable.task.api.Task;

import java.util.List;
import java.util.Map;

public interface ITaskService {

    /**
     * 查询用户任务列表
     * @param name
     * @return
     */
    List<Task> selectTasks(String name);

    /**
     * 完成指定任务
     * @param taskId  任务id
     * @param map  变量值
     */
    void complete(String taskId, Map<String, Object> map);
}
