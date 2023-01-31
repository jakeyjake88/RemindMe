package com.nashss.se.remindme.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "taskManagers")

public class TaskManager {
    private String taskManagerId;
    private String creatorId;
    private String taskManagerName;
    private boolean isActive;

    @DynamoDBHashKey(attributeName = "creatorId")
    public String getCreatorId() { return creatorId;}
    public void setCreatorId(String creatorId) { this.creatorId = creatorId;}

    @DynamoDBRangeKey(attributeName = "taskManagerName")
    public String getTaskManagerName() { return taskManagerName;}
    public void setTaskManagerName(String taskManagerName) { this.taskManagerName = taskManagerName;}

    @DynamoDBAttribute(attributeName = "taskManagerId")
    public String getTaskManagerId() { return taskManagerId; }
    public void setTaskManagerId(String taskManagerId) { this.taskManagerId = taskManagerId; }

    @DynamoDBAttribute(attributeName = "isActive")
    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskManager tm = (TaskManager) o;
        return taskManagerId.equals(tm.taskManagerId) && creatorId.equals(tm.creatorId)
                && taskManagerName.equals(tm.taskManagerName) && isActive == tm.isActive;
    }
}
