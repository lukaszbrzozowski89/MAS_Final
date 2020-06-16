/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package enums;

/**
 * Enum to set Flight instance status
 *
 * @author Lukasz
 * @see data.Flight.FlightInstance
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
