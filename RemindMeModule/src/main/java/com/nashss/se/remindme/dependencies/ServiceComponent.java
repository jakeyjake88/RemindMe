package com.nashss.se.remindme.dependencies;

import com.nashss.se.remindme.activity.*;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetTaskActivity provideGetTaskActivity();
    GetAllTasksActivity provideGetAllTasksActivity();
    CreateTaskManagerActivity provideCreateTaskManagerActivity();
    CreateUserActivity provideCreateUserActivity();
    GetUserActivity provideGetUserActivity();
}
