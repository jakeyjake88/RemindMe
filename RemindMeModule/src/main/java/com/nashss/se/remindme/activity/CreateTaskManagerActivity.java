package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.CreateTaskManagerRequest;
import com.nashss.se.remindme.activity.results.CreateTaskManagerResult;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;
import com.nashss.se.remindme.dynamodb.models.TaskManager;

import javax.inject.Inject;

public class CreateTaskManagerActivity {
    private final TaskManagerDao taskManagerDao;

    /**
     * Constructor for the CreateTaskManagerActivity class.
     *
     * @param taskManagerDao A data access object that performs operations on tasks
     */
    @Inject
    public CreateTaskManagerActivity(TaskManagerDao taskManagerDao) {
        this.taskManagerDao = taskManagerDao;
    }

    /**
     * Handles the creation of a new Task Manager by creating a new TaskManager object, setting its values based on the
     * information passed in the request, generating a unique Task Manager ID, and calling the `createTaskManager`
     * method to save it.
     *
     * @param request CreateTaskManagerRequest object that contains the task manager name and creator ID
     * @return CreateTaskManagerResult object that contains the created task manager's information including its ID, name,
     * and creator ID
     * @throws IllegalArgumentException if the request is null or any of the required fields are not provided
     */
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
