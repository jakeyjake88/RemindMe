package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.UserModel;

/**
 * Class for the CreateUserResult for the RemindMeClient.
 */
public class CreateUserResult {
    private final UserModel user;

    public CreateUserResult(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UserModel user;

        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }

        public CreateUserResult build() {
            return new CreateUserResult(user);
        }
    }
}
