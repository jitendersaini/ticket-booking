package com.booking.management.api.controllers;


import com.booking.management.api.model.TheaterResponse;
import com.booking.management.api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Jitender Saini
 */

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @GetMapping(value = "/get-theater-details/{theaterMovieId}")
    public ResponseEntity<Map<String, List<TheaterResponse>>> getTheaterDetails(@PathVariable String theaterMovieId, String movieTime, Integer userId) {
//        System.out.println("theaterId: "+ theaterId);
        System.out.println("movieTime: "+ movieTime);
//        System.out.println("movieId: "+ movieId);
        System.out.println("userId: "+ userId);

        return new ResponseEntity<>(bookingService.getTheaterDetails(theaterMovieId ,movieTime, userId), HttpStatus.OK);
    }

    @PostMapping(value = "/booking")
    public ResponseEntity<String> bookTicket(Integer theaterMovieId, Integer[] theaterSeatingArrangementId, Integer userId) {
//        System.out.println("theaterMovieId: "+theaterMovieId);
//        System.out.println("theaterSeatingArrangementId.len: "+theaterSeatingArrangementId.length);
//        System.out.println("userId: "+userId);
        return new ResponseEntity<>(bookingService.bookTicket(theaterMovieId,theaterSeatingArrangementId, userId), HttpStatus.CREATED);
    }

    @PutMapping(value = "/booking/cancel")
    public ResponseEntity<String> cancelTicket(Integer theaterMovieId, Integer[] theaterSeatingArrangementId, Integer userId) {
//        System.out.println("theaterMovieId: "+theaterMovieId);
//        System.out.println("theaterSeatingArrangementId.len: "+theaterSeatingArrangementId.length);
//        System.out.println("userId: "+userId);
        return new ResponseEntity<>(bookingService.cancelTicket(theaterMovieId,theaterSeatingArrangementId, userId), HttpStatus.OK);
    }
}
