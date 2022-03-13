package com.booking.management.api.model;

import java.io.Serializable;

/**
 * @author Jitender Saini
 */

public class Address implements Serializable {

    private static final long serialVersionUID = -3690235005675647142L;
    private String pinCode;
    private String streetNo;
    private String landmark;
    private City city;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
