package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.GetTaskManagerRequest;
import com.nashss.se.remindme.activity.results.GetTaskManagerResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import com.nashss.se.remindme.models.TaskManagerModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetTaskManagerActivity {
    private final TaskManagerDao tmDao;

    @Inject
    public GetTaskManagerActivity(TaskManagerDao tmDao) {
        this.tmDao = tmDao;
    }

    /**
     * This method handles a `GetTaskManagerRequest` and returns a `GetTaskManagerResult`.
     * It retrieves a list of `TaskManagerModel` objects that are associated with the provided `creatorId`.
     *
     * @param request The `GetTaskManagerRequest` object that contains the `creatorId` to search for.
     * @return A `GetTaskManagerResult` object that contains a list of `TaskManagerModel` objects.
     */
    public GetTaskManagerResult handleRequest(final GetTaskManagerRequest request) {
        String creatorId = request.getCreatorId();
        List<TaskManagerModel> tmList = new ArrayList<>();
        if (tmDao.getAllTaskManagers(creatorId) != null) {
            for (TaskManager t : tmDao.getAllTaskManagers(creatorId)) {
                TaskManagerModel mod = new ModelConverter().toTaskManagerModel(t);
                tmList.add(mod);
            }
        }
        return GetTaskManagerResult.builder()
                .withTask(tmList)
                .build();
    }
}
