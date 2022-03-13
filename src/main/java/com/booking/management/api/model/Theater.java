package com.booking.management.api.model;

import java.io.Serializable;

/**
 * @author Jitender Saini
 */

public class Theater implements Serializable {

    private static final long serialVersionUID = -3690235009325647142L;

    private int theaterId;
    private String theaterCode;
    private String theaterName;
    private Address address;
    private int occupancy;
    private String seatingClass;

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTheaterCode() {
        return theaterCode;
    }

    public void setTheaterCode(String theaterCode) {
        this.theaterCode = theaterCode;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public String getSeatingClass() {
        return seatingClass;
    }

    public void setSeatingClass(String seatingClass) {
        this.seatingClass = seatingClass;
    }
}
