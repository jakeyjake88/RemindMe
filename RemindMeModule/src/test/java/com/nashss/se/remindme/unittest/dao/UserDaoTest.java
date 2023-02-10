package com.nashss.se.remindme.unittest.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.remindme.dynamodb.UserDao;
import com.nashss.se.remindme.dynamodb.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UserDaoTest {
    @Mock
    private DynamoDBMapper dynamoDBMapper;
    private UserDao userDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        userDao = new UserDao(dynamoDBMapper);
    }

    @Test
    public void getUserTest() {
        String userId = "123";
        User user = new User();
        user.setUserId(userId);
        when(dynamoDBMapper.load(User.class, userId)).thenReturn(user);

        User retrievedUser = userDao.getUser(userId);

        assertNotNull(retrievedUser);
        assertEquals(user, retrievedUser);
    }

    @Test
    public void getUserNotFoundTest() {
        String userId = null;
        assertThrows(IllegalArgumentException.class, () -> {
            userDao.getUser(userId);
        });
    }

    @Test
    public void getUserNullTest() {
        String userId = "456";
        when(dynamoDBMapper.load(User.class, userId)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> {
            userDao.getUser(userId);
        });
    }

}
