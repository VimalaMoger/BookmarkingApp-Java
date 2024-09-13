package com.example.Thrill.io.dao;

import com.example.Thrill.io.dataStore.DataStore;
import com.example.Thrill.io.entities.Book;
import com.example.Thrill.io.entities.Bookmark;
import com.example.Thrill.io.entities.UserBookmark;
import com.example.Thrill.io.entities.WebLink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookmarkDao {
    public Bookmark[][] getBookmarks() {
        return DataStore.getBookmarks();
    }

    //background job class uses this
    //storing in a collection object
    public List<WebLink> getAllWebLinks(){
        List<WebLink> result= new ArrayList<>();
        Bookmark[][] bookmarks = DataStore.getBookmarks();
        List<WebLink> allWebLinks = getOnlyWeblinks(bookmarks);
        return allWebLinks;
    }

    private List<WebLink> getOnlyWeblinks(Bookmark[][] bookmarks) {
        List<WebLink> result= new ArrayList<>();
        Bookmark[]  allWebLinks = bookmarks[0];
        for(Bookmark bookmark : allWebLinks) {
            result.add((WebLink) bookmark);
        }
        return result;
    }

    //background job class uses this
    public List<WebLink> getWebLinks(WebLink.DownloadStatus downloadStatus){
        List<WebLink> result= new ArrayList<>();
        List<WebLink> allWebLinks = getAllWebLinks();
        for(WebLink webLink : allWebLinks) {
            if(webLink.getDownloadStatus().equals(downloadStatus)) {
                result.add(webLink);
            }
        }
        return result;
    }


    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }

    public Bookmark getBook(long bookId) {
        Bookmark[][] bookmarks = DataStore.getBookmarks();
        Bookmark[]  allBooks = bookmarks[2];
        for(Bookmark bookmark : allBooks) {
            if((bookmark).getId() == bookId){
                return bookmark;
            }
        }
        return null;
    }

    //accessing books from user bookmarked array
    public Collection<Bookmark> getBooks(boolean isBookmarked, long id) {
        List<Bookmark> result = new ArrayList<>();
        if(isBookmarked) {
            List<UserBookmark> userBookmarks = DataStore.getUserBookmarks();
            for (UserBookmark userBookmark : userBookmarks) {
                Bookmark bookmark = userBookmark.getBookmark();
                if(bookmark instanceof Book) {
                    result.add(bookmark);
                }
            }
            return  result;
        }else{
            Bookmark[][] bookmarks = DataStore.getBookmarks();
            Bookmark[]  allBooks = bookmarks[2];
            for(Bookmark bookmark : allBooks) {
                result.add(bookmark);
            }
        }
        return null;
    }
}
