package com.puretech.payment;

import java.time.LocalDate;
import java.util.*;

public class Room {
    private int roomNumber;
    private String type; // Single, Double, Suite
    private boolean isBooked;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }

    public boolean isAvailable() {
        return !isBooked;
    }

    public void book() {
        isBooked = true;
    }

    public void release() {
        isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }
}



