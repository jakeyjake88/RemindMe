package com.nashss.se.remindme.unittest.activity;

import com.nashss.se.remindme.activity.GetAllTasksActivity;
import com.nashss.se.remindme.activity.requests.GetAllTasksRequest;
import com.nashss.se.remindme.activity.results.GetAllTasksResult;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;

import com.nashss.se.remindme.models.TaskModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetAllTasksActivityTest {
    private GetAllTasksActivity getAllTasksActivity;

    @Mock
    private TaskDao taskDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        getAllTasksActivity = new GetAllTasksActivity(taskDao);
    }

    @Test
    public void handleRequest_WithTasksForManager_ReturnsTasksResult() {
        // Arrange
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        task.setTaskId("1");
        tasks.add(task);

        when(taskDao.getAllTasksForManager("1")).thenReturn(tasks);

        GetAllTasksRequest request = GetAllTasksRequest.builder()
                .withTaskManagerId("1")
                .build();

        // Act
        GetAllTasksResult result = getAllTasksActivity.handleRequest(request);

        // Assert
        List<TaskModel> taskModels = result.getTasks();
        assertEquals(1, taskModels.size());
        assertEquals("1", taskModels.get(0).getTaskId());
    }

    @Test
    public void handleRequest_WithNoTasksForManager_ReturnsEmptyTaskResult() {
        // Arrange
        when(taskDao.getAllTasksForManager("1")).thenReturn(null);

        GetAllTasksRequest request = GetAllTasksRequest.builder()
                .withTaskManagerId("1")
                .build();

        // Act
        GetAllTasksResult result = getAllTasksActivity.handleRequest(request);

        // Assert
        List<TaskModel> taskModels = result.getTasks();
        assertEquals(0, taskModels.size());
    }
}
