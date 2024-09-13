package com.example.Thrill.io;

import com.example.Thrill.io.constants.MovieGenre;
import com.example.Thrill.io.entities.Movie;
import com.example.Thrill.io.services.BookmarkManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;

public class MovieTest {
    @Test
    public void testIsKidFriendlyEligible() {
        Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
        boolean isKidFriendlyEligible = movie.isKidsFriendlyEligible();
        Assertions.assertEquals(true, isKidFriendlyEligible);
    }

}
