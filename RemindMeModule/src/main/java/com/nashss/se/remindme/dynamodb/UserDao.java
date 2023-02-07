package com.nashss.se.remindme.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.remindme.dynamodb.models.User;

import javax.inject.Inject;

public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public User saveUser(User user) {
        this.dynamoDBMapper.save(user);
        return user;
    }

    public User getUser(String userId) {
        if (userId == null) throw new IllegalArgumentException("User not found");
        User user = dynamoDBMapper.load(User.class, userId);
        if (null == user) {
            throw new IllegalArgumentException("User is null");
        }
        return user;
    }
}
