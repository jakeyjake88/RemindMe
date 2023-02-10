package com.nashss.se.remindme.unittest.activity;

import com.nashss.se.remindme.activity.GetUserActivity;
import com.nashss.se.remindme.activity.requests.GetUserRequest;
import com.nashss.se.remindme.activity.results.GetUserResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.UserDao;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetUserActivityTest {
    @Mock
    private UserDao userDao;

    @Mock
    private ModelConverter modelConverter;

    private GetUserActivity getUserActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        getUserActivity = new GetUserActivity(userDao);
    }

    @Test
    public void testHandleRequest_userFound() {
        // arrange
        String userId = "12345";
        User user = new User();
        user.setUserId(userId);
        UserModel userModel = new UserModel(userId, "dd", "dd");

        GetUserRequest request = GetUserRequest.builder()
                .withId(userId)
                .build();

        when(userDao.getUser(anyString())).thenReturn(user);
        when(modelConverter.toUserModel(user)).thenReturn(userModel);

        // act
        GetUserResult result = getUserActivity.handleRequest(request);

        // assert
        assertEquals(userModel.getUserId(), result.getUser().getUserId());
    }
}
