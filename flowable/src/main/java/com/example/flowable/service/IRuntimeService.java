package com.example.flowable.service;

import org.flowable.engine.runtime.ProcessInstance;

import java.util.Map;

public interface IRuntimeService {

    /**
     * 启动流程
     * @param processKey   流程定义key(流程图ID)
     * @param businessKey  业务key
     * @param map    参数键值对
     * @return  流程实例ID
     */
    ProcessInstance start(String processKey, String businessKey, String userId, Map<String, Object> map);

    /**
     * 终止流程实例
     * @param processInstanceId   流程实例id
     * @param reason    终止理由
     */
    void stop(String processInstanceId, String reason);

    /**
     * 回退到指定任务节点
     * @param currentTaskId  当前任务id
     * @param targetTaskKey  目标任务节点key
     */
    void backToStep(String currentTaskId, String targetTaskKey);

}
