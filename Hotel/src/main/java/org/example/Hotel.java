package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {

    private String hotelName;
    private List<Guest> hotelGuestList;
    private List<Room> hotelRoomList;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.hotelGuestList = new ArrayList<>();
        this.hotelRoomList = new ArrayList<>();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Guest> getHotelGuestList() {
        return hotelGuestList;
    }

    public void setHotelGuestList(List<Guest> hotelGuestList) {
        this.hotelGuestList = hotelGuestList;
    }

    public List<Room> getHotelRoomList() {
        return hotelRoomList;
    }

    public void setHotelRoomList(List<Room> hotelRoomList) {
        this.hotelRoomList = hotelRoomList;
    }

    public void addGuest(String guestName, String guestSurname) {
        Guest guest = new Guest(guestName, guestSurname);
        hotelGuestList.add(guest);
    }

    public void addRoom(int roomNumber) {
        Room room = new Room(roomNumber);
        hotelRoomList.add(room);
    }

    Room findRoomByNumber(int roomNumber) {
        for (Room room : hotelRoomList) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private Guest findGuestByName(String guestName) {
        for (Guest guest : hotelGuestList) {
            if (guest.getName().equals(guestName)) {
                return guest;
            }
        }
        return null;
    }

    public Map<Integer, String> getRoomsAndGuests() {
        Map<Integer, String> roomsAndGuests = new HashMap<>();
        for (Room room : hotelRoomList) {
            int roomNumber = room.getRoomNumber();
            List<Guest> guestList = room.getHotelGuestList();
            if (!guestList.isEmpty()) {
                StringBuilder guests = new StringBuilder();
                for (Guest guest : guestList) {
                    guests.append(guest.getName()).append(" ").append(guest.getSurname()).append(", ");
                }
                guests.delete(guests.length() - 2, guests.length());
                roomsAndGuests.put(roomNumber, guests.toString());
            } else {
                roomsAndGuests.put(roomNumber, "Vacant");
            }
        }
        return roomsAndGuests;
    }
}
