package com.nashss.se.remindme.dependencies;

import com.nashss.se.remindme.activity.CreateTaskManagerActivity;
import com.nashss.se.remindme.activity.CreateUserActivity;
import com.nashss.se.remindme.activity.GetAllTasksActivity;
import com.nashss.se.remindme.activity.GetTaskActivity;
import com.nashss.se.remindme.activity.GetTaskManagerActivity;
import com.nashss.se.remindme.activity.GetUserActivity;
import com.nashss.se.remindme.activity.AddTaskToManagerActivity;
import com.nashss.se.remindme.activity.MarkIsCompleteActivity;
import com.nashss.se.remindme.activity.DeleteTaskActivity;


import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the RemindMeClient.
 */
@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    /**
     * Provides the relevant activity.
     * @return GetTaskActivity
     */
    GetTaskActivity provideGetTaskActivity();

    /**
     * Provides the relevant activity.
     * @return GetAllTasksActivity
     */
    GetAllTasksActivity provideGetAllTasksActivity();

    /**
     * Provides the relevant activity.
     * @return CreateTaskManagerActivity
     */
    CreateTaskManagerActivity provideCreateTaskManagerActivity();

    /**
     * Provides the relevant activity.
     * @return CreateUserActivity
     */
    CreateUserActivity provideCreateUserActivity();

    /**
     * Provides the relevant activity.
     * @return GetUserActivity
     */
    GetUserActivity provideGetUserActivity();

    /**
     * Provides the relevant activity.
     * @return GetTaskManagerActivity
     */
    GetTaskManagerActivity provideGetTaskManagerActivity();

    /**
     * Provides the relevant activity.
     * @return AddTaskToManagerActivity
     */
    AddTaskToManagerActivity provideAddTaskToManagerActivity();

    /**
     * Provides the relevant activity.
     * @return MarkIsCompleteActivity
     */
    MarkIsCompleteActivity provideMarkIsCompleteActivity();

    /**
     * Provides the relevant activity.
     * @return DeleteTaskActivity
     */
    DeleteTaskActivity provideDeleteTaskActivity();
}
