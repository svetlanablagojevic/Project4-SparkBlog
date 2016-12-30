package com.teamtreehouse.blogspark2.dao;

import com.teamtreehouse.blogspark2.model.BlogEntry;
import com.teamtreehouse.blogspark2.model.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GoranB on 2016-12-29.
 */
public class SimpleBlogDAO implements BlogDAO{

    private List <BlogEntry> blogEntries;

    public SimpleBlogDAO() {
        this.blogEntries = new ArrayList<>();
    }

    @Override
    public boolean addEntry(BlogEntry blogEntry) {
        return blogEntries.add(blogEntry);
    }

    @Override
    public List<BlogEntry> findAllEntries() {
        return new ArrayList<>(blogEntries);
    }

    @Override
    public BlogEntry findEntryBySlug(String slug) {
        return blogEntries.stream()
                .filter(idea->idea.getSlug().equals(slug))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean removeEntry(BlogEntry blogEntry) {
        return blogEntries.remove(blogEntry);
    }
}
