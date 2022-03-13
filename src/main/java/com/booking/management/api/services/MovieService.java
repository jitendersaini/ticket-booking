package com.booking.management.api.services;

import com.booking.management.api.helpers.SqlConnection;
import com.booking.management.api.model.Movie;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies() {
        Connection conn = SqlConnection.connect();
        List<Movie> listMovie = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from MOVIE");
            if(rs != null) {
                while(rs.next()) {
                    Movie mv = new Movie();
                    mv.setMovieId(rs.getInt("ID"));
                    mv.setMovieName(rs.getString("TITLE"));
                    mv.setMovieType(rs.getString("MOVIE_TYPE"));
                    mv.setGenre(rs.getString("GENRE"));
                    listMovie.add(mv);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMovie;
    }
}
