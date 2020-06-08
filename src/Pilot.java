/*
 * Copyright (c) 2020
 * Łukasz Brzozowski (s17174) @ PJATK
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Pilot extends Person {

    private static int counter = 1;
    private int licenseId;
    private ArrayList<Plane> licenses = new ArrayList<>();
    private LocalDate dateOfExamsValidity;

    public Pilot(String name, String surname, LocalDate dateOfBirth, Address address, int licenseId, ArrayList<Plane> licenses, LocalDate dateOfExamsValidity) {
        super(name, surname, dateOfBirth, address);
        this.licenseId = licenseId;
        this.licenses = licenses;
        this.dateOfExamsValidity = dateOfExamsValidity;
    }

    public void setLicenses(ArrayList<Plane> licenses) {
        this.licenses = licenses;
    }

    public void setDateOfExamsValidity(LocalDate dateOfExamsValidity) {
        this.dateOfExamsValidity = dateOfExamsValidity;
    }

    public static int getCounter() {
        return counter;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public ArrayList<Plane> getLicenses() {
        return licenses;
    }

    public LocalDate getDateOfExamsValidity() {
        return dateOfExamsValidity;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "licenseId=" + licenseId +
                ", licenses=" + licenses +
                ", dateOfExamsValidity=" + dateOfExamsValidity +
                '}';
    }
}
