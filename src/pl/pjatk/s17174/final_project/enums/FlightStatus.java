/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.enums;

/**
 * Enum to set Flight instance status
 *
 * @author Lukasz
 * @see pl.pjatk.s17174.final_project.main.Flight.FlightInstance
 */
public enum FlightStatus {

    ADDED,
    CANCELLED,
    BOARDING,
    READY_TO_TAKE_OFF,
    DURING_FLIGHT,
    FINISHED;

    FlightStatus() {
    }

}
