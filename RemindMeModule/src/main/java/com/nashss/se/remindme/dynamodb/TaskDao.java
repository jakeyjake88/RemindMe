package com.nashss.se.remindme.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.exceptions.TaskNotFoundException;

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
        if (taskManagerId == null || taskId == null) throw new TaskNotFoundException("Nope");
        Task task = dynamoDBMapper.load(Task.class, taskManagerId, taskId);
        if (null == task) {
            throw new TaskNotFoundException(
                    "Could not find Task with TaskManagerId '%s' and TaskId %d");
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
