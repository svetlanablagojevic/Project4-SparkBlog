package com.teamtreehouse.blogspark2.dao;

import com.teamtreehouse.blogspark2.model.Comment;
import com.teamtreehouse.blogspark2.model.Tag;

import java.util.Set;

/**
 * Created by GoranB on 2016-12-28.
 */
public interface BlogEntryDAO {

    boolean addComment(Comment comment);

    void updateTitle(String newTitle);

    void updateText(String newText);

    Set<Comment> getComments();

    Set<Tag> getTags();

}
