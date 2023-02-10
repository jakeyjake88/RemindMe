package com.nashss.se.remindme.activity.requests;

/**
 * Class for the CreateUserRequest for the RemindMeClient.
 */
public class CreateUserRequest {
    private final String userId;
    private final String userName;
    private final String phoneNumber;

    /**
     * Constructor for the CreateUserRequest class.
     *
     * @param userId The unique identifier for the user
     * @param userName The name of the user
     * @param phoneNumber The phone number of the user
     */
    public CreateUserRequest(String userId, String userName, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder();}

    public static class Builder {
        private String userId;
        private String userName;
        private String phoneNumber;

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CreateUserRequest build() { return new CreateUserRequest(userId, userName, phoneNumber); }
    }
}
