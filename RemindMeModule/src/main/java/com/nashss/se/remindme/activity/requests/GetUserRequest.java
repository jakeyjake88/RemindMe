package com.nashss.se.remindme.activity.requests;

public class GetUserRequest {
    private final String userId;

    public GetUserRequest(String userId) {
        this.userId = userId;
    }

    public String getUserId() { return userId; }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "userId='" + userId + '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String userId;

        public Builder withId(String userId) {
            this.userId = userId;
            return this;
        }

        public GetUserRequest build() { return new GetUserRequest(userId); }
    }
}
