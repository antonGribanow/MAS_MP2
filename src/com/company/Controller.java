//package com.company;
//
//package MP2;
//
//import java.io.*;
//import java.util.*;
//
//
//
//public class Controller {
//    private static final String FILE_LOCATION = "db.txt";
//    private static final int CORRECT_EXIT_STATUS = 69;
//    private final static Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        String userInput = "0";
//        while (!userInput.equals("5")) {
//            displayMainMenu();
//            userInput = scanner.nextLine();
//            switch (userInput) {
//                case "1" -> createVisit();
//                case "2" -> displayVisit();
//                case "3" -> serialise();
//                case "4" -> deserialize();
//                case "5" -> exit();
//            }
//        }
//    }
//
//    public static void serialise() {
//        try {
//            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_LOCATION));
//            Visit.writeExtent(outputStream);
//            outputStream.flush();
//            outputStream.close();
//            System.out.println("Serialised!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void deserialize() {
//        try {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_LOCATION));
//            Visit.readExtent(inputStream);
//            inputStream.close();
//            System.out.println("Deserialized!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void displayMainMenu() {
//        System.out.println("1. Create a visit");
//        System.out.println("2. Display your reservations for visits");
//        System.out.println("3. Save to file");
//        System.out.println("4. Read from file");
//        System.out.println("5. Exit");
//    }
//
//    public static void createVisit() {
//        Test enduredTest = getTest();
//        Visit visit = new Visit(
//                new GregorianCalendar(2022, Calendar.JULY, 13),
//                new Room(
//                        Arrays.asList(
//                                "Scalpel",
//                                "Manometer"
//                        ),
//                        Collections.singletonList(createRoomDoctor(Collections.singletonList(new RoomDoctor()))),
//                        20.5
//                ),
//                "Cash",
//                null,
//                enduredTest,
//                new Patient(
//                        new ArrayList<>(Collections.singleton(enduredTest)),
//                        Arrays.asList(
//                                "I'm allergic to milk",
//                                "I'm scared to loud noises"
//                        )
//                )
//        );
//        System.out.println("Visit created!");
//    }
//
//    private static Test getTest() {
//        return new Test(
//                "MRI",
//                Arrays.asList(
//                        "DO NOT SMOKE",
//                        "DO NOT DO WORKOUT",
//                        "DO NOT EAT"
//                ),
//                300);
//    }
//
//    public static RoomDoctor createRoomDoctor(List<RoomDoctor> roomDoctors){
//        Doctor doctor = new Doctor("Marek", "Markowski", Doctor.Specialisation.NEUROLOGIST, roomDoctors);
//        Room room = new Room(Arrays.asList("Scalpel", "Manometer"), roomDoctors, 30);
//        return new RoomDoctor(doctor, room, "8:00", "18:00");
//    }
//
//    public static void exit() {
//        System.exit(CORRECT_EXIT_STATUS);
//    }
//}