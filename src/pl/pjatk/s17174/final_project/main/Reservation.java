/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import pl.pjatk.s17174.final_project.enums.ClassType;
import pl.pjatk.s17174.final_project.enums.ReservationStatus;

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

    public void checkFreeSeats(Flight.FlightInstance flightInstance) {
        //todo
    }

    public ReservationStatus checkReservationStatus() {
        return getStatus();
    }

    public void checkPaymentStatus() {
        //todo
    }

    public void changePaymentStatus() {
        //todo
    }

    public void changeReservationStatus(ReservationStatus status) {
        setStatus(status);
        //todo
    }

    public void generateReservationDocs() {
        //todo
    }

    public void cancelReservation() {
        //todo
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
