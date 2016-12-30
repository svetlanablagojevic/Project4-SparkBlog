package com.teamtreehouse.blogspark2.model;

/**
 * Created by GoranB on 2016-12-30.
 */
public class Tag {
    private String text;

    public Tag(String tag) {
        text = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
