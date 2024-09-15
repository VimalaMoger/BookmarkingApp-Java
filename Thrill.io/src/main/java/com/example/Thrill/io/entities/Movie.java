package com.example.Thrill.io.entities;

import com.example.Thrill.io.constants.MovieGenre;
import lombok.Data;

import java.util.Arrays;

@Data
public class Movie extends Bookmark {
    private int releaseYear;
    private String[] cast;
    private String[] directors;
    private MovieGenre genre;
    private double imdbRating;

    public  Movie(){}

    @Override
    public String toString() {
        return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", directors="
                + Arrays.toString(directors) + ", genre=" + genre + ", imdbRating=" + imdbRating + "]";
    }

    //stub
    public boolean isKidsFriendlyEligible() {
        if(getGenre().equals(MovieGenre.HORROR) || getReleaseYear()==1942 || getCast()[0].contains("Orizon")) {
            return false;
        }
        return true;
    }
}