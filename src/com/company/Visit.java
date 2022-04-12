package com.company;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Visit implements Serializable {
    public static int basicVisitCost = 200;
    public final UUID idVisit;
    public final GregorianCalendar visitDate;
    public final Room room; // todo asocjacja zwykla
    public final String paymentMethod;
    public String additionalInformation = null;
    public final Test test;
    public final Patient patient;
    private static List<Visit> allVisits = new ArrayList<>();
    public final Map<UUID, Patient> uuidPatientMap; // todo asocjacja kwalifikowana
    /* -- mapa
    1hdjagsjkdhajkdsakjsd12313@#$jhijohjdsf38475389475 -> Maciek,
    2 -> Anton
     */

    public Visit(GregorianCalendar visitDate,
                 Room room,
                 String paymentMethod,
                 String additionalInformation,
                 Test test,
                 Patient patient) {
        this.idVisit = UUID.randomUUID();
        this.visitDate = visitDate;
        this.room = room;
        this.paymentMethod = paymentMethod;
        this.additionalInformation = additionalInformation;
        this.test = test;
        this.patient = patient;
        this.uuidPatientMap = new TreeMap<>();
//        addVisit(this);
    }

    public void addUuidPatient(Patient patient) throws Exception { // todo asocjacja kwalifikowana - dodawanie
        if (!uuidPatientMap.containsKey(patient.id)) {
            uuidPatientMap.put(patient.id, patient);
            patient.addVisit(this); // todo reverse connection
        }
        throw new Exception("Object with this id already is added!");
    }

    public Patient findPatientByUuid(UUID uuid) throws Exception { // todo asocjacja kwalifikowana - wyszukiwanie
        if (!uuidPatientMap.containsKey(uuid)) throw new Exception("Unable to find Patient with UUID: " + uuid);
        return uuidPatientMap.get(uuid);
    }

//    public Visit(GregorianCalendar visitDate, Room room, String paymentMethod, Test test, Patient patient) {
//        this.idVisit = UUID.randomUUID();
//        this.visitDate = visitDate;
//        this.room = room;
//        this.paymentMethod = paymentMethod;
//        this.test = test;
//        this.patient = patient;
//        addVisit(this);
//    }

//    public static void addVisit(Visit visit) { //
//        allVisits.add(visit);
//    }

    public int getVisitCost(Test test) {
        return basicVisitCost + test.cost;
    }

    @Override
    public String toString() {
        return "Visit: " +
                "visit id: " + idVisit +
                ", visitDate: " + visitDate.get(Calendar.DATE) +
                "." + visitDate.get(Calendar.MONTH) +
                "." + visitDate.get(Calendar.YEAR) +
                ", room: " + room.toString() +
                ", paymentMethod: " + paymentMethod +
                ", additionalInformation: " + additionalInformation +
                ", visitCost: " + getVisitCost(test) +
                ", test: " + test +
                '}';
    }

    public static void writeExtent(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.writeObject(allVisits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExtent(ObjectInputStream objectInputStream) {
        try {
            allVisits = (ArrayList<Visit>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayVisit() {
        for (Visit visit : allVisits) {
            System.out.println(visit);
        }
    }

    public static void changeBasicVisitCost(int newCost) {
        basicVisitCost = newCost;
    }


}
