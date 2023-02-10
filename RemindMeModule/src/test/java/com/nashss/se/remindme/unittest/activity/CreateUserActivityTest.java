package com.nashss.se.remindme.unittest.activity;

import com.nashss.se.remindme.activity.CreateUserActivity;
import com.nashss.se.remindme.activity.requests.CreateUserRequest;
import com.nashss.se.remindme.activity.results.CreateUserResult;
import com.nashss.se.remindme.dynamodb.UserDao;
import com.nashss.se.remindme.dynamodb.models.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateUserActivityTest {
        @Mock
        private UserDao userDao;

        private CreateUserActivity createUserActivity;

        @BeforeEach
        public void setUp() {
            openMocks(this);
            createUserActivity = new CreateUserActivity(userDao);
        }

        @Test
        public void handleRequest_withValidInput_returnsCreateUserResult() {
            CreateUserRequest request = CreateUserRequest.builder()
                    .withUserId("userId")
                    .withUserName("userName")
                    .withPhoneNumber("phoneNumber")
                    .build();

            User user = new User();
            user.setUserId(request.getUserId());
            user.setUserName(request.getUserName());
            user.setPhoneNumber(request.getPhoneNumber());

            when(userDao.saveUser(any(User.class))).thenReturn(user);

            CreateUserResult result = createUserActivity.handleRequest(request);

            verify(userDao).saveUser(any(User.class));
            assertEquals(request.getUserId(), result.getUser().getUserId());
            assertEquals(request.getUserName(), result.getUser().getUserName());
            assertEquals(request.getPhoneNumber(), result.getUser().getPhoneNumber());
        }
}
