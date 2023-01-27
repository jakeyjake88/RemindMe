package com.nashss.se.remindme.models;

import java.util.Objects;

public class UserModel {

    private final String userId;
    private final String userName;
    private final String phoneNumber;


    private UserModel(String userId, String userName, String phoneNumber) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserModel that = (UserModel) o;

        return Objects.equals(userId, that.userId) && Objects.equals(userName, that.userName)
                && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, phoneNumber);
    }

    public static class Builder {
        private String userId;
        private String userName;
        private String phoneNumber;

        public UserModel.Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserModel.Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserModel.Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserModel build() {
            return new UserModel(userId, userName, phoneNumber);
        }
    }
}