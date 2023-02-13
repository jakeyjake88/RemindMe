package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.AddTaskToManagerRequest;
import com.nashss.se.remindme.activity.results.AddTaskToManagerResult;
import com.nashss.se.remindme.converters.LocalDateTimeConverter;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;

/**
 * Class for AddTaskToManagerActivity for the RemindMeClient.
 * <p>
 * This endpoint allows for users to add a Task to a Manager.
 */
public class AddTaskToManagerActivity {
    private final TaskDao taskDao;

    /**
     * Constructor for the AddTaskToManagerActivity class.
     *
     * @param taskDao A data access object that performs operations on tasks
     */
    @Inject
    public AddTaskToManagerActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * Handles the request to add a new task to a task manager.
     *
     * @param request An object that contains the information about the task to be added
     * @return An object that contains the result of the task addition
     */
    public AddTaskToManagerResult handleRequest(final AddTaskToManagerRequest request) {
        Task task = new Task();
        task.setTaskManagerId(request.getTaskManagerId());
        task.setDescription(request.getDescription());
        task.setName(request.getName());
        task.setTaskId(taskDao.generateNewId());
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        task.setDueDate(converter.unconvert(request.getDueDate()));

        taskDao.createTask(task);

        TaskModel taskM = new ModelConverter().toTaskModel(task);

        return AddTaskToManagerResult.builder()
                .withTask(taskM)
                .build();
    }
}
