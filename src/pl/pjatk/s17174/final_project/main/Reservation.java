/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import pl.pjatk.s17174.final_project.enums.ClassType;
import pl.pjatk.s17174.final_project.enums.ReservationStatus;
import pl.pjatk.s17174.final_project.model.MainModel;
import pl.pjatk.s17174.final_project.utils.Utils;

import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Arrays;

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
    private static int counter = 0;

    public Reservation(ClassType classType, LocalTime paymentWaitTime) {
        super();
        this.id = ++counter;
        this.seatNumber = counter;
        this.classType = classType;
        this.status = ReservationStatus.STARTED;
        this.paymentWaitTime = paymentWaitTime;
    }


    public ReservationStatus checkReservationStatus() {
        return getStatus();
    }

    public void checkPaymentStatus() {

    }

    public void changePaymentStatus() {
        if (LocalTime.now().isAfter(getPaymentWaitTime().plusHours(24))) {
            cancelReservation();
        } else {
            setStatus(ReservationStatus.WAITING_FOR_PAYMENT);
        }
    }

    public void changeReservationStatus(ReservationStatus status) {
        setStatus(status);
    }

    public void generateReservationDocs() throws Exception {
        MainModel mainModel = MainModel.getInstance();
        PrintWriter out = new PrintWriter("reservation.txt");
        out.write(Arrays.toString(mainModel.getReservation().getLinks(Utils.passengerClass)));
        out.write("\n");
        out.write("\n");
        out.write(mainModel.getReservation().toString());
        out.write("\n");
        out.write(Arrays.toString(mainModel.getReservation().getLinks(Utils.flightInstanceClass)));
        out.write("\n");
        out.write(Arrays.toString(mainModel.getReservation().getLinks(Utils.paymentClass)));
        out.close();
    }

    public void cancelReservation() {
        setStatus(ReservationStatus.CANCELLED);
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

    public void setClassType(ClassType classType) {
        this.classType = classType;
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
