package com.booking.management.api.services;

import com.booking.management.api.helpers.SqlConnection;
import com.booking.management.api.model.TheaterResponse;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BookingService {

    public String bookTicket(Integer theaterMovieId, Integer[] theaterSeatingArrangementId, Integer userId) {
        Connection conn = SqlConnection.connect();
        String status = "";
        try {
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("insert into MOVIE_BOOKING (USER_ID, THEATER_MOVIE_ID,THEATER_SEATING_ARRANGEMENTS_ID, BOOKING_STATUS) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            for(int tsaId: theaterSeatingArrangementId) {
                stmt.setInt(1, userId);
                stmt.setInt(2,theaterMovieId);
                stmt.setInt(3,tsaId);
                stmt.setInt(4,1); // 1 stands for Seat is booked.
                stmt.addBatch();
                stmt.clearParameters();
            }

            int[] results = stmt.executeBatch();
            status = results.length+" records inserted";

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    public Map<String, List<TheaterResponse>> getTheaterDetails(String theaterMovieId, String movieTime,  Integer userId) {
        Connection conn = SqlConnection.connect();
        Map<String, List<TheaterResponse>> map = new HashMap<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select \n" +
                    "\ttsa.ID,\t\n" +
                    "\ttm.ID THEATER_MOVIE_ID ,\n" +
                    "\ttsa.SEAT_CLASS,\n" +
                    "\ttsa.SEAT_LABEL,\n" +
                    "\t(\n" +
                    "\t CASE WHEN (select \n" +
                    "\t    \t\tCOUNT(*) \n" +
                    "\t    \t\tfrom \n" +
                    "\t    \t\tMOVIE_BOOKING mb \n" +
                    "\t    \twhere mb.THEATER_SEATING_ARRANGEMENTS_ID = tsa.id and BOOKING_STATUS = 1) > 0\n" +
                    "\t THEN 0\t    \n" +
                    "     ELSE 1\n" +
                    "     END\n" +
                    "     ) as SEATS_AVAILABLE\n" +
                    "from \n" +
                    "\tTHEATER_SEATING_ARRANGEMENTS tsa,\n" +
                    "\tTHEATER_MOVIE tm,\n" +
                    "\tMOVIE m,\n" +
                    "\tTHEATER t\n" +
                    "WHERE\n" +
                    "\ttsa.THEATER_ID = tm.THEATER_ID \n" +
                    "\tand m.ID = tm.MOVIE_ID\n" +
                    "\tand t.ID = tm.THEATER_ID\n" +
                    "\tand tm.MOVIE_TIME = '"+movieTime+"'\n" +
                    "\tand tm.ID = "+theaterMovieId+""
            );

            if(rs != null) {
                while(rs.next()) {
                    String seatClass = rs.getString("SEAT_CLASS");
                    TheaterResponse ta = new TheaterResponse();
                    ta.setTheaterArrangementId(rs.getInt("ID"));
                    ta.setSeatClass(seatClass);
                    ta.setSeatLabel(rs.getString("SEAT_LABEL"));
                    ta.setSeatAvailable(rs.getBoolean("SEATS_AVAILABLE"));
                    if(map.get(seatClass.equals("P")? "Premium" : "Basics") == null ) {
                        List<TheaterResponse> lst = new ArrayList<>();
                        lst.add(ta);
                        map.put(seatClass.equals("P")? "Premium" : "Basics", lst);

                    } else {
                        map.get(seatClass.equals("P")? "Premium" : "Basics").add(ta);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public String cancelTicket(Integer theaterMovieId, Integer[] theaterSeatingArrangementId, Integer userId) {
        Connection conn = SqlConnection.connect();
        String status = "";
        try {
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("update MOVIE_BOOKING set BOOKING_STATUS = 0 where THEATER_SEATING_ARRANGEMENTS_ID = ? and THEATER_MOVIE_ID = ? and USER_ID=?; ", Statement.RETURN_GENERATED_KEYS);

            for(int tsaId: theaterSeatingArrangementId) {
                stmt.setInt(1,tsaId);
                stmt.setInt(2,theaterMovieId);
                stmt.setInt(3, userId);
                stmt.addBatch();
                stmt.clearParameters();
            }

            int[] results = stmt.executeBatch();
            status = results.length+" rows affected";

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }
}
