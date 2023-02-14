package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.MarkIsCompleteRequest;
import com.nashss.se.remindme.activity.results.MarkIsCompleteResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;

/**
 * Class for the MarkIsCompleteActivity class for the RemindMeClient.
 */
public class MarkIsCompleteActivity {
    private final TaskDao taskDao;

    /**
     *
     * @param taskDao to access task table.
     */
    @Inject
    public MarkIsCompleteActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * Handles the request to mark a task as complete.
     *
     * @param request The request containing the taskID to be marked as complete.
     * @return An updated TaskModel.
     */

    public MarkIsCompleteResult handleRequest(final MarkIsCompleteRequest request) {
        String taskId = request.getTaskId();
        String taskManagerId = request.getTaskManagerId();
        Task task = taskDao.getTask(taskId, taskManagerId);
        task.setIsActive(false);
        taskDao.createTask(task);
        TaskModel tm = new ModelConverter().toTaskModel(task);

        return MarkIsCompleteResult.builder()
                .withTask(tm)
                .build();
    }

}
