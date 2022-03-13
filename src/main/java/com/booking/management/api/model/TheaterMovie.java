package com.booking.management.api.model;

public class TheaterMovie {
    enum MovieStatus {
        AVAILABLE(1), NOT_AVAILABLE(0);
        private int value;
        private MovieStatus(int value) {
            this.value = value;
        }
    }
}
