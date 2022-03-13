package com.booking.management.api.controllers;

import com.booking.management.api.model.Movie;
import com.booking.management.api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jitender Saini
 */

@RestController
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies")
    public ResponseEntity<List<Movie>> getMovieByStateCode() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }
}
