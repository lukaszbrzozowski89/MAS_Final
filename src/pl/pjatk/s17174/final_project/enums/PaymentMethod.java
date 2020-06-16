/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.enums;

/**
 * Enum to set Payment Method
 *
 * @author Lukasz
 * @see pl.pjatk.s17174.final_project.data.Payment
 */
public enum PaymentMethod {
    DEBIT_CARD,
    CREDIT_CARD,
    ONLINE_PAYMENT,
    TRANSFER;

    PaymentMethod() {
    }
}
