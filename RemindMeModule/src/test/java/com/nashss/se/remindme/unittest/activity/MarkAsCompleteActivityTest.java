package com.nashss.se.remindme.unittest.activity;

import com.nashss.se.remindme.activity.MarkIsCompleteActivity;
import com.nashss.se.remindme.activity.requests.MarkIsCompleteRequest;
import com.nashss.se.remindme.activity.results.MarkIsCompleteResult;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class MarkAsCompleteActivityTest {

    @Mock
    private TaskDao taskDao;

    private MarkIsCompleteActivity markIsCompleteActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        markIsCompleteActivity = new MarkIsCompleteActivity(taskDao);
    }

    @Test
    public void testHandleRequest() {
        String taskId = "test-task-id";
        String taskManagerId = "test-task-manager-id";

        when(taskDao.getTask(taskId, taskManagerId)).thenReturn(new Task());

        // Execution
        MarkIsCompleteRequest request = new MarkIsCompleteRequest(taskId, taskManagerId);

        // Verification
        verify(taskDao).getTask(taskId, taskManagerId);
    }
}
