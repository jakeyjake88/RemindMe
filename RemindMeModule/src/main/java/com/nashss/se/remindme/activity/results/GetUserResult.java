package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.UserModel;

/**
 * Class for the GetUserResult for the RemindMeClient.
 */
public class GetUserResult {
    private final UserModel user;

    private GetUserResult(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "GetUserResult{" + user;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UserModel user;

        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }

        public GetUserResult build() { return new GetUserResult(user); }
    }
}
