package com.booking.management.api.model;

import java.io.Serializable;

/**
 * @author Jitender Saini
 */

//enum MovieType {
//    ENGLISH,
//    HINDI;
//}
//
//enum Genre {
//    ADVENTURE,
//    HORROR,
//    ACTION,
//    SCIFI;
//}

public class Movie implements Serializable {

    private static final long serialVersionUID = -3644935537675647142L;

    private int movieId;
    private String movieName;
    private String movieType;
    private String genre;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre.toString();
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
