/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import pl.pjatk.s17174.final_project.enums.FlightStatus;
import pl.pjatk.s17174.final_project.enums.FlightType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static pl.pjatk.s17174.final_project.utils.Utils.*;

/**
 * Class using to store data about Flight
 * links with:
 * 1. Airport cardinality - 1..* - 1..*
 * 2. WeeklySchedule - 1 - *
 * 3. AdditionalSchedule - 1 - *
 * 4. FlightInstance - 1 - *
 *
 * @author Lukasz
 * @see Airport
 * @see WeeklySchedule
 * @see AdditionalSchedule
 * @see FlightInstance
 */
public class Flight extends ObjectPlusPlus {
    private static int counter = 0;
    private String numberOfFlight;
    private Airport airportFrom;
    private Airport airportTo;
    private FlightType flightType;
    private LocalTime timeOfFlight;
    private int id;

    public Flight(String numberOfFlight, Airport airportFrom, Airport airportTo, FlightType flightType) {
        super();
        this.id = ++counter;
        this.numberOfFlight = numberOfFlight;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightType = flightType;
    }

    public FlightInstance createFlightInstance(LocalTime time) throws Exception {

        FlightInstance flightInstance = new FlightInstance(setFlightId(time), time);
        this.addPart(flightInstanceClass, flightClass, flightInstance);
        return flightInstance;
    }


    public WeeklySchedule createWeeklySchedule(int day, LocalTime time) throws Exception {
        WeeklySchedule weeklySchedule = new WeeklySchedule(day, time);
        this.addPart(flightInstanceClass, flightClass, weeklySchedule);
        return weeklySchedule;
    }

    public AdditionalSchedule createAdditionalSchedule(LocalDate date, LocalTime time) throws Exception {
        AdditionalSchedule additionalSchedule = new AdditionalSchedule(date, time);
        this.addPart(flightInstanceClass, flightClass, additionalSchedule);
        return additionalSchedule;
    }

    private String setFlightId(LocalTime time) {
        return getNumberOfFlight() + "_" + time.toString();
    }

    public void addWeeklySchedule(int day, LocalTime time) {
        try {
            createWeeklySchedule(day, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAdditionalSchedule(LocalDate date, LocalTime time) {
        try {
            createAdditionalSchedule(date, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getNumberOfFlight() {
        return numberOfFlight;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

    public Airport getAirportTo() {
        return airportTo;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public LocalTime getTimeOfFlight() {
        return timeOfFlight;
    }

    public void setTimeOfFlight(LocalTime timeOfFlight) {
        this.timeOfFlight = timeOfFlight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Flight nr='" + numberOfFlight + '\'' +
                ", typ=" + flightType
                ;
    }

    /**
     * Inner class with private constructor to create composition - flight instance can't exits without flight
     *
     * @author Lukasz
     */
    public static class FlightInstance extends ObjectPlusPlus {
        private String flightId;
        private FlightStatus flightStatus;
        private LocalTime timeOfStart;
        private static int counterFlightInstance = 1;
        private int id;

        private FlightInstance(String flightId, LocalTime timeOfStart) {
            super();
            this.id = counterFlightInstance++;
            this.flightId = flightId;
            this.flightStatus = FlightStatus.ADDED;
            this.timeOfStart = timeOfStart;
        }

        /**
         * Method which change status of flight for cancelled - uses private setter
         *
         * @param instance flight instance you want to cancel
         */
        public void cancelFlightInstance(FlightInstance instance) {
            instance.setFlightStatus(FlightStatus.CANCELLED);
        }

        /**
         * Method which change flight status - uses private setter
         *
         * @param instance flight instance you want to update
         * @param status   status you want to update
         */
        public void updateFlightStatus(FlightInstance instance, FlightStatus status) {
            instance.setFlightStatus(status);
        }

        /**
         * Method which change time of flight ones o flight instances - uses private setter
         *
         * @param instance flight instance you want to change
         * @param time     time of flight departure
         */
        public void updateTimeOfDeparture(FlightInstance instance, LocalTime time) {
            instance.setTimeOfStart(time);
        }

        public boolean checkSeatsAvailability() throws Exception {
            List<FlightInstance> linkedClasses = (List<FlightInstance>) ObjectPlus.getExtent(FlightInstance.class);

            return true;
        }

        public String getFlightId() {
            return flightId;
        }

        public FlightStatus getFlightStatus() {
            return flightStatus;
        }

        public LocalTime getTimeOfStart() {
            return timeOfStart;
        }

        private void setTimeOfStart(LocalTime timeOfStart) {
            this.timeOfStart = timeOfStart;
        }

        private void setFlightStatus(FlightStatus flightStatus) {
            this.flightStatus = flightStatus;
        }

        @Override
        public String toString() {
            return "FlightInstance{" +
                    "flightId='" + flightId + '\'' +
                    ", flightStatus=" + flightStatus +
                    ", timeOfStart=" + timeOfStart +
                    '}';
        }
    }

    /**
     * Inner class with private constructor to create composition - weekly schedule can't exists without flight
     *
     * @author Lukasz
     */
    public static class WeeklySchedule extends ObjectPlusPlus {
        private int dayOfWeek;
        private LocalTime timeOfFlight;
        private static int counterWeekly = 1;
        private int id;

        private WeeklySchedule(int dayOfWeek, LocalTime timeOfFlight) {
            super();
            this.id = counterWeekly++;
            this.dayOfWeek = dayOfWeek;
            this.timeOfFlight = timeOfFlight;
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }

        public LocalTime getTimeOfFlight() {
            return timeOfFlight;
        }

        public void setDayOfWeek(int dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public void setTimeOfFlight(LocalTime timeOfFlight) {
            this.timeOfFlight = timeOfFlight;
        }

        public void editWeeklySchedule(WeeklySchedule weeklySchedule) {
            weeklySchedule.setDayOfWeek(weeklySchedule.getDayOfWeek());
            weeklySchedule.setTimeOfFlight(weeklySchedule.getTimeOfFlight());
            System.out.println("edited");
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "WeeklySchedule{" +
                    "dayOfWeek=" + dayOfWeek +
                    ", timeOfFlight=" + timeOfFlight +
                    '}';
        }
    }

    /**
     * inner class with private constructor to create composition - additional schedule can't exists without flight
     */
    public static class AdditionalSchedule extends ObjectPlusPlus {
        private LocalDate dayOfStart;
        private LocalTime timeOfFlight;
        private static int counterAdditional = 1;
        private int id;

        private AdditionalSchedule(LocalDate dayOfStart, LocalTime timeOfFlight) {
            super();
            this.id = counterAdditional++;
            this.dayOfStart = dayOfStart;
            this.timeOfFlight = timeOfFlight;
        }

        public LocalDate getDayOfStart() {
            return dayOfStart;
        }

        public LocalTime getTimeOfFlight() {
            return timeOfFlight;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "AdditionalSchedule{" +
                    "dayOfStart=" + dayOfStart +
                    ", timeOfFlight=" + timeOfFlight +
                    '}';
        }
    }
}
