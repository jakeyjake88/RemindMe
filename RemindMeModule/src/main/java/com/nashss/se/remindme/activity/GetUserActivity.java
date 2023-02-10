package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.GetUserRequest;
import com.nashss.se.remindme.activity.results.GetUserResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.UserDao;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.UserModel;

import javax.inject.Inject;

/**
 * Class for GetUserActivity in the RemindMeClient.
 * <p>
 * This endpoint allows for users to get an individual user.
 */
public class GetUserActivity {
    private final UserDao userDao;

    /**
     * Constructor for the GetUserActivity class.
     *
     * @param userDao data access object that performs operations on users
     */
    @Inject
    public GetUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Handles the request for getting a user and returns the result in the form of GetUserResult object.
     *
     * @param request object containing userId of the user to be retrieved
     * @return GetUserResult object containing the userModel of the requested user
     * @throws IllegalArgumentException if userId is null or the user with given userId is not found
     */
    public GetUserResult handleRequest(final GetUserRequest request) {
        String userId = request.getUserId();
        User user = userDao.getUser(userId);
        UserModel userModel = new ModelConverter().toUserModel(user);

        return GetUserResult.builder()
                .withUser(userModel)
                .build();
    }
}
