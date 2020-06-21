/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pjatk.s17174.final_project.enums.ClassType;
import pl.pjatk.s17174.final_project.enums.FlightType;
import pl.pjatk.s17174.final_project.enums.LuggageType;
import pl.pjatk.s17174.final_project.enums.PaymentMethod;
import pl.pjatk.s17174.final_project.main.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static pl.pjatk.s17174.final_project.utils.Utils.*;

public class MainModel extends ObjectPlusPlus implements Serializable {

    private static MainModel instance;
    public ArrayList<Object> links = new ArrayList<>();
    ArrayList<String> defaultLangs = new ArrayList<>();
    Plane plane, plane1, plane2, plane3, plane4, plane5, plane6, plane7;
    ArrayList<Plane> planes1 = new ArrayList<>();
    ArrayList<Plane> planes2 = new ArrayList<>();
    ArrayList<Plane> planes3 = new ArrayList<>();
    ArrayList<Plane> planes4 = new ArrayList<>();
    Address address1, address2, address3;
    Steward steward1, steward2, steward3, steward4;
    Pilot pilot1, pilot2, pilot3, pilot4;
    Passenger passenger1, passenger2, passenger3;
    Luggage luggage1, luggage2, luggage3, luggage4;
    Airport airport1, airport2, airport3, airport4, airport5;
    Flight flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8;
    Reservation reservation1, reservation2, reservation3, reservation4;
    Payment payment1, payment2, payment3, payment4;
    Owner owner1;
    Flight.FlightInstance flightInstance1, flightInstance2, flightInstance3, flightInstance4,
            flightInstance5, flightInstance6, flightInstance7, flightInstance8;
    Flight.WeeklySchedule weeklySchedule1, weeklySchedule2, weeklySchedule3, weeklySchedule4, weeklySchedule5,
            weeklySchedule6, weeklySchedule7, weeklySchedule8, weeklySchedule9, weeklySchedule10, weeklySchedule11,
            weeklySchedule12, weeklySchedule13, weeklySchedule14, weeklySchedule15, weeklySchedule16;
    String flightFrom;
    String flightTo;
    LocalDate flightDate;
    String passengerNumber;
    private Flight flight;
    private Reservation reservation;
    private Flight.FlightInstance flightInstance;
    private Passenger passenger;
    private Luggage luggage;
    private Payment payment;

    private MainModel() throws Exception {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        }
        defaultLangs.add("Polski");
        defaultLangs.add("English");

        plane = new Plane("Airbus", "A320", LocalDate.of(2019, 2, 3), 157, LocalDate.of(2020, 6, 8));
        plane1 = new Plane("Airbus", "A220", LocalDate.of(2018, 1, 13), 109, LocalDate.of(2020, 4, 8));
        plane2 = new Plane("Airbus", "A319", LocalDate.of(2017, 2, 3), 132, LocalDate.of(2020, 3, 18));
        plane3 = new Plane("Airbus", "A350", LocalDate.of(2016, 5, 31), 306, LocalDate.of(2020, 2, 8));
        plane4 = new Plane("Boeing", "737", LocalDate.of(2015, 7, 3), 160, LocalDate.of(2020, 1, 18));
        plane5 = new Plane("Boeing", "777", LocalDate.of(2014, 2, 13), 288, LocalDate.of(2019, 12, 30));
        plane6 = new Plane("Boeing", "757", LocalDate.of(2014, 12, 31), 234, LocalDate.of(2020, 6, 18));
        plane7 = new Plane("Bombardier", "CRJ-900", LocalDate.of(2013, 8, 3), 76, LocalDate.of(2020, 6, 17));

        planes1.add(plane);
        planes1.add(plane4);
        planes2.add(plane1);
        planes2.add(plane6);
        planes3.add(plane5);
        planes3.add(plane7);
        planes4.add(plane2);
        planes4.add(plane3);


        address1 = new Address("Warsaw", "Krucza 21", "00-120");
        address2 = new Address("Warsaw", "Piękna 20", "00-121");
        address3 = new Address("Warsaw", "Koszykowa 45", "01-320");

        steward1 = new Steward("Anna", "Kowalska", LocalDate.of(1966, 6, 2), address1, defaultLangs);
        steward2 = new Steward("Katarzyna", "Nowak", LocalDate.of(1987, 4, 5), address2, defaultLangs);
        steward3 = new Steward("Krzysztof", "Jerzyna", LocalDate.of(1975, 11, 1), address1, defaultLangs);
        steward4 = new Steward("Jarosław", "Psikuta", LocalDate.of(1975, 11, 1), address2, defaultLangs);

