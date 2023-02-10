package com.nashss.se.remindme.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Class for the CreateTaskManagerRequest for the RemindMeClient.
 */
@JsonDeserialize(builder = CreateTaskManagerRequest.Builder.class)
public class CreateTaskManagerRequest {
    private final String creatorId;
    private final String taskManagerName;

    /**
     * Constructor for the CreateUserRequest class.
     *
     * @param creatorId the unique identify for user
     * @param taskManagerName the name associated with the taskManager
     */
    private CreateTaskManagerRequest(String creatorId, String taskManagerName) {
        this.creatorId = creatorId;
        this.taskManagerName = taskManagerName;
    }

    public String getCreatorId() {
        return creatorId;
    }
    public String getTaskManagerName() {
        return taskManagerName;
    }


    @Override
    public String toString() {
        return "GetTaskManagerRequest{" +
                "taskManagerName'" + taskManagerName + '\'' + '}';
    }


    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }
    @JsonPOJOBuilder
    public static class Builder {
        private String creatorId;
        private String taskManagerName;


        public Builder withCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public Builder withTaskManagerName(String taskManagerName) {
            this.taskManagerName = taskManagerName;
            return this;
        }


        public CreateTaskManagerRequest build() { return new CreateTaskManagerRequest(creatorId, taskManagerName); }
    }
}
