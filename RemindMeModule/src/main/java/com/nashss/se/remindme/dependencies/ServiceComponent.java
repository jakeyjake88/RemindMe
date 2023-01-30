package com.nashss.se.remindme.dependencies;

import com.nashss.se.remindme.activity.CreateTaskManagerActivity;
import com.nashss.se.remindme.activity.GetAllTasksActivity;
import com.nashss.se.remindme.activity.GetTaskActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetTaskActivity provideGetTaskActivity();
    GetAllTasksActivity provideGetAllTasksActivity();
    CreateTaskManagerActivity provideCreateTaskManagerActivity();
}
