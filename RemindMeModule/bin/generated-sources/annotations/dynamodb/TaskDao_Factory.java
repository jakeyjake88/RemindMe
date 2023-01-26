package com.nashss.se.remindme.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class TaskDao_Factory implements Factory<TaskDao> {
  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public TaskDao_Factory(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public TaskDao get() {
    return newInstance(dynamoDBMapperProvider.get());
  }

  public static TaskDao_Factory create(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new TaskDao_Factory(dynamoDBMapperProvider);
  }

  public static TaskDao newInstance(DynamoDBMapper dynamoDBMapper) {
    return new TaskDao(dynamoDBMapper);
  }
}
