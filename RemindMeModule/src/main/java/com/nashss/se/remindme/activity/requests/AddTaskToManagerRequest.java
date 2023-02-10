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

    /**
     * Constructor for the CreateUserRequest class.
     *
     * @param taskManagerId The unique identifier for the taskManager
     * @param name The name of the user
     * @param description The description of the task
     */
    private AddTaskToManagerRequest(String taskManagerId, String name, String description) {
        this.taskManagerId = taskManagerId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "AddTaskToManagerRequest{" +
                "taskManagerId'" + taskManagerId +
                "name'" + name;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    @JsonPOJOBuilder
    public static class Builder {
        private String taskManagerId;
        private String name;
        private String description;

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

        public AddTaskToManagerRequest build() { return new AddTaskToManagerRequest(taskManagerId, name, description); }
    }
}
