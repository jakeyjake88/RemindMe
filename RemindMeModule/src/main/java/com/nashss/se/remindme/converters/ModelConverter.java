package com.nashss.se.remindme.converters;

import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.TaskManagerModel;
import com.nashss.se.remindme.models.TaskModel;
import com.nashss.se.remindme.models.UserModel;

public class ModelConverter {

    public TaskModel toTaskModel(Task task) {
        return TaskModel.builder().withTaskId(task.getTaskId())
                .withDescription(task.getDescription())
                .withDueDate(task.getDueDate())
                .withIsActive(task.getIsActive())
                .withName(task.getName())
                .withTaskManagerId(task.getTaskManagerId())
                .build();
    }

    public UserModel toUserModel(User user) {
        return UserModel.builder()
                .withUserId(user.getUserId())
                .withUserName(user.getUserName())
                .withPhoneNumber(user.getPhoneNumber())
                .build();
    }

    public TaskManagerModel toTaskManagerModel(TaskManager tm) {
        return TaskManagerModel.builder()
                .withTaskManagerId(tm.getTaskManagerId())
                .withCreatorId(tm.getCreatorId())
                .withIsActive(tm.getIsActive())
                .withName(tm.getTaskManagerName())
                .build();
    }

}
