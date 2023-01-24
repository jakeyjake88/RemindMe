package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.models.Task;
import exceptions.TaskNotFoundException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TaskDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public TaskDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Task getTask(String taskManagerId, String taskId) {
        Task task = dynamoDBMapper.load(Task.class, taskManagerId, taskId);
        if (null == task) {
            throw new TaskNotFoundException(
                    String.format("Could not find Task with TaskManagerId '%s' and TaskId %d"));
        }
        return task;
    }
}
