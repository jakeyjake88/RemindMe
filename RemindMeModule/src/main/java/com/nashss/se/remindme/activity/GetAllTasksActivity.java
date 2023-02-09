package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.GetAllTasksRequest;
import com.nashss.se.remindme.activity.results.GetAllTasksResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetAllTasksActivity {
    private final TaskDao taskDao;

    @Inject
    public GetAllTasksActivity(TaskDao taskDao) { this.taskDao = taskDao; }

    /**
     * Handles the request to get all tasks for a task manager.
     *
     * @param request The request containing the task manager ID.
     * @return A result object containing a list of task models.
     */
    public GetAllTasksResult handleRequest(final GetAllTasksRequest request) {
        String taskManagerId = request.getTaskManagerId();
        List<TaskModel> taskModel = new ArrayList<>();
        if (taskDao.getAllTasksForManager(taskManagerId) != null) {
            for (Task t : taskDao.getAllTasksForManager(taskManagerId)) {
                TaskModel taskM = new ModelConverter().toTaskModel(t);
                taskModel.add(taskM);
            }
        }

        return GetAllTasksResult.builder()
                .withTasks(taskModel)
                .build();
    }
}
