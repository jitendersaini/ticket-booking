package com.booking.management.api.controllers;

import com.booking.management.api.model.Country;
import com.booking.management.api.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jitender Saini
 */

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/country")
    public ResponseEntity<Object> getAllCountries() {
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/country/{countryCode}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String countryCode) {
        return new ResponseEntity<>(countryService.getCountryByCode(countryCode), HttpStatus.OK);
    }

}
