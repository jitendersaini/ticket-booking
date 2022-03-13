package com.booking.management.api.model;

import java.io.Serializable;

/**
 * @author Jitender Saini
 */

public class Country implements Serializable {
    private static final long serialVersionUID = -3644935005675681042L;

    private String countryCode;
    private String countryName;

    public Country() {
    }

    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
