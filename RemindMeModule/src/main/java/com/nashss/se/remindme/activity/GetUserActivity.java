package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.GetUserRequest;
import com.nashss.se.remindme.activity.results.GetUserResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.UserDao;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.UserModel;

import javax.inject.Inject;

public class GetUserActivity {
    private final UserDao userDao;

    @Inject
    public GetUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    public GetUserResult handleRequest(final GetUserRequest request) {
        String userId = request.getUserId();
        User user = userDao.getUser(userId);
        UserModel userModel = new ModelConverter().toUserModel(user);

        return GetUserResult.builder()
                .withUser(userModel)
                .build();
    }
}
