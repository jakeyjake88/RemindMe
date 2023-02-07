package com.nashss.se.remindme.activity.results;

import com.nashss.se.remindme.models.UserModel;

public class CreateUserResult {
    private final UserModel user;

    public CreateUserResult(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }
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
