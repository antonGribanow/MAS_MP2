package com.company;

import java.io.Serializable;
import java.util.*;

public class Patient implements Serializable {
    public final UUID id;
    public final List<Test> enduredTest;
    public final List<String> additionalInfo;
    public final List<Visit> visits;


    public Patient(List<Test> enduredTest, List<String> additionalInfo) {
        this.id = UUID.randomUUID();
        this.enduredTest = enduredTest;
        this.additionalInfo = additionalInfo;
        this.visits = new ArrayList<>();
    }

    public void addVisit(Visit visit) { // todo asocjacja kwalifikowana - reverse connection
        if (!visits.contains(visit)) {
            visits.add(visit);
        }
    }
}
