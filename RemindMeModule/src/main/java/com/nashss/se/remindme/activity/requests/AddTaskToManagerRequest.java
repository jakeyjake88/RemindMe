package com.nashss.se.remindme.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


/**
 * Class for the AddTaskToManagerRequest for the RemindMeClient.
 */
@JsonDeserialize(builder = AddTaskToManagerRequest.Builder.class)
public class AddTaskToManagerRequest {
    private String taskManagerId;
    private String name;
    private String description;
    private String dueDate;
    private String creatorId;

    /**
     * Constructor for the CreateUserRequest class.
     *
     * @param taskManagerId The unique identifier for the taskManager
     * @param name The name of the user
     * @param description The description of the task
     */
    private AddTaskToManagerRequest(String taskManagerId, String name,
                                    String description, String dueDate, String creatorId) {
        this.taskManagerId = taskManagerId;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.creatorId = creatorId;
    }

    public String getTaskManagerId() {
        return taskManagerId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getCreatorId() {
        return creatorId;
    }

    @Override
    public String toString() {
        return "AddTaskToManagerRequest{" +
                "taskManagerId'" + taskManagerId +
                "name'" + name +
                "dueDate'" + dueDate;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    @JsonPOJOBuilder
    public static class Builder {
        private String taskManagerId;
        private String name;
        private String description;
        private String dueDate;
        private String creatorId;

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

        public Builder withDueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder withCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public AddTaskToManagerRequest build() { return new AddTaskToManagerRequest(taskManagerId, name, description, dueDate, creatorId); }
    }
}
