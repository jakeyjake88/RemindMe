package converters;

import dynamodb.models.Task;
import models.TaskModel;

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
