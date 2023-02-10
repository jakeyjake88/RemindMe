package com.nashss.se.remindme.converters;

import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.TaskManagerModel;
import com.nashss.se.remindme.models.TaskModel;
import com.nashss.se.remindme.models.UserModel;

/**
 * Class for the ModelConverter.
 */
public class ModelConverter {

    /**
     * Method to convert to TaskModel.
     * @param task the task to be converted
     * @return the converted task
     */
    public TaskModel toTaskModel(Task task) {
        return TaskModel.builder().withTaskId(task.getTaskId())
                .withDescription(task.getDescription())
                .withDueDate(task.getDueDate())
                .withIsActive(task.getIsActive())
                .withName(task.getName())
                .withTaskManagerId(task.getTaskManagerId())
                .build();
    }

    /**
     * Method to convert to UserModel.
     * @param user the user to be converted
     * @return the converted User
     */
    public UserModel toUserModel(User user) {
        return UserModel.builder()
                .withUserId(user.getUserId())
                .withUserName(user.getUserName())
                .withPhoneNumber(user.getPhoneNumber())
                .build();
    }

    /**
     * Method to convert to TaskManagerModel.
     * @param tm the TaskManager to be converted
     * @return the converted TaskManager
     */
    public TaskManagerModel toTaskManagerModel(TaskManager tm) {
        return TaskManagerModel.builder()
                .withTaskManagerId(tm.getTaskManagerId())
                .withCreatorId(tm.getCreatorId())
                .withIsActive(tm.getIsActive())
                .withTaskManagerName(tm.getTaskManagerName())
                .build();
    }

}
