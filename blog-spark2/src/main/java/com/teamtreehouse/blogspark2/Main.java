package com.teamtreehouse.blogspark2;

import com.teamtreehouse.blogspark2.dao.BlogEntryDAO;
import com.teamtreehouse.blogspark2.dao.SimpleBlogDAO;
import com.teamtreehouse.blogspark2.dao.SimpleBlogEntryDAO;
import com.teamtreehouse.blogspark2.model.BlogEntries;
import com.teamtreehouse.blogspark2.model.BlogEntry;
import com.teamtreehouse.blogspark2.model.Comment;
import com.teamtreehouse.blogspark2.model.Tag;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static spark.Spark.*;
/**
 * Created by GoranB on 2016-12-23.
 */
public class Main {



    public static void main(String[] args) throws IOException {

        staticFileLocation("/public");



        SimpleBlogDAO blogDAO=new SimpleBlogDAO();
        List<BlogEntry> existingEntries = BlogEntries.load();
        existingEntries.forEach(blogDAO::addEntry);




        before((req, res) -> {
            if (req.cookie("password") != null) {
                req.attribute("password", req.cookie("password"));
            }
        });

        before("/new",(req, res) -> {
            if (req.attribute("password") == null || !req.attribute("password").equals("admin")) {
                res.redirect("/sign-in");
            }

        });

        before("/index/:slug/edit", (req, res) -> {
            if (req.attribute("password") == null || !req.attribute("password").equals("admin")) {
                res.redirect("/sign-in");
            }
        });


        //index page
        get("/", (req, res) -> {
            res.redirect("/index");
            return null;
        });


        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("blogEntries", blogDAO.findAllEntries());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //index page


        get("/new", (req, res) -> {
            return new ModelAndView(null, "new.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sign-in", (req, res) -> {
            return new ModelAndView(null, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());


        //password submission
        post("/sign-in", (req, res) -> {
            String password = req.queryParams("password");
            res.cookie("password", password);
            if (!password.equals("admin")) {
                res.redirect("/sign-in");
            } else {
                res.redirect("/");
            }
            return null;
        });

        post("/publish", (req, res) -> {
            String title = req.queryParams("title");
            String entry = req.queryParams("entry");
            BlogEntry newEntry=new BlogEntry (title, entry, LocalDateTime.now());
            blogDAO.addEntry(newEntry);
            res.redirect("/");
            return null;
        });


        get("/index/:slug", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            //model.put("idea", blogDAO.findEntryBySlug(req.params("slug")));
            BlogEntry entry = blogDAO.findEntryBySlug(req.params("slug"));
            model.put("entry", entry);
            SimpleBlogEntryDAO entryDAO = new SimpleBlogEntryDAO(entry);
            Set<Comment> comments = entryDAO.getComments();
            model.put("comments", comments);
            Set<Tag>tags=entryDAO.getTags();
            model.put("tags", tags);
            return new ModelAndView(model, "entry-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //edit entry page
        get("/index/:slug/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            BlogEntry entry = blogDAO.findEntryBySlug(req.params("slug"));
            model.put("entry", entry);
            return new ModelAndView(model, "edit-entry.hbs");
        }, new HandlebarsTemplateEngine());


        //save edited entry page
        post("/index/:slug/edit/save", (req, res) -> {
            String newTitle = req.queryParams("title");
            String newText = req.queryParams("entry");
            BlogEntry entry = blogDAO.findEntryBySlug(req.params("slug"));

            BlogEntryDAO entryDAO = new SimpleBlogEntryDAO(entry);
            entryDAO.updateTitle(newTitle);
            entryDAO.updateText(newText);

            res.redirect("/index/" + entry.getSlug());
            //res.redirect("/");
            return null;
        });

        //save comment

        post("/index/:slug/comment", (req, res) -> {
            BlogEntry entry = blogDAO.findEntryBySlug(req.params("slug"));
            String author = req.queryParams("name");
            String commentText = req.queryParams("comment");

            BlogEntryDAO entryDAO = new SimpleBlogEntryDAO(entry);
            Comment comment=new Comment(author, commentText, LocalDateTime.now());
            entryDAO.addComment(comment);
            res.redirect("/index/" + entry.getSlug());
            return null;
        });

        //delete entry

        get("/index/:slug/delete", (req, res) -> {
            BlogEntry entry = blogDAO.findEntryBySlug(req.params("slug"));
            boolean result = blogDAO.removeEntry(entry);
            System.out.println(result);
            res.redirect("/");
            return null;

        });








    }





}
