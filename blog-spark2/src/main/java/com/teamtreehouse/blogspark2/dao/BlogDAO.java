package com.teamtreehouse.blogspark2.dao;

import com.teamtreehouse.blogspark2.model.BlogEntry;

import java.util.List;

/**
 * Created by GoranB on 2016-12-23.
 */
public interface BlogDAO {

    boolean addEntry(BlogEntry blogEntry);
    List<BlogEntry> findAllEntries();
    BlogEntry findEntryBySlug(String slug);
    ///dovde je zadato
    boolean removeEntry(BlogEntry blogEntry);
}
