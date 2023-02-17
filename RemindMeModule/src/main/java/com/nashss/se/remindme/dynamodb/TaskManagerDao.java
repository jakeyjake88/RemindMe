package com.nashss.se.remindme.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Class for the TaskManagerDao.
 */
public class TaskManagerDao {
    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Constructor for the TaskManagerDao class.
     * @param dynamoDBMapper to access database
     */
    @Inject
    public TaskManagerDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Retrieves a TaskManager from the database using the creator ID and task manager name.
     *
     * @param creatorId The ID of the user who created the task manager.
     * @param taskManagerName The name of the task manager to retrieve.
     * @return The TaskManager with the specified creator ID and task manager name.
     * @throws IllegalArgumentException If the creator ID or task manager name is `null`
     * or if the task manager cannot be found.
     */
    public TaskManager getTaskManager(String creatorId, String taskManagerName) {
        if (taskManagerName == null || creatorId == null) {
            throw new IllegalArgumentException("Couldn't find taskManager");
        }
        TaskManager tm = dynamoDBMapper.load(TaskManager.class, creatorId, taskManagerName);
        if (null == tm) {
            throw new IllegalArgumentException("TaskManager is null");
        }
        return tm;
    }

    /**
     * Retrieves a TaskManager from the database using the creator ID and task manager name.
     *
     * @param taskManagerId the ID of the taskManager.
     * @return The TaskManager with the specified creator ID and task manager name.
     * @throws IllegalArgumentException If the creator ID or task manager name is `null`
     * or if the task manager cannot be found.
     */
    public TaskManager getTaskManagerById(String taskManagerId) {
        if (taskManagerId == null) {
            throw new IllegalArgumentException("Couldn't find taskManager");
        }

        DynamoDBQueryExpression<TaskManager> queryExpression = new DynamoDBQueryExpression<TaskManager>()
                .withIndexName("TaskManagerSearchById")
                .withConsistentRead(false)
                .withKeyConditionExpression("taskManagerId = :taskManagerId")
                .withExpressionAttributeValues(Map.of(
                        ":taskManagerId", new AttributeValue().withS(taskManagerId)
                ));

        PaginatedQueryList<TaskManager> result = dynamoDBMapper.query(TaskManager.class, queryExpression);

        if (result.isEmpty()) {
            throw new IllegalArgumentException("TaskManager is null");
        }

        return result.get(0);
    }

    /**
     * Retrieves all task managers for a user from the database.
     *
     * @param creatorId The ID of the user to retrieve task managers for.
     * @return A list of all task managers for the specified user.
     * @throws IllegalArgumentException If the creator ID is `null` or if no task managers are found.
     */
    public List<TaskManager> getAllTaskManagers(String creatorId) {
        if (creatorId == null) {
            throw new IllegalArgumentException("No creatorId:(");
        }
        TaskManager task = new TaskManager();
        task.setCreatorId(creatorId);
        DynamoDBQueryExpression<TaskManager> query =  new DynamoDBQueryExpression<TaskManager>()
                .withHashKeyValues(task);
        return dynamoDBMapper.query(TaskManager.class, query);
    }

    /**
     * Creates a new task manager and stores it in the database.
     *
     * @param tm The task manager to be created.
     * @return The created task manager.
     */
    public TaskManager createTaskManager(TaskManager tm) {
        this.dynamoDBMapper.save(tm);
        return tm;
    }

    /**
     * Generates a new, unique ID.
     *
     * @return A unique ID.
     */
    public String generateNewId() {
        return RandomStringUtils.randomAlphanumeric(7);
    }
}
