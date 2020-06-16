/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package data;/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */


import java.time.LocalDate;

/**
 * Class which stores data about passenger
 * links with:
 * 1. Plane with cardinality 0..1 - 1..*
 * 2. Luggage with cardinality 0..1 - 1..*
 *
 * @author Lukasz
 * @see Plane
 * @see Luggage
 */
public class Passenger extends Person {

    private static int counter = 1;
    private int id;
    private String email;
    private String phoneNumber;

    public Passenger(String name, String surname, LocalDate dateOfBirth, Address address, String email, String phoneNumber) {
        super(name, surname, dateOfBirth, address);
        this.id = counter++;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void chooseFlight(Flight.FlightInstance flightInstance) {
        //todo
    }

    public void chooseSeat(int seat) {
        //todo
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
