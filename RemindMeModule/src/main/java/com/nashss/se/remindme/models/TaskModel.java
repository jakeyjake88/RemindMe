package com.nashss.se.remindme.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Model for the Tasks.
 */
//CHECKSTYLE:OFF:Model
public class TaskModel {
    private final String taskId;
    private final String taskManagerId;
    private final String name;
    private final LocalDateTime dueDate;
    private final String description;
    private final boolean isActive;
    private final String creatorId;


    public TaskModel(String taskId, String taskManagerId, String name, LocalDateTime dueDate, String description, boolean isActive, String creatorId) {
        this.taskId = taskId;
        this.taskManagerId = taskManagerId;
        this.name = name;
        this.dueDate = dueDate;
        this.description = description;
        this.isActive = isActive;
        this.creatorId = creatorId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskManagerId() {
        return taskManagerId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getCreatorId() {
        return creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TaskModel that = (TaskModel) o;

        return Objects.equals(taskId, that.taskId) && Objects.equals(taskManagerId, that.taskManagerId)
        && Objects.equals(name, that.name) && Objects.equals(dueDate, that.dueDate)
        && Objects.equals(description, that.description) && Objects.equals(isActive, that.isActive)
                && Objects.equals(creatorId, that.creatorId);
    }
    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskManagerId, name, dueDate, description, isActive, creatorId);
    }

    public static class Builder {
        private String taskId;
        private String taskManagerId;
        private String name;
        private LocalDateTime dueDate;
        private String description;
        private boolean isActive;
        private String creatorId;

        public Builder withTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder withTaskManagerId(String taskManagerId) {
            this.taskManagerId = taskManagerId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder withCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public TaskModel build() {
            return new TaskModel(taskId, taskManagerId, name, dueDate, description, isActive, creatorId);
        }
    }
}
