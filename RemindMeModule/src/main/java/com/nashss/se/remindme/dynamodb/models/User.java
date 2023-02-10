package com.nashss.se.remindme.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

//CHECKSTYLE:OFF:Model
@DynamoDBTable(tableName = "users")

public class User {
    private String userId;
    private String userName;
    private String phoneNumber;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() { return userId; }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    @DynamoDBAttribute(attributeName = "phoneNumber")
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return userId.equals(user.userId) && userName.equals(user.userName)
                && phoneNumber.equals(user.phoneNumber);
    }
}
