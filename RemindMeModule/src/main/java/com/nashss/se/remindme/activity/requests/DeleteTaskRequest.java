package com.nashss.se.remindme.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Class for the DeleteTaskRequest for the RemindMeClient.
 */
@JsonDeserialize(builder = DeleteTaskRequest.Builder.class)
public class DeleteTaskRequest {
    private final String taskId;
    private final String taskManagerId;

    /**
     * Constructor for the CreateUserRequest class.
     *
     * @param taskId The unique identifier for the task
     * @param taskManagerId the managerid
     */
    public DeleteTaskRequest(String taskId, String taskManagerId) {
        this.taskManagerId = taskManagerId;
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskManagerId() {
        return taskManagerId;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String taskId;
        private String taskManagerId;

        public Builder withTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder withTaskManagerId(String taskManagerId) {
            this.taskManagerId = taskManagerId;
            return this;
        }

        public DeleteTaskRequest build() {
            return new DeleteTaskRequest(taskId, taskManagerId);
        }
    }
}
