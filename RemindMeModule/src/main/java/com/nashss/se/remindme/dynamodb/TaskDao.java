package com.nashss.se.remindme.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.exceptions.TaskNotFoundException;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for the TaskDao.
 */
@Singleton
public class TaskDao {
    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Constructor for the TaskDao class.
     * @param dynamoDBMapper to access database
     */
    @Inject
    public TaskDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Retrieves a Task from the database using the task manager ID and task ID.
     *
     * @param taskId The ID of the task to retrieve.
     * @param taskManagerId the taskManagerId.
     * @return The Task with the specified task manager ID and task ID.
     * @throws TaskNotFoundException If the task manager ID or task ID is `null` or if the task cannot be found.
     */
    public Task getTask(String taskId, String taskManagerId) {
        if (taskId == null || taskManagerId == null) {
            throw new TaskNotFoundException("Nope");
        }

        Task task = dynamoDBMapper.load(Task.class, taskManagerId, taskId);

        if (null == task) {
            throw new TaskNotFoundException(
                    "Could not find Task with TaskManagerId '%s' and TaskId %d");
        }
        return task;
    }

    /**
     * Retrieves all tasks for a task manager from the database.
     *
     * @param taskManagerId The ID of the task manager to retrieve tasks for.
     * @return A list of all tasks for the specified task manager.
     * @throws TaskNotFoundException If the task manager ID is `null` or if no tasks are found.
     */
    public List<Task> getAllTasksForManager(String taskManagerId) {
        if (taskManagerId == null) {
            throw new TaskNotFoundException("No task found!!");
        }

        Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
        expressionAttributeValues.put(":val1", new AttributeValue().withS(taskManagerId));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("taskManagerId = :val1")
                .withExpressionAttributeValues(expressionAttributeValues);
        return dynamoDBMapper.scan(Task.class, scanExpression);
    }

    /**
     * Creates a Task in the Database.
     *
     * @param task The task to be saved.
     * @return The saved task.
     */
    public Task createTask(Task task) {
        this.dynamoDBMapper.save(task);
        return task;
    }

    /**
     * Deletes a Task in the Database.
     *
     * @param task The task to be Deleted.
     * @return The Deleted task.
     */
    public Task deleteTask(Task task) {
        this.dynamoDBMapper.delete(task);
        return task;
    }

    /**
     * Creates a unique ID with 5 characters.
     *
     * @return The ID.
     */
    public String generateNewId() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
