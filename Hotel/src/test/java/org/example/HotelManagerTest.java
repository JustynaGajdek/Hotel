package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class HotelManagerTest {
    private HotelManager hotelManager;

    @Test
    public void addHotelTest() {
        // Given
        List<Hotel> listOfAvailableHotels = new ArrayList<>();
        hotelManager = new HotelManager(listOfAvailableHotels);
        String hotelName = "Hotel A";

        // When
        hotelManager.addHotel(hotelName);

        // Then
        Assertions.assertEquals(1, listOfAvailableHotels.size());
        Hotel addedHotel = listOfAvailableHotels.get(0);
        Assertions.assertEquals(hotelName, addedHotel.getHotelName());
    }

    @Test
    public void addGuestToHotelTest() {
        // Given
        List<Hotel> listOfAvailableHotels = new ArrayList<>();
        hotelManager = new HotelManager(listOfAvailableHotels);
        String hotelName = "Hotel A";
        String guestName = "Jan";
        String guestSurname = "Kowalski";
        hotelManager.addHotel(hotelName);

        // When
        hotelManager.addGuestToHotel(hotelName, guestName, guestSurname);

        // Then
        Hotel hotel = listOfAvailableHotels.get(0);
        List<Guest> guestList = hotel.getHotelGuestList();
        Assertions.assertEquals(1, guestList.size());
        Guest addedGuest = guestList.get(0);
        Assertions.assertEquals(guestName, addedGuest.getName());
        Assertions.assertEquals(guestSurname, addedGuest.getSurname());
    }

    @Test
    public void addRoomToHotelTest() {
        // Given
        List<Hotel> listOfAvailableHotels = new ArrayList<>();
        hotelManager = new HotelManager(listOfAvailableHotels);
        String hotelName = "Hotel A";
        int roomNumber = 101;
        hotelManager.addHotel(hotelName);

        // When
        hotelManager.addRoomToHotel(hotelName, roomNumber);

        // Then
        Hotel hotel = listOfAvailableHotels.get(0);
        List<Room> roomList = hotel.getHotelRoomList();
        Assertions.assertEquals(1, roomList.size());
        Room addedRoom = roomList.get(0);
        Assertions.assertEquals(roomNumber, addedRoom.getRoomNumber());
    }

    @Test
    public void assignGuestToRoomTest() {
        // Given
        List<Hotel> listOfAvailableHotels = new ArrayList<>();
        hotelManager = new HotelManager(listOfAvailableHotels);
        String hotelName = "Hotel A";
        int roomNumber = 101;
        String guestName = "Jan";
        String guestSurname = "Kowalski";
        hotelManager.addHotel(hotelName);
        hotelManager.addRoomToHotel(hotelName, roomNumber);

        // When
        hotelManager.assignGuestToRoom(hotelName, roomNumber, guestName, guestSurname);

        // Then
        Hotel hotel = listOfAvailableHotels.get(0);
        Room room = hotel.findRoomByNumber(roomNumber);
        Assertions.assertNotNull(room);
        List<Guest> guestList = room.getHotelGuestList();
        Assertions.assertEquals(1, guestList.size());
        Guest assignedGuest = guestList.get(0);
        Assertions.assertEquals(guestName, assignedGuest.getName());
        Assertions.assertEquals(guestSurname, assignedGuest.getSurname());
    }

    @Test
    public void displayGuestsInTheHotelTest() {

        // Given
        List<Hotel> listOfAvailableHotels = new ArrayList<>();
        hotelManager = new HotelManager(listOfAvailableHotels);
        Hotel hotel = new Hotel("Hotel A");
        hotel.addGuest("Jan", "Kowalski");
        hotel.addGuest("Anna", "Nowak");
        hotelManager.getListOfAvailableHotels().add(hotel);

        // When
        hotelManager.displayGuestsInHotel("Hotel A");

        // Then
        List<Guest> guests = hotel.getHotelGuestList();
        Assertions.assertEquals(2, guests.size());
        Assertions.assertEquals("Jan", guests.get(0).getName());
        Assertions.assertEquals("Kowalski", guests.get(0).getSurname());
        Assertions.assertEquals("Anna", guests.get(1).getName());
        Assertions.assertEquals("Nowak", guests.get(1).getSurname());
    }

    @Test
    public void displayRoomsAndGuestsInTheHotelTest() {
        // Given
        List<Hotel> listOfAvailableHotels = new ArrayList<>();
        hotelManager = new HotelManager(listOfAvailableHotels);
        Hotel hotel = new Hotel("Hotel A");
        hotel.addRoom(101);
        hotel.addRoom(102);
        hotel.addGuest("Jan", "Kowalski");
        hotelManager.getListOfAvailableHotels().add(hotel);

        // When
        hotelManager.assignGuestToRoom("Hotel A", 101, "Jan", "Kowalski");
        hotelManager.displayRoomsAndGuestsInHotel("Hotel A");

        // Then
        Map<Integer, String> roomsAndGuests = hotel.getRoomsAndGuests();
        Assertions.assertEquals(2, roomsAndGuests.size());
        Assertions.assertEquals("Jan Kowalski", roomsAndGuests.get(101));
        Assertions.assertEquals("Vacant", roomsAndGuests.get(102));
    }
}
