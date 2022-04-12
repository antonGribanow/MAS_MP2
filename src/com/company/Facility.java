package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Facility implements Serializable {
    public final UUID id;
    public final String street;
    public final String city;
    public final String code;
    public static final List<Room> allRooms = new ArrayList<>(); // todo kompozycja - statyczna lista!!!!!
    public final List<Room> roomsInFacility;

    public Facility(String street, String city, String code, List<Room> roomsInFacility, List<String> equipment, double roomSurface) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.city = city;
        this.code = code;
        this.roomsInFacility = roomsInFacility;
    }

    public void addRoom(Room room) throws Exception { // todo kompozycja - 2 zasada (część nie może być współdzielona)
        if (allRooms.contains(room)) throw new Exception("Passed room already exists! " + room);
        allRooms.add(room);
        roomsInFacility.add(room);
    }

    public void clearRoomsList(){
        roomsInFacility.clear();
        allRooms.clear();
    }

    @Override
    public String toString() {
        return "Facility: " +
                "facility id: " + id +
                ", street: " + street +
                ", city: " + city +
                ", code: " + code;
    }
}
