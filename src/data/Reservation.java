/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package data;

import enums.ClassType;
import enums.ReservationStatus;

import java.time.LocalTime;

/**
 * Class to store data about Reservation
 * links with:
 * 1. Passenger with cardinality 1 - *
 * 2. FlightInstance - 1..* - 1..*
 * 3. Payment 1 - *
 *
 * @author Lukasz
 * @see Passenger
 * @see Flight.FlightInstance
 * @see Passenger
 */

public class Reservation extends ObjectPlusPlus {

    private int id;
    private int seatNumber;
    private ClassType classType;
    private ReservationStatus status;
    private LocalTime paymentWaitTime;

    public Reservation(int id, int seatNumber, ClassType classType, LocalTime paymentWaitTime) {
        super();
        this.id = id;
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.status = ReservationStatus.STARTED;
        this.paymentWaitTime = paymentWaitTime;
    }


    public int getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalTime getPaymentWaitTime() {
        return paymentWaitTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", classType=" + classType +
                ", status=" + status +
                ", paymentWaitTime=" + paymentWaitTime +
                '}';
    }
}
