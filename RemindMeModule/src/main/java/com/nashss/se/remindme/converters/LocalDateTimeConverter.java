package com.nashss.se.remindme.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {
    @Override
    public String convert(LocalDateTime object) {
        return (object == null) ? null : object.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public LocalDateTime unconvert(String object) {
        return (object == null) ? null : LocalDateTime.parse(object, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
