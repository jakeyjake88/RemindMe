package com.nashss.se.remindme.converters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class for the LocalDateTimeConverter.
 */
public class DateTimeLocalConverter {

    /**
     * Converts to LocalDateTime from dateTimeLocal.
     *
     * @param datetimeLocal A localDateTime from HTML
     * @return Converted localDateTime
     */
    public LocalDateTime convertDatetimeLocalToJava(String datetimeLocal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(datetimeLocal, formatter);
    }

    /**
     * unConverts to LocalDateTime from dateTimeLocal.
     *
     * @param localDateTime A localDateTime from HTML
     * @return Converted localDateTime
     */
    public static String unconvertDatetimeLocalFromJava(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return localDateTime.format(formatter);
    }
}
