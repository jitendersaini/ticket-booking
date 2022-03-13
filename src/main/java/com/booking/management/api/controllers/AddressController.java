package com.booking.management.api.controllers;

import com.booking.management.api.model.Address;
import com.booking.management.api.services.AddressService;
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
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/address/{id}")
    public ResponseEntity<List<Address>> getAddressById(@PathVariable Integer id) {
        return new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/address/code/{code}")
    public ResponseEntity<List<Address>> getAddressByCode(@PathVariable String code) {
        return new ResponseEntity<>(addressService.getAddressByCode(code), HttpStatus.OK);
    }
}
