package com.nashss.se.remindme.unittest.converters;

import com.nashss.se.remindme.converters.DateTimeLocalConverter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DateTimeLocalConverterTest {


    @Test
    public void testConvertDatetimeLocalToJava() {
        DateTimeLocalConverter converter = new DateTimeLocalConverter();
        LocalDateTime expectedDateTime = LocalDateTime.of(2023, 2, 16, 12, 30);
        String datetimeLocal = "2023-02-16T12:30";
        LocalDateTime actualDateTime = converter.convertDatetimeLocalToJava(datetimeLocal);
        assertEquals(expectedDateTime, actualDateTime);
    }

    @Test
    public void testUnconvertDatetimeLocalFromJava() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 2, 16, 12, 30);
        String expectedDatetimeLocal = "2023-02-16T12:30";
        String actualDatetimeLocal = DateTimeLocalConverter.unconvertDatetimeLocalFromJava(localDateTime);
        assertEquals(expectedDatetimeLocal, actualDatetimeLocal);
    }
}
