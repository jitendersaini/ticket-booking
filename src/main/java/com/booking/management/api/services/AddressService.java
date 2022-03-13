package com.booking.management.api.services;

import com.booking.management.api.helpers.SqlConnection;
import com.booking.management.api.model.Address;
import com.booking.management.api.model.City;
import com.booking.management.api.model.Movie;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    public List<Address> getAddressById(Integer id) {
        Connection conn = SqlConnection.connect();
        List<Address> listAddress = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select a.ID, a.PIN_CODE, a.STREET_NO , a.LANDMARK, c.CODE , c.TITLE as CITY from ADDRESS a, CITY c where c.ID = a.CITY_ID and a.CITY_ID = "+id);
            if(rs != null) {
                while(rs.next()) {
                    Address address = new Address();
                    address.setStreetNo(rs.getString("STREET_NO"));
                    address.setLandmark(rs.getString("LANDMARK"));
                    address.setPinCode(rs.getString("PIN_CODE"));
                    City c = new City(rs.getString("CODE"), rs.getString("CITY"));
                    address.setCity(c);
                    listAddress.add(address);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAddress;
    }

    public List<Address> getAddressByCode(String code) {
        Connection conn = SqlConnection.connect();
        List<Address> listAddress = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select a.ID, a.PIN_CODE, a.STREET_NO , a.LANDMARK, c.CODE , c.TITLE as CITY from ADDRESS a, CITY c where c.ID = a.CITY_ID and c.CODE = '"+code+"'");
            if(rs != null) {
                while(rs.next()) {
                    Address address = new Address();
                    address.setStreetNo(rs.getString("STREET_NO"));
                    address.setLandmark(rs.getString("LANDMARK"));
                    address.setPinCode(rs.getString("PIN_CODE"));
                    City c = new City(rs.getString("CODE"), rs.getString("CITY"));
                    address.setCity(c);
                    listAddress.add(address);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAddress;
    }
}
