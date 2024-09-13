package com.example.Thrill.io.app;

import com.example.Thrill.io.constants.KidFriendlyStatus;
import com.example.Thrill.io.constants.UserType;
import com.example.Thrill.io.controller.BookmarkController;
import com.example.Thrill.io.entities.Bookmark;
import com.example.Thrill.io.entities.User;
import com.example.Thrill.io.partner.Shareable;

public class View {

    public static void browse(User user, Bookmark[][] bookmarks) {
        //1. bookmarking
        System.out.println("\n" + user.getEmail() + "is browsing items...");
        int bookmarkCount =0;
        for(Bookmark[] bookmarkList : bookmarks) {
            for(Bookmark bookmarkeach : bookmarkList) {
                //if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                boolean isBookmarked = getBookmarkDecision(bookmarkeach);
                if(isBookmarked) {
                    bookmarkCount++;
                    BookmarkController.getInstance().saveUserBookmark(user, bookmarkeach);
                    System.out.println("New Item Bookmarked "+ bookmarkeach);
                }
                //}
                //2.userTypes marking the bookmark as kid-friendly
                if(user.getUserType().equals(UserType.EDITOR.getType())
                        || user.getUserType().equals(UserType.CHIEF_EDITOR.getType())){
                    //check if bookmark is kidsFriendly
                    if(bookmarkeach.isKidsFriendlyEligible() && bookmarkeach.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                        KidFriendlyStatus kidFriendlyStatus = getKidFriendlyStatusDecision(bookmarkeach);
                        if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
                            BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmarkeach);
                        }
                    }

                    //3.sharing kidFriendly bookmarks with partner website, either book or weblink
                    if(bookmarkeach.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                            && bookmarkeach instanceof Shareable) {
                        boolean isShared = getShareDecision();
                        if(isShared) {
                            BookmarkController.getInstance().share(user, bookmarkeach);
                        }
                    }
                }

            }
        }

    }

    //below methods simulate user input
    private static boolean getShareDecision() {
        return Math.random() < 0.5 ? true : false;
    }

    private static KidFriendlyStatus getKidFriendlyStatusDecision(Bookmark bookmarkeach) {
        double randomVal = Math.random();
        //nested ternary operation
        return randomVal < 0.4 ? KidFriendlyStatus.APPROVED:
                (randomVal >= 0.4 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;

    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true :false;

    }
}