        pilot1 = new Pilot("Adam", "Dudek", LocalDate.of(1975, 12, 2), address3, 9876, planes1, LocalDate.of(2021, 12, 31));
        pilot2 = new Pilot("Roman", "Kosowski", LocalDate.of(1965, 1, 1), address2, 1234, planes2, LocalDate.of(2020, 11, 13));
        pilot3 = new Pilot("Adam", "Lewandowski", LocalDate.of(1976, 11, 12), address1, 11, planes3, LocalDate.of(2022, 1, 17));
        pilot4 = new Pilot("Piotr", "Gruszka", LocalDate.of(1959, 2, 11), address3, 876, planes4, LocalDate.of(2021, 2, 3));

        passenger1 = new Passenger("Paweł", "Grzywacz", LocalDate.of(2000, 7, 19), address1, "pawel@x.com", "123456789");
        passenger2 = new Passenger("Adam", "Janusz", LocalDate.of(1989, 11, 16), address2, "adam@x.com", "123456780");
        passenger3 = new Passenger("Janusz", "Nosacz", LocalDate.of(2001, 12, 11), address3, "januszl@x.com", "123456709");

        luggage1 = new Luggage(1, LuggageType.HAND);
        luggage2 = new Luggage(2, LuggageType.CHECKED);
        luggage3 = new Luggage(3, LuggageType.HAND);
        luggage4 = new Luggage(4, LuggageType.CHECKED);

        airport1 = new Airport("Warsaw", "WAW");
        airport2 = new Airport("London City", "LCY");
        airport3 = new Airport("Paris Charles De Gaulle", "CDG");
        airport4 = new Airport("Chicago O'Hare", "ORD");
        airport5 = new Airport("Barcelona", "BCA");

        flight1 = new Flight("LO331", airport1, airport3, FlightType.SHORT_HAUL);
        flight2 = new Flight("LO332", airport3, airport1, FlightType.SHORT_HAUL);
        flight3 = new Flight("LO437", airport1, airport5, FlightType.SHORT_HAUL);
        flight4 = new Flight("LO438", airport5, airport1, FlightType.SHORT_HAUL);
        flight5 = new Flight("LO001", airport1, airport4, FlightType.LONG_HAUL);
        flight6 = new Flight("LO002", airport4, airport1, FlightType.LONG_HAUL);
        flight7 = new Flight("LO287", airport1, airport2, FlightType.SHORT_HAUL);
        flight8 = new Flight("LO288", airport2, airport1, FlightType.SHORT_HAUL);

        reservation1 = new Reservation(ClassType.ECONOMY, LocalTime.now());
        reservation2 = new Reservation(ClassType.BUSINESS, LocalTime.now());
        reservation3 = new Reservation(ClassType.ECONOMY, LocalTime.now());
        reservation4 = new Reservation(ClassType.BUSINESS, LocalTime.now());

        payment1 = new Payment(1, PaymentMethod.ONLINE_PAYMENT, new BigDecimal(1200));
        payment2 = new Payment(2, PaymentMethod.CREDIT_CARD, new BigDecimal(9900));
        payment3 = new Payment(3, PaymentMethod.DEBIT_CARD, new BigDecimal(900));
        payment4 = new Payment(4, PaymentMethod.TRANSFER, new BigDecimal(1108));

        owner1 = new Owner("Fly With Me Airlines");

        flightInstance1 = flight1.createFlightInstance(LocalTime.of(6, 23));
        flightInstance2 = flight2.createFlightInstance(LocalTime.of(10, 4));
        flightInstance3 = flight3.createFlightInstance(LocalTime.of(12, 13));
        flightInstance4 = flight4.createFlightInstance(LocalTime.of(15, 3));
        flightInstance5 = flight5.createFlightInstance(LocalTime.of(13, 56));
        flightInstance6 = flight6.createFlightInstance(LocalTime.of(20, 4));
        flightInstance7 = flight7.createFlightInstance(LocalTime.of(18, 17));
        flightInstance8 = flight8.createFlightInstance(LocalTime.of(9, 0));

        weeklySchedule1 = flight1.createWeeklySchedule(1, LocalTime.of(6, 23));
        weeklySchedule2 = flight1.createWeeklySchedule(3, LocalTime.of(6, 23));
        weeklySchedule3 = flight1.createWeeklySchedule(5, LocalTime.of(6, 23));
        weeklySchedule4 = flight1.createWeeklySchedule(7, LocalTime.of(6, 23));

