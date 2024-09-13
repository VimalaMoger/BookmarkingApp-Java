package com.example.Thrill.io.services;

import com.example.Thrill.io.constants.BookGenre;
import com.example.Thrill.io.constants.KidFriendlyStatus;
import com.example.Thrill.io.constants.MovieGenre;
import com.example.Thrill.io.dao.BookmarkDao;
import com.example.Thrill.io.entities.*;
import com.example.Thrill.io.util.HttpConnect;
import com.example.Thrill.io.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Collection;

public class BookmarkManager {
    //using Singleton pattern
    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao dao = new BookmarkDao();

    private BookmarkManager() {}

    public static BookmarkManager getInstance() {
        return instance;
    }



    public Movie createMovie(long id, String title, int releaseYear, String[] cast,
                             String[] directors, MovieGenre horror, double imdbRating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(horror);
        movie.setImdbRating(imdbRating);
        return movie;

    }

    public Book createBook(long id, String title, String imageurl, int pblicationYear, String publisherId,
                           String[] authors, BookGenre bookGenre, double amazonRating) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setImage_url(imageurl);
        book.setPublicationYear(pblicationYear);
        book.setPublisher(publisherId);
        book.setAuthors(authors);
        book.setGenre(bookGenre);
        book.setAmazonRating(amazonRating);
        return book;
    }

    public WebLink createWebLink(long id, String title, String url, String host) {
        WebLink weblink = new WebLink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);
        return weblink;
    }
    public Bookmark[][] getBookmarks() {
            return dao.getBookmarks();
        }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark(user,bookmark);
        //userBookmark.setUser((user));
        //userBookmark.setBookmark(bookmark);
        if(bookmark instanceof WebLink){
            try{
                String url = ((WebLink)bookmark).getUrl();
                if(!url.endsWith(".pdf")){
                    String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
                    if(webpage != null){
                        IOUtil.write(webpage, bookmark.getId());
                    }
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        dao.saveUserBookmark(userBookmark);
    }


	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmarkeach) {
		bookmarkeach.setKidFriendlyStatus(kidFriendlyStatus);
        bookmarkeach.setKidFriendlyMarkedBy(user);
		// System.out.println("kid-friendly status:" + kidFriendlyStatus + "," +
		// bookmarkeach);
		System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", marked by " + user.getEmail() + bookmarkeach);

	}
    //sharing either book or weblink by user
	public void share(User user, Bookmark bookmarkeach) {
		bookmarkeach.setSharedBy(user);
		System.out.println("Data to be shared by:(" + bookmarkeach.getSharedBy().getFirstName()+")");
		if(bookmarkeach instanceof Book) {
			System.out.println(((Book)bookmarkeach).getItemData());
		}else if(bookmarkeach instanceof WebLink) {
			System.out.println(((WebLink)bookmarkeach).getItemData());
		 }

	}

	public Collection<Bookmark> getBooks(boolean isBookmarked, long id) {
		return dao.getBooks(isBookmarked,id);
	}

	public Bookmark getBook(long bookId) {
		return dao.getBook(bookId);
	}

}
