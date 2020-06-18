/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.pjatk.s17174.final_project.enums.ClassType;
import pl.pjatk.s17174.final_project.enums.FlightType;
import pl.pjatk.s17174.final_project.enums.LuggageType;
import pl.pjatk.s17174.final_project.enums.PaymentMethod;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static pl.pjatk.s17174.final_project.utils.Utils.*;

/**
 * Main class to create Objects and start Application
 */
public class Main extends Application {


    public static void main(String[] args) {

//        try {
//            FileUtils.readExtentFromFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            createFewObjects();
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
//        try {
//            FileUtils.saveExtentToFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MAS Final Project");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void createFewObjects() throws Exception {
        ArrayList<String> defaultLangs = new ArrayList<>();
        defaultLangs.add("Polski");
        defaultLangs.add("English");

        Plane plane = new Plane("Airbus", "A320", LocalDate.of(2019, 2, 3), 157, LocalDate.of(2020, 6, 8));
        Plane plane1 = new Plane("Airbus", "A220", LocalDate.of(2018, 1, 13), 109, LocalDate.of(2020, 4, 8));
        Plane plane2 = new Plane("Airbus", "A319", LocalDate.of(2017, 2, 3), 132, LocalDate.of(2020, 3, 18));
        Plane plane3 = new Plane("Airbus", "A350", LocalDate.of(2016, 5, 31), 306, LocalDate.of(2020, 2, 8));
        Plane plane4 = new Plane("Boeing", "737", LocalDate.of(2015, 7, 3), 160, LocalDate.of(2020, 1, 18));
        Plane plane5 = new Plane("Boeing", "777", LocalDate.of(2014, 2, 13), 288, LocalDate.of(2019, 12, 30));
        Plane plane6 = new Plane("Boeing", "757", LocalDate.of(2014, 12, 31), 234, LocalDate.of(2020, 6, 18));
        Plane plane7 = new Plane("Bombardier", "CRJ-900", LocalDate.of(2013, 8, 3), 76, LocalDate.of(2020, 6, 17));

        ArrayList<Plane> planes1 = new ArrayList<>();
        ArrayList<Plane> planes2 = new ArrayList<>();
        ArrayList<Plane> planes3 = new ArrayList<>();
        ArrayList<Plane> planes4 = new ArrayList<>();
        planes1.add(plane);
        planes1.add(plane4);
        planes2.add(plane1);
        planes2.add(plane6);
        planes3.add(plane5);
        planes3.add(plane7);
        planes4.add(plane2);
        planes4.add(plane3);


        Address address1 = new Address("Warsaw", "Krucza 21", "00-120");
        Address address2 = new Address("Warsaw", "Piękna 20", "00-121");
        Address address3 = new Address("Warsaw", "Koszykowa 45", "01-320");

        Steward steward1 = new Steward("Anna", "Kowalska", LocalDate.of(1966, 6, 2), address1, 1, defaultLangs);
        Steward steward2 = new Steward("Katarzyna", "Nowak", LocalDate.of(1987, 4, 5), address2, 2, defaultLangs);
        Steward steward3 = new Steward("Krzysztof", "Jerzyna", LocalDate.of(1975, 11, 1), address1, 3, defaultLangs);
        Steward steward4 = new Steward("Jarosław", "Psikuta", LocalDate.of(1975, 11, 1), address2, 3, defaultLangs);

        Pilot pilot1 = new Pilot("Adam", "Dudek", LocalDate.of(1975, 12, 2), address3, 9876, planes1, LocalDate.of(2021, 12, 31));
        Pilot pilot2 = new Pilot("Roman", "Kosowski", LocalDate.of(1965, 1, 1), address2, 1234, planes2, LocalDate.of(2020, 11, 13));
        Pilot pilot3 = new Pilot("Adam", "Lewandowski", LocalDate.of(1976, 11, 12), address1, 11, planes3, LocalDate.of(2022, 1, 17));
        Pilot pilot4 = new Pilot("Piotr", "Gruszka", LocalDate.of(1959, 2, 11), address3, 876, planes4, LocalDate.of(2021, 2, 3));

        Passenger passenger1 = new Passenger("Paweł", "Grzywacz", LocalDate.of(2000, 7, 19), address1, "pawel@x.com", "123456789");
        Passenger passenger2 = new Passenger("Adam", "Janusz", LocalDate.of(1989, 11, 16), address2, "adam@x.com", "123456780");
        Passenger passenger3 = new Passenger("Janusz", "Nosacz", LocalDate.of(2001, 12, 11), address3, "januszl@x.com", "123456709");

        Luggage luggage1 = new Luggage(1, LuggageType.HAND);
        Luggage luggage2 = new Luggage(2, LuggageType.CHECKED);
        Luggage luggage3 = new Luggage(3, LuggageType.HAND);
        Luggage luggage4 = new Luggage(4, LuggageType.CHECKED);

        Airport airport1 = new Airport("Warsaw", "WAW");
        Airport airport2 = new Airport("London City", "LCY");
        Airport airport3 = new Airport("Paris Charles De Gaulle", "CDG");
        Airport airport4 = new Airport("Chicago O'Hare", "ORD");


        Flight flight1 = new Flight("LO331", airport1, airport3, FlightType.SHORT_HAUL);
        Flight flight2 = new Flight("LO332", airport3, airport1, FlightType.SHORT_HAUL);
        Flight flight3 = new Flight("LO333", airport1, airport3, FlightType.SHORT_HAUL);
        Flight flight4 = new Flight("LO334", airport3, airport1, FlightType.SHORT_HAUL);
        Flight flight5 = new Flight("LO001", airport1, airport4, FlightType.LONG_HAUL);
        Flight flight6 = new Flight("LO002", airport4, airport1, FlightType.LONG_HAUL);
        Flight flight7 = new Flight("LO287", airport1, airport2, FlightType.SHORT_HAUL);
        Flight flight8 = new Flight("LO288", airport2, airport1, FlightType.SHORT_HAUL);

        Reservation reservation1 = new Reservation(1, 1, ClassType.ECONOMY, LocalTime.now());
        Reservation reservation2 = new Reservation(2, 1, ClassType.BUSINESS, LocalTime.now());
        Reservation reservation3 = new Reservation(3, 1, ClassType.ECONOMY, LocalTime.now());
        Reservation reservation4 = new Reservation(4, 1, ClassType.BUSINESS, LocalTime.now());

        Payment payment1 = new Payment(1, PaymentMethod.ONLINE_PAYMENT, new BigDecimal(1200));
        Payment payment2 = new Payment(2, PaymentMethod.CREDIT_CARD, new BigDecimal(9900));
        Payment payment3 = new Payment(3, PaymentMethod.DEBIT_CARD, new BigDecimal(900));
        Payment payment4 = new Payment(4, PaymentMethod.TRANSFER, new BigDecimal(1108));

        Owner owner1 = new Owner("Fly With Me Airlines");
        plane1.addLink(ownerClass, planeClass, owner1);
        plane2.addLink(ownerClass, planeClass, owner1);
        plane3.addLink(ownerClass, planeClass, owner1);
        plane4.addLink(ownerClass, planeClass, owner1);
        plane5.addLink(ownerClass, planeClass, owner1);
        plane6.addLink(ownerClass, planeClass, owner1);
        plane7.addLink(ownerClass, planeClass, owner1);

        Flight.FlightInstance flightInstance1 = flight1.createFlightInstance(LocalTime.of(6, 23));
        Flight.FlightInstance flightInstance2 = flight2.createFlightInstance(LocalTime.of(10, 4));
        Flight.FlightInstance flightInstance3 = flight3.createFlightInstance(LocalTime.of(12, 13));
        Flight.FlightInstance flightInstance4 = flight4.createFlightInstance(LocalTime.of(15, 3));
        Flight.FlightInstance flightInstance5 = flight5.createFlightInstance(LocalTime.of(13, 56));
        Flight.FlightInstance flightInstance6 = flight6.createFlightInstance(LocalTime.of(20, 4));
        Flight.FlightInstance flightInstance7 = flight7.createFlightInstance(LocalTime.of(18, 17));
        Flight.FlightInstance flightInstance8 = flight8.createFlightInstance(LocalTime.of(9, 0));

        Flight.WeeklySchedule weeklySchedule1 = flight1.createWeeklySchedule(1, LocalTime.of(6, 23));
        Flight.WeeklySchedule weeklySchedule2 = flight1.createWeeklySchedule(3, LocalTime.of(6, 23));
        Flight.WeeklySchedule weeklySchedule3 = flight1.createWeeklySchedule(5, LocalTime.of(6, 23));
        Flight.WeeklySchedule weeklySchedule4 = flight1.createWeeklySchedule(7, LocalTime.of(6, 23));

        Flight.WeeklySchedule weeklySchedule5 = flight2.createWeeklySchedule(2, LocalTime.of(9, 7));
        Flight.WeeklySchedule weeklySchedule6 = flight2.createWeeklySchedule(4, LocalTime.of(9, 7));
        Flight.WeeklySchedule weeklySchedule7 = flight2.createWeeklySchedule(6, LocalTime.of(9, 7));
        Flight.WeeklySchedule weeklySchedule8 = flight2.createWeeklySchedule(7, LocalTime.of(9, 7));

        Flight.WeeklySchedule weeklySchedule9 = flight3.createWeeklySchedule(3, LocalTime.of(12, 21));
        Flight.WeeklySchedule weeklySchedule10 = flight3.createWeeklySchedule(7, LocalTime.of(12, 21));

        Flight.WeeklySchedule weeklySchedule11 = flight1.createWeeklySchedule(1, LocalTime.of(15, 13));
        Flight.WeeklySchedule weeklySchedule12 = flight1.createWeeklySchedule(6, LocalTime.of(15, 13));

        Flight.WeeklySchedule weeklySchedule13 = flight1.createWeeklySchedule(1, LocalTime.of(20, 2));
        Flight.WeeklySchedule weeklySchedule14 = flight1.createWeeklySchedule(4, LocalTime.of(20, 2));

        Flight.WeeklySchedule weeklySchedule15 = flight1.createWeeklySchedule(1, LocalTime.of(22, 3));
        Flight.WeeklySchedule weeklySchedule16 = flight1.createWeeklySchedule(4, LocalTime.of(22, 3));


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

    }

}
