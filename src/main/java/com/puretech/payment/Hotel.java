package com.puretech.payment;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Booking bookRoom(String type, String guestName, LocalDate startDate, LocalDate endDate) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getType().equalsIgnoreCase(type)) {
                room.book();
                Booking booking = new Booking(guestName, room, startDate, endDate);
                bookings.add(booking);
                System.out.println("Room " + room.getRoomNumber() + " booked for " + guestName);
                return booking;
            }
        }
        System.out.println("No available room found!");
        return null;
    }

    public void cancelBooking(Booking booking) {
        booking.getRoom().release();
        bookings.remove(booking);
        System.out.println("Booking cancelled for room " + booking.getRoom().getRoomNumber());
    }
}

