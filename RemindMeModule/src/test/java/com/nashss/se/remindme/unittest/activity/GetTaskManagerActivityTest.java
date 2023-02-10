package com.nashss.se.remindme.unittest.activity;

import com.nashss.se.remindme.activity.GetTaskManagerActivity;
import com.nashss.se.remindme.activity.requests.GetTaskManagerRequest;
import com.nashss.se.remindme.activity.results.GetTaskManagerResult;
import com.nashss.se.remindme.dynamodb.TaskManagerDao;
import com.nashss.se.remindme.dynamodb.models.TaskManager;
import com.nashss.se.remindme.models.TaskManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetTaskManagerActivityTest {
    private GetTaskManagerActivity activity;

    @Mock
    private TaskManagerDao tmDao;

    @BeforeEach
    public void setup() {
        openMocks(this);
        activity = new GetTaskManagerActivity(tmDao);
    }

    @Test
    public void testHandleRequest() {
        String creatorId = "user1";
        GetTaskManagerRequest request = GetTaskManagerRequest.builder()
                .withCreatorId(creatorId)
                .build();

        List<TaskManager> tmList = new ArrayList<>();
        TaskManager tm1 = new TaskManager();
        TaskManager tm2 = new TaskManager();
        tm1.setTaskManagerId("tm1");
        tm1.setCreatorId(creatorId);
        tm2.setTaskManagerId("tm2");
        tm2.setCreatorId(creatorId);
        tmList.add(tm1);
        tmList.add(tm2);

        when(tmDao.getAllTaskManagers(creatorId)).thenReturn(tmList);

        GetTaskManagerResult result = activity.handleRequest(request);
        assertEquals(2, tmList.size());

        assertEquals(creatorId, tm1.getCreatorId());

        assertEquals(creatorId, tm2.getCreatorId());
    }
}
