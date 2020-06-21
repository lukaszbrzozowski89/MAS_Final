/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import pl.pjatk.s17174.final_project.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Class to store data about that - inherit from Person
 * links with FlightInstance with cardinality 1..* - 1..*
 *
 * @author Lukasz
 * @see Flight.FlightInstance
 */
public class Steward extends Person {

    private static int counter = 1;
    private int evidenceId;
    private ArrayList<String> languages = new ArrayList<>();


    public Steward(String name, String surname, LocalDate dateOfBirth, Address address, ArrayList<String> languages) throws Exception {
        super(name, surname, dateOfBirth, address);
        this.evidenceId = counter++;
        if (languages.size() < 2) {
            Utils.showAlertDialog("Steward musi znac przynajmniej 2 jezyki");
            throw new Exception();
        }
        this.languages = languages;
    }

    public static int getCounter() {
        return counter;
    }

    public int getEvidenceId() {
        return evidenceId;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Steward{" +
                "evidenceId=" + evidenceId +
                ", languages=" + languages +
                '}';
    }
}
