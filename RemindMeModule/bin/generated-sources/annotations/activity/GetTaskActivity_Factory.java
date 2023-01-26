package com.nashss.se.remindme.activity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import com.nashss.se.remindme.dynamodb.TaskDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetTaskActivity_Factory implements Factory<GetTaskActivity> {
  private final Provider<TaskDao> taskDaoProvider;

  public GetTaskActivity_Factory(Provider<TaskDao> taskDaoProvider) {
    this.taskDaoProvider = taskDaoProvider;
  }

  @Override
  public GetTaskActivity get() {
    return newInstance(taskDaoProvider.get());
  }

  public static GetTaskActivity_Factory create(Provider<TaskDao> taskDaoProvider) {
    return new GetTaskActivity_Factory(taskDaoProvider);
  }

  public static GetTaskActivity newInstance(TaskDao taskDao) {
    return new GetTaskActivity(taskDao);
  }
}
