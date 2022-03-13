package com.booking.management.api.model;

import java.io.Serializable;

/**
 * @author Jitender Saini
 */

public class City implements Serializable {
    private static final long serialVersionUID = -3690239032575647142L;

    public City(String cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    private String cityCode;
    private String cityName;
    private State state;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
