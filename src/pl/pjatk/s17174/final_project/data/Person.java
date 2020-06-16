/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.data;

import java.time.LocalDate;

/**
 * Abstract class to inherit from here dta about person
 *
 * @author Lukasz
 */

public abstract class Person extends ObjectPlusPlus {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Address address;

    public Person(String name, String surname, LocalDate dateOfBirth, Address address) {
        super();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                '}';
    }
}
