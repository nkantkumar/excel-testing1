package com.puretech.payment;

import java.time.LocalDate;

public class Booking {
    private String guestName;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(String guestName, Room room, LocalDate startDate, LocalDate endDate) {
        this.guestName = guestName;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Room getRoom() {
        return room;
    }
}
