package com.nashss.se.remindme.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Class for the MarkIsCompleteRequest class for the RemindMeClient.
 */
@JsonDeserialize(builder = MarkIsCompleteRequest.Builder.class)
public class MarkIsCompleteRequest {
    private final String taskId;

    /**
     * Constructor for the MarkIsCompleteRequest class.
     *
     * @param taskId The unique identifier for the taskManager
     */
    private MarkIsCompleteRequest(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
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

        public Builder withTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public MarkIsCompleteRequest build() {
            return new MarkIsCompleteRequest(taskId);
        }
    }
}
