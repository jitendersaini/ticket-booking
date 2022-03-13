package com.booking.management.api.services;

import com.booking.management.api.helpers.SqlConnection;
import com.booking.management.api.model.City;
import com.booking.management.api.model.State;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    public List<City> getCityByCode(String stateCode) {
        Connection conn = SqlConnection.connect();
        List<City> cityList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from CITY where state_id = (select id from STATE where code = '"+stateCode+"')");
            if(rs != null) {
                while(rs.next()) {
                    cityList.add(new City(rs.getString("CODE"),
                            rs.getString("TITLE")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }
}
