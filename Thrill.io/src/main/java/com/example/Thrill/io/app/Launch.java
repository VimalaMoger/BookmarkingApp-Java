package com.example.Thrill.io.app;

import com.example.Thrill.io.bgJobs.WebpageDownloaderTask;
import com.example.Thrill.io.dataStore.DataFromFile;
import com.example.Thrill.io.entities.Bookmark;
import com.example.Thrill.io.entities.User;
import com.example.Thrill.io.services.BookmarkManager;
import com.example.Thrill.io.services.UserManager;

import java.util.List;

public class Launch {
    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;
    /* The following functions in the main(),  loads data from files
        user can bookmark a book or weblink or movie
    * */
    public static void main(String[] args) {
        loadData();
        start();
        //background jobs
        runDownloaderJob();
    }

    private static void start() {
        System.out.println("\n2. Browsing...");
        for(User user : users) {
            View.browse(user, bookmarks);
        }
    }

    private static void loadData() {
        System.out.println("1. Loading data ..");
        DataFromFile.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();
        //System.out.println("printing data...");
        //printUserData();
       // printBookmarkData();


    }

    private static void runDownloaderJob() {
        WebpageDownloaderTask task = new WebpageDownloaderTask(true);
        (new Thread(task)).start();
    }

    private static void printBookmarkData() {
        for(List<Bookmark> bookmarkList : bookmarks) {
            for(Bookmark bookmark : bookmarkList) {
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for(User user : users) {
            System.out.println(user);
        }
    }
}

