/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package enums;

/**
 * Enum to set Payment Method
 *
 * @author Lukasz
 * @see data.Payment
 */
public enum PaymentMethod {
    DEBIT_CARD,
    CREDIT_CARD,
    ONLINE_PAYMENT,
    TRANSFER;

    PaymentMethod() {
    }
}
