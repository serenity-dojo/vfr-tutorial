package vfr.domain;

public class FlightLevel {

    private final Integer flightLevel;

    public FlightLevel(Integer flightLevel) {
        this.flightLevel = flightLevel;
    }

    public static FlightLevel of(Integer flightLevel) {
        return new FlightLevel(flightLevel);
    }

    public int inFeet() {
        return flightLevel * 100;
    }


}
