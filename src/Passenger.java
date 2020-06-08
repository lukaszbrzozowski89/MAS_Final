/*
 * Copyright (c) 2020
 * Łukasz Brzozowski (s17174) @ PJATK
 */


import java.time.LocalDate;

public class Passenger extends Person {

    private int id;
    private static int counter = 1;
    private String email;
    private String phoneNumber;

    public Passenger(String name, String surname, LocalDate dateOfBirth, Address address, String email, String phoneNumber) {
        super(name, surname, dateOfBirth, address);
        this.id = counter++;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getCounter() {
        return counter;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
