package com.nashss.se.remindme.dependencies;

import com.nashss.se.remindme.activity.GetTaskActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetTaskActivity provideGetTaskActivity();
}