package com.nashss.se.remindme.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Class for the MarkIsCompleteRequest class for the RemindMeClient.
 */
@JsonDeserialize(builder = MarkIsCompleteRequest.Builder.class)
public class MarkIsCompleteRequest {
    private final String taskId;
    private final String taskManagerId;

    /**
     * Constructor for the MarkIsCompleteRequest class.
     *
     * @param taskId The unique identifier for the taskManager
     * @param taskManagerId the managerId
     */
    private MarkIsCompleteRequest(String taskId, String taskManagerId) {
        this.taskManagerId = taskManagerId;
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskManagerId() {
        return taskManagerId;
    }
    @Override
    public String toString() {
        return "MarkIsCompleteRequest{" +
                "taskId='" + taskId;
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

        public MarkIsCompleteRequest build() {
            return new MarkIsCompleteRequest(taskId, taskManagerId);
        }
    }
}
