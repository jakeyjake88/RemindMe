package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class TaskManagerModel {
    private final String creatorId;
    private final String taskManagerId;
    private final String taskManagerName;
    private final boolean isActive;


    private TaskManagerModel(String taskId, String taskManagerId, String name, boolean isActive) {
        this.creatorId = taskId;
        this.taskManagerId = taskManagerId;
        this.taskManagerName = name;
        this.isActive = isActive;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public String getTaskManagerId() {
        return taskManagerId;
    }

    public String getTaskManagerName() {
        return taskManagerName;
    }


    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TaskManagerModel that = (TaskManagerModel) o;

        return Objects.equals(creatorId, that.creatorId) && Objects.equals(taskManagerId, that.taskManagerId)
                && Objects.equals(taskManagerName, that.taskManagerName) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatorId, taskManagerId, taskManagerName, isActive);
    }

    public static class Builder {
        private String creatorId;
        private String taskManagerName;
        private String taskManagerId;
        private boolean isActive;

        public TaskManagerModel.Builder withTaskId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public TaskManagerModel.Builder withTaskManagerId(String taskManagerId) {
            this.taskManagerId = taskManagerId;
            return this;
        }

        public TaskManagerModel.Builder withName(String name) {
            this.taskManagerName = taskManagerName;
            return this;
        }

        public TaskManagerModel.Builder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public TaskManagerModel build() {
            return new TaskManagerModel(creatorId, taskManagerName, taskManagerId, isActive);
        }
    }
}
