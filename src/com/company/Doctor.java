package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor {
    public final UUID id;
    public final String name;
    public final String surname;
    public final Specialisation specialisation;
    public final List<RoomDoctor> roomDoctors; // todo odniesienie do klasy asocjacyjnej

    public Doctor(String name, String surname, Specialisation specialisation) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.specialisation = specialisation;
        this.roomDoctors = new ArrayList<>();
    }

    public enum Specialisation {
        BASIC,
        NEUROLOGIST
    }

}
