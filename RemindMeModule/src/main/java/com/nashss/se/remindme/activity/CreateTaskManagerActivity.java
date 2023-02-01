package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.CreateTaskManagerRequest;
import com.nashss.se.remindme.activity.results.CreateTaskManagerResult;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;
import com.nashss.se.remindme.dynamodb.models.TaskManager;

import javax.inject.Inject;

public class CreateTaskManagerActivity {
    private final TaskManagerDao taskManagerDao;

    @Inject
    public CreateTaskManagerActivity(TaskManagerDao taskManagerDao) {
        this.taskManagerDao = taskManagerDao;
    }

    public CreateTaskManagerResult handleRequest(final CreateTaskManagerRequest request) {
        TaskManager taskManager = new TaskManager();
        taskManager.setTaskManagerId(taskManagerDao.generateNewId());
        taskManager.setTaskManagerName(request.getTaskManagerName());
        taskManager.setCreatorId(request.getCreatorId());

        taskManagerDao.createTaskManager(taskManager);
        return CreateTaskManagerResult.builder().withCreatorId(taskManager.getCreatorId())
                .withTaskManagerName(taskManager.getTaskManagerName())
                .withManagerId(taskManager.getTaskManagerId())
                .build();
    }

}
