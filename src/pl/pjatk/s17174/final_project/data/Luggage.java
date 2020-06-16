/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.data;

import pl.pjatk.s17174.final_project.enums.LuggageType;

/**
 * Class used to store pl.pjatk.s17174.final_project.data about luggage which can be added by Passenger
 * links with Passenger with cardinality 0..* - 1..*
 *
 * @author Lukasz
 * @see Passenger
 */
public class Luggage extends ObjectPlusPlus {

    private int id;
    private LuggageType luggageType;

    public Luggage(int id, LuggageType luggageType) {
        super();
        this.id = id;
        this.luggageType = luggageType;
    }

    public void addLuggage() {
        //todo
    }

    public void removeLuggage() {
        //todo
    }

    public int getId() {
        return id;
    }

    public LuggageType getLuggageType() {
        return luggageType;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "id=" + id +
                ", luggageType=" + luggageType +
                '}';
    }
}
