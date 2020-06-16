/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.enums;

/**
 * Enum to set Reservation status
 *
 * @author Lukasz
 * @see pl.pjatk.s17174.final_project.data.Reservation
 */
public enum ReservationStatus {

    STARTED,
    WAITING_FOR_PAYMENT,
    PAID,
    FINISHED,
    CANCELLED;

    ReservationStatus() {
    }
}
