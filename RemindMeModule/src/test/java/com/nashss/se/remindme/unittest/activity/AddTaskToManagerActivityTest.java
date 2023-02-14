package com.nashss.se.remindme.unittest.activity;

import com.nashss.se.remindme.activity.AddTaskToManagerActivity;
import com.nashss.se.remindme.activity.requests.AddTaskToManagerRequest;
import com.nashss.se.remindme.activity.results.AddTaskToManagerResult;
import com.nashss.se.remindme.converters.ModelConverter;
import com.nashss.se.remindme.dynamodb.TaskDao;
import com.nashss.se.remindme.dynamodb.models.Task;
import com.nashss.se.remindme.models.TaskModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class AddTaskToManagerActivityTest {
    private static final String TASK_MANAGER_ID = "task_manager_id";
    private static final String DESCRIPTION = "description";
    private static final String NAME = "name";
    private static final String TASK_ID = "task_id";
    AddTaskToManagerActivity t;

    @Mock
    private ModelConverter modelConverter;
    @Mock
    private TaskDao taskDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        t = new AddTaskToManagerActivity(taskDao);
    }

}
