/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class to create a pilot and store data about that - inherit from Person
 * links with FlightInstance with cardinality 2 - 1..*
 *
 * @author Lukasz
 * @see pl.pjatk.s17174.final_project.main.Flight.FlightInstance
 */
public class Pilot extends Person {

    private static int counter = 1;
    private int licenseId;
    private ArrayList<Plane> licenses = new ArrayList<>();
    private LocalDate dateOfExamsValidity;
    private int id;

    public Pilot(String name, String surname, LocalDate dateOfBirth, Address address, int licenseId, ArrayList<Plane> licenses, LocalDate dateOfExamsValidity) {
        super(name, surname, dateOfBirth, address);
        this.id = counter++;
        this.licenseId = licenseId;
        this.licenses = licenses;
        this.dateOfExamsValidity = dateOfExamsValidity;
    }

    public static Pilot checkExamsValidity() {
//     if ()
        return null;
    }

    public static int getCounter() {
        return counter;
    }

    public void addLicense(Plane plane) {
        licenses.add(plane);
    }

    public int getLicenseId() {
        return licenseId;
    }

    public ArrayList<Plane> getLicenses() {
        return licenses;
    }

    public void setLicenses(ArrayList<Plane> licenses) {
        this.licenses = licenses;
    }

    public LocalDate getDateOfExamsValidity() {
        return dateOfExamsValidity;
    }

    public void setDateOfExamsValidity(LocalDate dateOfExamsValidity) {
        this.dateOfExamsValidity = dateOfExamsValidity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pilot:" + getName() + " " + getSurname();
    }
}
