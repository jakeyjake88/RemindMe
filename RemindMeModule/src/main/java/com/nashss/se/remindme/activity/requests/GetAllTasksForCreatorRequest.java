package com.nashss.se.remindme.activity.requests;

/**
 * Class for the GetAllTasksForCreatorRequest for the RemindMeClient.
 */
public class GetAllTasksForCreatorRequest {
    private final String creatorId;

    /**
     * Constructor for the CreateUserRequest class.
     *
     * @param creatorId the unique identify for user
     */
    private GetAllTasksForCreatorRequest(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    @Override
    public String toString() {
        return "GetAllTasksRequest{ " +
                "creatorId'" +
                creatorId + '\'' + '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String creatorId;

        public Builder withCreatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        public GetAllTasksForCreatorRequest build() { return new GetAllTasksForCreatorRequest(creatorId);}
    }
}
