package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.AddTaskToManagerRequest;
import com.nashss.se.remindme.activity.results.AddTaskToManagerResult;
import com.nashss.se.remindme.converters.DateTimeLocalConverter;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class for AddTaskToManagerActivity for the RemindMeClient.
 * <p>
 * This endpoint allows for users to add a Task to a Manager.
 */
public class AddTaskToManagerActivity {
    private final TaskDao taskDao;
    private final TaskManagerDao tmDao;

    /**
     * Constructor for the AddTaskToManagerActivity class.
     *
     * @param taskDao A data access object that performs operations on tasks
     * @param tmDao - the task manager dao
     */
    @Inject
    public AddTaskToManagerActivity(TaskDao taskDao, TaskManagerDao tmDao) {
        this.tmDao = tmDao;
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
        task.setCreatorId(request.getCreatorId());
        task.setIsActive(true);
        TaskManager tm = tmDao.getTaskManagerById(request.getTaskManagerId());
        if (tm == null) {
            throw new IllegalArgumentException("TaskManager is null");
        } else if (!Objects.equals(tm.getCreatorId(), task.getCreatorId())) {
            throw new IllegalArgumentException("The creatorIds don't match!");
        }

        DateTimeLocalConverter converter = new DateTimeLocalConverter();
        LocalDateTime time = converter.convertDatetimeLocalToJava(request.getDueDate());
        task.setDueDate(time);
        taskDao.createTask(task);

        TaskModel taskM = new ModelConverter().toTaskModel(task);

        return AddTaskToManagerResult.builder()
                .withTask(taskM)
                .build();
    }
}
