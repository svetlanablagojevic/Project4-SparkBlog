package com.teamtreehouse.blogspark2.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GoranB on 2016-12-23.
 */
public class BlogEntry  {

    BlogEntry blogEntries;

    private String title;
    private String text;
    private String slug;
    private LocalDateTime dateTimeCreated;
    private Set <Comment> comments;
    private Set<Tag> tags;


    public BlogEntry(String title, String text, LocalDateTime dateTimeCreated) {
        this.title = title;
        this.text = text;
        this.dateTimeCreated = dateTimeCreated;
        this.comments=new HashSet<>();
        this.tags=new HashSet<>();
        try {
            Slugify slugify=new Slugify();
            slug=slugify.slugify(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //getters
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public String getSlug() {
        return slug;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Tag> getTags() {
        return tags;
    }



    //setters


    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getTimeString() {
        return TimeFormat.longFormat(dateTimeCreated);
    }


    public boolean addComment(Comment comment) {
        // Store these comments!
        return comments.add(comment);
    }

    protected boolean addTag(String tag) {
        return tags.add(new Tag(tag));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntry blogEntry = (BlogEntry) o;

        if (blogEntries != null ? !blogEntries.equals(blogEntry.blogEntries) : blogEntry.blogEntries != null)
            return false;
        if (title != null ? !title.equals(blogEntry.title) : blogEntry.title != null) return false;
        if (text != null ? !text.equals(blogEntry.text) : blogEntry.text != null) return false;
        if (slug != null ? !slug.equals(blogEntry.slug) : blogEntry.slug != null) return false;
        if (dateTimeCreated != null ? !dateTimeCreated.equals(blogEntry.dateTimeCreated) : blogEntry.dateTimeCreated != null)
            return false;
        if (comments != null ? !comments.equals(blogEntry.comments) : blogEntry.comments != null) return false;
        return tags != null ? tags.equals(blogEntry.tags) : blogEntry.tags == null;
    }

    @Override
    public int hashCode() {
        int result = blogEntries != null ? blogEntries.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (dateTimeCreated != null ? dateTimeCreated.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }
}
