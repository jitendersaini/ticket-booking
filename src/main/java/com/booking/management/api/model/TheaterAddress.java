package com.booking.management.api.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Jitender Saini
 */

public class TheaterAddress implements Serializable {

    private static final long serialVersionUID = -3690235009325647142L;

    private int theaterId;
    private int theaterMovieId;
    private int movieId;
//    private int theaterOccupancy;
    Map<String, MovieDetails> movieDetails;

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Map<String, MovieDetails> getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(Map<String, MovieDetails> movieDetails) {
        this.movieDetails = movieDetails;
    }

//    public int getTheaterOccupancy() {
//        return theaterOccupancy;
//    }
//
//    public void setTheaterOccupancy(int theaterOccupancy) {
//        this.theaterOccupancy = theaterOccupancy;
//    }

    public int getTheaterMovieId() {
        return theaterMovieId;
    }

    public void setTheaterMovieId(int theaterMovieId) {
        this.theaterMovieId = theaterMovieId;
    }
}
