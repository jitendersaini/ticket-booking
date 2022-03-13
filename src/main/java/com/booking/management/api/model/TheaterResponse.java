package com.booking.management.api.model;

import java.io.Serializable;

public class TheaterResponse implements Serializable {

    private static final long serialVersionUID = -3690235009325647142L;

    private int theaterArrangementId;
    private String seatClass;
    private String seatLabel;
    private boolean isSeatAvailable;

    public int getTheaterArrangementId() {
        return theaterArrangementId;
    }

    public void setTheaterArrangementId(int theaterArrangementId) {
        this.theaterArrangementId = theaterArrangementId;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatLabel() {
        return seatLabel;
    }

    public void setSeatLabel(String seatLabel) {
        this.seatLabel = seatLabel;
    }

    public boolean isSeatAvailable() {
        return isSeatAvailable;
    }

    public void setSeatAvailable(boolean seatAvailable) {
        isSeatAvailable = seatAvailable;
    }
}
