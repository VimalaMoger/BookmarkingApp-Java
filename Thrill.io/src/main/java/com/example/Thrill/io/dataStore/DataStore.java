/*
package com.example.Thrill.io.dataStore;

import com.example.Thrill.io.constants.BookGenre;
import com.example.Thrill.io.constants.Gender;
import com.example.Thrill.io.constants.MovieGenre;
import com.example.Thrill.io.constants.UserType;
import com.example.Thrill.io.entities.Bookmark;
import com.example.Thrill.io.entities.User;
import com.example.Thrill.io.entities.UserBookmark;
import com.example.Thrill.io.services.BookmarkManager;
import com.example.Thrill.io.services.UserManager;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static final int USER_BOOKMARK_LIMIT = 5; //user can bookmark up to five items
    public static final int BOOKMARKCOUNT_PER_TYPE = 5; //five selections in each type
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int TOTAL_USER_COUNT = 5;
    public static User[] users = new User[TOTAL_USER_COUNT];

    public static User[] getUsers() {
        return users;
    }

    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARKCOUNT_PER_TYPE]; //one for type, other for actual bookmark, each type can have 5 bookmarks
    //private static List<List<Bookmark>> bookmarks = new ArrayList<>();

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }

    private static List<UserBookmark> userBookmarks = new ArrayList<>(); //new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];//one to hold user bookmark

    public static List<UserBookmark> getUserBookmarks() {
        return userBookmarks;
    }
    //index initialized to 0
    private static int bookmarkIndex =0;

    //LOADING DATA
    public static void loadData() {
        loadUsers();
        LoadWebLinks();
        loadMovies();
        loadBooks();
    }

    private static void loadBooks() {
        bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", "", 1993, "Dover Publications", new String[]{"Ralph Waldo Emerson"}, BookGenre.PHILOSOPHY, 4.5);
        bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", "", 1988, "Touchstone", new String[]{"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
        bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", "", 2004, "O'Reilly Media", new String[]{"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson"}, BookGenre.TECHNICAL, 4.5);
        bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide", "", 2007, "Prentice Hall", new String[]{"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);

    }
    private static void loadMovies() {
        bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
        bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", 1940, new String[]{"Henry Fonda", "Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS, 8.2);
        bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness", 2004, new String[]{"Albert Cullum"}, new String[]{"Leslie Sullivan"}, MovieGenre.DOCUMENTARIES, 7.3);
        bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory",  2007, new String[]{"Kaley Cuoco", "Jim Parsons"}, new String[]{"Chuck Lorre", "Bill Prady"}, MovieGenre.TV_SHOWS, 8.7);
        bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru",  1952, new String[]{"Takashi Shimura", "Minoru Chiaki"}, new String[]{"Akira Kurosawa"}, MovieGenre.FOREIGN_MOVIES, 8.4);
    }

    private static void LoadWebLinks () {
        bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Interface vs Abstract Class", "https://www.mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com");
        bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com");
        bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003, "NIO tutorial by Greg Travis", "http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu");
        bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2024, "Virtual Hosting and Tomcat", "https://tomcat.apache.org/tomcat-9.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org");

    }

    private static void loadUsers () {
        users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE, UserType.USER.getType());
        users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "Sam", "M", Gender.MALE, UserType.USER.getType());
        users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Anita", "M", Gender.MALE, UserType.EDITOR.getType());
        users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Sara", "M", Gender.FEMALE, UserType.EDITOR.getType());
        users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Dheeru", "M", Gender.MALE, UserType.CHIEF_EDITOR.getType());

    }

    public static void add(UserBookmark userBookmark) {
        userBookmarks.add(userBookmark);
        //bookmarkIndex++;
    }

}*/
