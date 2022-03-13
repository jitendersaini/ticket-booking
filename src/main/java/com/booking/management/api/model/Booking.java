package com.booking.management.api.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

enum PaymentStatus {
    PAID,
    UNPAID;
}

public class Booking implements Serializable {
    private static final long serialVersionUID = -3690235902575647142L;

    private int bookingId;
    private int userId;
    private int movieId;
    private List<Movie> bookedSeats;
    private int amount;
    private PaymentStatus status_of_payment;
    private Date booked_date;
    private Time movie_timing;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public List<Movie> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Movie> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus_of_payment() {
        return status_of_payment;
    }

    public void setStatus_of_payment(PaymentStatus status_of_payment) {
        this.status_of_payment = status_of_payment;
    }

    public Date getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(Date booked_date) {
        this.booked_date = booked_date;
    }

    public Time getMovie_timing() {
        return movie_timing;
    }

    public void setMovie_timing(Time movie_timing) {
        this.movie_timing = movie_timing;
    }
}
