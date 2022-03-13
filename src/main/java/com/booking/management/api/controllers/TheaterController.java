package com.booking.management.api.controllers;


import com.booking.management.api.model.TheaterAddress;
import com.booking.management.api.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Jitender Saini
 */

@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping(value = "/theater/{cityCode}")
    public ResponseEntity<Map<String, List<TheaterAddress>>> getTheatersByCityCode(@PathVariable String cityCode, String movieCode) {
        System.out.println("movieCode: "+movieCode);
        return new ResponseEntity<>(theaterService.getTheatersByCityCode(cityCode, movieCode), HttpStatus.OK);
    }
}
