package com.teamtreehouse.blogspark2.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GoranB on 2016-12-29.
 */
public class BlogEntries {


    public static List<BlogEntry> load() {
        List<BlogEntry> entries = new ArrayList<>();



        BlogEntry firstEntry=new BlogEntry ("The best day I’ve ever had","Koja muzika je bila najpopularnija u vreme kad ste se rodili? Da li je to bio pop, rok, džez ili numera iz nekog filma? ",   LocalDateTime.of(2016, Month.JANUARY, 10, 5, 0));
        firstEntry.addComment(new Comment("Marco", "Well done!", LocalDateTime.now()));
        firstEntry.addTag("hash");
        entries.add(firstEntry);
        //

        BlogEntry secondEntry=new BlogEntry ("The absolute worst day I’ve ever had","Naime, naučnici su otkrili da pričanje sa samim sobom može biti put do različitih dostignuća i uspeha. ",  LocalDateTime.of(2016, Month.JANUARY, 10, 5, 0));
        entries.add(secondEntry);

        BlogEntry thirdEntry=new BlogEntry ("hat time at the mall!","Prema poslednjem izveštaju istražitelja Svetske antidoping agencije (WADA) Ričarda Meklarena od 9. decembra, više od 1.000 ruskih sportista je učestvovalo u programu 2011-2015. godine s kojim je bila upoznata i država. ", LocalDateTime.of(2016, Month.JANUARY, 10, 5, 0));
        entries.add(thirdEntry);



        return entries;
    }




    };



