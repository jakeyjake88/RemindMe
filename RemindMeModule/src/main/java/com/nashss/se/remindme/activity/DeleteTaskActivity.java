package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.DeleteTaskRequest;
import com.nashss.se.remindme.activity.results.DeleteTaskResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.exceptions.TaskNotFoundException;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;

/**
 * Class for the DeleteTaskActivity for the RemindMeClient.
 */
public class DeleteTaskActivity {
    private final TaskDao taskDao;

    /**
     * Constructor for the DeleteTaskActivity class.
     *
     * @param taskDao To access the task table.
     */
    @Inject
    public DeleteTaskActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public DeleteTaskResult handleRequest(DeleteTaskRequest request) {
        String taskId = request.getTaskId();
        Task task = taskDao.getTask(taskId);

        if (task == null) {
            throw new TaskNotFoundException("Task is null in Activity class");
        }
        Task deletedTask = taskDao.deleteTask(task);
        TaskModel tm = new ModelConverter().toTaskModel(deletedTask);

        return DeleteTaskResult.builder()
                .withTask(tm)
                .build();
    }
}
