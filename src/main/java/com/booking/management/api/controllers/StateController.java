package com.booking.management.api.controllers;

import com.booking.management.api.model.State;
import com.booking.management.api.services.StateService;
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
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping(value = "/state/{countryCode}")
    public ResponseEntity<List<State>> getStatesByCountryCode(@PathVariable String countryCode) {
        return new ResponseEntity<>(stateService.getCountryByCode(countryCode), HttpStatus.OK);
    }

}
