package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.CreateUserRequest;
import com.nashss.se.remindme.activity.results.CreateUserResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.UserDao;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.UserModel;

import javax.inject.Inject;

public class CreateUserActivity {
    private final UserDao userDao;

    @Inject
    CreateUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    public CreateUserResult handleRequest(final CreateUserRequest request) {
        User user = new User();
        user.setUserId(request.getUserId());
        user.setUserName(request.getUserName());
        user.setPhoneNumber(request.getPhoneNumber());

        userDao.saveUser(user);
        UserModel userM = new ModelConverter().toUserModel(user);

        return CreateUserResult.builder()
                .withUser(userM)
                .build();
    }
}
