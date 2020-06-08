import enums.FlightStatus;
import enums.FlightType;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight extends ObjectPlusPlus {

    private String numberOfFlight;
    private Airport airportFrom;
    private Airport airportTo;
    private FlightType flightType;
    private LocalTime timeOfFlight;

    public Flight(String numberOfFlight, Airport airportFrom, Airport airportTo, FlightType flightType) {
        this.numberOfFlight = numberOfFlight;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightType = flightType;
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
                ", timeOfFlight=" + timeOfFlight +
                '}';
    }


    public class FlightInstance {
        private String flightId;
        private FlightStatus flightStatus;
        private LocalTime timeOfStart;

        private FlightInstance(String flightId, FlightStatus flightStatus, LocalTime timeOfStart) {
            this.flightId = flightId;
            this.flightStatus = flightStatus;
            this.timeOfStart = timeOfStart;
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

    public class WeeklySchedule {
        private int dayOfWeek;
        private LocalTime timeOfFlight;

        private WeeklySchedule(int dayOfWeek, LocalTime timeOfFlight) {
            this.dayOfWeek = dayOfWeek;
            this.timeOfFlight = timeOfFlight;
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }

        public LocalTime getTimeOfFlight() {
            return timeOfFlight;
        }

        @Override
        public String toString() {
            return "WeeklySchedule{" +
                    "dayOfWeek=" + dayOfWeek +
                    ", timeOfFlight=" + timeOfFlight +
                    '}';
        }
    }


    public class AdditionalSchedule {
        private LocalDate dayOfStart;
        private LocalTime timeOfFlight;

        private AdditionalSchedule(LocalDate dayOfStart, LocalTime timeOfFlight) {
            this.dayOfStart = dayOfStart;
            this.timeOfFlight = timeOfFlight;
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
