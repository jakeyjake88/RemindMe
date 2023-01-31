package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.CreateTaskManagerRequest;
import com.nashss.se.remindme.activity.results.CreateTaskManagerResult;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;

import javax.inject.Inject;

public class CreateTaskManagerActivity {
    private final TaskManagerDao taskManagerDao;

    @Inject
    public CreateTaskManagerActivity(TaskManagerDao taskManagerDao) {
        this.taskManagerDao = taskManagerDao;
    }

    public CreateTaskManagerResult handleRequest(final CreateTaskManagerRequest request) {
        String managerId = taskManagerDao.generateNewId();

        return CreateTaskManagerResult.builder().withManagerId(managerId).build();
    }

}
