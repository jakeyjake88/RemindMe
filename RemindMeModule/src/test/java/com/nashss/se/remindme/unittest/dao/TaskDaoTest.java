package com.nashss.se.remindme.unittest.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.exceptions.TaskNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class TaskDaoTest {
    private TaskDao taskDao;

    @Mock
    private DynamoDBMapper dynamoDBMapper;

    private Task task;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        taskDao = new TaskDao(dynamoDBMapper);
        task = new Task();
        task.setTaskManagerId("managerId");
        task.setTaskId("taskId");
    }

    @Test
    public void testGetTask() {
        when(dynamoDBMapper.load(Task.class, "managerId", "taskId")).thenReturn(task);

        Task result = taskDao.getTask("managerId", "taskId");

        verify(dynamoDBMapper).load(Task.class, "managerId", "taskId");
        assertNotNull(result);
        assertEquals(task, result);
    }

}
