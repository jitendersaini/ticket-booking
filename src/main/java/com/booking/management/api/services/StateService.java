package com.booking.management.api.services;

import com.booking.management.api.helpers.SqlConnection;
import com.booking.management.api.model.Country;
import com.booking.management.api.model.State;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {
    public List<State> getCountryByCode(String countryCode) {
        Connection conn = SqlConnection.connect();
        List<State> statesList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from STATE where country_id = (select id from COUNTRY where code = '"+countryCode+"')");
            if(rs != null) {
                while(rs.next()) {
                    statesList.add(new State(rs.getString("CODE"),
                            rs.getString("TITLE")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statesList;
    }
}
