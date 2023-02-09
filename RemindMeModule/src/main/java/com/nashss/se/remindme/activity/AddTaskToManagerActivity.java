package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.AddTaskToManagerRequest;
import com.nashss.se.remindme.activity.results.AddTaskToManagerResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;

public class AddTaskToManagerActivity {
    private final TaskDao taskDao;

    @Inject
    AddTaskToManagerActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public AddTaskToManagerResult handleRequest(final AddTaskToManagerRequest request) {
        Task task = new Task();
        task.setTaskManagerId(request.getTaskManagerId());
        task.setDescription(request.getDescription());
        task.setName(request.getName());
        task.setTaskId(taskDao.generateNewId());

        taskDao.createTask(task);

        TaskModel taskM = new ModelConverter().toTaskModel(task);

        return AddTaskToManagerResult.builder()
                .withTask(taskM)
                .build();
    }
}
