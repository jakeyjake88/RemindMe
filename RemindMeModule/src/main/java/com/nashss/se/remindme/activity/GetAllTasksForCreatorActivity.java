package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.GetAllTasksForCreatorRequest;
import com.nashss.se.remindme.activity.results.GetAllTasksForCreatorResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class for GetAllTasksForCreatorActivity in the RemindMeClient.
 * <p>
 * This endpoint allows for users to get all tasks associated with a creatorId.
 */
public class GetAllTasksForCreatorActivity {
    private final TaskDao taskDao;

    /**
     * Constructor for the GetAllTasksForCreatorActivity class.
     *
     * @param taskDao data access object that performs operations on tasks
     */
    @Inject
    public GetAllTasksForCreatorActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * Handles the request to get all tasks for a creatorId.
     *
     * @param request The request containing the creatorId.
     * @return A result object containing a list of task models.
     */
    /*public GetAllTasksForCreatorResult handleRequest(final GetAllTasksForCreatorRequest request) {
        String creatorId = request.getCreatorId();
        List<TaskModel> taskModel = new ArrayList<>();
        if (taskDao.getAllTasksForCreator(creatorId) != null) {
            for (Task t : taskDao.getAllTasksForCreator(creatorId)) {
                TaskModel taskM = new ModelConverter().toTaskModel(t);
                taskModel.add(taskM);
            }
        }

        return GetAllTasksForCreatorResult.builder()
                .withTasks(taskModel)
                .build();
    } */

    public GetAllTasksForCreatorResult handleRequest(final GetAllTasksForCreatorRequest request) {
        String creatorId = request.getCreatorId();
        List<TaskModel> taskModel = new ArrayList<>();
        if (taskDao.getAllTasksForCreator(creatorId) != null) {
            for (Task t : taskDao.getAllTasksForCreator(creatorId)) {
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
        return GetAllTasksForCreatorResult.builder()
                .withTasks(taskModel)
                .build();
    }
}
