/*
 * Copyright (c) 2020
 * Łukasz Brzozowski (s17174) @ PJATK
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Steward extends Person {

    private static int counter = 1;
    private int evidenceId;
    private ArrayList<String> languages = new ArrayList<>();


    public Steward(String name, String surname, LocalDate dateOfBirth, Address address, int evidenceId, ArrayList<String> languages) {
        super(name, surname, dateOfBirth, address);
        this.evidenceId = evidenceId;
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
