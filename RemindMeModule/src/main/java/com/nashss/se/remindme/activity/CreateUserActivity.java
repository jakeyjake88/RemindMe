package com.nashss.se.remindme.activity;

import com.nashss.se.remindme.activity.requests.CreateUserRequest;
import com.nashss.se.remindme.activity.results.CreateUserResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.UserDao;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.UserModel;

import javax.inject.Inject;

/**
 * Class for CreateUserActivity for the RemindMeClient.
 * <p>
 * This endpoint allows for users to create an account.
 */
public class CreateUserActivity {
    private final UserDao userDao;

    /**
     * Constructor for the CreateUserActivity class.
     *
     * @param userDao data access object that performs operations on users
     */
    @Inject
    public CreateUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * handleRequest() is a method that handles the creation of a new user. It creates a new
     * instance of the User object, sets its properties using the parameters
     * provided in the CreateUserRequest, saves
     * it to the database using the `saveUser` method, and then
     * returns a CreateUserResult object that contains the
     * created user in the form of a UserModel object.
     *
     * @param request - a CreateUserRequest object that contains the user details to be created
     * @return CreateUserResult - a CreateUserResult object that contains the created user
     */
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
