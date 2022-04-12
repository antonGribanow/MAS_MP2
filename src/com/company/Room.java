package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Room implements Serializable {

    public final List<String> equipment;
    public final List<RoomDoctor> roomDoctors;  // todo odniesienie do klasy asocjacyjnej / asocjacja zwykłą
    private Facility facility;
    double roomSurface;

    private Room(List<String> equipment, Facility facility, double roomSurface) { // todo kompozycja - 1 zasada (PRYWATNY KONSTRUKTOR)
        this.equipment = equipment;
        this.facility = facility;
        this.roomSurface = roomSurface;
        this.roomDoctors = new ArrayList<>();
    }

    public static Room createRoom(List<String> equipment, Facility facility, double roomSurface) throws Exception { // todo kompozycja - 1 zasada (nie może istnieć część bez całości)
        if (facility == null) {
            throw new Exception("No facility");
        }
//        createRoom(equipment, facility, roomSurface); - TAK NIE ROBIMY
        Room room = new Room(equipment, facility, roomSurface);
        facility.addRoom(room);
        return room;
    }

    public void deleteFacility() { // todo kompozycja - 3 zasada (gdy niszczymy całość to niszczymy też wszystkie części)
        facility = null;
    }

    @Override
    public String toString() {
        return "equipment=" + equipment +
                ", roomSurface=" + roomSurface +
                '}';
    }
}