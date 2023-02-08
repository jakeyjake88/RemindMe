package com.nashss.se.remindme.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;

public class AddTaskToManagerRequest {
    private String taskManagerId;
    private String name;
    private String description;
    private LocalDateTime dueDate;

    private AddTaskToManagerRequest(String taskManagerId, String name, String description, LocalDateTime dueDate) {
        this.taskManagerId = taskManagerId;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTaskManagerId() { return taskManagerId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public LocalDateTime getDueDate() { return dueDate; }

    @Override
    public String toString() {
        return "AddTaskToManagerRequest{" +
                "taskManagerId'" + taskManagerId +
                "name'" + name;
    }

    public static Builder builder() { return new Builder(); }

    @JsonPOJOBuilder
    public static class Builder {
        private String taskManagerId;
        private String name;
        private String description;
        private LocalDateTime dueDate;

        public Builder withTaskManagerId(String taskManagerId) {
            this.taskManagerId = taskManagerId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withDueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }
        public AddTaskToManagerRequest build() { return new AddTaskToManagerRequest(taskManagerId, name, description, dueDate); }
    }
}
