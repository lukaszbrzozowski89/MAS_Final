public class Airport extends ObjectPlusPlus {

    private String name;
    private String airportCode;

    public Airport(String name, String airportCode) {
        this.name = name;
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public String getAirportCode() {
        return airportCode;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", flightCode='" + airportCode + '\'' +
                '}';
    }
}
