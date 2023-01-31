package com.nashss.se.remindme.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.nashss.se.remindme.dynamodb.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskListConverter implements DynamoDBTypeConverter<String, List<Task>> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(List<Task> listToBeConverted) {
        return GSON.toJson(listToBeConverted);
    }

    @Override
    public List<Task> unconvert(String dynamoDBRepresentation) {
        return GSON.fromJson(dynamoDBRepresentation, new TypeToken<ArrayList<Task>>() { } .getType());
    }
}
