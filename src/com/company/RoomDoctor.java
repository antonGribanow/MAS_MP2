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

class X { // z atrubutem
    private String str;

    public X(String str) {
        this.str = str;
    }
}

class Y { // bez atrybutu
 private String str = "źegnam";
}

class Z {
    String s = "hej";
X x = new X(s);


X x = new X();

Y y = new Y();
}
