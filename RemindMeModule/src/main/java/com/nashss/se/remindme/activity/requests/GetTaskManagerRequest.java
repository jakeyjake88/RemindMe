package com.nashss.se.remindme.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Class for the GetTaskManagerRequest for the RemindMeClient.
 */
@JsonDeserialize(builder = GetTaskManagerRequest.Builder.class)
public class GetTaskManagerRequest {
    private final String creatorId;

    private GetTaskManagerRequest(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorId() {
        return creatorId;
    }


    @Override
    public String toString() {
        return "GetTaskRequest{" +
                "creatorid='" + creatorId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static GetTaskManagerRequest.Builder builder() {
        return new GetTaskManagerRequest.Builder();
    }

    public static class Builder {
        private String creatorId;

        public GetTaskManagerRequest.Builder withCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }


        public GetTaskManagerRequest build() {
            return new GetTaskManagerRequest(creatorId);
        }
    }
}
