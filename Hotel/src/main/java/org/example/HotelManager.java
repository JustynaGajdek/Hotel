package org.example;

import java.util.List;
import java.util.Map;

public class HotelManager {

    private List<Hotel> listOfAvailableHotels;

    public HotelManager(List<Hotel> listOfAvailableHotels) {
        this.listOfAvailableHotels = listOfAvailableHotels;
    }


    public List<Hotel> getListOfAvailableHotels() {
        return listOfAvailableHotels;
    }

    public void setListOfAvailableHotels(List<Hotel> listOfAvailableHotels) {
        this.listOfAvailableHotels = listOfAvailableHotels;
    }

    public void addHotel(String hotelName) {
        Hotel hotel;
        hotel = new Hotel(hotelName);
        listOfAvailableHotels.add(hotel);
    }

    private Hotel findHotelByName(String hotelName) {
        for (Hotel hotel : listOfAvailableHotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }

    public void addGuestToHotel(String hotelName, String guestName, String guestSurname) {
        Hotel hotel = findHotelByName(hotelName);
        if (hotel != null) {
            hotel.addGuest(guestName, guestSurname);
            System.out.println("Added guest " + guestName + " to hotel " + hotelName + ".");
        } else {
            System.out.println("Hotel " + hotelName + " doesn't exist.");
        }
    }

    public void addRoomToHotel(String hotelName, int roomNumber) {
        Hotel hotel = findHotelByName(hotelName);
        if (hotel != null) {
            hotel.addRoom(roomNumber);
            System.out.println("Added room:" + roomNumber + " to hotel " + hotelName + ".");
        } else {
            System.out.println("Hotel " + hotelName + " does not exist.");
        }
    }

    public void assignGuestToRoom(String hotelName, int roomNumber, String guestName, String guestSurname) {
        Hotel hotel = findHotelByName(hotelName);
        if (hotel != null) {
            Room room = hotel.findRoomByNumber(roomNumber);
            if (room != null) {
                Guest guest = new Guest(guestName, guestSurname);
                room.getHotelGuestList().add(guest);
                System.out.println("Assigned guest " + guestName + " to room: " + roomNumber + " in hotel " + hotelName + ".");
            } else {
                System.out.println("Room " + roomNumber + " doesn't exist in hotel " + hotelName + ".");
            }
        } else {
            System.out.println("Hotel " + hotelName + " does not exist.");
        }
    }

    public void displayGuestsInHotel(String hotelName) {
        Hotel hotel = findHotelByName(hotelName);
        if (hotel != null) {
            List<Guest> guests = hotel.getHotelGuestList();
            if (!guests.isEmpty()) {
                System.out.println("Guests in hotel " + hotelName + ":");
                for (Guest guest : guests) {
                    System.out.println("Name: " + guest.getName() + ", Surname: " + guest.getSurname());
                }
            } else {
                System.out.println("No guests in hotel " + hotelName + ".");
            }
        } else {
            System.out.println("Hotel " + hotelName + "' doesn't exist.");
        }
    }

    public void displayRoomsAndGuestsInHotel(String hotelName) {
        Hotel hotel = findHotelByName(hotelName);
        if (hotel != null) {
            Map<Integer, String> roomsAndGuests = hotel.getRoomsAndGuests();
            if (!roomsAndGuests.isEmpty()) {
                System.out.println("Rooms and guests in hotel " + hotelName + ":");
                for (Map.Entry<Integer, String> entry : roomsAndGuests.entrySet()) {
                    int roomNumber = entry.getKey();
                    String guestName = entry.getValue();
                    System.out.println("Room: " + roomNumber + ", Guest: " + guestName );
                }
            } else {
                System.out.println("No rooms and guests in hotel " + hotelName + ".");
            }
        } else {
            System.out.println("Hotel " + hotelName + " does not exist.");
        }
    }
}