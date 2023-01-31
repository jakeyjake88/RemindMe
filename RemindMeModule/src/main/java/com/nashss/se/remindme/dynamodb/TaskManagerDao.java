package com.nashss.se.remindme.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Inject;

public class TaskManagerDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public TaskManagerDao(DynamoDBMapper dynamoDBMapper) { this.dynamoDBMapper = dynamoDBMapper; }

    public TaskManager getTaskManager(String creatorId, String taskManagerName) {
        if (taskManagerName == null || creatorId == null) throw new IllegalArgumentException("Couldn't find taskManager");
        TaskManager tm = dynamoDBMapper.load(TaskManager.class, creatorId, taskManagerName);
        if (null == tm) throw new IllegalArgumentException("TaskManager is null");
        return tm;
    }

    public String generateNewId() {
        return RandomStringUtils.randomAlphanumeric(7);
    }
}