        weeklySchedule5 = flight2.createWeeklySchedule(2, LocalTime.of(9, 7));
        weeklySchedule6 = flight2.createWeeklySchedule(4, LocalTime.of(9, 7));
        weeklySchedule7 = flight2.createWeeklySchedule(6, LocalTime.of(9, 7));
        weeklySchedule8 = flight2.createWeeklySchedule(7, LocalTime.of(9, 7));

        weeklySchedule9 = flight3.createWeeklySchedule(3, LocalTime.of(12, 21));
        weeklySchedule10 = flight3.createWeeklySchedule(7, LocalTime.of(12, 21));

        weeklySchedule11 = flight1.createWeeklySchedule(1, LocalTime.of(15, 13));
        weeklySchedule12 = flight1.createWeeklySchedule(6, LocalTime.of(15, 13));

        weeklySchedule13 = flight1.createWeeklySchedule(1, LocalTime.of(20, 2));
        weeklySchedule14 = flight1.createWeeklySchedule(4, LocalTime.of(20, 2));

        weeklySchedule15 = flight1.createWeeklySchedule(1, LocalTime.of(22, 3));
        weeklySchedule16 = flight1.createWeeklySchedule(4, LocalTime.of(22, 3));
        System.out.println("objects created");
        System.out.println("---------------");
        System.out.println("Starting creating links between objects");
        owner1.addLink(planeClass, ownerClass, plane);
        owner1.addLink(planeClass, ownerClass, plane1);
        owner1.addLink(planeClass, ownerClass, plane2);
        owner1.addLink(planeClass, ownerClass, plane3);
        owner1.addLink(planeClass, ownerClass, plane4);
        owner1.addLink(planeClass, ownerClass, plane5);
        owner1.addLink(planeClass, ownerClass, plane6);
        owner1.addLink(planeClass, ownerClass, plane7);

        steward1.addLink(flightInstanceClass, stewardClass, flightInstance1);
        steward2.addLink(flightInstanceClass, stewardClass, flightInstance1);
        pilot1.addLink(flightInstanceClass, pilotClass, flightInstance1);
        pilot2.addLink(flightInstanceClass, pilotClass, flightInstance1);
        plane.addLink(flightInstanceClass, planeClass, flightInstance1);
        reservation1.addLink(flightInstanceClass, reservationClass, flightInstance1);

        steward3.addLink(flightInstanceClass, stewardClass, flightInstance2);
        steward4.addLink(flightInstanceClass, stewardClass, flightInstance2);
        pilot1.addLink(flightInstanceClass, pilotClass, flightInstance2);
        pilot3.addLink(flightInstanceClass, pilotClass, flightInstance2);
        plane2.addLink(flightInstanceClass, planeClass, flightInstance2);
        reservation2.addLink(flightInstanceClass, reservationClass, flightInstance2);

        steward1.addLink(flightInstanceClass, stewardClass, flightInstance3);
        steward2.addLink(flightInstanceClass, stewardClass, flightInstance3);
        pilot2.addLink(flightInstanceClass, pilotClass, flightInstance3);
        pilot4.addLink(flightInstanceClass, pilotClass, flightInstance3);
        plane3.addLink(flightInstanceClass, planeClass, flightInstance3);
        reservation3.addLink(flightInstanceClass, reservationClass, flightInstance3);

        steward3.addLink(flightInstanceClass, stewardClass, flightInstance4);
        steward4.addLink(flightInstanceClass, stewardClass, flightInstance4);
        pilot1.addLink(flightInstanceClass, pilotClass, flightInstance4);
        pilot4.addLink(flightInstanceClass, pilotClass, flightInstance4);
        plane4.addLink(flightInstanceClass, planeClass, flightInstance4);
        reservation4.addLink(flightInstanceClass, reservationClass, flightInstance4);

        steward1.addLink(flightInstanceClass, stewardClass, flightInstance5);
        steward2.addLink(flightInstanceClass, stewardClass, flightInstance5);
        pilot2.addLink(flightInstanceClass, pilotClass, flightInstance5);
        pilot3.addLink(flightInstanceClass, pilotClass, flightInstance5);
        plane5.addLink(flightInstanceClass, planeClass, flightInstance5);

