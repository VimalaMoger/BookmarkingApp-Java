package com.example.Thrill.io.app;

import com.example.Thrill.io.dataStore.DataStore;
import com.example.Thrill.io.entities.Bookmark;
import com.example.Thrill.io.entities.User;
import com.example.Thrill.io.services.BookmarkManager;
import com.example.Thrill.io.services.UserManager;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;
    /* The following functions in the main(), manually  loading data using array
        user can bookmark any book or weblink or movie
    * */
    public static void main(String[] args) {
        loadData();
        start();
    }

    private static void start() {
        //System.out.println("\n2. Browsing...");
        for(User user : users) {
            View.browse(user, bookmarks);
        }
    }

    private static void loadData() {
        System.out.println("1. Loading data ..");
        DataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();
        //System.out.println("printing data...");
        //printUserData();
       // printBookmarkData();


    }

    private static void printBookmarkData() {
        for(Bookmark[] bookmarkList : bookmarks) {
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

