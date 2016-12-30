package com.teamtreehouse.blogspark2.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by GoranB on 2016-12-28.
 */
public class TimeFormat {

    public static String shortFormat(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static String longFormat(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("MMM d',' yyyy 'at' HH:mm"));
    }
}
