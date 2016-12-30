package com.teamtreehouse.blogspark2.model;

import java.time.LocalDateTime;

/**
 * Created by GoranB on 2016-12-23.
 */
public class Comment {

    private String author;
    private String text;
    private LocalDateTime dateTimeCreated;

    public Comment(String author, String text, LocalDateTime dateTimeCreated) {
        this.author = author;
        this.text = text;
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getLocalDateTime() {
        return dateTimeCreated;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.dateTimeCreated = localDateTime;
    }
}
