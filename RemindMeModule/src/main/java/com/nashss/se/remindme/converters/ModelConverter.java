package com.nashss.se.remindme.converters;

import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

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
}
