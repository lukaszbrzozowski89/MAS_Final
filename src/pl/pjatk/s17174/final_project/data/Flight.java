/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.data;

import pl.pjatk.s17174.final_project.enums.FlightStatus;
import pl.pjatk.s17174.final_project.enums.FlightType;

import java.time.LocalDate;
import java.time.LocalTime;

import static pl.pjatk.s17174.final_project.utils.Utils.*;

/**
 * Class using to store pl.pjatk.s17174.final_project.data about Flight
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
    private String numberOfFlight;
    private Airport airportFrom;
    private Airport airportTo;
    private FlightType flightType;
    private LocalTime timeOfFlight;

    public Flight(String numberOfFlight, Airport airportFrom, Airport airportTo, FlightType flightType) {
        super();
        this.numberOfFlight = numberOfFlight;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightType = flightType;
    }

    public FlightInstance createFlightInstance(LocalTime time) throws Exception {

        FlightInstance flightInstance = new FlightInstance(setFlightId() + "_" + time.toString(), time);
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

    private String setFlightId() {
        return getNumberOfFlight();
    }

    public void cancelFlight() {
        //todo
    }

    public void addWeeklySchedule() {
        //todo
    }

    public void addAdditionalSchedule() {
        //todo
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

    @Override
    public String toString() {
        return "Flight{" +
                "numberOfFlight='" + numberOfFlight + '\'' +
                ", airportFrom=" + airportFrom +
                ", airportTo=" + airportTo +
                ", flightType=" + flightType +
                '}';
    }

    /**
     * Inner class with private constructor to create composition - flight instance can't exits without flight
     *
     * @author Lukasz
     */
    public class FlightInstance extends ObjectPlusPlus {
        private String flightId;
        private FlightStatus flightStatus;
        private LocalTime timeOfStart;

        private FlightInstance(String flightId, LocalTime timeOfStart) {
            super();
            this.flightId = flightId;
            this.flightStatus = FlightStatus.ADDED;
            this.timeOfStart = timeOfStart;
        }

        public void cancelFlightInstance() {
            // TODO
        }

        public void updateFlightStatus() {
            // TODO
        }

        public void updateTimeOfDeparture() {
            // TODO
        }

        public void checkSeatsAvailability() {
            // TODO
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
    public class WeeklySchedule extends ObjectPlusPlus {
        private int dayOfWeek;
        private LocalTime timeOfFlight;

        private WeeklySchedule(int dayOfWeek, LocalTime timeOfFlight) {
            super();
            this.dayOfWeek = dayOfWeek;
            this.timeOfFlight = timeOfFlight;
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }

        public LocalTime getTimeOfFlight() {
            return timeOfFlight;
        }

        public void addWeeklySchedule() {
            // TODO
        }

        public void deleteWeeklySchedule() {
            // TODO

        }

        public void editWeeklySchedule() {
            // TODO

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
    public class AdditionalSchedule extends ObjectPlusPlus {
        private LocalDate dayOfStart;
        private LocalTime timeOfFlight;

        private AdditionalSchedule(LocalDate dayOfStart, LocalTime timeOfFlight) {
            super();
            this.dayOfStart = dayOfStart;
            this.timeOfFlight = timeOfFlight;
        }

        public void addAdditionalSchedule() {
            // TODO

        }

        public void deleteAdditionalSchedule() {
            // TODO

        }


        public LocalDate getDayOfStart() {
            return dayOfStart;
        }

        public LocalTime getTimeOfFlight() {
            return timeOfFlight;
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
