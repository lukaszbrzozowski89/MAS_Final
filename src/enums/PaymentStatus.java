/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package enums;

/**
 * Enum to set Payment Status
 *
 * @author Lukasz
 * @see data.Payment
 */
public enum PaymentStatus {
    STARTED,
    DURING_PROCESSING,
    FINISHED,
    CANCELLED;

    PaymentStatus() {
    }
}
