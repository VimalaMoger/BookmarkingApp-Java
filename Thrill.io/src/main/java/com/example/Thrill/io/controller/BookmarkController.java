package com.example.Thrill.io.controller;

import com.example.Thrill.io.constants.KidFriendlyStatus;
import com.example.Thrill.io.entities.Bookmark;
import com.example.Thrill.io.entities.User;
import com.example.Thrill.io.services.BookmarkManager;

public class BookmarkController {
    //using Singleton pattern
    private static BookmarkController instance = new BookmarkController();

    private BookmarkController() {}

    public static BookmarkController getInstance(){return instance;}

    public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmarkeach) {
        BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmarkeach);

    }

    public void share(User user, Bookmark bookmarkeach) {
        BookmarkManager.getInstance().share(user,bookmarkeach);
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
    }
}