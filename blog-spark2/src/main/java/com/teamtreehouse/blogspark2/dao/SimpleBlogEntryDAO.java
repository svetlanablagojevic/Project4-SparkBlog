package com.teamtreehouse.blogspark2.dao;

import com.teamtreehouse.blogspark2.model.BlogEntry;
import com.teamtreehouse.blogspark2.model.Comment;
import com.teamtreehouse.blogspark2.model.Tag;

import java.util.Set;

/**
 * Created by GoranB on 2016-12-29.
 */
public class SimpleBlogEntryDAO implements BlogEntryDAO {

    private BlogEntry entry;

    public SimpleBlogEntryDAO(BlogEntry entry) {
        this.entry = entry;

    }

    @Override
    public boolean addComment(Comment comment) {
        return entry.addComment(comment);
    }

    @Override
    public void updateTitle(String newTitle) {
        entry.setTitle(newTitle);

    }

    @Override
    public void updateText(String newText) {
        entry.setText(newText);

    }

    @Override
    public Set<Comment> getComments() {
       return entry.getComments();
    }

    @Override
    public Set<Tag> getTags() {
        return entry.getTags();
    }


}
