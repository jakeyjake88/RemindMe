package com.nashss.se.remindme.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.remindme.dynamodb.models.User;

import javax.inject.Inject;

/**
 * Class for the UserDao.
 */
public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Constructor for the userDao class.
     * @param dynamoDBMapper to access database
     */
    @Inject
    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Saves a user to the database.
     *
     * @param user The user to be saved.
     * @return The saved user.
     */
    public User saveUser(User user) {
        this.dynamoDBMapper.save(user);
        return user;
    }

    /**
     * Retrieves a user from the database by their ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return The retrieved user.
     * @throws IllegalArgumentException If no user with the given ID is found.
     */
    public User getUser(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User not found");
        }
        User user = dynamoDBMapper.load(User.class, userId);
        if (null == user) {
            throw new IllegalArgumentException("User is null");
        }
        return user;
    }
}
