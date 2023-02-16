package com.nashss.se.remindme.unittest.converters;

import com.nashss.se.remindme.converters.LocalDateTimeConverter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LocalDateTimeConverterTest {
    @Test
    public void testConvert() {
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        LocalDateTime localDateTime = LocalDateTime.of(2023, 2, 16, 15, 30);
        String expectedString = "2023-02-16T15:30:00";
        String actualString = converter.convert(localDateTime);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testUnconvert() {
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        String datetimeString = "2023-02-16T15:30:00";
        LocalDateTime expectedLocalDateTime = LocalDateTime.of(2023, 2, 16, 15, 30);
        LocalDateTime actualLocalDateTime = converter.unconvert(datetimeString);
        assertEquals(expectedLocalDateTime, actualLocalDateTime);
    }

    @Test
    public void testConvertNull() {
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        String actualString = converter.convert(null);
        assertNull(actualString);
    }

    @Test
    public void testUnconvertNull() {
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        LocalDateTime actualLocalDateTime = converter.unconvert(null);
        assertNull(actualLocalDateTime);
    }

}
