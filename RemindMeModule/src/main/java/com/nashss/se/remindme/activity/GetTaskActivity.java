package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.GetTaskRequest;
import com.nashss.se.remindme.activity.results.GetTaskResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;

public class GetTaskActivity {
    private final TaskDao taskDao;

    @Inject
    public GetTaskActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * The `handleRequest` method handles a request to retrieve a task given the task manager id and task id.
     *
     * @param getTaskRequest the request that contains the task manager id and task id
     * @return a GetTaskResult object containing the task
     */
    public GetTaskResult handleRequest(final GetTaskRequest getTaskRequest) {
        String taskId = getTaskRequest.getTaskId();
        String taskManagerId = getTaskRequest.getTaskManagerId();
        Task task = taskDao.getTask(taskManagerId, taskId);
        TaskModel taskModel = new ModelConverter().toTaskModel(task);

        return GetTaskResult.builder()
                .withTask(taskModel)
                .build();
    }

}
