package com.nashss.se.remindme.unittest.converters;

import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import com.nashss.se.remindme.dynamodb.models.User;
import com.nashss.se.remindme.models.TaskManagerModel;
import com.nashss.se.remindme.models.UserModel;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ModelConverterTest {


    @Test
    public void testToUserModel() {
        // Arrange
        User user = new User();
        user.setUserId("123");
        user.setUserName("John");
        user.setPhoneNumber("123-456-7890");
        ModelConverter modelConverter = new ModelConverter();

        // Act
        UserModel userModel = modelConverter.toUserModel(user);

        // Assert
        assertEquals(user.getUserId(), userModel.getUserId());
        assertEquals(user.getUserName(), userModel.getUserName());
        assertEquals(user.getPhoneNumber(), userModel.getPhoneNumber());
    }

    @Test
    public void testToTaskManagerModel() {
        // Arrange
        TaskManager taskManager = new TaskManager();
        taskManager.setTaskManagerId("123");
        taskManager.setTaskManagerName("John");
        taskManager.setCreatorId("My Task Manager");
        taskManager.setIsActive(true);
        ModelConverter modelConverter = new ModelConverter();

        // Act
        TaskManagerModel taskManagerModel = modelConverter.toTaskManagerModel(taskManager);

        // Assert
        assertEquals(taskManager.getTaskManagerId(), taskManagerModel.getTaskManagerId());
        assertEquals(taskManager.getCreatorId(), taskManagerModel.getCreatorId());
        assertEquals(taskManager.getIsActive(), taskManagerModel.getIsActive());
        assertEquals(taskManager.getTaskManagerName(), taskManagerModel.getTaskManagerName());
    }
}
