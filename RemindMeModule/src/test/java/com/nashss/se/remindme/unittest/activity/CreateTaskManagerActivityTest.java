package com.nashss.se.remindme.unittest.activity;

import com.nashss.se.remindme.activity.CreateTaskManagerActivity;
import com.nashss.se.remindme.activity.requests.CreateTaskManagerRequest;
import com.nashss.se.remindme.activity.results.CreateTaskManagerResult;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateTaskManagerActivityTest {
    private CreateTaskManagerActivity createTaskManagerActivity;
    private CreateTaskManagerRequest request;

    @Mock
    private TaskManagerDao taskManagerDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        createTaskManagerActivity = new CreateTaskManagerActivity(taskManagerDao);
        request = CreateTaskManagerRequest.builder()
                .withTaskManagerName("Test Manager")
                .withCreatorId("12345")
                .build();
    }

    @Test
    public void handleRequest_whenCalled_createsTaskManager() {
        String taskManagerId = "1";
        when(taskManagerDao.generateNewId()).thenReturn(taskManagerId);

        CreateTaskManagerResult result = createTaskManagerActivity.handleRequest(request);

        Assertions.assertEquals(taskManagerId, result.getManagerId());
    }
}
