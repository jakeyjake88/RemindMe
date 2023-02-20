package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.GetAllTasksRequest;
import com.nashss.se.remindme.activity.results.GetAllTasksResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class for GetAllTasksActivity in the RemindMeClient.
 * <p>
 * This endpoint allows for users to get all tasks associated with a manager.
 */
public class GetAllTasksActivity {
    private final TaskDao taskDao;

    /**
     * Constructor for the GetAllTasksActivity class.
     *
     * @param taskDao data access object that performs operations on tasks
     */
    @Inject
    public GetAllTasksActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

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

        Collections.sort(taskModel, new Comparator<TaskModel>() {
            @Override
            public int compare(TaskModel t1, TaskModel t2) {
                return t1.getDueDate().compareTo(t2.getDueDate());
            }
        });

        return GetAllTasksResult.builder()
                .withTasks(taskModel)
                .build();
    }
}
