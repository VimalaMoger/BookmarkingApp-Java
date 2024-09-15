package com.example.Thrill.io.dataStore;

import com.example.Thrill.io.constants.BookGenre;
import com.example.Thrill.io.constants.Gender;
import com.example.Thrill.io.constants.MovieGenre;
import com.example.Thrill.io.entities.*;
import com.example.Thrill.io.services.BookmarkManager;
import com.example.Thrill.io.services.UserManager;
import com.example.Thrill.io.util.IOUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFromFile {

    public static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    private static List<List<Bookmark>> bookmarks = new ArrayList<>(); //one for type, other for actual bookmark, each type can have 5 bookmarks

    public static List<List<Bookmark>> getBookmarks() {
        return bookmarks;
    }

    private static List<UserBookmark> userBookmarks = new ArrayList<>(); //new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];//one to hold user bookmark

    public static List<UserBookmark> getUserBookmarks() {
        return userBookmarks;
    }

    //LOADING DATA
    public static void loadData() {
        loadUsers();
        LoadWebLinks();
        loadMovies();
        loadBooks();
    }

    private static void loadBooks() {
        List<String> data = new ArrayList();
        IOUtil.read(data, "Book.txt");
        List<Bookmark> books = new ArrayList<>();

        for(String row : data) {
            String[] values = row.split("    ");
            System.out.println("values "+Arrays.toString(values));
            System.out.println(values[0]+".. " +values[1]+".. " +values[2]+".. " +values[4]+" " +values[5]+" " +values[6]);
            Book book = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], new Book().getImage_url(), Integer.parseInt(values[2]),values[3], new String[]{values[4]}, BookGenre.valueOfName(values[5]), Double.parseDouble(values[6]));
            books.add(book);
            bookmarks.add(books);
        }
    }
    private static void loadMovies() {
        List<String> data = new ArrayList();
        IOUtil.read(data, "Movie.txt");
        List<Bookmark> movies = new ArrayList<>();

        for(String row : data) {
            String[] values = row.split("\t");
            Movie movie = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), new String[]{(values[3])},new String[]{values[4]},MovieGenre.valueOfFeature(values[5]), Double.parseDouble(values[6]));
            movies.add(movie);
            bookmarks.add(movies);
        }
    }

    private static void LoadWebLinks () {
        List<String> data = new ArrayList();
        IOUtil.read(data, "Weblink.txt");
        List<Bookmark> webLinks = new ArrayList<>();

        for(String row : data) {
            String[] values = row.split("\t");
            WebLink webLink = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]);
            webLinks.add(webLink);
            bookmarks.add(webLinks);
        }
    }

    private static void loadUsers () {
        List<String> data = new ArrayList();
        IOUtil.read(data, "User.txt");
        int colNum = 0;
        for(String row : data) {
            String[] values = row.split("\t");
            Gender gender = Gender.MALE;
            if (values[5].equals(("f")))
                gender = Gender.FEMALE;
            else if (values[5].equals("t"))
                gender = Gender.TRANSGENDER;
            User user = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1],values[2], values[3], values[4], gender, values[6]);
            users.add(user);
        }
    }

    public static void add(UserBookmark userBookmark) {
        userBookmarks.add(userBookmark);
    }

}
