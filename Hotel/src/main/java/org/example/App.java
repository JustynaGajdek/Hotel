package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        // Napisz program w języku Java, który umożliwi zarządzanie hotelami bez użycia bazy danych. Dane będą przechowywane tylko w kolekcjach. Program powinien umożliwiać dodawanie nowych hoteli, zarządzanie listą gości w hotelach, listą pokoi w hotelach oraz przypisywanie gości do pokoi w konkretnych hotelach. Poniżej znajduje się szczegółowa lista, co program powinien realizować:
        //Stwórz klasę Hotel, która będzie zawierać pola:
        //nazwa hotelu
        //lista gości (kolekcja)
        //lista pokoi (kolekcja)
        //Stwórz klasę Gosc, która będzie zawierać pola:
        //imię
        //nazwisko
        //Stwórz klasę Pokoj, która będzie zawierać pola:
        //numer pokoju
        //lista gości w pokoju (kolekcja)
        //W głównej klasie programu (np. HotelManager) utwórz kolekcję, w której przechowasz hotele (np. List<Hotel>).
        //Dodaj do głównej klasy metody umożliwiające:
        //dodawanie nowego hotelu do kolekcji
        //dodawanie nowego gościa do konkretnego hotelu
        //dodawanie nowego pokoju do konkretnego hotelu
        //przypisywanie gościa do pokoju w konkretnym hotelu
        //wyświetlanie listy gości w konkretnym hotelu
        //wyświetlanie listy pokoi w konkretnym hotelu wraz z przypisanymi gośćmi
        //Zaimplementuj te metody w sposób umożliwiający interakcję z użytkownikiem (np. przez konsolę).
        //Przykładowe użycie programu:
        //Dodanie hotelu "Hotel A"
        //Dodanie gościa "Jan Kowalski" do "Hotel A"
        //Dodanie pokoju o numerze 101 do "Hotel A"
        //Przypisanie gościa "Jan Kowalski" do pokoju 101 w "Hotel A"
        //Wyświetlenie listy gości w "Hotel A"
        //Wyświetlenie listy pokoi wraz z gośćmi w "Hotel A"
        //Utwórz 2 hotele. Dodaj 2-3 gości do każdego hotelu


        List<Hotel> listOfAvailableHotels = new ArrayList<>();
        HotelManager hotelManager = new HotelManager(listOfAvailableHotels);

        hotelManager.addHotel("Hotel A");

        hotelManager.addGuestToHotel("Hotel A", "Jan", "Kowalski");

        hotelManager.addRoomToHotel("Hotel A", 101);

        hotelManager.assignGuestToRoom("Hotel A", 101, "Jan", "Kowalski");

        hotelManager.displayGuestsInHotel("Hotel A");

        hotelManager.displayRoomsAndGuestsInHotel("Hotel A");

        hotelManager.addHotel("Hotel B");
        hotelManager.addRoomToHotel("Hotel B", 202);
        hotelManager.addRoomToHotel("Hotel B", 203);
        hotelManager.addGuestToHotel("Hotel B", "Anna", "Nowak");
        hotelManager.addGuestToHotel("Hotel B", "Piotr", "Kot");

        hotelManager.assignGuestToRoom("Hotel B",202,"Anna", "Nowak");
        hotelManager.assignGuestToRoom("Hotel B",203,"Piotr", "Kot");

        hotelManager.displayRoomsAndGuestsInHotel("Hotel B");


        hotelManager.addHotel("Hotel C");
        hotelManager.addRoomToHotel("Hotel C", 1);
        hotelManager.addRoomToHotel("Hotel C", 2);
        hotelManager.addRoomToHotel("Hotel C", 3);
        hotelManager.addGuestToHotel("Hotel C", "Maria", "Kowalska");
        hotelManager.addGuestToHotel("Hotel C", "Tomasz", "Nowicki");
        hotelManager.addGuestToHotel("Hotel C", "Ewa", "Wrona");

        hotelManager.assignGuestToRoom("Hotel C",1,"Maria", "Kowalska");
        hotelManager.assignGuestToRoom("Hotel C",2,"Tomasz", "Nowicki");
        hotelManager.assignGuestToRoom("Hotel C",3,"Ewa", "Wrona");

        hotelManager.displayRoomsAndGuestsInHotel("Hotel C");
    }
    }

