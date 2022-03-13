package com.booking.management.api.services;

import com.booking.management.api.helpers.SqlConnection;
import com.booking.management.api.model.*;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TheaterService {
    public Map<String, List<TheaterAddress>> getTheatersByCityCode(String cityCode, String movieId) {
        Connection conn = SqlConnection.connect();
//        List<Theater> listTheaters = new ArrayList<>();
        Map<String, List<TheaterAddress>> map = new HashMap<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select \n" +
                    "\ttm.id THEATER_MOVIE_ID,\n" +
                    "\tt.TITLE,\n" +
                    "\tt.CODE,\n" +
                    "\tt.id THEATER_ID,\n" +
                    "\tm.ID MOVIE_ID,\t\n" +
                    "\tm.TITLE MOVIE_NAME,\n" +
                    "\tm.MOVIE_TYPE M_TYPE,\n" +
                    "\ta.STREET_NO,\n" +
                    "\ta.LANDMARK,\n" +
                    "\tc2.TITLE,\n" +
                    "\tm.GENRE,\n" +
                    "\ta.STREET_NO,\n" +
                    "\ta.LANDMARK,\n" +
                    "\ttm.MOVIE_STATUS CURRENT_STATUS,\n" +
                    "\ttm.MOVIE_TIME\n" +
                    "from \n" +
                    "\tTHEATER t,\n" +
                    "\tADDRESS a,\n" +
                    "\tMOVIE m,\n" +
                    "\tTHEATER_MOVIE tm,\n" +
                    "\tCITY c2\t \n" +
                    "where \n" +
                    "\tt.ADDRESS_ID = a.ID \n" +
                    "\tand tm.MOVIE_ID = m.ID \n" +
                    "\tand tm.THEATER_ID = t.ID \n" +
                    "\tand c2.ID = a.CITY_ID\n" +
                    "\tand c2.CODE = 'GGN'\n" +
                    ((movieId != null && !movieId.equals("")) ? "\tand m.ID = "+movieId+"\n" : "")+
                    "\tORDER BY t.CODE ");

            if(rs != null) {
                while(rs.next()) {
                    String movieName = rs.getString("MOVIE_NAME");
                    TheaterAddress ta = new TheaterAddress();
                    ta.setTheaterMovieId(rs.getInt("THEATER_MOVIE_ID"));
                    ta.setTheaterId(rs.getInt("THEATER_ID"));
                    ta.setMovieId(rs.getInt("MOVIE_ID"));
//                    ta.setTheaterOccupancy(rs.getInt("THEATER_OCCUPANCY"));

                    MovieDetails md = new MovieDetails();
                    md.setGenre(rs.getString("GENRE"));
                    md.setIsAvailable(rs.getString("CURRENT_STATUS"));
                    md.setMovieType(rs.getString("M_TYPE"));
//                    md.setTicketPrice(rs.getString("TICKET_PRICE"));
                    md.setStreet(rs.getString("STREET_NO"));
                    md.setLandMark(rs.getString("LANDMARK"));
                    md.setMovieName(movieName);
//                    md.setMovieClass(rs.getString("SEATING_CLASS"));

                    Map<String, MovieDetails> mp = new HashMap<>();
                    mp.put(rs.getString("MOVIE_TIME"), md);
                    ta.setMovieDetails(mp);

                    if(map.get(movieName) == null ) {
                        List<TheaterAddress> lst = new ArrayList<>();
                        lst.add(ta);
                        map.put(rs.getString("MOVIE_NAME"), lst);

                    } else {
                        map.get(rs.getString("MOVIE_NAME")).add(ta);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
