package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int roomNumber;
    private List<Guest> hotelGuestList;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.hotelGuestList = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Guest> getHotelGuestList() {
        return hotelGuestList;
    }

    public void setHotelGuestList(List<Guest> hotelGuestList) {
        this.hotelGuestList = hotelGuestList;
    }
}
