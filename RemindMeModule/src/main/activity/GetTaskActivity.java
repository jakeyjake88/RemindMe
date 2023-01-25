package activity;

import activity.requests.GetTaskRequest;
import activity.results.GetTaskResult;
import dynamodb.TaskDao;
import dynamodb.models.Task;

import javax.inject.Inject;

public class GetTaskActivity {
    private final TaskDao taskDao;

    @Inject
    public GetTaskActivity(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public GetTaskResult handleRequest(final GetTaskRequest getTaskRequest) {
        String taskId = getTaskRequest.getTaskId();
        String taskManagerId = getTaskRequest.getTaskManagerId();;
        Task task = taskDao.getTask(taskManagerId, taskId);
    }

}
