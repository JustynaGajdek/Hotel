package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    private Hotel hotel;


    @Test
    public void addGuestToTheHotelTest() {

        // Given
        hotel = new Hotel("Hotel A");
        hotel.addGuest("Jan", "Kot");
        hotel.addGuest("Julia", "Rak");

        // When
        List<Guest> guestList = hotel.getHotelGuestList();

        // Then
        Assertions.assertEquals(2, guestList.size());

        Guest guest1 = guestList.get(0);
        Assertions.assertEquals("Jan", guest1.getName());
        Assertions.assertEquals("Kot", guest1.getSurname());

        Guest guest2 = guestList.get(1);
        Assertions.assertEquals("Julia", guest2.getName());
        Assertions.assertEquals("Rak", guest2.getSurname());
    }

    @Test
    public void addRoomToTheHotelTest() {

        // Given
        hotel = new Hotel("Hotel A");
        hotel.addRoom(101);
        hotel.addRoom(102);

        // When
        List<Room> roomList = hotel.getHotelRoomList();


        // Then
        Room room1 = roomList.get(0);
        Room room2 = roomList.get(1);

        Assertions.assertEquals(2, roomList.size());
        Assertions.assertEquals(101, room1.getRoomNumber());
        Assertions.assertEquals(102, room2.getRoomNumber());
    }

    @Test
    public void findRoomByNumberTest() {

        // Given
        hotel = new Hotel("Hotel A");
        hotel.addRoom(101);
        hotel.addRoom(102);

        // When
        Room foundExistentRoom = hotel.findRoomByNumber(101);
        Room nonExistentRoom = hotel.findRoomByNumber(103);

        // Then
        Assertions.assertNotNull(foundExistentRoom);
        Assertions.assertEquals(101, foundExistentRoom.getRoomNumber());
        Assertions.assertNull(nonExistentRoom);
    }

    @Test
    public void getRoomsAndGuestsMapForTheHotelTest() {

        // Given
        hotel = new Hotel("Hotel A");
        hotel.addRoom(101);
        hotel.addRoom(102);

        hotel.addGuest("Jan", "Kot");
        hotel.addGuest("Julia", "Rak");
        List<Room> roomList = hotel.getHotelRoomList();
        List<Guest> guestList = hotel.getHotelGuestList();
        roomList.get(0).getHotelGuestList().add(guestList.get(0));
        roomList.get(1).getHotelGuestList().add(guestList.get(1));

        // When
        Map<Integer, String> roomsAndGuests = hotel.getRoomsAndGuests();

        // Then
        Assertions.assertEquals(2, roomsAndGuests.size());
        Assertions.assertEquals("Jan Kot", roomsAndGuests.get(101));
        Assertions.assertEquals("Julia Rak", roomsAndGuests.get(102));
    }
}
