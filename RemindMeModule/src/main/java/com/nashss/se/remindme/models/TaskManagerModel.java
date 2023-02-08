package com.nashss.se.remindme.models;

import java.util.Objects;

public class TaskManagerModel {
    private final String creatorId;
    private final String taskManagerId;
    private final String taskManagerName;
    private final boolean isActive;


    private TaskManagerModel(String taskId, String taskManagerId, String taskManagerName, boolean isActive) {
        this.creatorId = taskId;
        this.taskManagerId = taskManagerId;
        this.taskManagerName = taskManagerName;
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
    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private String creatorId;
        private String taskManagerName;
        private String taskManagerId;
        private boolean isActive;

        public Builder withCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public Builder withTaskManagerId(String taskManagerId) {
            this.taskManagerId = taskManagerId;
            return this;
        }

        public Builder withTaskManagerName(String taskManagerName) {
            this.taskManagerName = taskManagerName;
            return this;
        }

        public Builder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public TaskManagerModel build() {
            return new TaskManagerModel(creatorId, taskManagerId, taskManagerName, isActive);
        }
    }
}
