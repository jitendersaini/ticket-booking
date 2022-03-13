package com.booking.management.api.controllers;

import com.booking.management.api.model.City;
import com.booking.management.api.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jitender Saini
 */

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city/{stateCode}")
    public ResponseEntity<List<City>> getCityByStateCode(@PathVariable String stateCode) {
        return new ResponseEntity<>(cityService.getCityByCode(stateCode), HttpStatus.OK);
    }
}
