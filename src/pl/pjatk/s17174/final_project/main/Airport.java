/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

/**
 * Class using to store data about airports used in project
 * links with Flight with cardinality 1..* - 1..*
 *
 * @author Lukasz
 * @see Flight
 */
public class Airport extends ObjectPlusPlus {

    private String name;
    private String airportCode;


    public Airport(String name, String airportCode) {
        super();
        this.name = name;
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public String getAirportCode() {
        return airportCode;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", flightCode='" + airportCode + '\'' +
                '}';
    }
}
