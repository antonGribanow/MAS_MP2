package com.company;

public class RoomDoctor { // todo asocjacja z atrybutem
    public final Doctor doctor;
    public final Room room;
    public final String startHour;
    public final String endHour;

    public RoomDoctor(Doctor doctor, Room room, String startHour, String endHour) {
        this.doctor = doctor;
        this.room = room;
        this.startHour = startHour;
        this.endHour = endHour;
    }

}