        steward3.addLink(flightInstanceClass, stewardClass, flightInstance6);
        steward4.addLink(flightInstanceClass, stewardClass, flightInstance6);
        pilot1.addLink(flightInstanceClass, pilotClass, flightInstance6);
        pilot4.addLink(flightInstanceClass, pilotClass, flightInstance6);
        plane6.addLink(flightInstanceClass, planeClass, flightInstance6);

        steward1.addLink(flightInstanceClass, stewardClass, flightInstance7);
        steward2.addLink(flightInstanceClass, stewardClass, flightInstance7);
        pilot1.addLink(flightInstanceClass, pilotClass, flightInstance7);
        pilot3.addLink(flightInstanceClass, pilotClass, flightInstance7);
        plane7.addLink(flightInstanceClass, planeClass, flightInstance7);

        steward3.addLink(flightInstanceClass, stewardClass, flightInstance8);
        steward4.addLink(flightInstanceClass, stewardClass, flightInstance8);
        pilot2.addLink(flightInstanceClass, pilotClass, flightInstance8);
        pilot3.addLink(flightInstanceClass, pilotClass, flightInstance8);
        plane.addLink(flightInstanceClass, planeClass, flightInstance8);

        passenger1.addLink(reservationClass, passengerClass, reservation1);
        passenger2.addLink(reservationClass, passengerClass, reservation2);
        passenger3.addLink(reservationClass, passengerClass, reservation3);

        luggage1.addLink(passengerClass, luggageClass, passenger1);
        luggage2.addLink(passengerClass, luggageClass, passenger2);
        luggage3.addLink(passengerClass, luggageClass, passenger3);
        luggage4.addLink(passengerClass, luggageClass, passenger3);


        reservation1.addLink(paymentClass, reservationClass, payment1);
        reservation2.addLink(paymentClass, reservationClass, payment2);
        reservation3.addLink(paymentClass, reservationClass, payment3);
        reservation4.addLink(paymentClass, reservationClass, payment4);

        flight1.addLink(airportClass, flightClass, airport1);
        flight1.addLink(airportClass, flightClass, airport3);

        flight2.addLink(airportClass, flightClass, airport3);
        flight2.addLink(airportClass, flightClass, airport1);

        flight3.addLink(airportClass, flightClass, airport1);
        flight3.addLink(airportClass, flightClass, airport5);

        flight4.addLink(airportClass, flightClass, airport5);
        flight4.addLink(airportClass, flightClass, airport1);

        flight5.addLink(airportClass, flightClass, airport1);
        flight5.addLink(airportClass, flightClass, airport4);

        flight6.addLink(airportClass, flightClass, airport4);
        flight6.addLink(airportClass, flightClass, airport1);

        flight7.addLink(airportClass, flightClass, airport1);
        flight7.addLink(airportClass, flightClass, airport2);

        flight8.addLink(airportClass, flightClass, airport2);
        flight8.addLink(airportClass, flightClass, airport1);

        System.out.println("Links between objects created");
    }

    public static MainModel getInstance() throws Exception {
        if (instance == null) {
            System.out.println("new instance of Model");
            instance = new MainModel();
        } else {
            System.out.println("this instance of Model");
            return instance;
        }
        return instance;
    }

    public ObservableList<String> fillComboboxFrom() throws ClassNotFoundException {
        ObservableList<String> flightsName = FXCollections.observableArrayList();
        for (Flight flight : ObjectPlus.getExtent(Flight.class)) {
            if (!flightsName.contains(flight.getAirportFrom().getName()))
                flightsName.add(flight.getAirportFrom().getName());

        }
        return flightsName;
    }

    public ObservableList<String> fillComboboxTo() throws ClassNotFoundException {
        ObservableList<String> flightsName = FXCollections.observableArrayList();
        for (Flight flight : ObjectPlus.getExtent(Flight.class)) {
            if (!flightsName.contains(flight.getAirportTo().getName()))
                flightsName.add(flight.getAirportTo().getName());

        }
        return flightsName;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(String passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void createReservation() {
        reservation = new Reservation(null, LocalTime.now());
        this.getPassenger().addLink(reservationClass, passengerClass, reservation);
        this.getFlightInstance().addLink(reservationClass, flightInstanceClass, reservation);
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Flight.FlightInstance getFlightInstance() {
        return flightInstance;
    }

    public void setFlightInstance(Flight.FlightInstance flightInstance) {
        this.flightInstance = flightInstance;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
        this.getPassenger().addLink(luggageClass, passengerClass, luggage);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        this.getReservation().addLink(paymentClass, reservationClass, payment);
    }

    public void addPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
