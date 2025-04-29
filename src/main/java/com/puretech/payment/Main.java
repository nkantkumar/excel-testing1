package com.puretech.payment;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room(101, "Single"));
        hotel.addRoom(new Room(102, "Double"));
        hotel.addRoom(new Room(103, "Suite"));

        Booking b1 = hotel.bookRoom("Single", "Alice", LocalDate.now(), LocalDate.now().plusDays(2));
        Booking b2 = hotel.bookRoom("Double", "Bob", LocalDate.now(), LocalDate.now().plusDays(3));

        if (b1 != null) {
            hotel.cancelBooking(b1);
        }
    }
}
