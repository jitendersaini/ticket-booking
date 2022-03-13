package com.booking.management.api.services;

import com.booking.management.api.helpers.SqlConnection;
import com.booking.management.api.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Service
public class CountryService {

    public List<Country> getAll() {

        Connection conn = SqlConnection.connect();
        List<Country> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from COUNTRY");
            if(rs != null) {
                while(rs.next()) {
                    list.add(new Country(rs.getString("CODE"), rs.getString("TITLE")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Country getCountryByCode(String countryCode) {
        Connection conn = SqlConnection.connect();
        Country country = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from COUNTRY where upper(code) = '"+countryCode.toUpperCase(Locale.ROOT)+"'");
            if(rs != null) {
                if(rs.next()) country = new Country(rs.getString("CODE"),
                        rs.getString("TITLE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }
}
