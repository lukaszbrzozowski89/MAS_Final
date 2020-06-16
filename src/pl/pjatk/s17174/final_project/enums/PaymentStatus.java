/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.enums;

/**
 * Enum to set Payment Status
 *
 * @author Lukasz
 * @see pl.pjatk.s17174.final_project.main.Payment
 */
public enum PaymentStatus {
    STARTED,
    DURING_PROCESSING,
    FINISHED,
    CANCELLED;

    PaymentStatus() {
    }
}
