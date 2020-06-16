/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.data;

import pl.pjatk.s17174.final_project.enums.PaymentMethod;
import pl.pjatk.s17174.final_project.enums.PaymentStatus;

import java.math.BigDecimal;

/**
 * Class to store pl.pjatk.s17174.final_project.data about payments
 * links with Reservation with cardinality 1 - *
 *
 * @see Reservation
 */
public class Payment extends ObjectPlusPlus {

    private int id;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private BigDecimal amount;

    public Payment(int id, PaymentMethod paymentMethod, BigDecimal amount) {
        super();
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.STARTED;
        this.amount = amount;
    }

    public void getPaymentDetails() {
        //todo
    }

    public void makePayment() {
        //todo
    }

    public void changePaymentStatus(PaymentStatus status) {
        setPaymentStatus(status);
        //todo
    }

    public int getId() {
        return id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentMethod=" + paymentMethod +
                ", paymentStatus=" + paymentStatus +
                ", amount=" + amount +
                '}';
    }
}
