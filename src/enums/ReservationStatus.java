/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package enums;

/**
 * Enum to set Reservation status
 *
 * @author Lukasz
 * @see data.Reservation
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
