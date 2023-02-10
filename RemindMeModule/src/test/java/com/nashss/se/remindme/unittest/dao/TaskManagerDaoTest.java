package com.nashss.se.remindme.unittest.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.MockitoAnnotations.openMocks;

public class TaskManagerDaoTest {
    @Mock
    private DynamoDBMapper dynamoDBMapper;

    private TaskManagerDao taskManagerDao;

    @BeforeEach
    public void setup() {
        openMocks(this);
        taskManagerDao = new TaskManagerDao(dynamoDBMapper);
    }

    @Test
    public void getTaskManager_ShouldThrowException_WhenTaskManagerNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> taskManagerDao.getTaskManager("creatorId", null));
    }

    @Test
    public void getTaskManager_ShouldThrowException_WhenCreatorIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> taskManagerDao.getTaskManager(null, "taskManagerName"));
    }

    @Test
    public void getTaskManager_ShouldThrowException_WhenTaskManagerIsNotFound() {
        String creatorId = "creatorId";
        String taskManagerName = "taskManagerName";

        TaskManager tm = new TaskManager();
        tm.setCreatorId(creatorId);
        tm.setTaskManagerName(taskManagerName);

        Mockito.when(dynamoDBMapper.load(TaskManager.class, creatorId, taskManagerName)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> taskManagerDao.getTaskManager(creatorId, taskManagerName));
    }

    @Test
    public void getTaskManager_ShouldReturnTaskManager_WhenTaskManagerIsFound() {
        String creatorId = "creatorId";
        String taskManagerName = "taskManagerName";

        TaskManager tm = new TaskManager();
        tm.setCreatorId(creatorId);
        tm.setTaskManagerName(taskManagerName);

        Mockito.when(dynamoDBMapper.load(TaskManager.class, creatorId, taskManagerName)).thenReturn(tm);

        TaskManager result = taskManagerDao.getTaskManager(creatorId, taskManagerName);

        assertEquals(tm, result);
    }
}
