package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import dynamodb.models.Task;
import exceptions.TaskNotFoundException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Task> getAllTasksForManager(String taskManagerId) {
        Map<String, AttributeValue> rs = new HashMap<String, AttributeValue>();
        rs.put(":val1", new AttributeValue().withS(taskManagerId));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("taskManagerId = :val1")
                .withExpressionAttributeValues(rs);
        return dynamoDBMapper.scan(Task.class, scanExpression);
    }
}
